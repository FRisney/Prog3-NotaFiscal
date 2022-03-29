package com.github.com.frisney.nfe.domain;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
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

	public Cliente(){}
	public Cliente(String documento, String nome) {
		setDocumento(documento);
		setNome(nome);
	}
	

}
