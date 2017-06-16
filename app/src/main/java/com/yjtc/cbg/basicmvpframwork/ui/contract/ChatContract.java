package com.yjtc.cbg.basicmvpframwork.ui.contract;

import com.yjtc.cbg.basicmvpframwork.ui.base.IModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.IPresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.IView;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public interface ChatContract {

    public interface IChatView extends IView {

    }

    public interface IChatPresenter extends IPresenter<IChatView> {

    }

    public interface IChatModel extends IModel {

    }

}
