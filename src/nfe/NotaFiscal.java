package nfe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
	private String numero;
	private String chave;
	private LocalDate data;
	private Cliente cliente;
	private Emissor emissor;
	private List<Produto> produtos;

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Emissor getEmissor() {
		return emissor;
	}
	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public NotaFiscal(String numero, String chave, LocalDate data, Cliente cliente, Emissor emissor) {
		super();
		this.numero = numero;
		this.chave = chave;
		this.data = data;
		this.cliente = cliente;
		this.emissor = emissor;
		this.produtos = new ArrayList<Produto>();
	}
	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);
	}
}
