package com.yjtc.cbg.basicmvpframwork.di.module;

import com.yjtc.cbg.basicmvpframwork.ui.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@Module
public class AppModule {

    private App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    public App provideApplication() {
        return mApplication;
    }

}
