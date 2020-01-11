package com.zl.dao.impl;

import com.zl.dao.IUserDao;
import com.zl.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users=session.selectList("com.zl.dao.IUserDao.findAll");//参数就是能获取的配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        session.selectList("com.zl.dao.IUserDao.saveUser",user);
        //3.释放资源
        session.close();

    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        session.selectList("com.zl.dao.IUserDao.updateUser",user);
        //3.释放资源
        session.close();

    }

    public void deleteUser(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        session.selectList("com.zl.dao.IUserDao.deleteUser",id);
        //3.释放资源
        session.close();
    }

    public User findById(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        User user=session.selectOne("com.zl.dao.IUserDao.findById",id);
        //3.释放资源
        session.close();

        return user;
    }

    public List<User> findByName(String name) {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users=session.selectList("com.zl.dao.IUserDao.findByName",name);//参数就是能获取的配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session =factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        int num=session.selectOne("com.zl.dao.IUserDao.findTotal");//参数就是能获取的配置信息的key
        //3.释放资源
        session.close();
        return num;
    }
}
