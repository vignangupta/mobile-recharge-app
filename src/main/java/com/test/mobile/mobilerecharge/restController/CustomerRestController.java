package com.test.mobile.mobilerecharge.restController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.mobile.mobilerecharge.entity.Customer;
import com.test.mobile.mobilerecharge.service.CustomerService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService service;
	
	@RequestMapping("/customers")
	public List<Customer> listCustomer()
	{
		return service.listAll();
	}
	
	@RequestMapping(path="/{mobileno}")
	public String getCustomer(@PathVariable("mobileno")Long mobileno)
	{
		try {
		Customer rC = service.getCustomer(mobileno);
		return rC.toString();
		} catch (NoSuchElementException e) {
			return "Mobile number does not exist..!!";
		}
	}
	@PutMapping(path="/{mobileno}",consumes="application/json")
	public String update(@RequestBody Integer recharge, @PathVariable Long mobileno) {
		try {
			Customer existCustomer = service.getCustomer(mobileno);
			service.updateBalance(mobileno, recharge);
			return existCustomer.toString();
		} catch (NoSuchElementException e) {
			return "Enter valid details";
		}
	}
//	public ResponseEntity<?> update(@RequestBody Integer recharge, @PathVariable Long mobileno) {
//		try {
//			Customer existCustomer = service.getCustomer(mobileno);
//			service.updateBalance(mobileno, recharge);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	

}
