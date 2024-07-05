package org.cqipc.books.controller;

import com.google.gson.Gson;
import org.cqipc.books.bean.Tb_Books;
import org.cqipc.books.bean.Tb_User;
import org.cqipc.books.bean.Tb_User_Book;
import org.cqipc.books.dao.Tb_BooksDao;
import org.cqipc.books.dao.Tb_UserDao;
import org.cqipc.books.dao.Tb_User_BookDao;
import org.cqipc.books.dao.impl.Tb_BooksDaoImpl;
import org.cqipc.books.dao.impl.Tb_UserDaoImpl;
import org.cqipc.books.dao.impl.Tb_User_BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet("/UserBooksServlet")
public class UserBooksServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html:charset=UTF-8");
		String type=request.getParameter("type");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		Tb_UserDao ud=new Tb_UserDaoImpl();
		Tb_BooksDao bd=new Tb_BooksDaoImpl();
		Tb_User_BookDao ubd=new Tb_User_BookDaoImpl();
		if("initUserBooks".equals(type)) {
			int pageCount=Integer.parseInt(request.getParameter("page"));
			int c=ubd.findAllUserBookCount();
			int count=(c-1)/5+1;
			List<Tb_User> list1=ud.selectUserAll();
			List<Tb_Books> list2=bd.selectBooksAll();
			List<Tb_User_Book> list3=ubd.findAllUserBook(pageCount,5);
			Object[] param= {count,list1,list2,list3};
			out.print(gson.toJson(param));
		}else if("searchInfo".equals(type)) {
			int pageCount=Integer.parseInt(request.getParameter("page"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			int bid=Integer.parseInt(request.getParameter("bid"));
			int stat=Integer.parseInt(request.getParameter("stat"));
			String btime=request.getParameter("btime");
			String etime=request.getParameter("etime");
			System.out.println(pageCount);
			System.out.println(uid);
			System.out.println(bid);
			System.out.println(stat);
			System.out.println(btime);
			System.out.println(etime);
			List<Tb_User_Book> list3=null;
			int count=0;
			if(stat==2) {
				String dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss").format(new Date());
				list3=ubd.searchUserBooksPage(uid, bid, btime, etime, dateFormat, stat, pageCount, 5);
				int c=ubd.searchUserBooksPageount(uid, bid, btime, etime, dateFormat,1);
				count=(c-1)/5+1;
			}else {
				list3=ubd.searchUserBooksPage(uid, bid, btime, etime, null, stat, pageCount, 5);
				int c=ubd.searchUserBooksPageount(uid, bid, btime, etime, null,stat);
				count=(c-1)/5+1;
			}
			List<Tb_User> list1=ud.selectUserAll();
			List<Tb_Books> list2=bd.selectBooksAll();
			Object[] param= {count,list1,list2,list3};
			out.print(gson.toJson(param ));
		}else if("updateStat".equals(type)) {
			int id=Integer.parseInt(request.getParameter("id"));
			if(ubd.modifyStat(id)>0) {
				out.print(gson.toJson(1));
			}else {
				out.print(gson.toJson(0));
			}
		}else if("lendbook".equals(type)){
			int uid=Integer.parseInt(request.getParameter("uid"));
			int bid=Integer.parseInt(request.getParameter("bid"));
			if(ubd.findLendBookFlag(bid)<=0) {
				request.setAttribute("uid", uid);
				request.setAttribute("bid", bid);
				request.setAttribute("infos","借阅成功!");
				request.getRequestDispatcher("./jsp/lendbook.jsp").forward(request, response);
			}else {
				Tb_Books tb=bd.findBooksById(bid);
				request.setAttribute("books", tb);
				request.setAttribute("infos","该书籍已经被借阅了!");
				request.getRequestDispatcher("./jsp/book.jsp").forward(request, response);
			}
		}else if("lendbooks".equals(type)) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			int bid=Integer.parseInt(request.getParameter("bid"));

			String end_time=request.getParameter("end_time");
			String begin_time=new SimpleDateFormat("yy-MM-dd").format(new Date());
			Tb_User_Book tub=new Tb_User_Book(new Tb_User(uid,"",""),
					new Tb_Books(bid,"","", 0,"", "",null),begin_time,end_time, 1);
			if(ubd.addUserBook(tub)>0) {
				Tb_Books tb=bd.findBooksById(bid);
				request.setAttribute("books" ,tb);
				request.getRequestDispatcher("./jsp/book.jsp").forward(request, response);
			}else {
				request.setAttribute("info","借阅书籍失败，请重试!");
				request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);
			}
		}
	}

}
