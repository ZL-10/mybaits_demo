package com.zl.dao.impl;

import com.zl.dao.IUsersDao;
import com.zl.domain.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Statement;
import java.util.List;

public class IUserDaoImpl implements IUsersDao {
    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<Users> findAll() {
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法\
        List<Users> users = session.selectList("com.zl.dao.IUsersDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }
}
