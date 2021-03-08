package com.llicat.model;

import lombok.Data;

/**
 * @author: lipan
 * @date: 2021/2/17 13:32
 */
@Data
public class AuthenticationRequest {

    /*** 用户名 */
    private String username;
    /*** 密码 */
    private String password;
}
