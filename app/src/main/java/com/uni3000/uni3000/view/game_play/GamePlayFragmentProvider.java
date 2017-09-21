package com.uni3000.uni3000.view.game_play;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.uni3000.uni3000.view.game_play.module.OptionsModule;
import com.uni3000.uni3000.view.game_play.module.QuestModule;

@Module
public abstract class GamePlayFragmentProvider {
    @ContributesAndroidInjector(modules = OptionsModule.class)
    abstract OptionsFragment provideOptionsFragmentFactory();

    @ContributesAndroidInjector(modules = QuestModule.class)
    abstract QuestionHeaderFragment provideQuestionHeaderFragment();
}