package com.gzwork.servers.impl;

import com.gzwork.dao.UserDao;
import com.gzwork.entity.User;
import com.gzwork.servers.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gzwork
 */
@Service
public class UserServImpl implements UserServ {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(User user) {
        return this.userDao.getUserById(user);
    }
}
