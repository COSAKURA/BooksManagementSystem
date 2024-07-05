package org.cqipc.books.controller;

import com.google.gson.Gson;
import org.cqipc.books.bean.Tb_Books_Type;
import org.cqipc.books.dao.Tb_Books_TypeDao;
import org.cqipc.books.dao.impl.Tb_Books_TypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class BookTypeServlet
 */
@WebServlet("/BookTypeServlet")
public class BookTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        Tb_Books_TypeDao tbt = new Tb_Books_TypeDaoImpl();

        if ("selectBookTypeAll".equals(type)) {
            List<Tb_Books_Type> list = tbt.findAllBookType();
            out.print(gson.toJson(list));
        } else if ("insert".equals(type)) {
            String types = request.getParameter("types");
            int type_max_num = Integer.parseInt(request.getParameter("type_max_num"));
            Tb_Books_Type tb = new Tb_Books_Type(types, type_max_num);
            if (tbt.addBookType(tb) > 0) {
                out.print(gson.toJson(1));
            } else {
                out.print(gson.toJson(0));
            }
        } else if ("selectOne".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Tb_Books_Type tb = tbt.findBookTypeById(id);
            out.print(gson.toJson(tb));
        } else if ("selectBookPage".equals(type)) {
            int page = Integer.parseInt(request.getParameter("page"));
            int c = tbt.findBookTypePageCount();
            int count = (c - 1) / 5 + 1;
            int p = (page - 1) * 5;
            List<Tb_Books_Type> list = tbt.findBookTypePage(p, 5);
            Object[] param = {count, list};
            out.print(gson.toJson(param));
        } else if ("update".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String types = request.getParameter("types");
            int type_max_num = Integer.parseInt(request.getParameter("type_max_num"));
            Tb_Books_Type booktype = new Tb_Books_Type(id, types, type_max_num);
            if (tbt.modifyBookType(booktype) > 0) {
                out.print(gson.toJson(1));
            } else {
                out.print(gson.toJson(0));
            }
        }
    }
}