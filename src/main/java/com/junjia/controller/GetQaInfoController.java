package com.junjia.controller;

import com.junjia.service.StudentInfoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GetQaInfoController {

    @Resource
    public StudentInfoService studentInfoService;
//
//    @PostMapping("/insert")
//    public String GetQaInfo(){
//        StudentInfoDO student = new StudentInfoDO();
//        student.setSex(0);
//        student.setUser_name("章君佳");
//        student.setNick_name("小章鱼");
//        studentInfoService.addStudentInfo(student);
//        return "hello world";
//    }

}
