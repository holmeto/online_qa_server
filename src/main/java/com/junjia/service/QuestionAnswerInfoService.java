package com.junjia.service;

import com.junjia.dao.mapper.AnswerInfoMapper;
import com.junjia.model.QuestionAnswerDO;
import com.junjia.vo.QuestionAnswerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionAnswerInfoService {


    @Resource
    private AnswerInfoMapper answerInfoMapper;

    public List<QuestionAnswerVO> getQuestionAnswerList(Integer questionId) {
        List<QuestionAnswerDO> list = answerInfoMapper.getQuestionAnswerList(questionId);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.stream().map(this::TransferToQuestionAnswerVO).collect(Collectors.toList());
    }

    public int addAnswer(QuestionAnswerVO vo){
        return answerInfoMapper.addQuestionAnswerInfo(TransferToQuestionAnswerDO(vo));
    }


    public QuestionAnswerVO TransferToQuestionAnswerVO(QuestionAnswerDO in){
        if (in == null) {
            return null;
        }
        QuestionAnswerVO vo = new QuestionAnswerVO();
        vo.setQuestionId(in.getQuestion_id());
        vo.setAnswerContent(in.getAnswer_content());
        vo.setQuestionId(in.getQuestion_id());
        vo.setSubmitPersonId(in.getSubmit_person_id());
        vo.setSubmitPersonName(in.getSubmit_person_name());
        vo.setCreateTime(in.getCreate_time());
        return vo;
    }

    public QuestionAnswerDO TransferToQuestionAnswerDO(QuestionAnswerVO in) {
        if (in == null) {
            return null;
        }
        QuestionAnswerDO res = new QuestionAnswerDO();
        res.setQuestion_id(in.getQuestionId());
        res.setAnswer_content(in.getAnswerContent());
        res.setSubmit_person_id(in.getSubmitPersonId());
        res.setSubmit_person_name(in.getSubmitPersonName());
        res.setCreate_time(in.getCreateTime());
        return res;
    }


}
