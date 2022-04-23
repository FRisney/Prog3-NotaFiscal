package com.github.frisney.nfe.domain.interfaces;

import com.github.frisney.nfe.domain.Cliente;
import com.github.frisney.nfe.domain.Emissor;
import com.github.frisney.nfe.domain.NotaFiscal;
import com.github.frisney.nfe.domain.Produto;

import java.util.Date;
import java.util.List;

public interface INotaFiscalBuilder {
    NotaFiscal gera();
    void setNumero(String numero);
    void setChave(String chave);
    void setData(Date data);
    void setCliente(Cliente cliente);
    void setEmissor(Emissor emissor);
    void setProdutos(List<Produto> produtos);
}
