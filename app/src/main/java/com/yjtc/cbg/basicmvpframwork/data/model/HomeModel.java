package com.yjtc.cbg.basicmvpframwork.data.model;

import com.yjtc.cbg.basicmvpframwork.common.rx.RXResponseCompat;
import com.yjtc.cbg.basicmvpframwork.data.dto.AreaDto;
import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseModel;
import com.yjtc.cbg.basicmvpframwork.ui.contract.HomeContract;

import java.util.List;

import rx.Observable;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public class HomeModel extends BaseModel implements HomeContract.IHomeModel {

    public HomeModel(ApiService service) {
        super(service);
    }

    @Override
    public Observable<List<AreaDto>> getAreaData(String area) {
        return mService.getresponse(buildBody("Country", area)).compose(RXResponseCompat.<AreaDto>compatListResult());
    }
}
