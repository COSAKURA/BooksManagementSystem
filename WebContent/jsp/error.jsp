<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>错误信息提示页面</title>
</head>
<body>
    <%@ include file="./head.jsp" %>
    <br/>
    <h1>${requestScope.info}</h1>
    <br/>
    <%@ include file="./foot.jsp" %>
</body>
</html>