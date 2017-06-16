package com.yjtc.cbg.basicmvpframwork.ui.fragment;

import android.view.View;

import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerFragmentComponent;
import com.yjtc.cbg.basicmvpframwork.presenter.ChatPresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseProgressFragment;
import com.yjtc.cbg.basicmvpframwork.ui.contract.ChatContract;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public class ChatFragment extends BaseProgressFragment<ChatPresenter> implements ChatContract.IChatView {

    @Override
    protected void init() {
        showContentView();
        mUIListener.setTopState(View.VISIBLE);
        mUIListener.setBottomState(View.VISIBLE);
        mUIListener.setTopTitle(0, "聊天");
        mUIListener.setRightTextState(View.VISIBLE, R.string.sure);
    }

    @Override
    protected void setFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_chat;
    }
}
