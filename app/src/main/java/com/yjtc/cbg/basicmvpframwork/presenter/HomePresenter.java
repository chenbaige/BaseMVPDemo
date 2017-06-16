package com.yjtc.cbg.basicmvpframwork.presenter;

import com.yjtc.cbg.basicmvpframwork.common.rx.subscribe.ProgressDialogSubscribe;
import com.yjtc.cbg.basicmvpframwork.data.dto.AreaDto;
import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.data.model.HomeModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.BasePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.contract.HomeContract;

import java.util.List;

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
public class HomePresenter extends BasePresenter<HomeContract.IHomeView, HomeContract.IHomeModel> implements HomeContract.IHomePresenter {

    @Inject
    public HomePresenter(ApiService service) {
        super(service);
        this.mModel = new HomeModel(service);
    }

    @Override
    public void getAreaData() {
        mModel.getAreaData(mView.getArea()).subscribe(new ProgressDialogSubscribe<List<AreaDto>>(mContext) {
            @Override
            public void onNext(List<AreaDto> areaDtos) {
                mView.getAreaSuccess(areaDtos);
            }
        });
    }
}
