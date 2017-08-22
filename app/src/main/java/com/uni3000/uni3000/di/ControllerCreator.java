package com.uni3000.uni3000.di;

import dagger.Component;
import javax.inject.Singleton;
import com.uni3000.uni3000.controller.UserController;
import com.uni3000.uni3000.controller.module.UserModule;

@Singleton
@Component(modules = {UserModule.class})
public interface ControllerCreator {

    UserController provideUserController();

}