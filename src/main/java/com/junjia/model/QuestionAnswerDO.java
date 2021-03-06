package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionAnswerDO {

    private Long id;

    private String answer_content;

    private Integer question_id;

    private Integer submit_person_id;

    private String submit_person_name;

    private Date create_time;

}
