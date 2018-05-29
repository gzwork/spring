package com.gzwork.servers;

import com.gzwork.entity.User;


/**
 * @author Gzwork
 */
public interface UserServ {
    /**
     * 获取一个用户
     * @param user 用户对象
     * @return 数据库对象
     */
    User getUserById(User user);
}
