package com.uni3000.uni3000.di;

import android.content.Context;

import dagger.Component;
import javax.inject.Singleton;
import com.uni3000.uni3000.controller.UserController;
import com.uni3000.uni3000.controller.module.UserModule;
import com.uni3000.uni3000.controller.VocabController;
import com.uni3000.uni3000.controller.module.VocabModule;

@Singleton
@Component(modules = {UserModule.class, VocabModule.class})
public interface ControllerCreator {
    Context context();

    UserController provideUserController();

    VocabController provideVocabController();

    void inject(VocabController vocabController);
}