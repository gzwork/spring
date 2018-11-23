package com.gzwork.ctrl;

import com.gzwork.common.ResponseData;
import com.gzwork.entity.User;
import com.gzwork.enums.MsgCodeEnum;
import com.gzwork.servers.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gzwork
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Autowired
    private UserServ userServ;

    /**
     * 用户登录方法
     *
     * @return 用户登录处理信息
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody User user) {
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 根据ID获取用户信息
     *
     * @param userId 用户ID
     * @return 用户
     */
    @RequestMapping(path = "/getUserById", method = RequestMethod.GET)
    public ResponseData getUserById(@NotNull(message = "{user_id_valid}") Integer userId) {
        //获取结果
        return new ResponseData(userServ.getUserById(userId));
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 数据库操作结果
     */
    @RequestMapping(path = "/addUser", method = RequestMethod.PUT)
    public ResponseData addUser(@Valid User user, BindingResult bindingResult) {
        //验证合法性
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<String> errorMsgs = new ArrayList<>();
            allErrors.forEach(objectError -> {
                errorMsgs.add(objectError.getDefaultMessage());
            });
            return new ResponseData(errorMsgs, MsgCodeEnum.PARAMS_ILLEGAL);
        }
        return new ResponseData(userServ.addUser(user));
    }
}
