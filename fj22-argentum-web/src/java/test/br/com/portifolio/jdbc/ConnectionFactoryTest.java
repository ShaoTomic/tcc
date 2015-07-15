package br.com.portifolio.jdbc;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void  createConnectionTest() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.createConnection();
	}

}
