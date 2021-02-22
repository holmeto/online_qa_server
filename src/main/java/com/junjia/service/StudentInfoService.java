package com.junjia.service;

import com.junjia.dao.mapper.StudentInfoMapper;
import com.junjia.model.StudentInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

    @Autowired
    public StudentInfoMapper studentInfoMapper;

    public StudentInfoDO getStudentInfo(int id) {
        return studentInfoMapper.getStudentInfo(id);
    }

    public int addStudentInfo(StudentInfoDO student) {
        return studentInfoMapper.addStudentInfo(student);
    }
}
