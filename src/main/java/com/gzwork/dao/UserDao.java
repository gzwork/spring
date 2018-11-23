package com.gzwork.dao;

import com.gzwork.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 用户相关数据库操作
 *
 * @author Gzwork
 * @version v1.0  2018年8月2日 10:04:09
 */
@Repository
public interface UserDao {
    /**
     * 获取一个数据库用户对象
     *
     * @param userId 用户Id
     * @return 用户对象
     */
    User getUserById(@Param("userId") Integer userId);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 受影响行数
     */
    int addUser(User user);
}
