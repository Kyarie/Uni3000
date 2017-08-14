package com.uni3000.uni3000.di;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.uni3000.uni3000.view.main.MainActivityComponent;
/*
import iammert.com.dagger_android_injection.ui.detail.DetailActivityComponent;
import iammert.com.dagger_android_injection.ui.main.MainActivityComponent;*/

@Module(subcomponents = {MainActivityComponent.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}
