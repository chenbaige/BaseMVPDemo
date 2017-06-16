package com.yjtc.cbg.basicmvpframwork.ui.activity;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.yjtc.cbg.basicmvpframwork.R;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerActivityComponent;
import com.yjtc.cbg.basicmvpframwork.resover.OnNetWorkChangeListener;
import com.yjtc.cbg.basicmvpframwork.ui.App;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseActivity;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.ChatFragment;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.HomeFragment;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.MineFragment;
import com.yjtc.cbg.basicmvpframwork.ui.inter.OnFragmentChangeListener;
import com.yjtc.cbg.basicmvpframwork.ui.inter.OnFragmentChangeUIChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, OnNetWorkChangeListener, OnFragmentChangeUIChangeListener {

    public static OnNetWorkChangeListener anInterface;

    protected App mApp;

    //顶部可见
    private boolean topVisible = false;
    //底部可见
    private boolean bottomVisible = false;

    @BindView(R.id.toolbar)
    View toolbar;
    @BindView(R.id.content_layout)
    View content_layout;
    @BindView(R.id.tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.tv_toolbar_state)
    TextView mTvToolbarState;
    @BindView(R.id.common_bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.common_net_expection_layout)
    View mCommonNetContent;

    private OnFragmentChangeListener OnFragmentChangeListener;

    private Unbinder mUnbinder;

    //记录第一次点击
    private long clickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anInterface = this;
        mUnbinder = ButterKnife.bind(this);
        if (mApp == null) {
            mApp = (App) getApplication();
        }
        setNetWorkVisiable();
        DaggerActivityComponent.builder().appComponent(mApp.getAppComponent()).build().inject(this);
        initView();
    }

    private void setNetWorkVisiable() {
        if (App.netState) {
            mCommonNetContent.setVisibility(View.GONE);
        } else {
            mCommonNetContent.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.common_bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.favorite_unselect, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.comments_unselect, "Chat"))
                .addItem(new BottomNavigationItem(R.mipmap.atm_unselect, "Mine"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        if (null != mTvToolbarTitle)
            mTvToolbarTitle.setText("我的App");

        bottomNavigationBar.setFirstSelectedPosition(0);
        bottomNavigationBar.selectTab(0);
    }

    /**
     * Fragment 跳转事件
     */
    public void startFragmentAdd(Fragment fragment) {
        // ------------------------------------------------------------------------
        printCurrFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment to_fragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());
        if (to_fragment != null) {
            for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(i);
                if (fragment.getClass().getName().equals(entry.getName())) {
                    fragmentManager.popBackStack(entry.getName(), 1);
                }
            }
        }
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        if (fragment instanceof OnFragmentChangeListener) {
            OnFragmentChangeListener = (OnFragmentChangeListener) fragment;
        }
        fragmentTransaction.replace(R.id.content, fragment, fragment.getClass().getName()).commitAllowingStateLoss();
        // ------------------------------------------------------------------------
    }

    private void printCurrFragment() {
        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
            System.out.println(getSupportFragmentManager().getBackStackEntryAt(i).getName());
        }
    }

    /**
     * 监听后退事件
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 按下的如果是BACK，同时没有重复
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content);
            FragmentManager fragmentManager = getSupportFragmentManager();
            for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                FragmentManager.BackStackEntry backstatck = getSupportFragmentManager().getBackStackEntryAt(i);
                Fragment back_fragment = fragmentManager.findFragmentByTag(backstatck.getName());
                if (back_fragment instanceof OnFragmentChangeListener) {
                    OnFragmentChangeListener = (OnFragmentChangeListener) back_fragment;
                }
            }
            if (null != fragment) {
                if (fragment.getClass().getName().equals(HomeFragment.class.getName())) {
                    exit();
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
//            appExit();
//            在这里清除缓存
        }
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                startFragmentAdd(new HomeFragment());
                break;

            case 1:
                startFragmentAdd(new ChatFragment());
                break;

            case 2:
                startFragmentAdd(new MineFragment());
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }

    @OnClick({R.id.iv_toolbar_back, R.id.tv_toolbar_state, R.id.common_net_expection_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                getSupportFragmentManager().popBackStack();
                break;
            case R.id.tv_toolbar_state:

                break;
            case R.id.common_net_expection_layout:
                setNetWork();
                break;
        }
    }

    private void setNetWork() {
        Intent intent = null;
        if (Build.VERSION.SDK_INT > 10) {
            intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        } else {
            intent = new Intent();
            ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
            intent.setComponent(componentName);
            intent.setAction("android.intent.action.VIEW");
        }
        startActivity(intent);
    }

    @Override
    public void onNetEnable() {
        mCommonNetContent.setVisibility(View.GONE);
    }

    @Override
    public void onNetDisable() {
        mCommonNetContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void setTopTitle(int resid, String title) {
        if (resid == 0) {
            mTvToolbarTitle.setText(title);
        } else {
            mTvToolbarTitle.setText(resid);
        }
    }

    @Override
    public void setTopState(int state) {
        if (state == View.VISIBLE) {
            topVisible = true;
        } else {
            topVisible = false;
        }
        toolbar.setVisibility(state);
        setContentframe();
    }

    @Override
    public void setBottomState(int state) {
        if (state == View.VISIBLE) {
            bottomVisible = true;
        } else {
            bottomVisible = false;
        }
        bottomNavigationBar.setVisibility(state);
        setContentframe();
    }

    @Override
    public void setRightTextState(int state, int resid) {
        if (resid != 0) {
            mTvToolbarState.setText(resid);
        }
        mTvToolbarState.setVisibility(state);
    }

    public void setContentframe() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(content_layout.getLayoutParams());
        RelativeLayout.LayoutParams headlayoutParams = new RelativeLayout.LayoutParams(toolbar.getLayoutParams());
        RelativeLayout.LayoutParams bottomlayoutParams = new RelativeLayout.LayoutParams(bottomNavigationBar.getLayoutParams());
        if (topVisible) {
            layoutParams.topMargin = headlayoutParams.height;
        } else {
            layoutParams.topMargin = 0;
        }
        if (bottomVisible) {
            layoutParams.bottomMargin = bottomlayoutParams.height;
        } else {
            layoutParams.bottomMargin = 0;
        }
        content_layout.setLayoutParams(layoutParams);
    }
}
