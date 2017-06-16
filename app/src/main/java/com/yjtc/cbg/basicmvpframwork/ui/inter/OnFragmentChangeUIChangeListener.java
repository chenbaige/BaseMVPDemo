package com.yjtc.cbg.basicmvpframwork.ui.inter;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:进入fragment后控制activity内ui的状态
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-15
 */
public interface OnFragmentChangeUIChangeListener {

    //设置头部名称
    void setTopTitle(int resid, String title);

    //设置头部状态(隐藏与显示)
    void setTopState(int state);

    //设置底部状态(隐藏与显示)
    void setBottomState(int state);

    //设置右文字状态(隐藏与显示)
    void setRightTextState(int state, int resid);

    //设置右图状态(隐藏与显示)
    //void setRightImageState(int state,int resid);

    //点击底部菜单按钮
//    void clickButtonMenu(int type);

    //执行返回
//    void clickBack();
}
