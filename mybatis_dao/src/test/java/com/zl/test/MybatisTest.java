package com.zl.test;

import com.zl.dao.IUserDao;
import com.zl.dao.impl.UserDaoImpl;
import com.zl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取dao的代理对象
        userDao = new UserDaoImpl(factory);

    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

        /**
         * @param
         * @return void
         * 测试查询所有用户
         *
         */
    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * @param
     * @return void
     * 测试保存用户
     */
    @Test
    public void TestSaveUser() {
        User user = new User();
        user.setUsername("lastInsertId");
        user.setAddress("广东");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("before save"+user);
        userDao.saveUser(user);
        System.out.println("-----------------------");
        System.out.println("after save"+user);

    }

    /**
     * @param
     * @return void
     * 测试更新用户数据
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(54);
        user.setUsername("mybatis_updateUser");
        user.setAddress("广东");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * @param
     * @return void
     * 测试根据用户id进行删除
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(54);
        System.out.println("delete user success");
    }

    /**
     * @param
     * @return void
     * 根据id进行查询
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * @param
     * @return void
     * 测试名字模糊查询
     * 这里的名字需要带上%，才能进行模糊查询
     */
    @Test
    public void testFindByName() {
        String name = "%王";
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * @param
     * @return void
     * 测试查询记录条数
     */
    @Test
    public void testFindTotal() {
        int num = userDao.findTotal();
        System.out.println("total users =" + num);
    }




}
