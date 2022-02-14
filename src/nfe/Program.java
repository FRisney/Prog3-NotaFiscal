package nfe;

import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
