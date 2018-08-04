package com.tianli.litemall.common_library.response;

import java.io.Serializable;

/**
 * Created by zhoubo30110 on 2018/7/31.
 */

public class BaseDTO<T> implements Serializable {
        public String msg;
        public String code;
        public T data;

    @Override
    public String toString() {
        return "BaseDTO{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
