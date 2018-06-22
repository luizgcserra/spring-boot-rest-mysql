package com.example.repository;

import java.util.List;
import com.example.model.Beneficiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, String> {
	
	@Query(value="FROM beneficiary WHERE nomeBeneficiario=?0")
	public List<Beneficiary> findByName(String name);
}
