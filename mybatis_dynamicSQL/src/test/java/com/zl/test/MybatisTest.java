package com.zl.test;

import com.zl.dao.IUserDao;
import com.zl.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

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
        user.setUserName("lastInsertId");
        user.setUserAddress("广东");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("before save"+user);
        userDao.saveUser(user);
        //5.提交事务
        sqlSession.commit();
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
        user.setUserId(49);
        user.setUserName("mybatis_updateUser");
        user.setUserAddress("广东");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        userDao.updateUser(user);
        //5.提交事务
        sqlSession.commit();
    }

    /**
     * @param
     * @return void
     * 测试根据用户id进行删除
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(52);
        //5.提交事务
        sqlSession.commit();
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
        String name = "%王";
        int num = userDao.findTotal();
        System.out.println("total users =" + num);
    }

    /**
     * @param
     * @return void
     * 测试通过复杂条件查询
     *
     */
    @Test
    public void testFindByQueryVo() {
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUserName("%王");
        vo.setUser(user);
        List<User> users=  userDao.findByQueryVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * @param
     * @return void
     * 通过条件查询
     *
     */
    @Test
    public void testFindUserByCondition(){
        User u=new User();
        u.setUserName("老王");
        List<User> users=userDao.findUserByCondition(u);
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByListId(){
        QueryVo vo=new QueryVo();
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        vo.setIds(ids);
        List<User> users=userDao.findUserByListId(vo);
        for(User user:users){
            System.out.println(user);
        }
    }

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);

    }

    @After
    public void destroy() throws IOException {

        sqlSession.close();
        in.close();
    }
}
