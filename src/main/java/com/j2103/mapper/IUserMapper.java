package com.j2103.mapper;

import com.j2103.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

public interface IUserMapper {

    /**
     *  添加用户的方法
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     *  查询所有的方法
     * @return
     */
    List<User> findAll();

    /**
     *  根据id查询一条用户信息
     * @param uidd
     * @return
     */
    User findById(int uidd);

    /**
     * 根据id查询一条用户信息
     * @param user
     * @return
     */
    User findByUid(User user);

    /**
     *  根据id修改一条用户信息
     * @param user
     * @return
     */
    boolean updateById(User user);

    /**
     *  根据id删除一条用户信息
     * @param uid
     * @return
     */
    boolean deleteById(int uid);

}
