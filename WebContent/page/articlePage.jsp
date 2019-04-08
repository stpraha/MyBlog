<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的博客 | MyBlog</title>

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
		
		<div id="article">
			<div id="a_head ">
				<h1>${article.title}</h1>
				<div>
					<h5>
						<span>${article.time}</span> <a href="/Blog/SortServlet?get=${article.sort}">${article.sort}</a>
					${article.author}
					</h5>
				</div>
				<div class="r_div">
					<h5>
						<span class="glyphicon glyphicon-eye-open">&nbsp;${article.visit}&nbsp;</span>						
						 <span class="glyphicon glyphicon-heart" id="love">&nbsp;${article.star}&nbsp;</span> 
						 <span	class="glyphicon glyphicon-comment">&nbsp;${article.comment}&nbsp; </span>
					</h5>
				</div>
				<!-- 
				<div id="tag">
				<c:forEach var="t" items="${article_tags}">
					<a href="/Blog/TagsServlet?get=${t.tag}">${t.tag}&nbsp;</a>
				</c:forEach>
				</div>
				 -->
			</div>
		</div>
	
		<div id="content-box" style="background:white; ">
		<br/>
			<div id="content-con">${article.content}
			<!-- 
	  			<script>
	  				var article_content = "${article.content}";
	    			document.getElementById('content-con').innerHTML = marked(article_content);
	 			</script>
			 -->
				  	<!-- 
				<div id="a_content">
					<h4>${article.content}</h4>
				</div>
			 		-->
			</div>
			<br/>
		</div>
		<br/>
		
		<!-- 加载文章评论 -->
		<div class="comment"> <h3>评论列表：</h3>
			<c:forEach var="comm" varStatus="status" items="${comment_list}">			
				<div class="f_div">		
					<span>${comm.commenderNickName}</span>					
					<span>&nbsp;&nbsp;于&nbsp;${comm.commentTime}</span>
					<span>&nbsp;&nbsp;说道：</span>
				</div>		
				
				<div  id="c_content" class="c_left">						
				<pre>${comm.commentContent} </pre>			
				</div>					
				<div class="line"></div>
			</c:forEach>	
		</div>
		
		<div class="line"></div>
			<!-- 写评论 -->
			<div id="comment">
				<div>
					<h3>发表评论：</h3>
				</div>
				<textarea id="comment_input" style="resize:none; width:70%; height:80px;" name="comment_input" placeholder="有什么想说的尽管说吧！"></textarea>
				<br/>
				<br/>
				<input  id="commender_nickname" style="width:30%; display:inline-block" class="form-control" type="text" name="commender_nickname" placeholder="怎么称呼鸭？" />
				<div style="width:10%; display:inline-block"></div>
				<input  id="commender_email" style="width:30%; display:inline-block" class="form-control" type="text" name="commender_email" placeholder="留个邮箱吧！" />
				
				<br/>							
				<button  type="button" value="评论" onclick="comment();">评论</button>	
				<button  type="button" value="点赞" onclick="star();">点个赞</button>
				<script>
					function star(){
						var a_id = "${article.id}";
						$.ajax({
							type:"post",
							url:"servletComment",
							datatype:"text",
							data:
							{
								"article_id":a_id,
								"message":"star",
							},
							success:function(callBack)
							{
								alert("谢谢你的赞！");
							}
						});
					}
				</script>
				<script>
					function comment(){
						var a_id = "${article.id}";
						var a_title = "${article.title}";
						
						$.ajax({
							type:"post",
							url:"servletComment",
							datatype:"text",
							data:
							{
								"message":"comment",
								"article_id":a_id,
								"article_title":a_title,
								"comment_content":$("#comment_input").val(),
								"commender_nickname":$("#commender_nickname").val(),
								"commender_email":$("#commender_email").val(),
							},
							success:function(callBack)
							{
								alert("评论成功了！");
							}
						});
					}
				</script>
				<br/>								
			</div>
		<br/>
		<br/>
		<br/>
		<div class="line"></div>
		
		
		<div class="line"></div>
			<a href="LoginServlet">Stpraha 首页&nbsp;&nbsp;</a>|
			<a href="#">&nbsp;&nbsp;返回顶部</a>
		
		<br/>
		<br/>
		<br/>
		<br/>
 	
	
		
	
</body>
</html>