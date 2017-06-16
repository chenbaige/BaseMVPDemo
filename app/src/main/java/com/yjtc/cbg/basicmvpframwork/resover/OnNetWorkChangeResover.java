package com.yjtc.cbg.basicmvpframwork.resover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.util.Log;

import com.yjtc.cbg.basicmvpframwork.ui.App;
import com.yjtc.cbg.basicmvpframwork.ui.activity.MainActivity;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:实现网络监听，当网络状态变换的时候调用
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-15
 */
public class OnNetWorkChangeResover extends BroadcastReceiver {

    private OnNetWorkChangeListener anInterface = MainActivity.anInterface;

    private String getConnectionType(int type) {
        String connType = "";
        if (type == ConnectivityManager.TYPE_MOBILE) {
            connType = "3G网络数据";
        } else if (type == ConnectivityManager.TYPE_WIFI) {
            connType = "WIFI网络";
        }
        return connType;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            // 监听wifi的打开与关闭，与wifi的连接无关
            case WifiManager.WIFI_STATE_CHANGED_ACTION:
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                Log.e("TAG", "wifiState:" + wifiState);
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        System.out.println("WIFI状态：WifiManager.WIFI_STATE_DISABLED");
                        break;
                    case WifiManager.WIFI_STATE_DISABLING:
                        System.out.println("WIFI状态：WifiManager.WIFI_STATE_DISABLING");
                        break;
                }
                break;
            // 监听wifi的连接状态即是否连上了一个有效无线路由
            case WifiManager.NETWORK_STATE_CHANGED_ACTION:
                Parcelable parcelableExtra = intent
                        .getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                if (null != parcelableExtra) {
                    // 获取联网状态的NetWorkInfo对象
                    NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                    //获取的State对象则代表着连接成功与否等状态
                    NetworkInfo.State state = networkInfo.getState();
                    //判断网络是否已经连接
                    boolean isConnected = state == NetworkInfo.State.CONNECTED;
                    Log.e("TAG", "isConnected:" + isConnected);
                    if (isConnected) {
                        System.out.println("WIFI状态：链接可用");
                    } else {
                        System.out.println("WIFI状态：链接不可用");
                    }
                }
                break;
            // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
            case ConnectivityManager.CONNECTIVITY_ACTION:
                //获取联网状态的NetworkInfo对象
                NetworkInfo info = intent
                        .getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
                if (info != null) {
                    //如果当前的网络连接成功并且网络连接可用
                    if (NetworkInfo.State.CONNECTED == info.getState() && info.isAvailable()) {
                        if (info.getType() == ConnectivityManager.TYPE_WIFI
                                || info.getType() == ConnectivityManager.TYPE_MOBILE) {
                            Log.i("TAG", getConnectionType(info.getType()) + "连上");
                            if (anInterface != null)
                                anInterface.onNetEnable();
                            App.netState = true;
                        }
                    } else {
                        Log.i("TAG", getConnectionType(info.getType()) + "断开");
                        if (anInterface != null)
                            anInterface.onNetDisable();
                        App.netState = false;
                    }
                }
                break;
        }
    }
}
