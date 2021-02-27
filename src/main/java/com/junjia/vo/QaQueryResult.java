package com.junjia.vo;

import lombok.Data;

@Data
public class QaQueryResult<E> {

    private E data;

    private int total;

}
