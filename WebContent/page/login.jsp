<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>

<style type="text/css">
body{
	margin:0px;  
	background-color: white; 
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;  
	text-align: center;  
	color: #A6A6A6;  
}

/*输入框样式，去掉背景阴影模仿原生应用的输入框*/
input{
width: 100%;  
height: 50px;  
border:none;  
padding-left:3px;  
font-size: 18px;  
}
input:focus {  
    outline: none;  
}

/*登录按钮*/
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
/*container*/
#page_container{
	width:400px;
	margin:0 auto;
}
</style>


<body style="background:url(pic/background.jpg);">

	<div id="page_container">
		<form action="../LoginServlet" method="post" name="loginform">
		<div class="username_input_block">
			<input type="text" name="username" placeholder="Username"/>
		</div>
	
		<!--密码输入框-->
		<div class="password_input_block">
			<input type="password" name="password" placeholder="Password"/>
		</div>
	
		<button type="submit" value="提交" id="login_button" onclick="submit;">Login</button>
		</form>
	</div>

</body>


</html>