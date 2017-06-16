package com.yjtc.cbg.basicmvpframwork.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.data.dto.AreaDto;
import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerFragmentComponent;
import com.yjtc.cbg.basicmvpframwork.presenter.HomePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseProgressFragment;
import com.yjtc.cbg.basicmvpframwork.ui.contract.HomeContract;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-06-13
 */
public class HomeFragment extends BaseProgressFragment<HomePresenter> implements HomeContract.IHomeView {


    @BindView(R.id.mTv)
    TextView mMTv;

    @BindView(R.id.mTv1)
    TextView mMTv1;

    @BindView(R.id.mArea)
    TextView mArea;

    public HomeFragment() {
    }

    @Override
    protected void init() {
        showContentView();
        mUIListener.setBottomState(View.VISIBLE);
        mUIListener.setTopTitle(0, "主页");
        mUIListener.setRightTextState(View.VISIBLE, R.string.sure);
    }

    @Override
    protected void setFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public String getArea() {
        return "cn";
    }

    @Override
    public void getAreaSuccess(List<AreaDto> data) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < data.size(); i++)
            buffer.append(data.get(i).getAreaName().toString()).append("--");
        mArea.setText(buffer.toString());
    }

    @OnClick({R.id.mTv, R.id.mTv1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mTv:
                mPresenter.getAreaData();
                break;
            case R.id.mTv1:
                mActivity.startFragmentAdd(new UserDetailFragment());
                break;
        }
    }
}
