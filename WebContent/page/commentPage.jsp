<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论总览 | MyBlog</title>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">

<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="./css/article.css" />
<link type="text/css" rel="stylesheet" href="./css/comment.css" />

<script src="./js/article.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>

</head>


<style type="text/css">
button{  
    width: 200px;  
    height: 50px;  
    margin-top: 25px;  
    background: #1E90FF;  
    border-radius: 10px;  
    border:none;
    font-size: 18px;
    font-weight: 700;  
    color: #fff;
}
button:hover {
background: #79A84B;  
outline: 0;
}
#content-con{
	margin-left:30px;
	margin-right:30px;
	
}
</style>


<body style="background:url(pic/background.jpg);">

	<div class="head_line"></div>

	<div class="container" id="main">

		<div class="head">
			<div id="title">
				<h3>
					<a href="servletMainpage">返回首页 | Stpraha</a>
				</h3>
			</div>
		</div>
		
		<!-- 加载文章评论 -->
		<div class="comment">	
			<c:forEach var="comm" varStatus="status" items="${comment_list}">			
				<div class="f_div">		
					<span>${comm.commenderNickName}</span>					
					<span>&nbsp;&nbsp;于&nbsp;${comm.commentTime}</span>
					<span>&nbsp;&nbsp;在文章</span>
					<span>&nbsp;&nbsp;<a href="ArticleServlet?id=${comm.commentArticleId}">${comm.commentArticleTitle}</a></span>
					<span>&nbsp;&nbsp;评论：</span>
				</div>		
				
				<div  id="c_content" class="c_left">						
				<pre>${comm.commentContent} </pre>			
				</div>					
				<div class="line"></div>
			</c:forEach>	
		</div>
		
		
		
		<br/>
		<br/>
		<br/>
		<div class="line"></div>
		
		
		
		<br/>
		<br/>
		<br/>
		<br/>
 	
	
		
	
</body>
</html>