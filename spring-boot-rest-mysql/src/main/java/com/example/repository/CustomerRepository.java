package com.example.repository;

import java.util.List;
import com.example.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	@Query(value = "SELECT id, firstname, lastname, email FROM customer c WHERE c.email=?0")
	public List<Customer> findByEmail(String email);
}
