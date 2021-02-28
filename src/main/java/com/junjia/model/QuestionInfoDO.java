package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionInfoDO {

    private Long id;

    private String question_name;

    private String question_content;

    private String question_type;

    private Long submit_person_id;

    private String submit_person_name;

    private Date create_time;

    private Date modify_time;

}
