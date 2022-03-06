package com.github.com.frisney.nfe.test;

import com.github.com.frisney.nfe.domain.Cliente;
import com.github.com.frisney.nfe.domain.Emissor;
import com.github.com.frisney.nfe.domain.NotaFiscal;
import com.github.com.frisney.nfe.domain.Produto;

import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {
		Emissor emissor = new Emissor("nome emissor","cnpj");
		Cliente cli = new Cliente("documento","nome");
		LocalDate data = LocalDate.now();
		NotaFiscal nf = new NotaFiscal("numero","chave",data,cli,emissor);
		nf.adicionaProduto(new Produto(1,"produto 1","produto 1",10.0f,2));
		nf.adicionaProduto(new Produto(2,"produto 2","produto 2",10.0f,2));
		nf.adicionaProduto(new Produto(3,"produto 3","produto 3",10.0f,2));
		System.out.println(nf.getProdutos().get(2).getDescricao());
	}

}
