package com.yjtc.cbg.basicmvpframwork.di.component;

import com.yjtc.cbg.basicmvpframwork.common.rx.RXErrorHandler;
import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.di.module.AppModule;
import com.yjtc.cbg.basicmvpframwork.di.module.HttpModule;
import com.yjtc.cbg.basicmvpframwork.ui.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Title: BasicMvpFramwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    public ApiService getApiService();

    public App getApplication();

    public RXErrorHandler getRXErrorHandler();

}
