<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>书籍详情页</title>
	<link rel="stylesheet" href="../layui/css/layui.css" />
	<style type="text/css">
		.container {
			width: 800px;
			margin: 20px auto;
			background-color: #ffffff;
			border: 1px solid #e6e6e6;
			box-shadow: 0 0 10px rgba(0,0,0,0.1);
			padding: 20px;
			overflow: hidden;
			text-align: center; /* Centering content */
		}
		.left {
			width: 30%;
			display: inline-block; /* Ensure left and right are aligned properly */
			text-align: center;
		}
		.left img {
			max-width: 100%;
			height: auto;
			border: 1px solid #ccc;
			padding: 5px;
			background-color: #f6f6f6;
			margin-left: 20px;
		}
		.right {
			width: 70%;
			display: inline-block; /* Ensure left and right are aligned properly */
			padding-left: 20px;
			text-align: left;
			vertical-align: top;
		}
		.book-info {
			margin-bottom: 20px;
		}
		.book-info table {
			width: 100%;
			border-collapse: collapse;
		}
		.book-info table td {
			padding: 8px;
			border-bottom: 1px solid #e6e6e6;
		}
		.book-description {
			clear: both;
			padding-top: 20px;
		}
		.book-description p {
			line-height: 1.6;
			margin-bottom: 10px;
			text-align: left;
		}
		.book-description pre {
			white-space: pre-wrap;
			font-size: 14px;
			line-height: 1.6;
			background-color: #f9f9f9;
			padding: 10px;
			border: 1px solid #e6e6e6;
			overflow: auto;
		}
		.action-button {
			margin-top: 20px;
			text-align: center;
		}
		.action-button button {
			margin-right: 10px;
		}
	</style>
</head>
<body>
<%@ include file="./head.jsp" %>
<script type="text/javascript">

	function books(bid,uid){
		location.href="${path}/UserBooksServlet?type=lendbook&uid="+uid+"&bid="+bid;
	}
</script>

<c:if test="${not empty requestScope.infos}">
	<script type="text/javascript">
		layui.use('layer', function(){
			layer.open({
				title: '信息提示',
				content: '${requestScope.infos}'
			});
		});
	</script>
</c:if>

<div class="container">
	<div class="left">
		<img src="${path}/img/book.jpg" alt="Book Cover" />
	</div>
	<div class="right">
		<div class="book-info">
			<table>
				<tr>
					<td>${requestScope.books.book_name}</td>
				</tr>
				<tr>
					<td>作者：${requestScope.books.book_author}</td>

				</tr>
				<tr>
					<td>出版社：${requestScope.books.published_house}</td>
				</tr>
				<tr>
					<td>ISBN：${requestScope.books.ISBN}</td>
				</tr>
				<tr>
					<td>价格：${requestScope.books.book_price}</td>
				</tr>
			</table>
		</div>
		<div class="book-description">
			<pre>
				孔昊主编的《JavaWeb设计实用教程》以Eclipse工具作为开发环境，讲解了JavaWeb设计理论和设计方法，是长期在企业从事Eclipse软件开发的工程师与
				高校从事相关课程教学的老师紧密合作的成果。本书内容包括Eclipse基础、Web开发环境搭建、Web项目开发、MVC框架设计、Struts框架设计、Hibernate框架设计、JUnit测试、CVS版本控制等内容。
				每章最后均安排了实训题，作为对教材的补充、强化和引导，便于读者上机练习。书中内容理论与实践相结合，注重基本知识的理解与基本技能的培养，是一本实用性较强的教材。
				本书既可作为高职高专计算机及相关专业的JavaWeb设计课程教材，也非常适合Eclipse开发学习和参考。
				《JavaWeb设计实用教程》配有授课电子课件和已调试成功的项目，需要的教师可登录WWW.cmpedu.com免费注册、审核通过后下载，或联系编辑索取（QQ：1239258369，电话：010—88379739）。
            </pre>
		</div>
		<div class="action-button">
			<button class="layui-btn layui-btn-lg layui-btn-normal"
					onclick="books(${requestScope.books.id},${sessionScope.users.id})">借阅书籍</button>
		</div>
	</div>
</div>

<%@ include file="./foot.jsp" %>
</body>
</html>
