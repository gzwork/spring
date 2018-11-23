package com.gzwork.servers.impl;

import com.gzwork.dao.UserDao;
import com.gzwork.entity.User;
import com.gzwork.servers.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户操作相关服务
 *
 * @author Gzwork
 * @version v1.0  2018年8月2日 10:04:09
 */
@Service
public class UserServImpl implements UserServ {


    @Autowired
    private UserDao userDao;

    /**
     * 获取一个用户
     *
     * @param userId 用户ID
     * @return 数据库对象
     */
    @Override
    public User getUserById(Integer userId) {
        return this.userDao.getUserById(userId);
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 时候添加成功
     */
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0;
    }
}
