package com.test.mobile.mobilerecharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.mobile.mobilerecharge.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
