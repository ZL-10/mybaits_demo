package com.zl.test;

import com.zl.dao.IAccountDao;
import com.zl.dao.IUserDao;
import com.zl.domain.Account;
import com.zl.domain.AccountUser;
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

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    IAccountDao accountDao;
    IUserDao userDao;

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
         accountDao=sqlSession.getMapper(IAccountDao.class);
         userDao=sqlSession.getMapper(IUserDao.class);


    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findByUid(){
        List<Account> accounts=accountDao.findByUid(41);
        for(Account account:accounts) {
            System.out.println(account);
        }
    }

}
