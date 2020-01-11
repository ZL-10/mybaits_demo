package com.zl.test;

import com.zl.dao.IUserDao;
import com.zl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
        sqlSession=sqlSessionFactory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        IUserDao userDao1=sqlSession1.getMapper(IUserDao.class);
        User user1=userDao1.findById(41);
        sqlSession1.close();


        SqlSession sqlSession2=sqlSessionFactory.openSession();
        IUserDao userDao2=sqlSession2.getMapper(IUserDao.class);
        User user2=userDao2.findById(41);
        sqlSession1.close();

        System.out.println(user1==user2);
    }
}
