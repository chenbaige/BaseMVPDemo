package com.yjtc.cbg.basicmvpframwork.ui.base;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-25
 */
public interface IView {

    void showLoading();

    void dismissLoading();

    void showError(String message);

}
