package com.llicat.service;

import com.llicat.model.AuthenticationRequest;
import com.llicat.model.UserDto;

/**
 * 认证接口
 * @author: lipan
 * @date: 2021/2/17 13:15
 */

public interface AuthenticationService {

    /*** 用户认证 * @param authenticationRequest 用户认证请求 * @return 认证成功的用户信息 */
    UserDto authentication(AuthenticationRequest authenticationRequest);

}
