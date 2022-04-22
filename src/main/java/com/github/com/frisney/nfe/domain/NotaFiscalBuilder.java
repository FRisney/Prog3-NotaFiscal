package com.github.com.frisney.nfe.domain;

import com.github.com.frisney.nfe.domain.interfaces.INotaFiscalBuilder;

import java.util.Date;
import java.util.List;

public class NotaFiscalBuilder implements INotaFiscalBuilder {
    private String numero;
    private String chave;
    private Date data;
    private Cliente cliente;
    private Emissor emissor;
    private List<Produto> produtos;

    @Override
    public NotaFiscal gera() {
        NotaFiscal nf = new NotaFiscal(numero, chave, data, cliente, emissor,produtos);
        return nf;
    }
    @Override
    public void setNumero(String numero) { this.numero = numero; }
    @Override
    public void setChave(String chave) { this.chave = chave; }
    @Override
    public void setData(Date data) { this.data = data; }
    @Override
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    @Override
    public void setEmissor(Emissor emissor) { this.emissor = emissor; }
    @Override
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
