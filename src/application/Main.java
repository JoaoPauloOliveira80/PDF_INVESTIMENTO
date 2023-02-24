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
	public static void main(String[] args) throws IOException {
		
		String caminho1 = "C:\\PROJETO DEV\\PDF_INVESTIMENTO/ResumoNegociacao_2023-02-23.csv";
		
		FileInputStream entradaArquivo = new FileInputStream(new File(caminho1));
		Scanner lerArq = new Scanner(entradaArquivo, "UTF-8");

	   List<Operacao> operacao = new ArrayList<>();
	   
	   
		while(lerArq.hasNext()) {
			String linha = lerArq.nextLine();
			
			
			if(linha != null && !linha.isEmpty()) {
				//System.out.println(linha);
								
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
		for(Operacao op : operacao) {
			System.out.println(op);
			
		}
		
		
		
		
		lerArq.close();	
	}
	
	public static void create() {
		boolean f = false;
		try {
			Connection conn = ConexaoMySQL.create();
			
			System.out.println("Testando");
			String sql = ("Insert into operacao (ativo,conta,dt_negociacao,price,qtd_compra,qtd_venda,valor_compra,valor_venda) values('?', '?', '?', '?', '?', '?', '?', '?')");
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(0, dados[0]);
			stmt.setInt(1,Integer.parseInt(dados[1]));
			stmt.setString(2, dados[2]);
			stmt.setDouble(3, Double.valueOf(dados[3].replace(",", ".")));
			stmt.setInt(4, Integer.parseInt(dados[4]));
			stmt.setInt(5, Integer.parseInt(dados[5]));
			stmt.setDouble(6, Double.valueOf(dados[6].replace(",", ".")));
			stmt.setDouble(7, Double.valueOf(dados[7].replace(",", ".")));
			
			
			stmt.executeUpdate();
			conn.close();
			stmt.close();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println(e);
		}
	}
}
