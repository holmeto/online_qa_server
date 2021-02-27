package com.junjia.dao.mapper;


import com.junjia.model.QuestionInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionInfoMapper {

    int addQuestionInfo(QuestionInfoDO question);

    int updateTeacherInfo(QuestionInfoDO question);

    QuestionInfoDO getQuestionInfoById(int id);

    List<QuestionInfoDO> getQuestionList(@Param("questionName") String questionName, @Param("limit") int limit, @Param("offset") int offset);

    int getQuestionCount(@Param("questionName") String questionName);
}
