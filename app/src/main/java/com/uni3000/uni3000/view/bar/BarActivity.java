package com.uni3000.uni3000.view.bar;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.game_play.QuestionActivity;
import com.uni3000.uni3000.view.game_play.OptionsFragment;
import com.uni3000.uni3000.view.map.MapActivity;
import com.uni3000.uni3000.view.map.location.LocationActivity;
import com.uni3000.uni3000.view.map.university.UniversityActivity;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BarActivity extends AppCompatActivity implements HasSupportFragmentInjector, OnClickListener {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, UserHeaderFragment.newInstance())
                    .add(R.id.container, NavigationTabFragment.newInstance())
                    .commitAllowingStateLoss();

        Button chat5 = (Button)findViewById(R.id.chat5);
        chat5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.chat5:
                startActivity(new Intent(BarActivity.this, QuestionActivity.class));
                break;
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}

