package Controllers;

import java.util.*;
import Models.*;
import Views.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;

public class IndexController {

	public static IndexView getViewContent(ServletContext context, HttpServletRequest request) {
		IndexView iv = new IndexView();
		List<Post> postList = null;
		int visitorCount = 0;

		try {
			String cs = context.getInitParameter("cs");
			int topCount = Integer.parseInt(context.getInitParameter("index_top"));
			
			postList = BlogPostDAO.getIndexTop(cs, topCount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		iv.setPosts(postList);
		iv.setVisitorCount(visitorCount);
		return iv;
	}

}
