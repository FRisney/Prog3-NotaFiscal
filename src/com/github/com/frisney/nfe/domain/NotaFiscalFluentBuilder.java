package com.github.com.frisney.nfe.domain;

import com.github.com.frisney.nfe.domain.interfaces.INotaFiscalFluentBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalFluentBuilder implements INotaFiscalFluentBuilder {
    private String numero;
    private String chave;
    private LocalDate data;
    private Cliente cliente;
    private Emissor emissor;
    private List<Produto> produtos = new ArrayList<>();

    public static NotaFiscalFluentBuilder builder(){
        return new NotaFiscalFluentBuilder();
    }

    public  NotaFiscalFluentBuilder addProduto(Produto produto){
        this.produtos.add(produto);
        return this;
    }

    @Override
    public NotaFiscal gera() {
        NotaFiscal nf = new NotaFiscal(numero, chave, data, cliente, emissor,produtos);
        return nf;
    }
    @Override
    public NotaFiscalFluentBuilder setNumero(String numero) { this.numero = numero;
        return this;
    }
    @Override
    public NotaFiscalFluentBuilder setChave(String chave) { this.chave = chave;
        return this;
    }
    @Override
    public NotaFiscalFluentBuilder setData(LocalDate data) { this.data = data;
        return this;
    }
    @Override
    public NotaFiscalFluentBuilder setCliente(Cliente cliente) { this.cliente = cliente;
        return this;
    }
    @Override
    public NotaFiscalFluentBuilder setEmissor(Emissor emissor) { this.emissor = emissor;
        return this;
    }
    @Override
    public NotaFiscalFluentBuilder setProdutos(List<Produto> produtos) { this.produtos = produtos;
        return this;
    }
}
