package com.neuedu.sell.VO;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class ResultVO<T> {

    private Integer code;
    private String message;
    private T data;

    public ResultVO() {
    }
    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
