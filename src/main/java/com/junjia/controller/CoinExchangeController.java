package com.junjia.controller;

import com.junjia.service.CoinExchangeInfoService;
import com.junjia.service.StudentInfoService;
import com.junjia.service.TeacherInfoService;
import com.junjia.vo.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class CoinExchangeController {

    @Resource
    public CoinExchangeInfoService coinExchangeInfoService;

    @Resource
    public StudentInfoService studentInfoService;

    @Resource
    public TeacherInfoService teacherInfoService;

    @PostMapping("point/addCoinExchangeInfo")
    @Transactional
    public QaResult addCoinExchangeInfo(@RequestBody ExchangeVO body) {
        body.setCreateTime(new Date());
        StudentInfoVO studentInfo = studentInfoService.getStudentInfoById(body.getSubmitPersonId());
        if (studentInfo != null) {
            coinExchangeInfoService.addCoinExchangeInfo(body);
            studentInfo.setCoinCount(studentInfo.getCoinCount() - body.getNeedCoin());
            studentInfoService.updateStudentInfo(studentInfo);
            return QaResult.getDefaultSuccessResult();
        }
        TeacherInfoVO teacherInfo = teacherInfoService.getTeacherInfoById(body.getSubmitPersonId());
        if (teacherInfo != null) {
            coinExchangeInfoService.addCoinExchangeInfo(body);
            teacherInfo.setCoinCount(teacherInfo.getCoinCount() - body.getNeedCoin());
            teacherInfoService.updateInfo(teacherInfo);
            return QaResult.getDefaultSuccessResult();
        }
        return QaResult.getDefaultResult();
    }

    @PostMapping("/point/getCoinExchangeInfoList")
    public QaResult getCoinExchangeInfoList(@RequestBody UserQuery query) {
        if (query.getId() == null) {
            return QaResult.getDefaultResult();
        }
        List<ExchangeVO> list = coinExchangeInfoService.getCoinExchangeList(query.getId());
        QaResult<List<ExchangeVO>> result = QaResult.getDefaultSuccessResult();
        result.setData(list);
        return result;
    }


}
