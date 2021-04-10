package com.junjia.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private int distance;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

}
