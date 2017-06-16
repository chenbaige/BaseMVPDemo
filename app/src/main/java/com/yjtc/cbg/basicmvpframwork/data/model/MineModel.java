package com.yjtc.cbg.basicmvpframwork.data.model;

import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseModel;
import com.yjtc.cbg.basicmvpframwork.ui.contract.MineContract;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public class MineModel extends BaseModel implements MineContract.IMineModel {


    public MineModel(ApiService service) {
        super(service);
    }
}
