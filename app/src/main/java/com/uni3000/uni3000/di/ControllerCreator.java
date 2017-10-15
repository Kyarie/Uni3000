package com.uni3000.uni3000.di;

import android.content.Context;

import dagger.Component;
import javax.inject.Singleton;

import com.uni3000.uni3000.controller.QuestController;
import com.uni3000.uni3000.controller.UserController;
import com.uni3000.uni3000.controller.module.UserModule;
import com.uni3000.uni3000.controller.McQuestionController;
import com.uni3000.uni3000.controller.module.McQuestionModule;

@Singleton
@Component(modules = {UserModule.class, McQuestionModule.class})
public interface ControllerCreator {
    Context context();

    UserController provideUserController();

    McQuestionController provideMcQuestionController();

    QuestController provideQuestController();

    void inject(McQuestionController mcQuestionController);

    void inject(QuestController questController);
}