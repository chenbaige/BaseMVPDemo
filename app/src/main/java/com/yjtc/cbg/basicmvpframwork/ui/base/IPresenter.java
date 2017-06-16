package com.yjtc.cbg.basicmvpframwork.ui.base;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-06-13
 */
public interface IPresenter<T extends IView> {

    void attachVIew(T view);

    void detachVIew();
}
