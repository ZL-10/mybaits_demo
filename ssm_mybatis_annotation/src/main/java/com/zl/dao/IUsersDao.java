package com.zl.dao;

import com.zl.domain.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * Users类dao层接口
 * */
public interface IUsersDao {
    //查询所有user
    @Select("select * from users")
    List<Users> findAll();
}