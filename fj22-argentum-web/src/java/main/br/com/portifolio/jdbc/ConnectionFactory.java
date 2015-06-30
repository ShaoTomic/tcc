package br.com.portifolio.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	public Connection createConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
		
		
		Properties prop = new Properties();
		
		System.out.println("iniciando ...");
		
		prop.load(new FileInputStream(System.getProperty("user.home")+"/Desenvolvimento/workspaces/workspace-portifolio/loja/mydb.cfg"));
		System.out.println("user.home:"+System.getProperty("user.home"));
		String host = prop.getProperty("host").toString();
		String username = prop.getProperty("username").toString();
		String password = prop.getProperty("password").toString();
		String driver = prop.getProperty("driver").toString();
		
        System.out.println("host: " + host + "\n username: " + username + "\n password: " + password + "\ndriver: " + driver);	
     
        Class.forName(driver);
        System.out.println("--------------------------");
        System.out.println("DRIVER: " + driver);
        Connection connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);

        return connection;
	}
}
