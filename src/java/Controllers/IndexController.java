package Controllers;

import java.util.*;
import Models.*;
import Views.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Utils.*;

public class IndexController{

	public static IndexView getViewContent(ServletContext context, HttpServletRequest request) {
		IndexView iv = new IndexView();
		List<Post> postList = null;
		List<Integer> counterItems = new ArrayList<>();
		int visitorCount = 0;

		try {
			String cs = context.getInitParameter("cs");
			int topCount = Integer.parseInt(context.getInitParameter("index_top"));

			postList = BlogPostDAO.getIndexTop(cs, topCount);

			int minDigits = Integer.parseInt(context.getInitParameter("min_counter_digits"));
			visitorCount = StatDAO.visitorCount(cs);
			counterItems = BlogUtils.generateCounterItems(visitorCount, minDigits);
			
			StatDAO.newVisitor(cs, request.getRemoteAddr(), request.getRequestURI(), new java.util.Date());
		} catch (Exception e) {
			e.printStackTrace();
		}

		iv.setPosts(postList);
		iv.setPageCounterItems(counterItems);
		return iv;
	}

}
