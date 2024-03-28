package com.customer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController 
{
@Autowired
private ICustomerService service;

//RESTful API methods for Retrieval operations
@GetMapping("/customers")
public List<Customer> list()
{
return service.listAll();
}
@GetMapping("/customer/{custid}")
public ResponseEntity<Customer> get(@PathVariable int custid)
{
	try
	{
		Customer customer = service.get(custid);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
}
//RESTful API method for create operation
@PostMapping("/customers/add")
public void add(@RequestBody Customer customer)
{
	service.save(customer);
}

//RESTful API method for update operation
@PutMapping("/customers/update/{custid}")
public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable int custid)
{
	try
	{
		Customer existcustomer = service.get(custid);
		service.save(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
}

//RESful API method for delete operation
@DeleteMapping("/customers/delete/{custid}")
public void delete(@PathVariable int custid)
{
	service.delete(custid);
}
}