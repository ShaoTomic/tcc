package br.com.portifolio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection createConnection(){
		String host = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha ="";
		
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(host, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexao;
	}
}
