package it.polito.tdp.ruzzle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnect {
	
private static String jdbcURL="jdbc:mysql://localhost/dizionario?user=root&password=";
	
	public static Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore connessione database", e);
		}
	}

}
