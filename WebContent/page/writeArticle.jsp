<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写博客</title>

<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

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
					<a href="../welcome.html">返回首页 | Stpraha</a>
				</h3>
			</div>
		</div>
		<br/>
		<div class="line"></div>
			<div id="title">
				<input id="title-con" style="width:100%; display:inline-block;" class="form-control" type="text" name="title" placeholder="文章标题"></input>
			</div>
		<div id="content-box">
			<br/>
				<div id="content-con">
		  			 <textarea id="container-conn" name="text" style="width: 100%; height: 400px; margin: 0 auto;"></textarea> 
	
	  				<script type="text/javascript">  
	        				UE.getEditor("container-conn");
	  				</script>
				</div>
				<br/>
		</div>
		
		
		<div>选择分类： 
			<select name="sort" id="sort_list">
				<option value="a">这个功能还没做好</option>
				<option value="b">现在只能看看</option>
				<option value="c">估计也不打算做</option>
				<option value="d">没时间啊</option>
			</select>
		</div>

		<button  type="button" value="发表文章" onclick="publish();">发表文章</button>	
		<button  type="button" value="保存草稿还没做好" onclick="draft();">保存草稿还没做好</button>
		
		<script>
			function publish(){
				var write_text = UE.getEditor("container-conn").getContent();
				$.ajax({
					type:"post",
					url:"../servletWrite",
					datatype:"text",
					data:
					{
						"write_title":$("#title-con").val(),
						"write_content":write_text,
						"write_author":"Stpraha",
						"write_sort":"哪有什么分类",
					},
					success:function(callBack)
					{
						alert("提交了！");
					}
				});
			}
		</script>
		
		<script>
			function draft(){
				$.ajax({
					type:"post",
					url:"../servletWrite",
					datatype:"text",
					data:
					{
						"write_title":$("#title").val(),
						"write_content":$("#container").val(),
					},
					success:function(callBack)
					{
						alert("保存了！");
					}
				});
			}
		</script>
	</div>
	
</body>
</html>









