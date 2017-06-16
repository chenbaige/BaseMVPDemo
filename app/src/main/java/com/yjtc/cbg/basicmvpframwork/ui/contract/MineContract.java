package com.yjtc.cbg.basicmvpframwork.ui.contract;

import com.yjtc.cbg.basicmvpframwork.ui.base.IModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.IPresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.IView;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-06-13
 */
public interface MineContract {

    public interface IMineView extends IView {

    }

    public interface IMinePresenter extends IPresenter<IMineView> {

    }

    public interface IMineModel extends IModel {

    }

}
