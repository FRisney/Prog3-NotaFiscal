package com.github.com.frisney.nfe.domain;

public class Cliente {
	private String documento;
	private String nome;

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente(String documento, String nome) {
		setDocumento(documento);
		setNome(nome);
	}
	

}
