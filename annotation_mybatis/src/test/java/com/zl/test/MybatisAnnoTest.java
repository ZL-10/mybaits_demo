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

public class MybatisAnnoTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    IUserDao userDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
//        sqlSession.close();
//        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }
}
