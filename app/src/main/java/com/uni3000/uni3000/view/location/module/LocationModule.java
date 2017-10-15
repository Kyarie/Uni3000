package com.uni3000.uni3000.view.location.module;

import com.uni3000.uni3000.controller.common.LocationType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationModule {
    @Provides // TODO: This should be a singleton
    LocationType provideLocationType(){
        return new LocationType();
    }
}
