package org.cqipc.books.controller;

import com.google.gson.Gson;
import org.cqipc.books.bean.Tb_Books;
import org.cqipc.books.bean.Tb_Books_Type;
import org.cqipc.books.dao.Tb_BooksDao;
import org.cqipc.books.dao.Tb_User_BookDao;
import org.cqipc.books.dao.impl.Tb_BooksDaoImpl;
import org.cqipc.books.dao.impl.Tb_User_BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {
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
        Tb_BooksDao bd = new Tb_BooksDaoImpl();
        Tb_User_BookDao ubd = new Tb_User_BookDaoImpl();
        if ("selectBooksPage".equals(type)) {
            int page = Integer.parseInt(request.getParameter("page"));
            int c = bd.selectBooksCount();
            int count = (c - 1) / 5 + 1;
            List<Tb_Books> list = bd.findAllBooksPage(page, 5);
            Object[] param = {count, list};
            out.print(gson.toJson(param));
        } else if ("removeBooks".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (ubd.findBookUseByBid(id) > 0) {
                out.print(gson.toJson(-1));

            } else {
                if (bd.removeBooks(id) > 0) {
                    out.print(gson.toJson(1));
                } else {
                    out.print(gson.toJson(0));
                }
            }
        } else if ("selectOne".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Tb_Books tb = bd.findBooksById(id);
            out.print(gson.toJson(tb));
        } else if ("update".equals(type)) {
            int id = Integer.parseInt(request.getParameter("bid"));
            String ISBN = request.getParameter("isbn");
            String book_name = request.getParameter("book_name");
            double book_price = Double.parseDouble(request.getParameter("book_price"));
            String book_author = request.getParameter("book_author");
            String published_house = request.getParameter("published_house");
            int book_category = Integer.parseInt(request.getParameter("book_category"));
            Tb_Books tb = new Tb_Books(id, ISBN, book_name, book_price, book_author, published_house, new Tb_Books_Type(book_category, null, 0));
            if (bd.modifyBooks(tb) > 0) {
                out.print(gson.toJson(1));

            } else {
                out.print(gson.toJson(0));
            }
        } else if ("insert".equals(type)) {
            String ISBN = request.getParameter("isbn");
            String book_name = request.getParameter("book_name");
            double book_price = Double.parseDouble(request.getParameter("book_price"));
            String book_author = request.getParameter("book_author");
            String published_house = request.getParameter("published_house");
            int book_category = Integer.parseInt(request.getParameter("book_category"));
            Tb_Books tb = new Tb_Books(ISBN, book_name, book_price, book_author, published_house, new Tb_Books_Type(book_category, null, 0));
            if (bd.addBooks(tb) > 0) {
                out.print(gson.toJson(1));
            } else {
                out.print(gson.toJson(0));
            }
        } else if ("selectBooksById".equals(type)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Tb_Books tb = bd.findBooksById(id);
            request.setAttribute("books", tb);
            request.getRequestDispatcher("./jsp/book.jsp").forward(request, response);
        }
    }

}
