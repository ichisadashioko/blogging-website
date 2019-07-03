package DAO;

import java.util.*;
import java.sql.*;
import Utils.*;

public class StatDAO {

	public static void newVisitor(String cs, String ip, String requestUrl, java.util.Date time) throws Exception {
		Connection conn = DBContext.getConnection(cs);

		String sql = "insert into visit_history(ip, time_visit, request_url) values (?, ? , ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, ip);
        ps.setString(3, requestUrl);
        ps.setString(2, BlogUtils.formatSQLDate(time));

        ps.executeUpdate();
	}
}
