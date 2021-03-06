package com.junjia.vo;

import lombok.Data;

import java.util.List;

@Data
public class QuestionAndAnswerVO {

    private QuestionVO question;

    private List<QuestionAnswerVO> answerList;


}
