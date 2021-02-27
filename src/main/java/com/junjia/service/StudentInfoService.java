package com.junjia.service;

import com.junjia.dao.mapper.StudentInfoMapper;
import com.junjia.model.StudentInfoDO;
import com.junjia.vo.StudentInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    @Autowired
    public StudentInfoMapper studentInfoMapper;

    public StudentInfoVO getStudentInfoById(int id) {
        StudentInfoDO student = studentInfoMapper.getStudentInfoById(id);
        return TransferToStudentInfoVO(student);
    }

    public int addStudentInfo(StudentInfoDO student) {
        return studentInfoMapper.addStudentInfo(student);
    }

    public StudentInfoVO getStudentInfoByPassword(String userName, String password) {
        List<StudentInfoDO> res = studentInfoMapper.getStudentInfoByPassword(userName, password);
        if (res == null || res.size() == 0) {
            return null;
        }
        return TransferToStudentInfoVO(res.get(0));
    }

    public StudentInfoVO TransferToStudentInfoVO(StudentInfoDO student) {
        if (student == null) {
            return null;
        }
        StudentInfoVO res = new StudentInfoVO();
        res.setId(student.getId());
        res.setUserName(student.getUser_name());
        res.setNickName(student.getNick_name());
        res.setSex(student.getSex());
        res.setClass_number(student.getClass_number());
        res.setStudent_number(student.getStudent_number());
        res.setDepartment(student.getDepartment());
        return res;
    }
}
