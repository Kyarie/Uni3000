package com.uni3000.uni3000.view.map;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.map.location.LocationActivity;
import com.uni3000.uni3000.view.navigation_tab.NavigationTabFragment;
import com.uni3000.uni3000.view.map.university.UniversityActivity;
import com.uni3000.uni3000.view.user_header.UserHeaderFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MapActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, UserHeaderFragment.newInstance())
                    .add(R.id.container, NavigationTabFragment.newInstance())
                    .commitAllowingStateLoss();

    }

    public void ButtonOnClick(View v) {
        switch (v.getId()) {
            case R.id.officeButton:
                startActivity(new Intent(MapActivity.this,UniversityActivity.class));
                break;
            case R.id.testLocationButton:
                Intent i = new Intent(getApplicationContext(), LocationActivity.class);
                i.putExtra("key","user clicked test location button");
                startActivity(new Intent(MapActivity.this, LocationActivity.class));
                startActivity(i);
                break;
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


}
