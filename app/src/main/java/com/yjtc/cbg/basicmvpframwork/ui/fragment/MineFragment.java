package com.yjtc.cbg.basicmvpframwork.ui.fragment;

import android.view.View;

import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerFragmentComponent;
import com.yjtc.cbg.basicmvpframwork.presenter.MinePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseProgressFragment;
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
public class MineFragment extends BaseProgressFragment<MinePresenter> implements MineContract.IMineView {

    @Override
    protected void init() {
        showContentView();
        mUIListener.setBottomState(View.VISIBLE);
        mUIListener.setTopTitle(0, "我的");
        mUIListener.setRightTextState(View.VISIBLE, R.string.sure);
    }

    @Override
    protected void setFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_mine;
    }
}
