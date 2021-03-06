package com.junjia.service;

import com.junjia.dao.mapper.TeacherInfoMapper;
import com.junjia.model.TeacherInfoDO;
import com.junjia.vo.TeacherInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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


    public int updateInfo(TeacherInfoVO vo){
        return teacherInfoMapper.updateTeacherInfo(TransferToTeacherInfoDO(vo));
    }

    public int addTeacherInfo(TeacherInfoDO teacher) {
        return teacherInfoMapper.addTeacherInfo(teacher);
    }

    public TeacherInfoVO getTeacherInfoById(int id) {
        TeacherInfoDO student = teacherInfoMapper.getTeacherInfoById(id);
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
        res.setCoinCount(teacher.getCoin_count());
        return res;
    }

    public TeacherInfoDO TransferToTeacherInfoDO(TeacherInfoVO teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherInfoDO res = new TeacherInfoDO();
        res.setId(teacher.getId());
        res.setNick_name(teacher.getNickName());
        res.setDepartment(teacher.getDepartment());
        res.setCoin_count(teacher.getCoinCount());
        res.setModify_time(new Date());
        return res;
    }

}
