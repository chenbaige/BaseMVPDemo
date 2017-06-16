package com.yjtc.cbg.basicmvpframwork.data.http;

import com.yjtc.cbg.basicmvpframwork.data.dto.AreaDto;
import com.yjtc.cbg.basicmvpframwork.data.entity.ResponseListEntity;

import okhttp3.RequestBody;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public interface ApiService {

    public static final String BASE_URL = "http://www.2thewin.com/";


    @POST("AppIndex/GetAllArea")
    Observable<ResponseListEntity<AreaDto>> getresponse(@Body RequestBody body);
}
