package com.yjtc.cbg.basicmvpframwork.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.ui.App;
import com.yjtc.cbg.basicmvpframwork.ui.activity.MainActivity;
import com.yjtc.cbg.basicmvpframwork.ui.inter.OnFragmentChangeListener;
import com.yjtc.cbg.basicmvpframwork.ui.inter.OnFragmentChangeUIChangeListener;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-27
 */
public abstract class BaseProgressFragment<T extends BasePresenter> extends Fragment implements IView, OnFragmentChangeListener {

    @Inject
    protected T mPresenter;

    private FrameLayout mRootView;

    protected MainActivity mActivity;

    protected OnFragmentChangeUIChangeListener mUIListener;

    private View mProgressView;
    private FrameLayout mContentView;
    private View mPEmptyView;

    private Unbinder mUnbinder;

    private TextView mEmptyText;

    @Inject
    protected App mApp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.activity_progress, container, false);

        mProgressView = mRootView.findViewById(R.id.view_progress);
        mContentView = (FrameLayout) mRootView.findViewById(R.id.view_content);
        mPEmptyView = mRootView.findViewById(R.id.view_empty);

        mEmptyText = (TextView) mRootView.findViewById(R.id.tv_empty);
        mEmptyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEmptyViewClick();
            }
        });
        if (this.mApp == null)
            this.mApp = (App) getActivity().getApplication();
        setFragmentComponent(mApp.getAppComponent());
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachVIew(this);
        setRealContentView();
        init();
    }

    protected abstract void init();

    protected abstract void setFragmentComponent(AppComponent appComponent);

    private void setRealContentView() {
        View view = LayoutInflater.from(getActivity()).inflate(setContentLayout(), mContentView, true);
        mUnbinder = ButterKnife.bind(this, view);
    }

    public void onEmptyViewClick() {

    }

    protected void showProgressView() {
        showViewById(R.id.view_progress);
    }

    protected void showContentView() {
        showViewById(R.id.view_content);
    }

    protected void showEmptyView() {
        showViewById(R.id.view_empty);
    }

    protected void showEmptyView(int resId) {
        showViewById(R.id.view_empty);
        mEmptyText.setText(getString(resId));
    }

    @Override
    public void showLoading() {
        showProgressView();
    }

    @Override
    public void dismissLoading() {
        showContentView();
    }

    @Override
    public void showError(String message) {
        showEmptyView(message);
    }

    protected void showEmptyView(String message) {
        showViewById(R.id.view_empty);
        mEmptyText.setText(message);
    }

    private void showViewById(int id) {
        for (int i = 0; i < mRootView.getChildCount(); i++) {
            if (mRootView.getChildAt(i).getId() == id) {
                mRootView.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mRootView.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }

    public abstract int setContentLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mUnbinder != null)
            mUnbinder.unbind();

        if (mPresenter != null)
            mPresenter.detachVIew();
    }

    @Override
    public void onRightTextClick() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();
        if (getActivity() instanceof OnFragmentChangeUIChangeListener)
            mUIListener = (OnFragmentChangeUIChangeListener) getActivity();
    }
}
