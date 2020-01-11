package com.zl.dao;

import com.zl.domain.Account;
import com.zl.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * @param
     * @return java.util.List<com.zl.domain.Account>
     * 查询所有账户
     *
     */
    List<Account> findAll();


    List<Account> findByUid(Integer id);


}
