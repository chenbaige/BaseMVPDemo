package com.yjtc.cbg.basicmvpframwork.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public class ResponseListEntity<T> implements Serializable {
    public static final int SUCCESS = 1;

    private int status;
    private String msg;
    private List<T> data;


    public boolean success() {
        return status == SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
