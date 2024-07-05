<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改用户密码页面</title>
	<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../layui/layui.js"></script>
	<link rel="stylesheet" href="../layui/css/layui.css"  />
	<script type="text/javascript" src="../js/users/modify.js"></script>
	<style type="text/css">
		.container {
			width: 600px;
			height: 400px;
			margin: 0 auto;
			padding: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0,0,0,0.1);
		}
		.container table {
			width: 100%;
		}
		.container td {
			padding: 10px;
			text-align: right;
		}
		.container input[type=text] {
			width: 300px;
			padding: 8px;
			font-size: 14px;
		}
		.container .submit-btn {
			margin-top: 20px;
			text-align: center;
		}
	</style>
</head>
<body>
<%@ include file="./head.jsp"  %>
<div class="container">
	<table class="layui-table">
		<tr>
			<td>原密码：</td>
			<td><input type="password" id="oldpwd" placeholder="请输入原密码" class="layui-input"></td>
		</tr>
		<tr>
			<td>新密码：</td>
			<td><input type="password" id="newpwd" placeholder="请输入新密码" class="layui-input"></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" id="repwd" placeholder="请确认新密码" class="layui-input"></td>
		</tr>
		<tr class="submit-btn">
			<td colspan="2">
				<input id="submit" type="button" class="layui-btn layui-btn-lg layui-btn-normal" value="提&nbsp;&nbsp;交">
			</td>
		</tr>
	</table>
</div>
<%@ include file="./foot.jsp"  %>
</body>
</html>
