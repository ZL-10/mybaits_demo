package com.zl.dao;

import com.zl.domain.User;

import java.util.List;

/**
 * @author zl
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * @param id
     * @return com.zl.domain.User
     * 通过id查询
     *
     */
    User findById(Integer id);

}
