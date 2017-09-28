package com.uni3000.uni3000.view.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.uni3000.uni3000.view.game_play.OptionsFragment;
import com.uni3000.uni3000.view.game_play.module.GamePlayFragmentModule;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabModule;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderModule;

@Module
public abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = UserHeaderModule.class)
    abstract UserHeaderFragment provideUserHeaderFragmentFactory();

    @ContributesAndroidInjector(modules = NavigationTabModule.class)
    abstract NavigationTabFragment provideNavigationTabFragmentFactory();

    @ContributesAndroidInjector(modules = GamePlayFragmentModule.class)
    abstract OptionsFragment provideMCFragmentFactory();
}