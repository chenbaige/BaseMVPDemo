package com.yjtc.cbg.basicmvpframwork.di.component;

import com.yjtc.cbg.basicmvpframwork.di.ActivityScope;
import com.yjtc.cbg.basicmvpframwork.ui.activity.MainActivity;

import dagger.Component;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-05-24
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
