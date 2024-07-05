<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图书管理系统</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../css/style.css"> <!-- 自定义的样式表 -->
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
<%@ include file="./head.jsp" %>
<div class="layui-container">
	<div class="layui-row">
		<div class="layui-col-md-offset2 layui-col-md8">
			<br>
			<div class="layui-card">
				<div class="layui-card-header">欢迎您，${sessionScope.users.user }</div>
				<div class="layui-card-body">
					<!-- 此处放置首页内容 -->
					<p>这里可以放一些首页内容，比如最新图书推荐、公告信息等。</p>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="./foot.jsp" %>
</body>
</html>
