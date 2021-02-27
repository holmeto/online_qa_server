package com.junjia.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherInfoVO {

    private Long id;

    private String userName;

    private String nickName;

    private Integer sex;

    private String department;

    private String teacherNumber;

    private Integer coinCount;

}
