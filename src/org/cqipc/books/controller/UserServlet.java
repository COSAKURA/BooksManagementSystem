package org.cqipc.books.controller;

import com.google.gson.Gson;
import org.cqipc.books.bean.Tb_User;
import org.cqipc.books.bean.Tb_User_Book;
import org.cqipc.books.dao.Tb_UserDao;
import org.cqipc.books.dao.Tb_User_BookDao;
import org.cqipc.books.dao.impl.Tb_UserDaoImpl;
import org.cqipc.books.dao.impl.Tb_User_BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html:charset=UTF-8");
        String type = request.getParameter("type");
        Tb_UserDao tu = new Tb_UserDaoImpl();
        Tb_User_BookDao ubd = new Tb_User_BookDaoImpl();
        Gson gson = new Gson();
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if ("selectUsersAll".equals(type)) {
            List<Tb_User> list = tu.selectUserAll();
            out.print(gson.toJson(list));
        } else if ("delete".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (tu.removeUser(id) > 0) {
                out.print(gson.toJson("ok"));
            } else {
                out.print(gson.toJson("no"));
            }
        } else if("modiftRootPwd".equals(type)) {
            int id=Integer.parseInt(request.getParameter("id"));
            String pwd=request.getParameter("pwd");
            if(tu.modifyPassword(id, pwd)>0) {
                out.print(gson.toJson(1));
            }else {
                out.print(gson.toJson(0));
            }
        } else if ("regUser".equals(type)) {
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            if (tu.findUserNames(username) == 0) {
                Tb_User t = new Tb_User(username, password);
                if (tu.addUsers(t) > 0) {

                    request.setAttribute("errorInfo", "注册成功!");
                    request.getRequestDispatcher("reg.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorInfo", "系统错误，请重试!");
                    request.getRequestDispatcher("reg.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorInfo", "该用户名已被使用，请重试!");
                request.getRequestDispatcher("reg.jsp").forward(request, response);
            }
        } else if ("exits".equals(type)) {
            session.removeAttribute("users");
            session.removeAttribute("list");
            session.removeAttribute("list2");
            response.sendRedirect("./Login.jsp");
        } else if ("findUserData".equals(type)) {
            Tb_User tus = (Tb_User) session.getAttribute("users");
            int pageCount = Integer.parseInt(request.getParameter("page"));
            int c = ubd.findUserBookByUidCount(tus.getId());
            int count = (c - 1) / 5 + 1;
            List<Tb_User_Book> list = ubd.findUserBookByUid(tus.getId(), pageCount, 5);
            request.setAttribute("count", count);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("userbooklist", list);
            request.getRequestDispatcher("./jsp/users.jsp").forward(request, response);
        }
        else if("findUserPwd".equals(type)){
            Tb_User t=(Tb_User)session.getAttribute("users");
            out.print(gson.toJson(t));
        }


    }

}
