package com.github.com.frisney.nfe.test;

import com.github.com.frisney.nfe.domain.*;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Program {

	public static void main(String[] args) {
		NotaFiscal nf1 = NotaFiscalFluentBuilder.builder()
				.setChave("chavmassa")
				.setNumero("12356789")
				.setData(LocalDate.now())
				.setEmissor(new Emissor("nome emissor","cnpj"))
				.setCliente(new Cliente("documento","nome"))
				.gera();

		NotaFiscal nf2 = NotaFiscalFluentBuilder.builder()
			.setChave("chave")
			.setNumero("nmr")
			.setData(LocalDate.now())
			.setEmissor(new Emissor("nome emissor","cnpj"))
			.setCliente(new Cliente("documento","nome"))
			.addProduto(new Produto(1,"produto 1","produto 1", new BigDecimal(0.0f),2))
			.addProduto(new Produto(2,"produto 2","produto 2", new BigDecimal(10.0f),2))
			.addProduto(new Produto(3,"produto 3","produto 3", new BigDecimal(10.0f),2))
			.gera();

		System.out.println(nf1.getChave());
		System.out.println(nf2.getProdutos().get(2).getDescricao());
		System.out.println(nf2.getProdutos().get(1).getDescricao());
		System.out.println(nf2.getProdutos().get(0).getDescricao());
	}

}
