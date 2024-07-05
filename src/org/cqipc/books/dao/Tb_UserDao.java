package org.cqipc.books.dao;

import org.apache.ibatis.annotations.Param;
import org.cqipc.books.bean.Tb_User;

import java.util.List;

public interface Tb_UserDao {

    Tb_User userLogin(@Param("user") String user, @Param("passwd") String passwd);

    int addUsers(Tb_User user);

    int modifyPassword(@Param("id") int id, @Param("passwd") String passwd);

    List<Tb_User> selectUserAll();

    int removeUser(int id);

    int modifyPasswordByRoot(@Param("username") String username, @Param("passwd") String passwd);

    int findUserNames(String username);

    Tb_User findUserByUsername(String username);
}
