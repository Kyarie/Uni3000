package com.uni3000.uni3000.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.uni3000.uni3000.view.bar.BarActivity;
import com.uni3000.uni3000.view.bar.BarModule;
import com.uni3000.uni3000.view.build.BuildActivity;
import com.uni3000.uni3000.view.build.BuildModule;
import com.uni3000.uni3000.view.home.HomeActivity;
import com.uni3000.uni3000.view.home.HomeModule;
import com.uni3000.uni3000.view.home.FragmentProvider;
import com.uni3000.uni3000.view.library.LibraryActivity;
import com.uni3000.uni3000.view.library.LibraryModule;
import com.uni3000.uni3000.view.map.location.LocationActivity;
import com.uni3000.uni3000.view.map.location.LocationModule;
import com.uni3000.uni3000.view.map.MapActivity;
import com.uni3000.uni3000.view.map.MapModule;
import com.uni3000.uni3000.view.map.university.UniversityActivity;
import com.uni3000.uni3000.view.map.university.UniversityModule;
import com.uni3000.uni3000.view.map.university.recruit.RecruitActivity;
import com.uni3000.uni3000.view.map.university.recruit.RecruitModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeModule.class, FragmentProvider.class})
    abstract HomeActivity bindHomeActivity();
    @ContributesAndroidInjector(modules = {UniversityModule.class, com.uni3000.uni3000.view.map.university.FragmentProvider.class})
    abstract UniversityActivity bindUniversityActivity();
    @ContributesAndroidInjector(modules = {LibraryModule.class, com.uni3000.uni3000.view.library.FragmentProvider.class})
    abstract LibraryActivity bindLibraryActivity();
    @ContributesAndroidInjector(modules = {BarModule.class, com.uni3000.uni3000.view.bar.FragmentProvider.class})
    abstract BarActivity bindBarActivity();
    @ContributesAndroidInjector(modules = {BuildModule.class, com.uni3000.uni3000.view.build.FragmentProvider.class})
    abstract BuildActivity bindBuildActivity();

    @ContributesAndroidInjector(modules = {RecruitModule.class, com.uni3000.uni3000.view.map.university.recruit.FragmentProvider.class})
    abstract RecruitActivity bindRecruitActivity();

    @ContributesAndroidInjector(modules = {MapModule.class, com.uni3000.uni3000.view.map.FragmentProvider.class})
    abstract MapActivity bindMapActivity();

    @ContributesAndroidInjector(modules = {LocationModule.class, com.uni3000.uni3000.view.map.location.FragmentProvider.class})
    abstract LocationActivity bindLocationActivity();

}