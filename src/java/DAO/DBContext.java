package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

	public static Connection getConnection(String cs) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(cs);
		return conn;
	}
}
