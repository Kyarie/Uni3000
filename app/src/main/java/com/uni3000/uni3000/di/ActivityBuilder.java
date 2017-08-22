package com.uni3000.uni3000.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.uni3000.uni3000.view.home.HomeActivity;
import com.uni3000.uni3000.view.home.HomeModule;
import com.uni3000.uni3000.view.home.FragmentProvider;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeModule.class, FragmentProvider.class})
    abstract HomeActivity bindHomeActivity();
}