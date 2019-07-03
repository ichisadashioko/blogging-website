
import java.sql.*;
import java.util.*;
import Models.*;
import DAO.*;
import Utils.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// us-123my-life.simplesite.com

		String cs = "jdbc:sqlserver://localhost:2222;databaseName=Blogging;integratedSecurity=true;";
		java.util.Date time = new java.util.Date();
		System.out.println(time);
		System.out.println(BlogUtils.formatSQLDate(time));
		StatDAO.newVisitor(cs, "255.255.255.10", "index.html", time);
	}
}
