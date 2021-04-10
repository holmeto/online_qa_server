package com.junjia.controller;


import com.junjia.enums.RoleEnum;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoginController {

    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @PostMapping("/login")
    public QaResult login(@RequestBody LoginBody body) {
        // 判断是学生还是老师，校验是否注册
        if (RoleEnum.getRoleByRoleNumber(body.getRole()) == RoleEnum.STUDENT) {
            StudentInfoVO studentInfo = studentInfoService.getStudentInfoByPassword(body.getUserName(), body.getPassword());
            if (studentInfo == null) {
                return QaResult.getDefaultResult().withMessage("学生账号错误，请重新输入");
            }
            QaResult<StudentInfoVO> result = QaResult.getDefaultSuccessResult();
            result.setData(studentInfo);
            return result;
        } else if (RoleEnum.getRoleByRoleNumber(body.getRole()) == RoleEnum.TEACHER) {
            TeacherInfoVO teacherInfo = teacherInfoService.getTeacherInfoByPassword(body.getUserName(), body.getPassword());
            if (teacherInfo == null) {
                return QaResult.getDefaultResult().withMessage("老师账号错误，请重新输入");
            }
            QaResult<TeacherInfoVO> result = QaResult.getDefaultSuccessResult();
            result.setData(teacherInfo);
            return result;
        }
        System.out.println("login success");
        return QaResult.getDefaultSuccessResult();
    }

    @PostMapping("/getUserInfo")
    public QaResult getUserInfoByID(@RequestBody UserQuery query) {
        if (query.getId() == null) {
            return QaResult.getDefaultResult();
        }
        StudentInfoVO studentInfo = studentInfoService.getStudentInfoById(query.getId());
        if (studentInfo != null) {
            QaResult<StudentInfoVO> result = QaResult.getDefaultSuccessResult();
            result.setData(studentInfo);
            return result;
        }
        TeacherInfoVO teacherInfo = teacherInfoService.getTeacherInfoById(query.getId());
        if (teacherInfo == null) {
            return QaResult.getDefaultResult();
        }
        QaResult<TeacherInfoVO> result = QaResult.getDefaultSuccessResult();
        result.setData(teacherInfo);
        return result;
    }

    @PostMapping("/getCoinRankList")
    public QaResult getUserInfoByCoinRank() {
        List<StudentInfoVO> list = studentInfoService.getStudentInfoByCoinRank();
        if (list != null && list.size() > 0) {
            QaResult<List<StudentInfoVO>> result = QaResult.getDefaultSuccessResult();
            result.setData(list);
            return result;
        }
        return QaResult.getDefaultSuccessResult();
    }

}
