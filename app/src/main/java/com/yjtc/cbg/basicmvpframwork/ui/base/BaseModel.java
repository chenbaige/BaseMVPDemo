package com.yjtc.cbg.basicmvpframwork.ui.base;

import com.google.gson.Gson;
import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-26
 */
public class BaseModel implements IModel {

    protected ApiService mService;

    public BaseModel(ApiService service) {
        mService = service;
    }

    protected <T extends Object> RequestBody buildBody(T bean) {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), gson.toJson(bean));
        return body;
    }

    protected RequestBody buildBody(String name, String value) {
        String json = "{\"" + name + "\":" + "\"" + value + "\"}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        return body;
    }

}
