package com.uni3000.uni3000.view.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import com.uni3000.uni3000.R;
import com.uni3000.uni3000.model.User;

public class HomeActivity extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        user.num = 1;
    }
}
