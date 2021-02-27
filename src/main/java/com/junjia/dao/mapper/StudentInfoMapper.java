package com.junjia.dao.mapper;


import com.junjia.model.StudentInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StudentInfoMapper {

    int addStudentInfo(StudentInfoDO student);

    int updateStudentInfo(StudentInfoDO student);

    StudentInfoDO getStudentInfoById(int id);
}
