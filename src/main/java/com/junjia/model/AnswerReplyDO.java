package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerReplyDO {

    private Long id;

    private String answerContent;

    private Long answeredId;

    private Long answeredPersonId;

    private String answeredPerson;

    private Long submitPersonId;

    private String submitPerson;

    private Date createTime;

}
