package com.github.com.frisney.nfe.test;

import com.github.com.frisney.nfe.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		NotaFiscal nf = NotaFiscalFluentBuilder.builder()
			.setChave("chave")
			.setNumero("numero")
			.setData(LocalDate.now())
			.setEmissor(new Emissor("nome emissor","cnpj"))
			.setCliente(new Cliente("documento","nome"))
			.addProduto(new Produto(1,"produto 1","produto 1",10.0f,2))
			.addProduto(new Produto(2,"produto 2","produto 2",10.0f,2))
			.addProduto(new Produto(3,"produto 3","produto 3",10.0f,2))
			.gera();

		System.out.println(nf.getProdutos().get(2).getDescricao());
		System.out.println(nf.getProdutos().get(1).getDescricao());
		System.out.println(nf.getProdutos().get(0).getDescricao());
	}

}
