package com.yjtc.cbg.basicmvpframwork.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import com.yjtc.cbg.basicmvpframwork.common.rx.ProgressDialogHandler;
import com.yjtc.cbg.basicmvpframwork.common.rx.RXErrorHandler;
import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;

/**
 * Title: basicmvpframwork
 * <p>ip
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-26
 */
public class BasePresenter<T extends IView, M extends IModel> implements IPresenter<T> {

    protected T mView;

    protected M mModel;

    protected Context mContext;

    protected RXErrorHandler mErrorHandler;

    protected ProgressDialogHandler mDialogHandler;

    public BasePresenter(ApiService service) {

    }

    //根据BaseView获取context对象
    protected Context getContext() {
        if (mView instanceof Fragment) {
            return ((Fragment) mView).getActivity();
        } else {
            return (Activity) mView;
        }
    }

    @Override
    public void attachVIew(T view) {
        this.mView = view;
        this.mContext = ((android.support.v4.app.Fragment) mView).getActivity();
    }

    @Override
    public void detachVIew() {
        this.mView = null;
    }
}
