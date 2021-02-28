package com.junjia.service;

import com.junjia.dao.mapper.StudentInfoMapper;
import com.junjia.model.StudentInfoDO;
import com.junjia.vo.StudentInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentInfoService {

    @Autowired
    public StudentInfoMapper studentInfoMapper;

    public StudentInfoVO getStudentInfoById(int id) {
        StudentInfoDO student = studentInfoMapper.getStudentInfoById(id);
        return TransferToStudentInfoVO(student);
    }

    public int updateStudentInfo(StudentInfoVO vo) {
        return studentInfoMapper.updateStudentInfo(TransferToStudentInfoDO(vo));
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
        res.setClassNumber(student.getClass_number());
        res.setStudentNumber(student.getStudent_number());
        res.setDepartment(student.getDepartment());
        res.setCoinCount(student.getCoin_count());
        return res;
    }

    public StudentInfoDO TransferToStudentInfoDO(StudentInfoVO vo){
        if (vo == null) {
            return null;
        }
        StudentInfoDO res = new StudentInfoDO();
        res.setId(vo.getId());
        res.setNick_name(vo.getNickName());
        res.setCoin_count(vo.getCoinCount());
        res.setModify_time(new Date());
        return res;
    }
}
