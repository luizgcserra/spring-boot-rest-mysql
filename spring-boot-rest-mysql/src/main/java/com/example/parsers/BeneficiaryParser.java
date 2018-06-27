package com.example.parsers;

public class BeneficiaryParser {

	public static com.example.contracts.Beneficiary Parse(com.example.model.Beneficiary model) {
		return new com.example.contracts.Beneficiary(model.getCodigoPrograma(), model.getKey().getNisBeneficiario(),
				model.getNomeMunicipio(), model.getFonteFinalidade(), model.getDataSaque(), model.getValorParcela(),
				model.getNomeBeneficiario(), model.getKey().getMesCompetencia(), model.getCodigoFuncao(),
				model.getMesReferencia(), model.getUf(), model.getCodigoMunicipio(), model.getCodigoAcao(),
				model.getCodigoSubFuncao());
	}

	public static com.example.model.Beneficiary Parse(com.example.contracts.Beneficiary contract) {
		return new com.example.model.Beneficiary(
				new com.example.model.BeneficiaryKey(contract.getNisBeneficiario(),
						contract.getMesCompetencia().replace("/", "")),
				contract.getUf(), contract.getCodigoMunicipio(), contract.getNomeMunicipio(),
				contract.getCodigoFuncao(), contract.getCodigoSubFuncao(), contract.getCodigoPrograma(),
				contract.getCodigoAcao(), contract.getNomeBeneficiario(), contract.getFonteFinalidade(),
				contract.getMesReferencia(), contract.getValorParcela(), contract.getDataSaque());
	}

}
