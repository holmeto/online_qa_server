package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionAnswerDO {

    private Long id;

    private String answerContent;

    private Long questionId;

    private Long submitPersonId;

    private String submitPerson;

    private Date create_time;

}
