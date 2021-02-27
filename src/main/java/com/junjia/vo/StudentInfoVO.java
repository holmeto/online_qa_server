package com.junjia.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentInfoVO {

    private Long id;

    private String userName;

    private String nickName;

    private Integer sex;

    private String department;

    private String class_number;

    private String student_number;

    private Integer coin_count;
}
