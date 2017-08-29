package com.uni3000.uni3000.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.uni3000.uni3000.view.home.HomeActivity;
import com.uni3000.uni3000.view.home.HomeModule;
import com.uni3000.uni3000.view.home.FragmentProvider;
import com.uni3000.uni3000.view.library.LibraryActivity;
import com.uni3000.uni3000.view.university.UniversityActivity;
import com.uni3000.uni3000.view.university.UniversityModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeModule.class, FragmentProvider.class})
    abstract HomeActivity bindHomeActivity();
    @ContributesAndroidInjector(modules = {UniversityModule.class, com.uni3000.uni3000.view.university.FragmentProvider.class})
    abstract UniversityActivity bindUniversityActivity();
    @ContributesAndroidInjector(modules = {UniversityModule.class, com.uni3000.uni3000.view.library.FragmentProvider.class})
    abstract LibraryActivity bindLibraryActivity();

}