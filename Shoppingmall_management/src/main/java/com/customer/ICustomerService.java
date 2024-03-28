package com.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ICustomerService {
@Autowired
private ICustomerRepository repo;

public List<Customer> listAll()
{
	return repo.findAll();
}
public void save(Customer customer)
{
	repo.save(customer);
}
public Customer get(int custid)
{
	return repo.findById(custid).get();
}
public void delete(int custid)
{
	repo.deleteById(custid);
}
}