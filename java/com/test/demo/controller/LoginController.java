package com.test.demo.controller;

import cn.hutool.captcha.GifCaptcha;
import com.alibaba.fastjson.JSONObject;
import com.test.demo.dto.LoginDTO;
import com.test.demo.dto.UserDto;
import com.test.demo.entity.UserEntity;
import com.test.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Resource
    private GifCaptcha gifCaptcha;

    @Resource
    private UserService userService;

    @GetMapping("indexLogin")
    public String indexLogin() {
        return "login";
    }

    /**
     * ajax异步请求后台接口
     *
     * @param loginDTO
     * @return
     */
    @ResponseBody
    @PostMapping("login")
    public String login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
        System.out.println("用户填写的登录信息:" + JSONObject.toJSONString(loginDTO));
        boolean captchaValidResult = gifCaptcha.verify(loginDTO.getCaptcha());
        System.out.println("验证码验证结果:" + captchaValidResult);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        // 当用户输入的验证码错误，直接返回错误提示信息给前端
        if (!captchaValidResult) {
            result.put("success", false);
            result.put("msg", "请输入正确的验证码!");
            return result.toJSONString();
        }
        // 当验证码检验通过，则查询用户信息是否输入正确
        UserEntity userEntity = userService.getByUserNameAndPwd(loginDTO.getUsername(), loginDTO.getPassword());
        if (userEntity == null) {
            result.put("success", false);
            result.put("msg", "用户名或者密码输入错误，请重新输入!");
            return result.toJSONString();
        }
        result.put("success", true);
        result.put("msg", "登录成功");
        // 登录成功，将用户信息存入session中
        UserDto user = new UserDto();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getNickName());
        request.getSession().setAttribute("user", user);

        return result.toJSONString();
    }

    /**
     * form 表单请求的后台接口
     * @param loginDTO
     * @return
     */
    @PostMapping("syncLogin")
    public String syncLogin(LoginDTO loginDTO, HttpServletRequest request) {
        System.out.println("用户填写的登录信息:" + JSONObject.toJSONString(loginDTO));
        UserEntity userEntity = userService.getByUserNameAndPwd(loginDTO.getUsername(), loginDTO.getPassword());
        HttpSession httpSession = request.getSession();
        if (userEntity == null) {
            httpSession.setAttribute("msg", "用户名或者密码输入错误，请重新输入!");
            return "redirect:login";
        }

        UserDto user = new UserDto();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getNickName());
        user.setUserposition(userEntity.getUserPosition());
        httpSession.setAttribute("user", user);
//        boolean result =  gifCaptcha.verify(loginDTO.getCaptcha());
//        System.out.println("验证码验证结果:" + result);


        if (user.getUserposition().equals("staff")) {
            return "index";
        } else if (user.getUserposition().equals("HR")) {
            return "index";
        } else {
            return "Home";
        }
    }

    @GetMapping("captcha")
    public void captcha(HttpServletResponse response) {
        // 生成数字验证码
        gifCaptcha.createCode();

        String code = gifCaptcha.getCode();
        System.out.println("系统生成的验证码:" + code);
        try {
            response.setContentType("image/gif");
            gifCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("生成验证码异常，异常信息如下:\n" + e.getLocalizedMessage());
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "Home";
    }
}
