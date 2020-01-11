package com.zl.test;

import com.zl.dao.IUserDao;
import com.zl.domain.User;
import com.zl.mybatis.io.Resources;
import com.zl.mybatis.sqlsession.SqlSession;
import com.zl.mybatis.sqlsession.SqlSessionFactory;
import com.zl.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisCRUDTest {
/*
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlsession;
    private IUserDao userDao;

    @Test
    public void testFindOne() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Before
    public void init() {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建SqlSession工厂对象
        factory = builder.build(in);
        //4.创建SqlSession对象
        sqlsession = factory.openSession();
        //5.创建Dao的代理对象
        userDao = sqlsession.getMapper(IUserDao.class);
    }

    @After
    public void desroty() throws Exception{
        sqlsession.commit();
        sqlsession.close();
        in.close();
    }
*/
}
