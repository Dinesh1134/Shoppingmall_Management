package com.customer;

	import jakarta.persistence.Column;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	public class Customer {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer custid;
	    @Column(name="custname")
	    private String custname;
	    @Column(name="phoneno")
	    private String phone;
	    @Column(name="email")
	    private String email;
	    
	    public Customer() {
	    	
	    }
	    
	    
		public Customer(Integer custid, String custname, String phone, String email) {
			super();
			this.custname = custname;
			this.phone = phone;
			this.email = email;
		}


		public Integer getCustid() {
			return custid;
		}
		public void setCustid(Integer custid) {
			this.custid = custid;
		}
		public String getCustname() {
			return custname;
		}
		public void setCustname(String custname) {
			this.custname = custname;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "Customer [custid=" + custid + ", custname=" + custname + ", phone=" + phone + ", email=" + email + "]";
		}
	}

