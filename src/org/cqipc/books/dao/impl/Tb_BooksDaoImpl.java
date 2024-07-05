package org.cqipc.books.dao.impl;


import org.cqipc.books.bean.Tb_Books;
import org.cqipc.books.dao.Tb_BooksDao;

import java.util.List;

public class Tb_BooksDaoImpl extends BaseDao<Tb_BooksDao> implements Tb_BooksDao {

    public Tb_BooksDaoImpl() {
        this.setMapper(Tb_BooksDao.class);
    }

    @Override
    public int addBooks(Tb_Books tb) {
        int count = this.getMapper().addBooks(tb);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int modifyBooks(Tb_Books tb) {
        int count = this.getMapper().modifyBooks(tb);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int removeBooks(int id) {
        int count = this.getMapper().removeBooks(id);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public Tb_Books findBooksById(int id) {
        return this.getMapper().findBooksById(id);
    }

    @Override
    public List<Tb_Books> findAllBooksPage(int pageCount, int pageSize) {
        int p = (pageCount - 1) * pageSize;
        return this.getMapper().findAllBooksPage(p, pageSize);
    }

    @Override
    public int selectBooksCount() {
        return this.getMapper().selectBooksCount();
    }

    @Override
    public List<Tb_Books> selectBooksAll() {
        return this.getMapper().selectBooksAll();
    }


}
