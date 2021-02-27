package com.junjia.dao.mapper;


import com.junjia.model.QuestionInfoDO;
import com.junjia.model.TeacherInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionInfoMapper {

    int addQuestionInfo(QuestionInfoDO question);

    int updateTeacherInfo(QuestionInfoDO question);

    QuestionInfoDO getQuestionInfoById(int id);

    List<QuestionInfoDO> getQuestionListById(int id);
}
