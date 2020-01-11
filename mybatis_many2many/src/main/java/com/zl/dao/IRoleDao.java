package com.zl.dao;

import com.zl.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * @param
     * @return java.util.List<com.zl.domain.Role>
     * 查询所有角色
     */
    List<Role> findAll();
}
