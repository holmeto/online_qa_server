package com.junjia.vo;

import lombok.Data;

@Data
public class LoginBody {

    public String userName;

    public String password;

    public Integer role;
}
