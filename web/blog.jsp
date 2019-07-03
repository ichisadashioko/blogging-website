
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="Models.*"%>
<%@page import="Views.*"%>
<%@page import="Controllers.*"%>
<%
	ServletContext context = getServletContext();
	BlogView pageView = BlogController.getViewContent(context, request);
	Post p = pageView.getPost();
	List<Integer> pageCounterItems = pageView.getPageCounterItems();
%>
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
								<a href="index.jsp" class="title title-link">Blogging About By Life</a>
							</div>
							<div class="subtitle">Welcome to my blog</div>
						</div>
					</div>
				</div>
				<!-- this is the menu content -->
				<div class="navbar">
					<a class="active" href="index.jsp">My Blog</a>
					<a href="about.jsp">About Me</a>
				</div>
			</div>
			<!-- the controller has determined which view to be shown in the content -->
			<div class="content-wrapper" id="content">
				<div class="container">
					<div id="left" class="span9">
						<div class="wrapper blog-post">
							<div class="content">
								<%if(p!=null){%>
								<div class="avatar">
									<i class="icon-<%=p.getIconClass()%>"></i>
								</div>
								<div class="blog-post-body section">
									<div class="controls">
										<span class="date-text"><%=p.getDate()%></span>
									</div>
									<div class="heading">
										<h1 class="page-title"><%=p.getHeading()%></h1>
									</div>
									<div class="content"><%=p.generateContentHtml()%></div>
								</div>
								<%}%>
								<ul class="pager">
									<li>
										<a href="overview.jsp">Overview</a>
									</li>
								</ul>
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
									<div>
										<ul>
											<li><a href="" id="share-facebook"><i class="icon-facebook-sign"></i><span>Share on Facebook</span></a></li>
											<li><a href="" id="share-twitter"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
										</ul>
									</div>
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
							This website was created with SimpleSite
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
