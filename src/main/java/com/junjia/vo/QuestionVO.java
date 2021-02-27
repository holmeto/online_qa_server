package com.junjia.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionVO {

    private Long id;

    private String questionName;

    private String questionContent;

    private String questionType;

    private Integer submitPersonId;

    private String submitPersonName;

    private Date createTime;

    private Date modifyTime;

}
