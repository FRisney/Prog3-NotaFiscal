package com.github.com.frisney.nfe.test;

import com.github.com.frisney.nfe.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		Emissor emissor = new Emissor("nome emissor","cnpj");
		Cliente cli = new Cliente("documento","nome");
		LocalDate data = LocalDate.now();
		List<Produto> prods = new ArrayList<>();
		prods.add(new Produto(1,"produto 1","produto 1",10.0f,2));
		prods.add(new Produto(2,"produto 2","produto 2",10.0f,2));
		prods.add(new Produto(3,"produto 3","produto 3",10.0f,2));
		NotaFiscalBuilder nfb = new NotaFiscalBuilder();
		nfb.setChave("chave");
		nfb.setNumero("numero");
		nfb.setData(data);
		nfb.setEmissor(emissor);
		nfb.setCliente(cli);
		nfb.setProdutos(prods);
		NotaFiscal nf = nfb.gera();
		System.out.println(nf.getProdutos().get(0).getDescricao());
		System.out.println(nf.getProdutos().get(1).getDescricao());
		System.out.println(nf.getProdutos().get(2).getDescricao());
	}

}
