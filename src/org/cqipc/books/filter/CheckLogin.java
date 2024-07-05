package org.cqipc.books.filter;

import org.cqipc.books.bean.Tb_User;
import org.cqipc.books.dao.Tb_UserDao;
import org.cqipc.books.dao.impl.Tb_UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLogin implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("登录过滤器正在过滤。。。。");
        HttpServletRequest re = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        String username = re.getParameter("username");
        String pwd = re.getParameter("pwd");
        Tb_UserDao tud = new Tb_UserDaoImpl();
        Tb_User tu = tud.userLogin(username, pwd);
        if (username.equals("root") && tu != null) {
            rs.sendRedirect("./html/index.html");
        } else if (username.equals("root") && tu == null) {
            request.setAttribute("info", "管理员的用户名或者密码错误!");
            request.getRequestDispatcher("./Login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录过滤器启动了");
    }

}
