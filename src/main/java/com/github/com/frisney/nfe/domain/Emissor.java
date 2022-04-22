package com.github.com.frisney.nfe.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="emissores")
public class Emissor implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer Id;
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
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}

	public Emissor(){}
	public Emissor(String nome, String cnpj) {
		setNome(nome);
		setCnpj(cnpj);
	}
}
