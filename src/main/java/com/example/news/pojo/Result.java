package com.example.news.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    private final static Integer SUCCESS = 200;
    private final static Integer FAIL = 500;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Result ok(String msg){
        return new Result(SUCCESS, msg);
    }

    public static Result data(Object data){
        return new Result(SUCCESS, data);
    }

    public static Result fail(String msg){
        return new Result(FAIL, msg);
    }
}
