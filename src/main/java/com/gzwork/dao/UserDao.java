package com.gzwork.dao;

import com.gzwork.entity.User;
import org.springframework.stereotype.Repository;


/**
 * @author Gzwork
 */
@Repository
public interface UserDao {
    /**
     * 获取一个数据库用户对象
     * @param user 用户对象
     * @return 用户对象
     */
    User getUserById(User user);
}
