package com.junjia.model;

import lombok.Data;

import java.util.Date;

@Data
public class CoinExchangeInfoDO {

    private Long id;

    private Integer submit_person_id;

    private String submit_person_name;

    private String exchange_detail;

    private Date create_time;

}
