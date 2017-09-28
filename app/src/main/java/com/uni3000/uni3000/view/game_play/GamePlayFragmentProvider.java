package com.uni3000.uni3000.view.game_play;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.uni3000.uni3000.view.game_play.module.GamePlayFragmentModule;

@Module
public abstract class GamePlayFragmentProvider {
    @ContributesAndroidInjector(modules = GamePlayFragmentModule.class)
    abstract OptionsFragment provideOptionsFragmentFactory();

    @ContributesAndroidInjector(modules = GamePlayFragmentModule.class)
    abstract QuestionHeaderFragment provideQuestionHeaderFragment();

    @ContributesAndroidInjector(modules = GamePlayFragmentModule.class)
    abstract GameResultFragment provideGameResultFragment();
}