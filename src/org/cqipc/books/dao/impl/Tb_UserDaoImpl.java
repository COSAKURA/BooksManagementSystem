package org.cqipc.books.dao.impl;

import org.cqipc.books.bean.Tb_User;
import org.cqipc.books.dao.Tb_UserDao;

import java.util.List;

public class Tb_UserDaoImpl extends BaseDao<Tb_UserDao> implements Tb_UserDao {

    public Tb_UserDaoImpl() {
        this.setMapper(Tb_UserDao.class);
    }

    @Override
    public Tb_User userLogin(String user, String password) {
        return this.getMapper().userLogin(user, password);
    }

    @Override
    public int addUsers(Tb_User users) {
        int count = this.getMapper().addUsers(users);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int modifyPassword(int id, String passwd) {
        int count = this.getMapper().modifyPassword(id, passwd);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public List<Tb_User> selectUserAll() {
        return this.getMapper().selectUserAll();
    }

    @Override
    public int removeUser(int id) {
        int count = this.getMapper().removeUser(id);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int modifyPasswordByRoot(String username, String passwd) {
        int count = this.getMapper().modifyPasswordByRoot(username, passwd);
        this.sqlSession.commit();
        return count;
    }

    @Override
    public int findUserNames(String username) {
        return this.getMapper().findUserNames(username);
    }

    @Override
    public Tb_User findUserByUsername(String username) {
        Tb_User count = this.getMapper().findUserByUsername(username);
        this.sqlSession.commit();
        return count;
    }


}
