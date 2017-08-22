package com.uni3000.uni3000.view.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderModule;

@Module
public abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = UserHeaderModule.class)
    abstract UserHeaderFragment provideUserHeaderFragmentFactory();
}