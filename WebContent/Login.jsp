<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎登录Sakura图书馆</title>
        <link rel="stylesheet" href="./css/Login.css" />
        <link rel="icon" href="./img/sakura.ico" type="image/x-icon"/>
		<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
		<script type="text/javascript">

		</script>
	</head>
    <body>k
    <div class="container">
        <div class="container_text">
            <h1 class="Login_text">Sign Up💕</h1>
        </div>
        <div class="Login-form">
            <form action="./UserLoginServlet" method="get">
                <div class="username">
                    <label for="username">Phone/Email</label>
                    <input type="text" id="username" name="username"  placeholder="Enter Your Account">
                </div>
                <div class="password">
                    <label for="pwd">Password</label>
                    <input type="password" id="pwd" name="pwd" placeholder="Enter Your Password">
                </div>
                <div class="login">
                    <input type="submit" value="Click Login">
                </div>
                <div class="register_box">
                    好没有账号?
                    <a href="./reg.jsp" id="register" target="_blank">马上注册 👉</a>
                </div>
                <div class="log-item">Sakura © 2024 SOUNDCLOUD</div>
            </form>
            <h3 align="center"><font color="red">${requestScope.info }</font></h3>
        </div>
    </div>

    </body>
</html>