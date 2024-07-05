package org.cqipc.books.dao.impl;

import org.cqipc.books.bean.Tb_Books_Type;
import org.cqipc.books.dao.Tb_Books_TypeDao;

import java.util.List;

public class Tb_Books_TypeDaoImpl extends BaseDao<Tb_Books_TypeDao> implements Tb_Books_TypeDao {

    public Tb_Books_TypeDaoImpl() {
        this.setMapper(Tb_Books_TypeDao.class);
    }

    @Override
    public int addBookType(Tb_Books_Type booksType) {
        int count = this.getMapper().addBookType(booksType);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int modifyBookType(Tb_Books_Type booktype) {
        int count = this.getMapper().modifyBookType(booktype);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public Tb_Books_Type findBookTypeById(int id) {
        return this.getMapper().findBookTypeById(id);
    }

    @Override
    public List<Tb_Books_Type> findAllBookType() {
        return this.getMapper().findAllBookType();
    }

    @Override
    public List<Tb_Books_Type> findBookTypePage(int pageCount, int pageSize) {
        return this.getMapper().findBookTypePage(pageCount, pageSize);
    }

    @Override
    public int findBookTypePageCount() {
        return this.getMapper().findBookTypePageCount();
    }
}
