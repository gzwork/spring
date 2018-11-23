package com.gzwork.test;

import com.gzwork.entity.User;
import com.gzwork.servers.UserServ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "classpath*:spring.xml")
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    private UserServ userServ;

    @Test
    public void getUserById() {
        User user = new User();
        user.setUserId(1);
        System.out.println(userServ.getUserById(user.getUserId()));
    }

    @Test
    public void groovy() {

    }


}
