<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>借阅</title>
	<link rel="stylesheet" href="${path}/layui/css/layui.css"/>
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="${path}/layui/layui.js"></script>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
			margin: 0;
			padding: 0;
		}
		.container {
			width: 600px;
			margin: 20px auto;
			padding: 20px;
			background-color: #fff;
			border: 1px solid #ddd;
			box-shadow: 0 0 10px rgba(0,0,0,0.1);
		}
		.submit-button {
			margin-top: 20px;
			text-align: center;
		}
	</style>
</head>
<body>
<%@ include file="./head.jsp"  %>
<script type="text/javascript">
	//验证借阅书籍的信息函数
	function check() {
		var t = $("#borrow-date").val();
		if (t.trim() !== "") {
			var d = new Date(t);
			var date = new Date();
			if (d > date) {
				return true;
			} else {
				layui.use('layer', function () {
					layer.open({
						title: '信息提示',
						content: '借阅时间必须大于当前时间！'
					});
				});
				return false;
			}
		} else {
			layui.use('layer', function () {
				layer.open({
					title: '信息提示',
					content: '借阅时间不能为空！'
				});
			});
			return false;
		}
	}
</script>
<div class="container">
	<form action="${path}/UserBooksServlet?type=lendbooks&uid=${requestScope.uid}&bid=${requestScope.bid}" method="post"
		  onsubmit="return check()">
		<table class="layui-table">
			<tr>
				<td style="width: 40%;">请设置借阅到期时间：</td>
				<td><input type="date" id="borrow-date" name="end_time" required></td>
			</tr>
			<tr>
				<td colspan="2" class="submit-button">
					<button type="submit" class="layui-btn layui-btn-lg layui-btn-normal">提&nbsp;&nbsp;交</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript" src="${path}/js/datetime.js"></script>
<%@ include file="./foot.jsp"  %>
</body>
</html>
