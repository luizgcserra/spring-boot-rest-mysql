package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "beneficiary")
public class Beneficiary {

	private String uf;
	private String codigoMunicipio;
	private String nomeMunicipio;
	private String codigoFuncao;
	private String codigoSubFuncao;
	private String codigoPrograma;
	private String codigoAcao;
	@Id
	private String nisBeneficiario;
	private String nomeBeneficiario;
	private String fonteFinalidade;
	private String mesReferencia;
	private double valorParcela;
	private String mesCompetencia;
	private String dataSaque;

	public Beneficiary() {

	}

	public Beneficiary(String codigoPrograma, String nisBeneficiario, String nomeMunicipio, String fonteFinalidade,
			String dataSaque, double valorParcela, String nomeBeneficiario, String mesCompetencia, String codigoFuncao,
			String mesReferencia, String uf, String codigoMunicipio, String codigoAcao, String codigoSubFuncao) {
		super();
		this.codigoPrograma = codigoPrograma;
		this.nisBeneficiario = nisBeneficiario;
		this.nomeMunicipio = nomeMunicipio;
		this.fonteFinalidade = fonteFinalidade;
		this.dataSaque = dataSaque;
		this.valorParcela = valorParcela;
		this.nomeBeneficiario = nomeBeneficiario;
		this.mesCompetencia = mesCompetencia;
		this.codigoFuncao = codigoFuncao;
		this.mesReferencia = mesReferencia;
		this.uf = uf;
		this.codigoMunicipio = codigoMunicipio;
		this.codigoAcao = codigoAcao;
		this.codigoSubFuncao = codigoSubFuncao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getCodigoFuncao() {
		return codigoFuncao;
	}

	public void setCodigoFuncao(String codigoFuncao) {
		this.codigoFuncao = codigoFuncao;
	}

	public String getCodigoSubFuncao() {
		return codigoSubFuncao;
	}

	public void setCodigoSubFuncao(String codigoSubFuncao) {
		this.codigoSubFuncao = codigoSubFuncao;
	}

	public String getCodigoPrograma() {
		return codigoPrograma;
	}

	public void setCodigoPrograma(String codigoPrograma) {
		this.codigoPrograma = codigoPrograma;
	}

	public String getCodigoAcao() {
		return codigoAcao;
	}

	public void setCodigoAcao(String codigoAcao) {
		this.codigoAcao = codigoAcao;
	}

	public String getNisBeneficiario() {
		return nisBeneficiario;
	}

	public void setNisBeneficiario(String nisBeneficiario) {
		this.nisBeneficiario = nisBeneficiario;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public String getFonteFinalidade() {
		return fonteFinalidade;
	}

	public void setFonteFinalidade(String fonteFinalidade) {
		this.fonteFinalidade = fonteFinalidade;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public String getMesCompetencia() {
		return mesCompetencia;
	}

	public void setMesCompetencia(String mesCompetencia) {
		this.mesCompetencia = mesCompetencia;
	}

	public String getDataSaque() {
		return dataSaque;
	}

	public void setDataSaque(String dataSaque) {
		this.dataSaque = dataSaque;
	}
	
	
}
