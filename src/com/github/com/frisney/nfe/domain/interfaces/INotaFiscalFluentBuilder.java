package com.github.com.frisney.nfe.domain.interfaces;

import com.github.com.frisney.nfe.domain.Cliente;
import com.github.com.frisney.nfe.domain.Emissor;
import com.github.com.frisney.nfe.domain.NotaFiscal;
import com.github.com.frisney.nfe.domain.NotaFiscalFluentBuilder;
import com.github.com.frisney.nfe.domain.Produto;

import java.time.LocalDate;
import java.util.List;

public interface INotaFiscalFluentBuilder {
    NotaFiscal gera();
    NotaFiscalFluentBuilder setNumero(String numero);
    NotaFiscalFluentBuilder setChave(String chave);
    NotaFiscalFluentBuilder setData(LocalDate data);
    NotaFiscalFluentBuilder setCliente(Cliente cliente);
    NotaFiscalFluentBuilder setEmissor(Emissor emissor);
    NotaFiscalFluentBuilder setProdutos(List<Produto> produtos);
}
