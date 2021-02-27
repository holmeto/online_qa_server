package com.junjia.dao.mapper;


import com.junjia.model.StudentInfoDO;
import com.junjia.model.TeacherInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherInfoMapper {

    int addTeacherInfo(TeacherInfoDO teacher);

    int updateTeacherInfo(TeacherInfoDO teacher);

    TeacherInfoDO getTeqcherInfoById(int id);

    List<TeacherInfoDO> getTeacherInfoByPassword(@Param("userName") String userName, @Param("password") String password);
}
