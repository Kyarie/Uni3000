package com.uni3000.uni3000.view.library;

import com.uni3000.uni3000.view.game_play.OptionsFragment;
import com.uni3000.uni3000.view.game_play.module.OptionsModule;
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

    @ContributesAndroidInjector(modules = OptionsModule.class)
    abstract OptionsFragment provideDialogFragmentFactory();
}