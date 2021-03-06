package com.junjia.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionAnswerVO {

    private Long id;

    private String answerContent;

    private Integer questionId;

    private Integer submitPersonId;

    private String submitPersonName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
