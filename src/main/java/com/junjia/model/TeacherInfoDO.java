package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherInfoDO {

    private Long id;

    private String userName;

    private String nickName;

    private String password;

    private String email;

    private Date birthday;

    private Integer sex;

    private String department;

    private String teacherNumber;

    private Date createTime;

    private Date modifyTime;

    private Integer coinCount;

}
