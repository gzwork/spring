package com.gzwork.ctrl;

import com.gzwork.common.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gzwork
 */
@RestController
@RequestMapping("/user")
public class UserCtrl {

    /**
     * 用户登录方法
     *
     * @return 用户登录处理信息
     */
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseData login(){
        ResponseData responseData=new ResponseData();
        return  responseData;
    }
}
