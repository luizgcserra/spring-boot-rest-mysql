package com.example.repository;

import java.util.List;
import com.example.model.Beneficiary;
import com.example.model.BeneficiaryKey;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, BeneficiaryKey> {
	
	@Query(value="FROM beneficiary WHERE nome_beneficiario=:name")
	public List<Beneficiary> findByName(@Param("name") String name);
	
	@Query(value="FROM beneficiary WHERE nis_beneficiario=:nisBeneficiario")
	public List<Beneficiary> findByNis(@Param("nisBeneficiario") String nisBeneficiario);
}
