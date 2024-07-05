<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户个人信息页面</title>
	<style type="text/css">
		.big {
			margin: 20px auto;
			width: 750px;
			border: 1px solid #ccc;
			padding: 10px;
			overflow: hidden;
		}
		.left {
			width: 25%;
			float: left;
			padding-right: 20px;
		}
		.right {
			width: 70%;
			float: left;
		}
		.table-container {
			margin-top: 20px;
		}
		.table-container table {
			width: 100%;
			border-collapse: collapse;
		}
		.table-container table td, .table-container table th {
			padding: 8px;
			border: 1px solid #ccc;
			text-align: center;
		}
		.pagination {
			margin-top: 10px;
			text-align: center;
		}
		.pagination a, .pagination span {
			margin: 0 5px;
		}
	</style>
	<%@ include file="./head.jsp" %>
	<script type="text/javascript">
		// 修改密码
		function modifyPWD() {
			location.href="${path}/jsp/modify.jsp";
		}

		// 跳转获取用户数据
		function jumppage(p) {
			location.href="${path}/UserServlet?type=findUserData&page=" + p;
		}

		// 上一页按钮
		function upPage(p) {
			if ((p - 1) > 0) {
				location.href="${path}/UserServlet?type=findUserData&page=" + (p - 1);
			} else {
				layui.use('layer', function () {
					layer.open({
						title: '信息提示',
						content: '没有上一页了!!'
					});
				});
			}
		}

		// 下一页按钮
		function downPage(p, count) {
			if ((p + 1) <= count) {
				location.href="${path}/UserServlet?type=findUserData&page=" + (p + 1);
			} else {
				layui.use('layer', function () {
					layer.open({
						title: '信息提示',
						content: '没有下一页了!!'
					});
				});
			}
		}
	</script>
</head>
<body>
<!--
    获取总数，页码，列表数据
 -->
<c:set value="${requestScope.count}" var="count"/>
<c:set value="${requestScope.pageCount}" var="pageCount"/>
<c:set value="${requestScope.userbooklist}" var="list"/>
<div class="big">
	<div class="left">
		<table class="layui-table" style="width: 100%;">
			<tr>
				<td>ID:</td>
				<td>${sessionScope.users.id }</td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td>${sessionScope.users.user }</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="button" onclick="modifyPWD()" value="修改密码" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger"/>
				</td>
			</tr>
		</table>
	</div>
	<div class="right">
		<div class="table-container">
			<table id="mytabs" class="layui-table">
				<thead>
				<tr>
					<th>编号</th>
					<th>书籍名称</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>状态</th>
				</tr>
				</thead>
				<tbody>
				<c:if test="${not empty list}">
					<c:forEach items="${list}" var="userbook">
						<tr>
							<td>${userbook.id}</td>
							<td>${userbook.bookId.book_name}</td>
							<td>${userbook.begin_time}</td>
							<td>${userbook.end_time }</td>
							<td>
								<jsp:useBean id="now" class="java.util.Date" scope="page"/>
								<fmt:parseDate value="${userbook.end_time}" var="date1"/>
								<c:choose>
									<c:when test="${userbook.stat == 0}">
										<font color="gray">已归还</font>
									</c:when>
									<c:when test="${userbook.stat == 1}">
										<c:choose>
											<c:when test="${date1 >= now}">
												<font color="green">未归还</font>
											</c:when>
											<c:when test="${date1 < now}">
												<font color="red">已超时</font>
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty list}">
						<tr>
							<td colspan="5">您还没有借阅信息!</td>
						</tr>
					</c:if>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="5">没有获取到数据，请重试</td>
					</tr>
				</c:if>
				</tbody>
				<tfoot>
				<tr>
					<td align="right" colspan="5" class="pagination">
						<a href="javascript:jumppage(1)">首页</a>&nbsp;
						<a href="javascript:upPage(${pageCount})">上一页</a>&nbsp;
						<c:forEach begin="1" end="${count}" var="i">
							<c:choose>
								<c:when test="${i == pageCount}">
									&nbsp;${i}&nbsp;
								</c:when>
								<c:otherwise>
									&nbsp;<a href="javascript:jumppage(${i})">${i}</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<a href="javascript:downPage(${pageCount},${count})">下一页</a>&nbsp;
						<a href="javascript:jumppage(${count})">尾页</a>
					</td>
				</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>
<%@ include file="./foot.jsp"  %>
</body>
</html>
