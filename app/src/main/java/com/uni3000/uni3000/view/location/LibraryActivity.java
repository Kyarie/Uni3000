package com.uni3000.uni3000.view.location;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.common.LocationType;
import com.uni3000.uni3000.di.AppComponent;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.view.location.module.LocationModule;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LibraryActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject LocationType locationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.header_profile, UserHeaderFragment.newInstance())
                    .add(R.id.footer_navigation, NavigationTabFragment.newInstance())
                    .commitAllowingStateLoss();

        this.loadAction();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void loadAction() {
        ActionFragment actionFragment = (ActionFragment) getSupportFragmentManager().findFragmentById(R.id.action_navigation);
        actionFragment.setLocation(locationType.LIBRARY);
        actionFragment.loadButton();
    }
}

