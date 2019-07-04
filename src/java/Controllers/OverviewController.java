package Controllers;

import java.util.*;
import Models.*;
import Views.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Utils.*;

public class OverviewController {

	public static OverviewView getViewContent(ServletContext context, HttpServletRequest request) {
		OverviewView view = new OverviewView();
		List<Integer> counterItems = new ArrayList<>();
		int visitorCount = 0;
		int numPages = 0;
		int pageNum = 0;
		
		List<MonthlyEntry> entryList = new ArrayList<>();

		try {
			String cs = context.getInitParameter("cs");
			int minDigits = Integer.parseInt(context.getInitParameter("min_counter_digits"));
			visitorCount = StatDAO.visitorCount(cs);
			counterItems = BlogUtils.generateCounterItems(visitorCount, minDigits);

			StatDAO.newVisitor(cs, request.getRemoteAddr(), request.getRequestURI(), new java.util.Date());

			int numPerPage = Integer.parseInt(context.getInitParameter("num_per_page"));
			int numPosts = BlogPostDAO.numPosts(cs);
			numPages = (int) Math.ceil((double) numPosts / (double) numPerPage);

			pageNum = 1;

			try {
				pageNum = Integer.parseInt(request.getParameter("page"));
				pageNum = (pageNum > 0) ? pageNum : 1;
				pageNum = (pageNum > numPages) ? numPages : pageNum;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			int endIdx = pageNum * numPerPage;
			int startIdx = endIdx - numPerPage;
			
			List<Post> postList = BlogPostDAO.select(cs, startIdx, endIdx);
			entryList = BlogUtils.filterPostList(postList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.setNumPages(numPages);
		view.setPageNum(pageNum);
		view.setEntryList(entryList);
		view.setPageCounterItems(counterItems);
		return view;
	}
}
