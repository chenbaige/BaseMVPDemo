package com.yjtc.cbg.basicmvpframwork.common.rx.subscribe;

import android.content.Context;

import com.yjtc.cbg.basicmvpframwork.common.exception.BaseException;
import com.yjtc.cbg.basicmvpframwork.common.rx.ProgressDialogHandler;
import com.yjtc.cbg.basicmvpframwork.common.rx.RXErrorHandler;
import com.yjtc.cbg.basicmvpframwork.ui.base.IView;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-25
 */
public abstract class ProgressSubscribe<T> extends ErrorSubscribe<T> implements ProgressDialogHandler.onProgressCancelistener {

    private IView mView;

    private RXErrorHandler mHandler;

    public ProgressSubscribe(Context context, IView view) {
        super(context);
        this.mView = view;
        this.mHandler = new RXErrorHandler(context);
    }

    public boolean isShowProgress() {
        return true;
    }

    @Override
    public void onStart() {
        if (isShowProgress())
            mView.showLoading();
    }

    @Override
    public void onCompleted() {
        mView.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {
        BaseException baseException = mHandler.handleError(e);

        mView.showError(baseException.getDisplayMessage());
    }

    @Override
    public void onProgressCancel() {
        unsubscribe();
    }
}
