package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

	private static boolean loadFlag = false;

	public static Connection getConnection(String cs) throws Exception {
		if (!loadFlag) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			loadFlag = true;
		}
		Connection conn = DriverManager.getConnection(cs);
		return conn;
	}
}
