package com.example.controllers;

import java.lang.reflect.Type;
import java.net.URI;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import java.util.List;
import com.example.repository.BeneficiaryRepository;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	private final BeneficiaryRepository beneficiaryRepository;

	public BeneficiaryController(BeneficiaryRepository beneficiaryRepository) {
		this.beneficiaryRepository = beneficiaryRepository;
	}

	@GetMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> getOne(@PathVariable(value = "id") String id) {
		com.example.model.Beneficiary beneficiary = this.beneficiaryRepository.findOne(id);
		ModelMapper mapper = new ModelMapper();

		if (beneficiary != null) {
			return ResponseEntity.ok(mapper.map(beneficiary, com.example.contracts.Beneficiary.class));
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(headers = "Accept=application/json")
	public ResponseEntity<?> add(@RequestBody com.example.contracts.Beneficiary input) {
		ModelMapper mapper = new ModelMapper();
		com.example.model.Beneficiary result = this.beneficiaryRepository
				.save(mapper.map(input, com.example.model.Beneficiary.class));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getNisBeneficiario()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(headers = "Accept=application/json")
	public ResponseEntity<?> modify(@RequestBody com.example.contracts.Beneficiary input) {
		if (input != null && input.getNisBeneficiario().length() > 0) {
			ModelMapper mapper = new ModelMapper();

			this.beneficiaryRepository.save(mapper.map(input, com.example.model.Beneficiary.class));

			return ResponseEntity.ok(input);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		if (id != null && id.length() > 0) {
			this.beneficiaryRepository.delete(id);

			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> get(@RequestParam(value = "nomeBeneficiario", required = false) String nomeBeneficiario) {
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<com.example.contracts.Beneficiary>>() {}.getType();
		
		if (nomeBeneficiario != null) {
			return ResponseEntity.ok(
					mapper.map(this.beneficiaryRepository.findByName(nomeBeneficiario), listType));
		} else {
			return ResponseEntity
					.ok(mapper.map(this.beneficiaryRepository.findAll(), listType));
		}
	}

}