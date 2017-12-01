package com.uni3000.uni3000.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.uni3000.uni3000.view.build.BuildFragmentProvider;
import com.uni3000.uni3000.view.learn.StudyActivity;
import com.uni3000.uni3000.view.location.BarActivity;
import com.uni3000.uni3000.view.build.BuildActivity;
import com.uni3000.uni3000.view.build.BuildModule;
import com.uni3000.uni3000.view.home.HomeActivity;
import com.uni3000.uni3000.view.home.HomeModule;
import com.uni3000.uni3000.view.home.FragmentProvider;
import com.uni3000.uni3000.view.location.LibraryActivity;
import com.uni3000.uni3000.view.location.LocationFragmentProvider;
import com.uni3000.uni3000.view.location.module.LocationModule;
import com.uni3000.uni3000.view.location.LocationActivity;
import com.uni3000.uni3000.view.location.MapActivity;
import com.uni3000.uni3000.view.map.university.UniversityActivity;
import com.uni3000.uni3000.view.map.university.UniversityModule;
import com.uni3000.uni3000.view.map.university.recruit.RecruitActivity;
import com.uni3000.uni3000.view.map.university.recruit.RecruitModule;
import com.uni3000.uni3000.view.game_play.QuestionActivity;
import com.uni3000.uni3000.view.game_play.module.QuestionModule;
import com.uni3000.uni3000.view.game_play.GamePlayFragmentProvider;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeModule.class, FragmentProvider.class})
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector(modules = {UniversityModule.class, com.uni3000.uni3000.view.map.university.FragmentProvider.class})
    abstract UniversityActivity bindUniversityActivity();

    @ContributesAndroidInjector(modules = {LocationModule.class, LocationFragmentProvider.class})
    abstract LibraryActivity bindLibraryActivity();

    @ContributesAndroidInjector(modules = {LocationModule.class, LocationFragmentProvider.class})
    abstract BarActivity bindBarActivity();

    @ContributesAndroidInjector(modules = {BuildModule.class, BuildFragmentProvider.class})
    abstract BuildActivity bindBuildActivity();

    @ContributesAndroidInjector(modules = {RecruitModule.class, com.uni3000.uni3000.view.map.university.recruit.FragmentProvider.class})
    abstract RecruitActivity bindRecruitActivity();

    @ContributesAndroidInjector(modules = {LocationModule.class, LocationFragmentProvider.class})
    abstract MapActivity bindMapActivity();

    @ContributesAndroidInjector(modules = {LocationModule.class, LocationFragmentProvider.class})
    abstract LocationActivity bindLocationActivity();

    @ContributesAndroidInjector(modules = {QuestionModule.class, GamePlayFragmentProvider.class})
    abstract QuestionActivity bindQuestionActivity();

    @ContributesAndroidInjector(modules = {QuestionModule.class})
    abstract StudyActivity bindStudyActivity();

}