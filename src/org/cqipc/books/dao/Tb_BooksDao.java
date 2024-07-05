package org.cqipc.books.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.books.bean.Tb_Books;

import java.util.List;

/**
 * @author Sakura
 */
public interface Tb_BooksDao {
    int addBooks(Tb_Books tb);

    int modifyBooks(Tb_Books tb);

    int removeBooks(int id);

    Tb_Books findBooksById(int id);

    List<Tb_Books> findAllBooksPage(@Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    int selectBooksCount();

    List<Tb_Books> selectBooksAll();
}
