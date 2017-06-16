package com.yjtc.cbg.basicmvpframwork.di.component;

import com.yjtc.cbg.basicmvpframwork.di.FragmentScope;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.ChatFragment;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.HomeFragment;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.MineFragment;
import com.yjtc.cbg.basicmvpframwork.ui.fragment.UserDetailFragment;

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
@FragmentScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(HomeFragment homeFragment);

    void inject(ChatFragment chatFragment);

    void inject(MineFragment mineFragment);

    void inject(UserDetailFragment userDetailFragment);
}
