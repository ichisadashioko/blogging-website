package Controllers;

import java.util.*;
import Models.*;
import Views.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Utils.*;

public class BlogController {

	public static BlogView getViewContent(ServletContext context, HttpServletRequest request) {
		BlogView view = new BlogView();
		Post post = null;
		List<Integer> counterItems = new ArrayList<>();
		int visitorCount = 0;

		try {
			String cs = context.getInitParameter("cs");
			int minDigits = Integer.parseInt(context.getInitParameter("min_counter_digits"));
			visitorCount = StatDAO.visitorCount(cs);
			counterItems = BlogUtils.generateCounterItems(visitorCount, minDigits);
			
			StatDAO.newVisitor(cs, request.getRemoteAddr(), request.getRequestURI(), new java.util.Date());
			
			int id = Integer.parseInt(request.getParameter("id"));
			post = BlogPostDAO.select(cs, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		view.setPost(post);
		view.setPageCounterItems(counterItems);
		return view;
	}
}
