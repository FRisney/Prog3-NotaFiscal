package com.github.com.frisney.nfe.domain.interfaces;

import com.github.com.frisney.nfe.domain.Cliente;
import com.github.com.frisney.nfe.domain.Emissor;
import com.github.com.frisney.nfe.domain.NotaFiscal;
import com.github.com.frisney.nfe.domain.Produto;

import java.util.Date;
import java.util.List;

public interface INotaFiscalFluentBuilder {
    NotaFiscal gera();
    INotaFiscalFluentBuilder setNumero(String numero);
    INotaFiscalFluentBuilder setChave(String chave);
    INotaFiscalFluentBuilder setData(Date data);
    INotaFiscalFluentBuilder setCliente(Cliente cliente);
    INotaFiscalFluentBuilder setEmissor(Emissor emissor);
    INotaFiscalFluentBuilder setProdutos(List<Produto> produtos);
}
