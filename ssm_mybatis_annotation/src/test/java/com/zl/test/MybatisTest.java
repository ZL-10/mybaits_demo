package com.zl.test;

import com.zl.dao.IUsersDao;
import com.zl.domain.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //使用SqlSession创建Dao接口的代理对象
        IUsersDao usersDao = session.getMapper(IUsersDao.class);
        //使用代理对象执行方法
        List<Users> users = usersDao.findAll();
        for (Users user : users) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
