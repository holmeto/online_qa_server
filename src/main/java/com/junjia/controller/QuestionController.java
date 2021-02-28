package com.junjia.controller;

import com.junjia.model.Common;
import com.junjia.service.QuestionInfoService;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController()
public class QuestionController {

    @Resource
    public QuestionInfoService questionInfoService;

    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @PostMapping("question/addQuestion")
    @Transactional
    public QaResult addQuestion(@RequestBody QuestionVO body) {
        // 校验登录账号是否存在
        Integer submitPersonID = null;
        String submitPersonName = null;
        StudentInfoVO student = studentInfoService.getStudentInfoById(body.getSubmitPersonId());
        if (student == null) {
            TeacherInfoVO teacher = teacherInfoService.getTeacherInfoById(body.getSubmitPersonId());
            if (teacher != null) {
                submitPersonID = teacher.getId().intValue();
                submitPersonName = teacher.getNickName();
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
            submitPersonID = student.getId().intValue();
            submitPersonName = student.getNickName();
            if (student.getCoinCount() == null) {
                student.setCoinCount(Common.COIN);
            } else {
                student.setCoinCount(student.getCoinCount() + Common.COIN);
            }
            studentInfoService.updateStudentInfo(student);
        }
        body.setSubmitPersonId(submitPersonID);
        body.setSubmitPersonName(submitPersonName);
        body.setCreateTime(new Date());
        questionInfoService.addQuestion(body);


        return QaResult.getDefaultSuccessResult();
    }

    @PostMapping("question/getQuestionList")
    public QaResult getQuestionList(@RequestBody QuestionQuery query) {
        int limit, offset;
        if (query.getPageNo() != 0 && query.getPageSize() != 0) {
            limit = (query.getPageNo() - 1) * query.getPageSize();
            offset = query.getPageSize();
        } else {
            limit = 0;
            offset = 10;
        }
        query.setQuestionName(Strings.trimToNull(query.getQuestionName()));

        List<QuestionVO> list = questionInfoService.getQuestionList(query.getQuestionName(), limit, offset);
        int total = questionInfoService.getQuestionCount(query.getQuestionName());
        QaQueryResult<List<QuestionVO>> data = new QaQueryResult<>();
        data.setData(list);
        data.setTotal(total);
        return QaResult.getDefaultSuccessResult(data);
    }


}
