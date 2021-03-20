package com.junjia.controller;

import com.junjia.enums.RoleEnum;
import com.junjia.model.StudentInfoDO;
import com.junjia.model.TeacherInfoDO;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.QaResult;
import com.junjia.vo.RegisterVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class RegisterController {


    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @PostMapping("/register")
    public QaResult login(@RequestBody RegisterVO body) {
        if (RoleEnum.getRoleByRoleNumber(body.getRole()) == RoleEnum.STUDENT) {
            StudentInfoDO student = new StudentInfoDO();
            student.setUser_name(body.getName());
            student.setNick_name(body.getNickName());
            student.setEmail(body.getEmail());
            student.setPassword(body.getPassword());
            student.setCreate_time(new Date());
            student.setSex(body.getSex());
            student.setCoin_count(0);
            studentInfoService.addStudentInfo(student);
        } else {
            TeacherInfoDO teacher = new TeacherInfoDO();
            teacher.setUser_name(body.getName());
            teacher.setNick_name(body.getNickName());
            teacher.setEmail(body.getEmail());
            teacher.setPassword(body.getPassword());
            teacher.setCreate_time(new Date());
            teacher.setSex(body.getSex());
            teacher.setCoin_count(0);
            teacherInfoService.addTeacherInfo(teacher);
        }
        return QaResult.getDefaultSuccessResult();
    }

}
