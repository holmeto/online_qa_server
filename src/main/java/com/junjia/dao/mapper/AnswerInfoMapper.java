package com.junjia.dao.mapper;


import com.junjia.model.QuestionAnswerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnswerInfoMapper {

    int addQuestionAnswerInfo(QuestionAnswerDO answer);

    int updateQuestionInfo(QuestionAnswerDO answer);

    QuestionAnswerDO getQuestionAnswerInfoById(int id);

    List<QuestionAnswerDO> getQuestionAnswerList(@Param("questionId") Integer questionId);

    int getQuestionAnswerCount(@Param("questionId") Long questionId);
}
