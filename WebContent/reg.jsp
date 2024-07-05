<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="./layui/layui.js"></script>
    <link rel="stylesheet" href="./layui/css/layui.css" />
    <link href="./css/reg.css" rel="stylesheet">
    <link rel="icon" href="./img/sakura.ico" type="image/x-icon"/>
</head>
<body>
<div class="container">
    <!-- 注册页面左图 -->
    <div class="left"></div>
    <!-- 注册栏 -->
    <div class="right">
        <div class="reg-label">
            <label>用户注册</label>
            <hr>
        </div>
        <div class="reg-box">
            <form action="./UserServlet?type=regUser" id="formId" class="reg-form" method="POST">
                <div>
                    <input type="text" name="Username" id="InputUsername" placeholder="用户名" onblur="InputUsernameBlur()">
                    <label id="errorName"></label>
                </div>
                <div>
                    <input type="password" name="Password" id="InputPassword" placeholder="密码" onblur="InputPasswordBlur()">
                    <label id="errorPassword"></label>
                </div>
                <div>
                    <input type="password" name="Repassword" id="InputRepassword" placeholder="确认密码" onblur="InputRepasswordBlur()">
                    <label id="errorRepassword"></label>
                </div>
                <div class="reg-sub">
                    <input id="submitButton" type="submit" onclick="return checkForm()" value="免费注册">
                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom">
    <label>© 重庆工业职业技术学院 ｜ 人工智能与大数据学院 ｜ 软件工程 ｜ 02170086</label>
</div>
<!-- regist.js -->
<script type="text/javascript" charset="UTF-8" src="./js/users/reg.js"></script>
<c:if test="${!empty requestScope.errorInfo }">
    <c:if test="${requestScope.errorInfo == '注册成功！'}">
        <script type="text/javascript">
            $(document).ready(function() {
                layui.use('layer', function(){
                    layer.open({
                        title: '提示',
                        content: '注册成功，请返回首页登录！',
                         end: function(){
                             window.location.href="./index.jsp";
                         }
                    });
                });
            });
        </script>
    </c:if>
    <c:if test="${requestScope.errorInfo != '注册成功！'}">
        <script type="text/javascript">
            $(document).ready(function() {
                layui.use('layer', function(){
                    layer.open({
                        title: '提示',
                        content: '${requestScope.errorInfo}！'
                    });
                });
            });
        </script>
    </c:if>
</c:if>
</body>
</html>
