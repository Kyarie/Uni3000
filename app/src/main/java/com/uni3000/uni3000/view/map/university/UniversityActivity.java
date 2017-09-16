package com.uni3000.uni3000.view.map.university;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.map.MapActivity;
import com.uni3000.uni3000.view.map.university.recruit.RecruitActivity;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class UniversityActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, UserHeaderFragment.newInstance())
                    .add(R.id.container, NavigationTabFragment.newInstance())
                    .commitAllowingStateLoss();
    }

    public void ButtonOnClick(View v) {
        switch (v.getId()) {
            case R.id.recruitButton:
                Intent intent = new Intent(UniversityActivity.this,RecruitActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


}

