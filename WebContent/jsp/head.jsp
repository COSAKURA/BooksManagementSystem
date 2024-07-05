<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.cqipc.books.bean.Tb_Books"%>
<%@ page import="org.cqipc.books.bean.Tb_Books_Type"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>XXX图书馆</title>
    <c:set value="${pageContext.request.contextPath}" var="path"/>
    <link rel="stylesheet" href="${path}/layui/css/layui.css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${path}/layui/layui.js"></script>
    <style>
        /* Update your existing styles or add these to your <style> tag */

        /* Header */
        .header {
            background-image: url('${path}/img/2.png') ;
            background-size: cover;
            background-position: center;
            height: 400px;
            padding-top: 10px;
            text-align: center;
            color: #ffffff;

        }
        #main {

        }

        .header p {
            font-size: 50px;
            font-weight: bold;
        }

        /* Menu and Submenu */
        #menu, .smenu {
            background-color: rgba(255, 255, 255, 0.5););
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #menu ul, .smenu {
            display: flex;
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .m_li, .m_li_a, .s_li, .s_li_a {
            line-height: 50px;
            text-align: center;
            font-weight: bold;
        }

        .m_li a, .m_li_a a, .s_li a, .s_li_a {
            display: block;
            color: #ffffff;
            font-size: 16px;
            padding: 0 15px;
            transition: background-color 0.3s, color 0.3s;
        }

        .m_li a:hover, .s_li a:hover {
            background-color: rgba(178, 34, 34, 0);
        }

        /* Welcome Message */
        .welcome-message {
            text-align: right;
            margin: 10px;
        }

        .welcome-message h3 {
            font-size: 16px;
        }

        .welcome-message h3 a {
            color: #484343;
        }

        /* General Body Styling */
        body, td, th {
            font-family: Tahoma, Verdana, Arial, sans-serif;
            font-size: 12px;
            color: #333333;
            margin: 0;
            background-color: #f9f9f9;
        }

        a {
            color: #333333;
            text-decoration: none;
        }

        a:hover, a:active {
            color: black;
            text-decoration: none;
        }

    </style>
</head>
<body>

<div class="header">
    <p>欢迎访问Sakura图书馆</p>
    <div id="menu">
        <ul>
            <li id="m_1" class='m_li_a' onclick='selectMenu(1);'><a href="${path}/jsp/index.jsp">财税首页</a></li>
            <c:forEach var="type" items="${sessionScope.list}" varStatus="loop">
                <li id="m_${loop.index + 2}" class='m_li' onclick='selectMenu(${loop.index + 2});'>
                    <a href="#">${type.type}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="smenu">
        <c:forEach var="type" items="${sessionScope.list}" varStatus="loop">
            <li id="s_${loop.index + 2}" class='s_li'>
                <c:forEach var="book" items="${sessionScope.list2}">
                    <c:if test="${type.id == book.bookCategory.id}">
                        <a href="javascript:selectBooks(${book.id})">${book.book_name}</a>
                    </c:if>
                </c:forEach>
            </li>
        </c:forEach>
    </div>
</div>


<div class="welcome-message">
    <h3>欢迎用户：<font color="red"><b><a href="javascript:jumpUsers()">${users.user}</a></b></font>登录，
        <a href="javascript:exits()">退出登录</a></h3>
</div>
<script>
    var def = 1; // Initialize default selected menu item

    // Function to select menu item and show corresponding submenu
    function selectMenu(object) {
        // Deselect the previously selected menu item
        var prevM = document.getElementById("m_" + def);
        prevM.className = "m_li";

        // Hide the previously displayed submenu
        var prevS = document.getElementById("s_" + def);
        prevS.style.display = "none";

        // Select the clicked menu item
        var currentM = document.getElementById("m_" + object);
        currentM.className = "m_li_a";

        // Show the corresponding submenu
        var currentS = document.getElementById("s_" + object);
        currentS.style.display = "block";

        // Update the default for next comparison
        def = object;
    }

    function exits() {
        layui.use('layer', function () {
            layer.confirm('确定要退出登录吗？', {icon: 3, title: '提示'}, function (index) {
                location.href = "${path}/UserServlet?type=exits";
            });
        });
    }

    function jumpUsers() {
        location.href = "${path}/UserServlet?type=findUserData&page=1";
    }

    function selectBooks(bid) {
        location.href = "${path}/BooksServlet?type=selectBooksById&id=" + bid;
    }
</script>
</body>
</html>
