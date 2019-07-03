package DAO;

import java.util.*;
import java.sql.*;
import Models.*;

public class BlogPostDAO {

	public static List<Post> getIndexTop(String cs, int topCount) throws Exception {
		List<Post> postList = new ArrayList<>();

		Connection conn = DBContext.getConnection(cs);
		String sql = "select top(?) p.id, p.title, p.dc, p.blog_type, p.content, p.img, p.author, t.icon_class from BlogPosts as p join BlogTypes as t on p.blog_type=t.id order by p.dc desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, topCount);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			java.util.Date dc = rs.getTimestamp("dc");
			String pt = rs.getString("blog_type");
			String iconClass = rs.getString("icon_class");

			if (pt.equals("article")) {
				String content = rs.getString("content");
				String img = rs.getString("img");
				BlogPost p = new BlogPost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setContent(content);
				p.setImg(img);
				postList.add(p);
			} else if (pt.equals("quote")) {
				String quote = rs.getString("content");
				String author = rs.getString("author");
				QuotePost p = new QuotePost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setQuote(quote);
				p.setAuthor(author);
				postList.add(p);
			} else if (pt.equals("photo")) {
				String img = rs.getString("img");
				PhotoPost p = new PhotoPost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setImg(img);
				postList.add(p);
			}
		}
		return postList;
	}

	public static Post select(String cs, int id) throws Exception {
		Connection conn = DBContext.getConnection(cs);
		String sql = "select p.id, p.title, p.dc, p.blog_type, p.content, p.img, p.author, t.icon_class from BlogPosts as p join BlogTypes as t on p.blog_type=t.id where p.id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String title = rs.getString("title");
			java.util.Date dc = rs.getTimestamp("dc");
			String pt = rs.getString("blog_type");
			String iconClass = rs.getString("icon_class");

			if (pt.equals("article")) {
				String content = rs.getString("content");
				String img = rs.getString("img");
				BlogPost p = new BlogPost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setContent(content);
				p.setImg(img);
				return p;
			} else if (pt.equals("quote")) {
				String quote = rs.getString("content");
				String author = rs.getString("author");
				QuotePost p = new QuotePost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setQuote(quote);
				p.setAuthor(author);
				return p;
			} else if (pt.equals("photo")) {
				String img = rs.getString("img");
				PhotoPost p = new PhotoPost();
				p.setId(id);
				p.setDc(dc);
				p.setHeading(title);
				p.setIconClass(iconClass);
				p.setImg(img);
				return p;
			}
		}
		return null;
	}

	public static int numPosts(String cs) throws Exception {
		Connection conn = DBContext.getConnection(cs);
		String sql = "select count(*) as c from BlogPosts";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		int retval = 0;
		if (rs.next()) {
			retval = rs.getInt("c");
		}
		return retval;
	}

	public static List<Post> select(String cs, int startIdx, int endIdx) throws Exception {
		Connection conn = DBContext.getConnection(cs);
		String sql = "select * from (select ROW_NUMBER() over(order by dc desc) as rownum, id, title, dc from BlogPosts) as s where s.rownum > ? and s.rownum <= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, startIdx);
		ps.setInt(2, endIdx);
		ResultSet rs = ps.executeQuery();
		
		List<Post> postList = new ArrayList<>();
		
		while(rs.next()){
			Post p = new Post();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			java.util.Date dc = rs.getTimestamp("dc");
			p.setId(id);
			p.setHeading(title);
			p.setDc(dc);
			
			postList.add(p);
		}
		return postList;
	}
}
