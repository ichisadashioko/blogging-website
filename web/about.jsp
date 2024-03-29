
<%@page import="java.util.*"%>
<%@page import="Models.*"%>
<%@page import="Views.*"%>
<%@page import="Controllers.*"%>
<%
	ServletContext context = getServletContext();
	AboutView pageView = AboutController.getViewContent(context, request);
	List<Integer> pageCounterItems = pageView.getPageCounterItems();
%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html5>
<html>

	<head>
    <title>About Me</title>
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
					<a href="index.jsp">My Blog</a>
					<a class="active">About Me</a>
				</div>
			</div>
			<div class="content-wrapper" id="content">
				<!-- Content wrapper-->
				<div class="container">
					<div id="left" class="span9">
						<div class="wrapper">
							<div class="content">
								<div class="row-fluid padding-all margins-topbottom">
									<div class="sections-wrapper">
										<div class="span12">
											<div class="section article margins-on">
												<div class="heading wordwrapfix">
													<h3>About Me</h3>
												</div>
												<div class="content">
													<p><span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
															diam nonummy nibh euismod tincidunt ut laoreet dolore magna
															aliquam erat volutpat. Ut wisi enim ad minim veniam, quis
															nostrud exerci tation ullamcorper suscipit lobortis nisl ut
															aliquip
															ex ea commodo consequat. Duis autem vel eum iriure dolor in
															hendrerit in vulputate velit esse molestie consequat, vel illum
															dolore eu feugiat nulla facilisis at vero eros et accumsan et
															iusto odio dignissim qui blandit praesent luptatum zzril delenit
															augue
															duis dolore te feugait nulla facilisi. Nam liber tempor cum
															soluta nobis eleifend option congue nihil imperdiet doming id
															quod mazim placerat facer possim assum. </span></p>
													<p><span>Typi non habent claritatem insitam; est usus legentis in iis
															qui facit eorum
															claritatem. Investigationes demonstraverunt lectores legere me
															lius quod ii legunt saepius. Claritas est etiam processus
															dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum
															est notare quam littera gothica, quam nunc putamus parum claram,
															anteposuerit
															litterarum formas humanitatis per seacula quarta decima et
															quinta decima. Eodem modo typi, qui nunc nobis videntur parum
															clari, fiant sollemnes in futurum.</span></p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row-fluid padding-all margins-topbottom">
									<div class="sections-wrapper">
										<div class="span12">
											<div class="section signature margins-on">
												<div class="content">
													<div class="signature-text-noimg">
														<p>Kind regrads</p>
														<div class="signature-sign">
															Vivianne Russell
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
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
