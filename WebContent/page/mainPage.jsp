<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客首页 | MyBlog</title>

<!-- Bootstrap core CSS -->
<link	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="./css/main.css" />
</head>

<body style="background:url(pic/background.jpg);">

<% request.setCharacterEncoding("UTF-8"); %>

	<div class="head_line"></div>

	<div class="container" id="main">
	
		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2><a href="/MyBlog/welcome.html">Stpraha</a></h2>
				</div>

				<div class="c_center" id="person_info">
					<img src="pic/head.gif" height="130" width="130"
						alt="丢失了我的头像?" class="img-circle">
					<h5 class="text-muted">Emial: 470741655@qq.com</h5>
					<h5 class="text-muted">Wechat: STPRAHA</h5>
					<h5 class="text-muted"><a href="https://github.com/stpraha">Github: https://github.com/stpraha</a> </h5>
					<h5 class="text-muted"><a href="https://blog.csdn.net/sinat_15901371">CSDN: 跳币上山岭</a> </h5>
				</div>
				<br/>
				<br/>
				<div id="list">
					<table class="table table-hover c_center">
						<tr>
							<td><a href="welcome.html"><span class="glyphicon glyphicon-home"></span>
								&nbsp;&nbsp;首页</a></td>
						</tr>
						<tr>	
							<td><a href="servletCommentpage"><span class="glyphicon glyphicon-list"></span>
								&nbsp;&nbsp;评论总览</a></td>
						</tr>
						<tr>
							<td><a href="/MyBlog/page/login.jsp"><span class="glyphicon glyphicon-tags"></span>
								&nbsp;&nbsp;写文章</a></td>
						</tr>						
						<tr>
							<td><a href="welcome.html"><span class="glyphicon glyphicon-book"></span>
								&nbsp;&nbsp;访问数据</a></td>
						</tr>
						<tr>
							<td><a href="welcome.html"><span class="glyphicon glyphicon-user"></span>
								&nbsp;&nbsp;关于作者</a></td>
						</tr>
					</table>
				</div>
				
				<br/>
				
				<div class="c_center" id="QRcode">
					<img src="pic/QR.jpg" height="316" width="233" class="img-rounded">
				</div>
			</div>
			
									
			<div  class="col-md-8 " id="right_Content">
				<br/>
				<br/>
				<div class="list-group">
					<a class="list-group-item active">博文列表</a>
					
					<!-- 这里初始化文章列表 -->
					<c:forEach var="article" items="${article_list}" >
					<div  class="list-group-item">		
					<h5><a href="ArticleServlet?id=${article.id}">${article.title}</a></h5>
					
					
					</div>
					</c:forEach>
					<!-- 初始化文章列表完成 -->		
											
				</div>
			</div>	
		</div>				
		<div class="foot_line"></div>
			</div><!-- container -->

</body>
</html>