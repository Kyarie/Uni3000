package com.uni3000.uni3000.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.uni3000.uni3000.view.home.HomeActivity;
import com.uni3000.uni3000.view.home.HomeModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity bindHomeActivity();
}