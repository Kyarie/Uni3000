package com.uni3000.uni3000.controller.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import com.uni3000.uni3000.model.Interface.IUser;
import com.uni3000.uni3000.model.User;

@Module
public class UserModule {

    @Provides @Singleton
    IUser provideUser(){
        return new User();
    }

}