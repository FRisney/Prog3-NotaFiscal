package com.github.com.frisney.nfe.domain;

import com.github.com.frisney.nfe.domain.exceptions.ProdutoCodigoTamanhoInvalidoException;
import com.github.com.frisney.nfe.domain.exceptions.ProdutoValorZeroException;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="produtos")
public class Produto implements Serializable {
	private static final Integer CODIGO_MIN_LENGTH = 5;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private Integer quant;

	public Produto(){}
	public Produto(Integer id, String nome, String descricao, BigDecimal valor, Integer quant) {
		super();
		try {
			setId(id);
			setNome(nome);
			setDescricao(descricao);
			setValor(valor);
		} catch (ProdutoValorZeroException | ProdutoCodigoTamanhoInvalidoException e) {
			e.printStackTrace();
		}
		setQuant(quant);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) throws ProdutoCodigoTamanhoInvalidoException {
		if (id.toString().length() < CODIGO_MIN_LENGTH){
			this.id = Integer.parseInt(Formatter.padLeft(id.toString(),CODIGO_MIN_LENGTH));
			throw new ProdutoCodigoTamanhoInvalidoException();
		}
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) throws ProdutoValorZeroException {
		if (valor.equals(BigDecimal.ZERO)){
			throw new ProdutoValorZeroException();
		}
		this.valor = valor;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
}
