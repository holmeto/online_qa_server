package com.junjia.controller;

import com.junjia.model.Common;
import com.junjia.service.QuestionAnswerInfoService;
import com.junjia.service.QuestionInfoService;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class AnswerController {

    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @Resource
    QuestionInfoService questionInfoService;


    @Resource
    private QuestionAnswerInfoService questionAnswerInfoService;

    @PostMapping("answer/addAnswer")
    @Transactional
    public QaResult addAnswer(@RequestBody QuestionAnswerVO body) {
        StudentInfoVO student = studentInfoService.getStudentInfoById(body.getSubmitPersonId());
        if (student == null) {
            TeacherInfoVO teacher = teacherInfoService.getTeacherInfoById(body.getSubmitPersonId());
            if (teacher != null) {
                // 更新积分
                if (teacher.getCoinCount() == null) {
                    teacher.setCoinCount(Common.COIN);
                } else {
                    teacher.setCoinCount(teacher.getCoinCount() + Common.COIN);
                }
                teacherInfoService.updateInfo(teacher);
            } else {
                return QaResult.getDefaultResult().withMessage("用户不存在，请先注册");
            }
        } else {
            if (student.getCoinCount() == null) {
                student.setCoinCount(Common.COIN);
            } else {
                student.setCoinCount(student.getCoinCount() + Common.COIN);
            }
            studentInfoService.updateStudentInfo(student);
        }
        body.setCreateTime(new Date());
        questionAnswerInfoService.addAnswer(body);
        return QaResult.getDefaultSuccessResult();
    }

    @PostMapping("answer/getQuestionAndAnswer")
    public QaResult<QuestionAndAnswerVO> getQuestionAndAnswer(@RequestBody QuestionAnswerQuery query){
        QuestionVO question = questionInfoService.getStudentInfoById(query.getQuestionId());
        List<QuestionAnswerVO> list = questionAnswerInfoService.getQuestionAnswerList(query.getQuestionId());
        QuestionAndAnswerVO result = new QuestionAndAnswerVO();
        result.setQuestion(question);
        result.setAnswerList(list);
        return QaResult.getDefaultSuccessResult(result);
    }

}
