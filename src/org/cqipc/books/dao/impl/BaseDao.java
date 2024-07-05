package org.cqipc.books.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BaseDao<T> {
    protected SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private Class<T> mapper;

    public BaseDao() {
        initSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession(true);
    }

    public T getMapper() {
        return sqlSession.getMapper(mapper);
    }

    public void setMapper(Class<T> mapper) {
        this.mapper = mapper;
    }

    private void initSqlSessionFactory() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("MyBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
}
