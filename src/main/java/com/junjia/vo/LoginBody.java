package com.junjia.vo;

import lombok.Data;

@Data
public class LoginBody {

    private String userName;

    private String password;

    private Integer role;
}
