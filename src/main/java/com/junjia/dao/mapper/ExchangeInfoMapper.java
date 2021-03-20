package com.junjia.dao.mapper;

import com.junjia.model.CoinExchangeInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExchangeInfoMapper {

    int addCoinExchangeInfo(CoinExchangeInfoDO exchange);

    List<CoinExchangeInfoDO> getExchangeList(@Param("submitPersonId") Integer submitPersonId);
}
