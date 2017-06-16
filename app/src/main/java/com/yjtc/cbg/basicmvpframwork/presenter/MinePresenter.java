package com.yjtc.cbg.basicmvpframwork.presenter;

import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.data.model.MineModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.BasePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.contract.MineContract;

import javax.inject.Inject;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public class MinePresenter extends BasePresenter<MineContract.IMineView, MineContract.IMineModel> implements MineContract.IMineModel {

    @Inject
    public MinePresenter(ApiService service) {
        super(service);
        this.mModel = new MineModel(service);
    }
}
