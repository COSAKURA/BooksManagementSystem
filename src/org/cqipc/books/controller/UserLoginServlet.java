package org.cqipc.books.controller;

import org.cqipc.books.bean.Tb_Books;
import org.cqipc.books.bean.Tb_Books_Type;
import org.cqipc.books.bean.Tb_User;
import org.cqipc.books.dao.Tb_BooksDao;
import org.cqipc.books.dao.Tb_Books_TypeDao;
import org.cqipc.books.dao.Tb_UserDao;
import org.cqipc.books.dao.impl.Tb_BooksDaoImpl;
import org.cqipc.books.dao.impl.Tb_Books_TypeDaoImpl;
import org.cqipc.books.dao.impl.Tb_UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        Tb_UserDao tud = new Tb_UserDaoImpl();
        Tb_Books_TypeDao btd = new Tb_Books_TypeDaoImpl();
        Tb_BooksDao tbd = new Tb_BooksDaoImpl();
        Tb_User tu = tud.userLogin(username, pwd);
        HttpSession session = request.getSession();
        if (tu != null) {
            List<Tb_Books_Type> list = btd.findAllBookType();
            List<Tb_Books> list2 = tbd.selectBooksAll();
            session.setAttribute("users", tu);
            session.setAttribute("list", list);
            session.setAttribute("list2", list2);
            response.sendRedirect("./jsp/index.jsp");
        } else {
            request.setAttribute("info", "用户名或者密码错误!");
            request.getRequestDispatcher("./Login.jsp").forward(request, response);
        }
    }

}
