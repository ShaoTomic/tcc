package br.com.portifolio.jdbc;

import java.sql.Connection;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void testeDeConexaoAoDB() {
		Connection con = ConnectionFactory.createConnection();
	}

}
