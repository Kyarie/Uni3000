package com.uni3000.uni3000.view.location;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.QuestController;
import com.uni3000.uni3000.controller.module.ControllerModule;
import com.uni3000.uni3000.di.ControllerCreator;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.model.DatabaseObject.Action_Button;
import com.uni3000.uni3000.view.game_play.QuestionActivity;

import java.util.List;

import dagger.android.support.AndroidSupportInjection;

public class ActionFragment extends Fragment {

    private String location;
    QuestController questController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action, container, false);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        ControllerCreator creator = DaggerControllerCreator.builder().controllerModule(new ControllerModule(getActivity())).build();
        questController = creator.provideQuestController();
    }

    public void loadButton() {
        LinearLayout actionNav = (LinearLayout)getView().findViewById(R.id.action_layout);
        List<Action_Button> actionButtons = questController.getActiveActionButtonByLocation(location);
        for (Action_Button action : actionButtons) {
            Button button = new Button(getActivity());
            button.setText(action.getActionButtonLabel());
            button.setOnClickListener(actionClickListener(button));
            actionNav.addView(button);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    OnClickListener actionClickListener(final Button button) {
        return new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra("activity", getActivity().getClass().getName());
                startActivity(intent);
            }
        };
    }
}
