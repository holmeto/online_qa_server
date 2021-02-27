package com.junjia.service;

import com.junjia.dao.mapper.StudentInfoMapper;
import com.junjia.dao.mapper.TeacherInfoMapper;
import com.junjia.model.StudentInfoDO;
import com.junjia.model.TeacherInfoDO;
import com.junjia.vo.StudentInfoVO;
import com.junjia.vo.TeacherInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {

    @Autowired
    public TeacherInfoMapper teacherInfoMapper;

    public TeacherInfoVO getTeacherInfoByPassword(String userName, String password) {
        List<TeacherInfoDO> res = teacherInfoMapper.getTeacherInfoByPassword(userName, password);
        if (res == null || res.size() == 0) {
            return null;
        }
        return TransferToTeacherInfoVO(res.get(0));
    }


    public TeacherInfoVO getTeacherInfoById(int id) {
        TeacherInfoDO student = teacherInfoMapper.getTeqcherInfoById(id);
        return TransferToTeacherInfoVO(student);
    }

    public TeacherInfoVO TransferToTeacherInfoVO(TeacherInfoDO teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherInfoVO res = new TeacherInfoVO();
        res.setId(teacher.getId());
        res.setUserName(teacher.getUser_name());
        res.setNickName(teacher.getNick_name());
        res.setSex(teacher.getSex());
        res.setDepartment(teacher.getDepartment());
        res.setCoinCount(teacher.getCoinCount());
        return res;
    }


}
