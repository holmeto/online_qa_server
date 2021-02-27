package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionInfoDO {

    private Long id;

    private String questionName;

    private String questionContent;

    private String questionType;

    private Long submitPersonId;

    private String submitPersonName;

    private Date createTime;

    private Date modifyTime;

}
