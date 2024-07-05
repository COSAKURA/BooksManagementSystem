package org.cqipc.books.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.books.bean.Tb_Books_Type;

import java.util.List;

public interface Tb_Books_TypeDao {

    int addBookType(Tb_Books_Type booktype);

    int modifyBookType(Tb_Books_Type booktype);

    Tb_Books_Type findBookTypeById(int id);

    List<Tb_Books_Type> findAllBookType();

    int findBookTypePageCount();

    List<Tb_Books_Type> findBookTypePage(@Param("pageCount") int pageCount, @Param("pageSize") int pageSize);
}