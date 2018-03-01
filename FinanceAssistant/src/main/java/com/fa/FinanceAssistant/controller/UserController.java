package com.fa.FinanceAssistant.controller;

import com.fa.FinanceAssistant.common.ResponseResult;
import com.fa.FinanceAssistant.model.User;
import com.fa.FinanceAssistant.service.UserService;
import com.fa.FinanceAssistant.viewmodel.ModifyUserPasswordRequest;
import com.fa.FinanceAssistant.viewmodel.RegisterUserRequest;
import com.fa.FinanceAssistant.viewmodel.ResetUserPasswordRequest;
import com.fa.FinanceAssistant.viewmodel.UpdateUserRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wenfeng on 2018/2/28.
 */
@RestController
@Api(value = "用户相关")
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/register")
    public ResponseResult register(@RequestBody RegisterUserRequest request){
        User user= new User();
        BeanUtils.copyProperties(request,user);
        userService.create(user);
        return ResponseResult.SuccessResult();
    }

    @PostMapping(value = "/update")
    public ResponseResult update(@RequestBody UpdateUserRequest request){
        // 获取当前登录用户
        User user= new User();
        BeanUtils.copyProperties(request,user);
        userService.update(user);
        return ResponseResult.SuccessResult();
    }

    @PostMapping(value = "/enableToggle")
    public ResponseResult enableToggle(@RequestBody UpdateUserRequest request){
        User user= new User();  // 获取当前登录用户
        Boolean enable=user.getEnable();
        user.setEnable(!enable);
        userService.update(user);
        return ResponseResult.SuccessResult();
    }

    @PostMapping(value = "/modifyPassword")
    public ResponseResult modifyPassword(@RequestBody ModifyUserPasswordRequest request){
        User user= new User();  // 获取当前登录用户
        if(request.getOldPassword().equals(user.getPassword())){
            //todo exception
        }
        user.setPassword(request.getNewPassword());
        userService.update(user);
        return ResponseResult.SuccessResult();
    }

    @PostMapping(value = "/resetPassword")
    public ResponseResult resetPassword(@RequestBody ResetUserPasswordRequest request){
        User user= new User();
        //todo 验证码
        user.setPassword(request.getPassword());
        userService.update(user);
        return ResponseResult.SuccessResult();
    }

    @PostMapping(value = "/{id}")
    public ResponseResult findUserInfo(@PathVariable("id") String id){
        User user=userService.findById(id);
        return ResponseResult.SuccessResult(user);
    }
}
