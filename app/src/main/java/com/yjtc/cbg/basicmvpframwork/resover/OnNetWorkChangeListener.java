package com.yjtc.cbg.basicmvpframwork.resover;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-15
 */
public interface OnNetWorkChangeListener {

    //网络可用时调用
    void onNetEnable();
    //网络不可用时调用
    void onNetDisable();
}
