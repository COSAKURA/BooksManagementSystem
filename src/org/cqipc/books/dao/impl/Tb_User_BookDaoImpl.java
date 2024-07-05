package org.cqipc.books.dao.impl;

import org.cqipc.books.bean.Tb_User_Book;
import org.cqipc.books.dao.Tb_User_BookDao;

import java.util.List;

public class Tb_User_BookDaoImpl extends BaseDao<Tb_User_BookDao> implements Tb_User_BookDao {


    public Tb_User_BookDaoImpl() {
        this.setMapper(Tb_User_BookDao.class);
    }

    @Override
    public int addUserBook(Tb_User_Book tub) {
        int count = this.getMapper().addUserBook(tub);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int removeUserBooks(int id) {
        int count = this.getMapper().removeUserBooks(id);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public List<Tb_User_Book> findUserBookByUid(int uid, int pageCount, int pageSize) {
        int p = (pageCount - 1) * pageSize;
        return this.getMapper().findUserBookByUid(uid, p, pageSize);

    }

    @Override
    public int findUserBookByUidCount(int uid) {
        return this.getMapper().findUserBookByUidCount(uid);
    }

    @Override
    public List<Tb_User_Book> findUserBookByBid(int bid, int pageCount, int pageSize) {
        return this.getMapper().findUserBookByBid(bid, pageCount, pageSize);
    }

    @Override
    public int findUserBookByBidCount(int bid) {
        return this.getMapper().findUserBookByBidCount(bid);
    }

    @Override
    public List<Tb_User_Book> findAllUserBook(int pageCount, int pageSize) {
        int p = (pageCount - 1) * pageSize;
        return this.getMapper().findAllUserBook(p, pageSize);
    }

    @Override
    public int findAllUserBookCount() {
        return this.getMapper().findAllUserBookCount();
    }

    @Override
    public int modifyStat(int id) {
        int count = this.getMapper().modifyStat(id);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int findBookUseByBid(int bid) {
        return this.getMapper().findBookUseByBid(bid);
    }

    @Override
    public List<Tb_User_Book> searchUserBooksPage(int uid, int bid, String btime, String etime, String endTime, int stat, int pageCount, int pageSize) {
        int p = (pageCount - 1) * 5;
        return this.getMapper().searchUserBooksPage(uid, bid, btime, etime, endTime, stat, p, pageSize);
    }

    @Override
    public int searchUserBooksPageount(int uid, int bid, String btime, String etime, String endTime, int stat) {
        return this.getMapper().searchUserBooksPageount(uid, bid, btime, etime, endTime, stat);
    }

    @Override
    public int findLendBookFlag(int bid) {
        return this.getMapper().findLendBookFlag(bid);
    }
}
