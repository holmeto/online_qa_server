package com.junjia.dao.mapper;


import com.junjia.model.StudentInfoDO;
import com.junjia.model.TeacherInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherInfoMapper {

    int addTeacherInfo(TeacherInfoDO teacher);

    int updateTeacherInfo(TeacherInfoDO teacher);

    TeacherInfoDO getTeqcherInfoById(int id);
}
