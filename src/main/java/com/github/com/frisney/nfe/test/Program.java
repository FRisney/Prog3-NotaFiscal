package com.github.com.frisney.nfe.test;

import com.github.com.frisney.nfe.domain.*;
import com.github.com.frisney.nfe.repositories.ClienteRepository;
import com.github.com.frisney.nfe.repositories.EmissorRepository;
import com.github.com.frisney.nfe.repositories.NotaFiscalRepository;
import com.github.com.frisney.nfe.repositories.ProdutoRepository;
import com.github.com.frisney.nfe.repositories.interfaces.IBasicRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		IBasicRepository<Cliente,Integer> cliServ = new ClienteRepository();
		IBasicRepository<Emissor,Integer> emiServ = new EmissorRepository();
		IBasicRepository<Produto,Integer> prodServ = new ProdutoRepository();
		IBasicRepository<NotaFiscal,Integer> notaServ = new NotaFiscalRepository();
		Cliente cli = cliServ.byId(1);
		if (cli == null){
			cli = new Cliente("documento","cliente");
			cliServ.insert(cli);
		}
		Emissor emi = emiServ.byId(1);
		if (emi == null){
			emi = new Emissor("nome emissor","cnpj");
			emiServ.insert(emi);
		}
		List<Produto> produtos = prodServ.all();
		if (produtos.isEmpty()){
			Produto prod1 = new Produto(342342,"Lol","Produto",new BigDecimal(25.0f),1);
			prodServ.insert(prod1);
			produtos.add(prod1);
		}
		NotaFiscal nf1 = NotaFiscalFluentBuilder.builder()
				.setChave("12356789")
				.setNumero("12356789")
				.setData(new Date())
				.setEmissor(emi)
				.setCliente(cli)
				.setProdutos(produtos)
				.gera();
		notaServ.insert(nf1);
		System.out.println(nf1.getProdutos().get(0).getDescricao());
	}

}
