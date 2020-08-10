package com.test.mobile.mobilerecharge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long mobileno;
	private String name;
	private Integer balance;
	public Customer() {}
	
	public Customer(Long mobileno, String name, Integer balance) {
		super();
		//this.customerId = customerId;
		this.mobileno = mobileno;
		this.name = name;
		this.balance = balance;
	}

	
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [mobileno=" + mobileno + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
	

}
