package com.zl.dao;

import com.zl.domain.QueryVo;
import com.zl.domain.User;

import java.util.List;

/**
 * @author zl
 * 用户的持久层接口
 *
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
       * @param user
     * @return void
     * 更新用户信息
     *
     */
    void updateUser(User user);

    /**
       * @param id UserId
     * @return void
     * 根据用户Id删除User
     *
     */
    void deleteUser(Integer id);

    /**
       * @param id
     * @return void
     * 根据id查询用户
     *
     */
    User findById(Integer id);
    /**
       * @param name
     * @return java.util.List<com.zl.domain.User>
     * 名字模糊查询
     *
     */
    List<User> findByName(String name);

    /**
       * @param
     * @return int
     * 聚合查询：返回总用户数
     *
     */
    int findTotal();

    /**
     * @param vo
     * @return com.zl.domain.User
     *
     * 
     */
    List<User> findByQueryVo(QueryVo vo);
    
    /**
     * @param user
     * @return java.util.List<com.zl.domain.User>
     * 通过条件查询
     * 
     */
    List<User> findUserByCondition(User user);

    /**
     * @param vo
     * @return java.util.List<com.zl.domain.User>
     * 通过集合Id查询数据
     *
     */
    List<User> findUserByListId(QueryVo vo);
    
}
