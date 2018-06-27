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

import java.util.ArrayList;
import java.util.List;

import com.example.model.Beneficiary;
import com.example.model.BeneficiaryKey;
import com.example.parsers.BeneficiaryParser;
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
	public ResponseEntity<?> get(@PathVariable(value = "id") String id) {
		List<com.example.model.Beneficiary> modelList = this.beneficiaryRepository.findByNis(id);

		if (modelList != null) {
			List<com.example.contracts.Beneficiary> contractList = new ArrayList<com.example.contracts.Beneficiary>(
					modelList.size());

			for (com.example.model.Beneficiary model : modelList) {
				contractList.add(BeneficiaryParser.Parse(model));
			}

			return ResponseEntity.ok(contractList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(value = "/{id}/{competency}", headers = "Accept=application/json")
	public ResponseEntity<?> getOne(@PathVariable(value = "id") String id,
			@PathVariable(value = "competency") String competency) {
		com.example.model.Beneficiary beneficiary = this.beneficiaryRepository
				.findOne(new BeneficiaryKey(id, competency));

		if (beneficiary != null) {
			return ResponseEntity.ok(BeneficiaryParser.Parse(beneficiary));
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(headers = "Accept=application/json")
	public ResponseEntity<?> add(@RequestBody com.example.contracts.Beneficiary input) {
		com.example.model.Beneficiary result = this.beneficiaryRepository.save(BeneficiaryParser.Parse(input));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getKey().getNisBeneficiario()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(headers = "Accept=application/json")
	public ResponseEntity<?> modify(@RequestBody com.example.contracts.Beneficiary input) {
		if (input != null && input.getNisBeneficiario().length() > 0) {
			this.beneficiaryRepository.save(BeneficiaryParser.Parse(input));

			return ResponseEntity.ok(input);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		if (id != null && id.length() > 0) {
			this.beneficiaryRepository.findByNis(id).forEach(b -> {
				this.beneficiaryRepository.delete(new BeneficiaryKey(id, b.getKey().getMesCompetencia()));
			});

			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getAll(
			@RequestParam(value = "nomeBeneficiario", required = false) String nomeBeneficiario) {
		List<com.example.model.Beneficiary> modelList = null;

		if (nomeBeneficiario != null) {
			modelList = this.beneficiaryRepository.findByName(nomeBeneficiario);
		} else {
			modelList = (List<Beneficiary>) this.beneficiaryRepository.findAll();
		}

		if (modelList != null) {
			List<com.example.contracts.Beneficiary> contractList = new ArrayList<com.example.contracts.Beneficiary>(
					modelList.size());

			for (com.example.model.Beneficiary model : modelList) {
				contractList.add(BeneficiaryParser.Parse(model));
			}

			return ResponseEntity.ok(contractList);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}