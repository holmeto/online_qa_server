package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionInfoDO {

    private Long id;

    private String questionName;

    private String quetionContent;

    private String questionType;

    private String submitPerson;

    private Date birthday;

    private Date createTime;

    private Date modifyTime;

}
