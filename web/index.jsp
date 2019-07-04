<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page import="java.util.*"%>
<%@page import="Models.*"%>
<%@page import="Views.*"%>
<%@page import="Controllers.*"%>
<%
	ServletContext context = getServletContext();
	IndexView pageView = IndexController.getViewContent(context, request);
	List<Post> postList = pageView.getPosts();
	List<Integer> pageCounterItems = pageView.getPageCounterItems();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>

	<head>
		<title>My Blog</title>
		<link rel="stylesheet" type="text/css" href="css/index.css">
	</head>

	<body>
		<!-- this is the Sheet -->
		<div class="site-wrapper">
			<!-- this is the Header content -->
			<div class=" header-wrapper" id="header">
				<!-- this is the header wrapper -->
				<div class="container">
					<!-- these are the titles -->
					<div class="title-wrapper">
						<div class="title-wrapper-inner">
							<div class="title">
								<a class="title title-link">Blogging About By Life</a>
							</div>
							<div class="subtitle">Welcome to my blog</div>
						</div>
					</div>
				</div>
				<!-- this is the menu content -->
				<div class="navbar">
					<a class="active">My Blog</a>
					<a href="about.jsp">About Me</a>
				</div>
			</div>
			<!-- the controller has determined which view to be shown in the content -->
			<div class="content-wrapper" id="content">
				<div class="container">
					<div id="left" class="span9">
						<div class="wrapper blog">
							<div class="heading">
								<h1 class="page-title">My Blog</h1>
							</div>
							<div class="content">
								<%for (int i = 0; i < postList.size(); i++) {
										Post p = postList.get(i);
								%>
								<div class="section">
									<div class="content">
										<div class="avatar">
											<i class="icon-<%=p.getIconClass()%>"></i>
										</div>
										<div class="item">
											<div class="controls">
												<span class="date-text"><%=p.getDate()%></span>
											</div>
											<div class="heading">
												<h4><a href="blog.jsp?id=<%=p.getId()%>"><%=p.getHeading()%></a></h4>
											</div>
											<div class="content">
												<%=p.generateContentHtml()%>
											</div>
										</div>
									</div>
								</div>
								<%}%>
								<ul class="pager"><li><a href="overview.jsp">Overview</a></li></ul>
							</div>
						</div>
					</div>
					<div id="right" class="span3">
						<div class="sidebar">
							<div class="wrapper share-box">
								<div class="heading wordwrapfix">
									<h4>Share this page</h4>
								</div>
								<div class="content">
									<div><ul>
											<li><a id="share-facebook"><i class="icon-facebook-sign"></i><span>Share on Facebook</span></a></li>
											<li><a id="share-twitter"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
										</ul></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- this is the Footer content -->
			<div class=" footer-wrapper" id="footer">
				<!-- this is the footer wrapper -->
				<div class="container">
					<div class="footer-info">
						<div class="footer-info-text">
							Made with &hearts;
						</div>
					</div>
					<div class="footer-page-counter">
						<%for (int i = 0; i < pageCounterItems.size(); i++) {%><span class="footer-page-counter-item"><%=pageCounterItems.get(i)%></span><%}%>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>
