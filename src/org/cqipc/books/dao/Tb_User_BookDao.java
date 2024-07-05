package org.cqipc.books.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.books.bean.Tb_User_Book;

import java.util.List;

public interface Tb_User_BookDao {
    int addUserBook(Tb_User_Book tub);

	int removeUserBooks(int id);

    List<Tb_User_Book> findUserBookByUid(@Param("uid") int uid, @Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    int findUserBookByUidCount(int uid);

    List<Tb_User_Book> findUserBookByBid(@Param("bid") int bid, @Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    int findUserBookByBidCount(int bid);

    List<Tb_User_Book> findAllUserBook(@Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    int findAllUserBookCount();

    int modifyStat(@Param("id") int id);

    int findBookUseByBid(int bid);

    List<Tb_User_Book> searchUserBooksPage(@Param("uid") int uid, @Param("bid") int bid, @Param("btime") String btime, @Param("etime") String etime, @Param("endTime") String endTime, @Param("stat") int stat, @Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    int searchUserBooksPageount(@Param("uid") int uid, @Param("bid") int bid, @Param("btime") String btime, @Param("etime") String etime, @Param("endTime") String endTime, @Param("stat") int stat);

    int findLendBookFlag(int bid);


}
