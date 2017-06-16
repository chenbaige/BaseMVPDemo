package com.yjtc.cbg.basicmvpframwork.ui.contract;

import com.yjtc.cbg.basicmvpframwork.data.dto.AreaDto;
import com.yjtc.cbg.basicmvpframwork.ui.base.IModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.IPresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.IView;

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
public interface HomeContract {

    public interface IHomeView extends IView {
        String getArea();

        void getAreaSuccess(List<AreaDto> data);
    }

    public interface IHomePresenter extends IPresenter<IHomeView> {
        void getAreaData();
    }

    public interface IHomeModel extends IModel {
        Observable<List<AreaDto>> getAreaData(String area);
    }

}
