package knk;

import java.sql.*;

public class DBConnection {
	
	private static Connection dbConnection;

	private final static String host = "localhost";
	private final static String dbName = "projektiKNK";
	private final static String username = "root";
	private final static String password = "programim";

	public static Connection getConnection() {
		if (dbConnection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, username, password);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return dbConnection;

	}

	public static void main(String[] args) {

	}
}
