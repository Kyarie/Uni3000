package com.uni3000.uni3000.view.bar;

import com.uni3000.uni3000.view.dialog.McFragment;
import com.uni3000.uni3000.view.dialog.McModule;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabModule;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = UserHeaderModule.class)
    abstract UserHeaderFragment provideUserHeaderFragmentFactory();

    @ContributesAndroidInjector(modules = NavigationTabModule.class)
    abstract NavigationTabFragment provideNavigationTabFragmentFactory();


    @ContributesAndroidInjector(modules = McModule.class)
    abstract McFragment provideMcFragmentFactory();
}