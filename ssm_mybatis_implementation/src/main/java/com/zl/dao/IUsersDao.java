package com.zl.dao;

import com.zl.domain.Users;

import java.util.List;

/*
 * Users类dao层接口
 * */
public interface IUsersDao {
    //    查询所有user
    List<Users> findAll();
}