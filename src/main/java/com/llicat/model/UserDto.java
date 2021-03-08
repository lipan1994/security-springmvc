package com.llicat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author: lipan
 * @date: 2021/2/17 13:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    public static final String SESSION_USER_KEY = "_user";
    /**
     * 保存用户权限
     */
    private Set<String> authorities;
}
