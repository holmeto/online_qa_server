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
        vo.setQuestionName(question.getQuestionName());
        vo.setQuestionContent(question.getQuestionContent());
        vo.setSubmitPersonId(question.getSubmitPersonId().intValue());
        vo.setSubmitPersonName(question.getSubmitPersonName());
        vo.setCreateTime(question.getCreateTime());
        vo.setModifyTime(question.getModifyTime());
        return vo;
    }

    public QuestionInfoDO TransferToQuestionInfoDO(QuestionVO vo) {
        if (vo == null) {
            return null;
        }
        QuestionInfoDO result = new QuestionInfoDO();
        result.setQuestionName(vo.getQuestionName());
        result.setQuestionContent(vo.getQuestionContent());
        result.setQuestionType(vo.getQuestionType());
        result.setSubmitPersonId(Long.valueOf(vo.getSubmitPersonId()));
        result.setSubmitPersonName(vo.getSubmitPersonName());
        result.setCreateTime(vo.getCreateTime());
        result.setModifyTime(vo.getModifyTime());
        return result;
    }


}
