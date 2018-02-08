package com.example.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> getOne(@PathVariable(value = "id") int id) {
		Customer customer = this.customerRepository.findOne(id);

		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(headers = "Accept=application/json")
	public ResponseEntity<?> add(@RequestBody Customer input) {
		Customer result = this.customerRepository.save(input);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(headers = "Accept=application/json")
	public ResponseEntity<?> modify(@RequestBody Customer input) {
		if (input != null && input.getId() > 0) {
			this.customerRepository.save(input);

			return ResponseEntity.ok(input);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
		if (id > 0) {
			this.customerRepository.delete(id);

			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> get(@RequestParam(value = "email", required = false) String email) {
		if (email != null) {
			return ResponseEntity.ok(this.customerRepository.findByEmail(email));
		} else {
			return ResponseEntity.ok(this.customerRepository.findAll());
		}
	}

}