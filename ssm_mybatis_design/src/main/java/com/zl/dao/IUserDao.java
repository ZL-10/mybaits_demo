package com.zl.dao;

import com.zl.domain.User;
import com.zl.mybatis.annotations.Select;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
       * @param userId
     * @return com.zl.domain.User
     *
     *
     */
    User findById(Integer userId);
}
