package com.github.frisney.nfe.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
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

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + id +
				", documento='" + documento + '\'' +
				", nome='" + nome + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
