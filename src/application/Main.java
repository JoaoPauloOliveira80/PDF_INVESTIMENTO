package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.connection.ConexaoMySQL;
import application.modal.Operacao;

public class Main {

	static String[] dados;
	static List<Operacao> operacao;
	
	Operacao op;
	public static void main(String[] args) throws IOException {

		String caminho1 = "C:\\PROJETO DEV\\PDF_INVESTIMENTO/ResumoNegociacao_2023-02-23.csv";

		FileInputStream entradaArquivo = new FileInputStream(new File(caminho1));
		Scanner lerArq = new Scanner(entradaArquivo, "UTF-8");

		operacao = new ArrayList<>();

		while (lerArq.hasNext()) {
			String linha = lerArq.nextLine();

			if (linha != null && !linha.isEmpty()) {
				// System.out.println(linha);

				dados = linha.split("\\;");

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

				create();

			}
		}

		System.out.println(operacao);
		
		
		for (Operacao op : operacao) {
			System.out.println(op);
						

		}

		lerArq.close();
	}

	public static void create() {
		boolean f = false;
		try {
			Connection conn = ConexaoMySQL.create();

			String mysql = "INSERT INTO operacao (id, ativo, conta, dt_negociacao, price, qtd_compra, qtd_venda, valor_compra, valor_venda)	VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(mysql);
			
			int cont = 1;
			for (Operacao op : operacao) {
				 
				
				
										
					op.setId(cont);
				
				
//				System.out.println("Id: " + cont);
//				System.out.println("Testando" + op.getAtivo());
				stmt.setInt(1, op.getId());
				stmt.setString(2, op.getAtivo().replaceAll("\"", ""));
				stmt.setInt(3, op.getConta());
				stmt.setString(4, op.getDtNegociacao());
				stmt.setDouble(5, op.getPrice());
				stmt.setInt(6, Integer.valueOf(op.getQtdCompra()));
				stmt.setInt(7, Integer.valueOf(op.getQtdVenda()));
				stmt.setDouble(8, op.getValorCompra());
				stmt.setDouble(9, op.getQtdVenda());
				
				cont++;
				if(op.getId() > 0) {
					
				}else {
					System.out.println("Ocorreu um erro");
				}
			}

			stmt.executeUpdate();
			conn.close();
			stmt.close();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
	}
}
