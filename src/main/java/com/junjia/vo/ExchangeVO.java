package com.junjia.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ExchangeVO {

    private Integer submitPersonId;

    private String submitPersonName;

    private Integer needCoin;

    private String exchangeDetail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
