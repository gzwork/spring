package com.gzwork.servers;

import com.gzwork.entity.User;


/**
 * 用户操作相关服务
 *
 * @author Gzwork
 * @version v1.0  2018年8月2日 10:04:09
 */
public interface UserServ {
    /**
     * 获取一个用户
     *
     * @param userId 用户ID
     * @return 数据库对象
     */
    User getUserById(Integer userId);

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 时候添加成功
     */
    boolean addUser(User user);
}
