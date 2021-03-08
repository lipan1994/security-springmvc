package com.llicat.controller;

import com.llicat.model.AuthenticationRequest;
import com.llicat.model.UserDto;
import com.llicat.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: lipan
 * @date: 2021/2/17 13:38
 */

@RestController
public class LoginController {


    @Autowired
    private AuthenticationService authenticationService;

    /*** 用户登录 * @param authenticationRequest 登录请求 * @return */
    @PostMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession httpSession) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        httpSession.setAttribute(UserDto.SESSION_USER_KEY,userDto);
        return userDto.getFullname() + " 登录成功";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @GetMapping(value = "logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session) {
        session.invalidate();
        return "退出成功";
    }


    /*** 测试资源1 * @param session * @return */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session) {
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj != null) {
            fullname = ((UserDto) userObj).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    /*** 测试资源2 * @param session * @return */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj != null) {
            fullname = ((UserDto) userObj).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + " 访问资源2";
    }
}
