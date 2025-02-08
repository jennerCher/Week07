<<<<<<< HEAD
package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class  	 {
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		System.out.println("Conncecting with url" + url);
		
		
			
			try {
				Connection conn = DriverManager.getConnection(url);
				System.out.println("Successfully obtained connection!");
				return conn;
			} catch (SQLException e) {
				System.out.println("Erro getting connection");
				throw new DbException(e);
		
	}
	}
=======
package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		System.out.println("Conncecting with url" + url);
		
		
			
			try {
				Connection conn = DriverManager.getConnection(url);
				System.out.println("Successfully obtained connection!");
				return conn;
			} catch (SQLException e) {
				System.out.println("Erro getting connection");
				throw new DbException(e);
		
	}
	}
>>>>>>> 5f1187616e0b71d897f6df8e228d6ba0d7300099
}