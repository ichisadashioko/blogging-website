package Controllers;

import java.util.*;
import Models.*;
import Views.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Utils.*;

public class AboutController {

	public static AboutView getViewContent(ServletContext context, HttpServletRequest request) {
		AboutView view = new AboutView();
		List<Integer> counterItems = new ArrayList<>();
		int visitorCount = 0;

		try {
			String cs = context.getInitParameter("cs");
			int minDigits = Integer.parseInt(context.getInitParameter("min_counter_digits"));
			visitorCount = StatDAO.visitorCount(cs);
			counterItems = BlogUtils.generateCounterItems(visitorCount, minDigits);

			StatDAO.newVisitor(cs, request.getRemoteAddr(), request.getRequestURI(), new java.util.Date());

		} catch (Exception e) {
			e.printStackTrace();
		}

		view.setPageCounterItems(counterItems);
		return view;
	}
}
