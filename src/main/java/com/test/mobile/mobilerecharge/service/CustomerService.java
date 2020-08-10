package com.test.mobile.mobilerecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mobile.mobilerecharge.entity.Customer;
import com.test.mobile.mobilerecharge.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository srepo;
	
	public List<Customer> listAll()
	{
		return srepo.findAll();
	}
	
	public Customer getCustomer(Long mobileno)
	{
		System.out.println("In service layer");
		Customer c=null;
		c=srepo.findById(mobileno).get();
		return c;
	}
	
	public Customer updateBalance(Long mobileno,Integer recharge)
	{
		Customer rCustomer = srepo.findById(mobileno).get();
		Integer curr_balance = rCustomer.getBalance();
		rCustomer.setBalance(curr_balance + recharge);
		srepo.save(rCustomer);		
		return rCustomer;
	}
	

}
