package application.modal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacao {
	private String dtNegociacao;
	private Integer conta;
	private String ativo;
	private Double price;
	private Integer qtdCompra;
	private Integer qtdVenda;
	private Double valorCompra;
	private Double valorVenda;

	public Operacao() {
		// TODO Auto-generated constructor stub
	}

	public Operacao(String dtNegociacao, Integer conta, String ativo, Double price, Integer qtdCompra, Integer qtdVenda,
			Double valorCompra, Double valorVenda) {
		super();
		this.dtNegociacao = dtNegociacao;
		this.conta = conta;
		this.ativo = ativo;
		this.price = price;
		this.qtdCompra = qtdCompra;
		this.qtdVenda = qtdVenda;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
	}

	public String getDtNegociacao() {
		return dtNegociacao;
	}

	public void setDtNegociacao(String dtNegociacao) {
		this.dtNegociacao = dtNegociacao;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(Integer qtdCompra) {
		this.qtdCompra = qtdCompra;
	}

	public Integer getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(Integer qtdVenda) {
		this.qtdVenda = qtdVenda;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	@Override
	public String toString() {
		return "Operacao [dtNegociacao=" + dtNegociacao + ", conta=" + conta + ", ativo=" + ativo + ", price=" + price
				+ ", qtdCompra=" + qtdCompra + ", qtdVenda=" + qtdVenda + ", valorCompra=" + valorCompra
				+ ", valorVenda=" + valorVenda + "]";
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void getPer() throws FileNotFoundException {
		String caminho1 = "C:\\PROJETO DEV\\PDF_INVESTIMENTO/negociacao.csv";

		FileInputStream entradaArquivo = new FileInputStream(new File(caminho1));

		Scanner lerArq = new Scanner(entradaArquivo, "UTF-8");

		List<Operacao> operacao = new ArrayList<>();
		while (lerArq.hasNext()) {
			String linha = lerArq.nextLine();

			if (linha != null && !linha.isEmpty()) {
				// System.out.println(linha);

				String[] dados = linha.split("\\;");

				Operacao op = new Operacao();
				op.setDtNegociacao(dados[0]);
				op.setConta(Integer.parseInt(dados[1]));
				op.setAtivo(dados[2]);
				op.setPrice(Double.valueOf(dados[3].replace(",", ".")));
				op.setQtdCompra(Integer.parseInt(dados[4]));
				op.setQtdVenda(Integer.parseInt(dados[5]));
				op.setValorCompra(Double.valueOf(dados[6].replace(",", ".")));
				op.setValorVenda(Double.valueOf(dados[7].replace(",", ".")));

				operacao.add(op);
			}
		}

		System.out.println(operacao);
		for (Operacao op : operacao) {
			System.out.println(op);
		}
		lerArq.close();
	}

}
