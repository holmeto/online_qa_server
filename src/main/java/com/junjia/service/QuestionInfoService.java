package com.junjia.service;

import com.junjia.dao.mapper.QuestionInfoMapper;
import com.junjia.model.QuestionInfoDO;
import com.junjia.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionInfoService {

    @Autowired
    public QuestionInfoMapper questionInfoMapper;

    public QuestionVO getStudentInfoById(int id) {
        QuestionInfoDO question = questionInfoMapper.getQuestionInfoById(id);
        return TransferToQuestionVO(question);
    }

    public List<QuestionVO> getQuestionList(String questionName, int limit, int offset) {
        List<QuestionInfoDO> list = questionInfoMapper.getQuestionList(questionName, limit, offset);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.stream().map(this::TransferToQuestionVO).collect(Collectors.toList());
    }

    public int getQuestionCount(String questionName) {
        return questionInfoMapper.getQuestionCount(questionName);
    }



    public int addQuestion(QuestionVO question) {
        return questionInfoMapper.addQuestionInfo(TransferToQuestionInfoDO(question));
    }

    public QuestionVO TransferToQuestionVO(QuestionInfoDO question) {
        if (question == null) {
            return null;
        }
        QuestionVO vo = new QuestionVO();
        vo.setId(question.getId());
        vo.setQuestionName(question.getQuestion_name());
        vo.setQuestionContent(question.getQuestion_content());
        vo.setQuestionType(question.getQuestion_type());
        vo.setSubmitPersonId(question.getSubmit_person_id().intValue());
        vo.setSubmitPersonName(question.getSubmit_person_name());
        vo.setCreateTime(question.getCreate_time());
        vo.setModifyTime(question.getModify_time());
        return vo;
    }

    public QuestionInfoDO TransferToQuestionInfoDO(QuestionVO vo) {
        if (vo == null) {
            return null;
        }
        QuestionInfoDO result = new QuestionInfoDO();
        result.setQuestion_name(vo.getQuestionName());
        result.setQuestion_content(vo.getQuestionContent());
        result.setQuestion_type(vo.getQuestionType());
        result.setSubmit_person_id(Long.valueOf(vo.getSubmitPersonId()));
        result.setSubmit_person_name(vo.getSubmitPersonName());
        result.setCreate_time(vo.getCreateTime());
        result.setModify_time(vo.getModifyTime());
        return result;
    }


}
