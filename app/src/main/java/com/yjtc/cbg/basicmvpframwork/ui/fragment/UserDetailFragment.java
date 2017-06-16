package com.yjtc.cbg.basicmvpframwork.ui.fragment;

import android.view.View;

import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerFragmentComponent;
import com.yjtc.cbg.basicmvpframwork.presenter.HomePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseProgressFragment;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-15
 */
public class UserDetailFragment extends BaseProgressFragment<HomePresenter> {
    @Override
    protected void init() {
        showContentView();
        mUIListener.setBottomState(View.GONE);
        mUIListener.setTopTitle(0, "用户详情");
        mUIListener.setRightTextState(View.VISIBLE, R.string.sure);
    }

    @Override
    protected void setFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_user_detail;
    }
}
