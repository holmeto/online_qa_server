package com.junjia.service;

import com.junjia.dao.mapper.ExchangeInfoMapper;
import com.junjia.model.CoinExchangeInfoDO;
import com.junjia.vo.ExchangeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinExchangeInfoService {

    @Autowired
    public ExchangeInfoMapper exchangeInfoMapper;

    public List<ExchangeVO> getCoinExchangeList(Integer submitPersonId) {
        List<CoinExchangeInfoDO> list = exchangeInfoMapper.getExchangeList(submitPersonId);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.stream().map(this::TransferToExchangeVO).collect(Collectors.toList());
    }

    public int addCoinExchangeInfo(ExchangeVO info) {
        return exchangeInfoMapper.addCoinExchangeInfo(TransferToCoinExchangeInfoDO(info));
    }


    public ExchangeVO TransferToExchangeVO(CoinExchangeInfoDO in) {
        if (in == null) {
            return null;
        }
        ExchangeVO vo = new ExchangeVO();
        vo.setSubmitPersonId(in.getSubmit_person_id());
        vo.setSubmitPersonName(in.getSubmit_person_name());
        vo.setCreateTime(in.getCreate_time());
        vo.setExchangeDetail(in.getExchange_detail());
        return vo;
    }

    public CoinExchangeInfoDO TransferToCoinExchangeInfoDO(ExchangeVO in) {
        if (in == null) {
            return null;
        }
        CoinExchangeInfoDO out = new CoinExchangeInfoDO();
        out.setSubmit_person_id(in.getSubmitPersonId());
        out.setSubmit_person_name(in.getSubmitPersonName());
        out.setExchange_detail(in.getExchangeDetail());
        out.setCreate_time(in.getCreateTime());
        return out;
    }


}
