package com.uni3000.uni3000.view.user_header;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
        UserHeaderModule.class})
public interface UserHeaderComponent extends AndroidInjector<UserHeaderActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserHeaderActivity> {
    }
}