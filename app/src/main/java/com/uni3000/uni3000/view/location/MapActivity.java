package com.uni3000.uni3000.view.location;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.QuestController;
import com.uni3000.uni3000.controller.module.McQuestionModule;
import com.uni3000.uni3000.di.ControllerCreator;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.model.Location;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MapActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    QuestController questController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ControllerCreator creator = DaggerControllerCreator.builder().mcQuestionModule(new McQuestionModule(this)).build();
        questController = creator.provideQuestController();
        this.loadLocation();
    }

    public void loadLocation() {
        List<Location> locations = questController.getActiveLocation();
        LinearLayout locationDisplay = (LinearLayout) this.findViewById(R.id.active_locations);
        for (Location loc : locations) {
            Button building = new Button(this);
            building.setText(loc.getLocationName());
            building.setOnClickListener(locationClickListener(building));
            locationDisplay.addView(building);
        }
    }

    OnClickListener locationClickListener(final Button button)  {
        return new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, LocationActivity.class);
                intent.putExtra("location", button.getText().toString());
                startActivity(intent);
            }
        };
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
