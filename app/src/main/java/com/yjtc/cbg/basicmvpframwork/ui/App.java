package com.yjtc.cbg.basicmvpframwork.ui;

import android.app.Application;

import com.yjtc.cbg.basicmvpframwork.di.component.AppComponent;
import com.yjtc.cbg.basicmvpframwork.di.component.DaggerAppComponent;
import com.yjtc.cbg.basicmvpframwork.di.module.AppModule;
import com.yjtc.cbg.basicmvpframwork.di.module.HttpModule;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
public class App extends Application {

    public static boolean netState = true;

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).httpModule(new HttpModule()).build();
    }

}
