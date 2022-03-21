package com.github.com.frisney.nfe.domain;

import com.github.com.frisney.nfe.domain.exceptions.ChaveTamanhoInvalidoException;
import com.github.com.frisney.nfe.domain.exceptions.ListaProdutosVaziaException;
import com.github.com.frisney.nfe.domain.exceptions.NumeroTamanhoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
	private static final int CHAVE_LENGTH = 44;
	private static final int NUMERO_LENGTH = 9;
	private String numero;
	private String chave;
	private LocalDate data;
	private Cliente cliente;
	private Emissor emissor;
	private List<Produto> produtos;

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) throws NumeroTamanhoInvalidoException {
		if (numero.length() > NUMERO_LENGTH) {
			throw new NumeroTamanhoInvalidoException();
		}
		this.numero = numero;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) throws ChaveTamanhoInvalidoException {
		if (chave.length() > CHAVE_LENGTH) {
			throw new ChaveTamanhoInvalidoException();
		}
		if (chave.length() < CHAVE_LENGTH) {
			chave = Formatter.padRight(chave,CHAVE_LENGTH);
		}
		this.chave = chave;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Emissor getEmissor() {
		return emissor;
	}
	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) throws ListaProdutosVaziaException {
		if (produtos.isEmpty()){
			throw new ListaProdutosVaziaException();
		}
		this.produtos = produtos;
	}
	public NotaFiscal(String numero, String chave, LocalDate data, Cliente cliente, Emissor emissor,List<Produto> produtos) {
		super();
		try {
			setChave(chave);
		} catch (ChaveTamanhoInvalidoException e) {
			e.printStackTrace();
		}
		try {
			setNumero(numero);
		} catch (NumeroTamanhoInvalidoException e) {
			e.printStackTrace();
		}
		try {
			setProdutos(produtos);
		} catch (ListaProdutosVaziaException e) {
			e.printStackTrace();
		}
		setData(data);
		setCliente(cliente);
		setEmissor(emissor);
	}
}
