package com.github.com.frisney.nfe.domain;

public class Emissor {
	private String nome;
	private String cnpj;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Emissor(String nome, String cnpj) {
		setNome(nome);
		setCnpj(cnpj);
	}

}
