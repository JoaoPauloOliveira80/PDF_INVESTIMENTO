package application.modal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacao {
	private int id;
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

	

	public Operacao(int id, String dtNegociacao, Integer conta, String ativo, Double price, Integer qtdCompra,
			Integer qtdVenda, Double valorCompra, Double valorVenda) {
		super();
		this.id = id;
		this.dtNegociacao = dtNegociacao;
		this.conta = conta;
		this.ativo = ativo;
		this.price = price;
		this.qtdCompra = qtdCompra;
		this.qtdVenda = qtdVenda;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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

	
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return "Operacao [id=" + id + ", dtNegociacao=" + dtNegociacao + ", conta=" + conta + ", ativo=" + ativo
				+ ", price=" + price + ", qtdCompra=" + qtdCompra + ", qtdVenda=" + qtdVenda + ", valorCompra="
				+ valorCompra + ", valorVenda=" + valorVenda + "]";
	}
	
}
