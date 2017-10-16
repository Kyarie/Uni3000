package com.uni3000.uni3000.view.location;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.common.LocationType;
import com.uni3000.uni3000.view.game_play.QuestionActivity;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BarActivity extends AppCompatActivity implements HasSupportFragmentInjector, OnClickListener {

    @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject LocationType locationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        this.loadAction();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void loadAction() {
        ActionFragment actionFragment = (ActionFragment) getSupportFragmentManager().findFragmentById(R.id.action_navigation);
        actionFragment.setLocation(locationType.BAR);
        actionFragment.loadButton();
    }
}

