package com.junjia.controller;


import com.junjia.enums.RoleEnum;
import com.junjia.model.StudentInfoDO;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.LoginBody;
import com.junjia.vo.QaResult;
import com.junjia.vo.StudentInfoVO;
import com.junjia.vo.TeacherInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @PostMapping("/login")
    public QaResult login(@RequestBody LoginBody body) {
        // 判断是学生还是老师，校验是否注册
        if (RoleEnum.getRoleByRoleNumber(body.role) == RoleEnum.STUDENT) {
            StudentInfoVO studentInfo = studentInfoService.getStudentInfoByPassword(body.userName, body.password);
            if (studentInfo == null) {
                return QaResult.getDefaultResult().withMessage("学生账号错误，请重新输入");
            }
            QaResult<StudentInfoVO> result = QaResult.getDefaultSuccessResult();
            result.setData(studentInfo);
            return result;
        } else if (RoleEnum.getRoleByRoleNumber(body.role) == RoleEnum.TEACHER) {
            TeacherInfoVO teacherInfo = teacherInfoService.getTeacherInfoByPassword(body.userName, body.password);
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


}
