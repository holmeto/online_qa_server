package com.junjia.vo;

import lombok.Data;

@Data
public class QaResult<T> {

    public QaResult(boolean success, String msg, T data) {
        this.success = success;
        this.message = msg;
        this.data = data;
    }

    public boolean success;

    public String message;

    public T data;

    public static <T> QaResult<T> getDefaultSuccessResult() {
        return new QaResult<>(true, "", null);
    }

    public static <T> QaResult<T> getDefaultResult() {
        return new QaResult<>(false, "", null);
    }

    public <T> QaResult<T> withMessage(String msg) {
        this.message = msg;
        return (QaResult<T>) this;
    }
}
