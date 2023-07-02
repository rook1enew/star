package com.test.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.dto.UserModifyDto;
import com.test.demo.dto.UserRegisterDto;
import com.test.demo.entity.UserEntity;
import com.test.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("userRegister")
    public String register() {
        return "userRegister";
    }

    @ResponseBody
    @PostMapping("submitRegister")
    public String submitRegister(@RequestBody UserRegisterDto userRegisterDto) {
        // 检验用户名是否被注册
        List<UserEntity> userEntityList = userService.getByUserName(userRegisterDto.getUserName());
        JSONObject result = new JSONObject();
        result.put("code", 0);
        if (!CollectionUtils.isEmpty(userEntityList)) {
            result.put("msg", "该用户名已经被注册了，请重新输入用户名!");
            return result.toJSONString();
        }
        // 检验手机号是否被注册
        userEntityList = userService.getByMobileNum(userRegisterDto.getMobileNum());
        if (!CollectionUtils.isEmpty(userEntityList)) {
            result.put("msg", "该手机号已经被注册了，请重新输入手机号!");
            return result.toJSONString();
        }
        userService.addUser(userRegisterDto);
        result.put("success", true);
        return result.toJSONString();
    }

    @GetMapping("userModify")
    public String userModify() {
        return "userModify";
    }

    @GetMapping("userInfo")
    @ResponseBody
    public String userInfo(Long userId) {
        UserEntity userEntity = userService.getByUserId(userId);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("success", true);
        result.put("userInfo", userEntity);
        return result.toJSONString();
    }

    @PostMapping("updateUser")
    public String submitUserModify(UserModifyDto userModifyDto) {
        userService.updateUser(userModifyDto);
        return "index";
    }
}
