package com.example.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "beneficiary")
public class Beneficiary {

	@EmbeddedId
	private BeneficiaryKey key;
	private String uf;
	private String codigoMunicipio;
	private String nomeMunicipio;
	private String codigoFuncao;
	private String codigoSubFuncao;
	private String codigoPrograma;
	private String codigoAcao;
	private String nomeBeneficiario;
	private String fonteFinalidade;
	private String mesReferencia;
	private double valorParcela;
	private String dataSaque;

	public Beneficiary() {

	}

	public Beneficiary(BeneficiaryKey key, String uf, String codigoMunicipio, String nomeMunicipio, String codigoFuncao,
			String codigoSubFuncao, String codigoPrograma, String codigoAcao, String nomeBeneficiario,
			String fonteFinalidade, String mesReferencia, double valorParcela, String dataSaque) {
		super();
		this.key = key;
		this.uf = uf;
		this.codigoMunicipio = codigoMunicipio;
		this.nomeMunicipio = nomeMunicipio;
		this.codigoFuncao = codigoFuncao;
		this.codigoSubFuncao = codigoSubFuncao;
		this.codigoPrograma = codigoPrograma;
		this.codigoAcao = codigoAcao;
		this.nomeBeneficiario = nomeBeneficiario;
		this.fonteFinalidade = fonteFinalidade;
		this.mesReferencia = mesReferencia;
		this.valorParcela = valorParcela;
		this.dataSaque = dataSaque;
	}

	public BeneficiaryKey getKey() {
		return key;
	}

	public void setKey(BeneficiaryKey key) {
		this.key = key;
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

	public String getDataSaque() {
		return dataSaque;
	}

	public void setDataSaque(String dataSaque) {
		this.dataSaque = dataSaque;
	}

	
}
