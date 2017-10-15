package com.uni3000.uni3000.view.location;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Button;

import com.uni3000.uni3000.R;

import dagger.android.support.AndroidSupportInjection;

public class ActionFragment extends Fragment {

    private String location;

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
    }

    public void loadButton() {
        LinearLayout actionNav = (LinearLayout)getView().findViewById(R.id.action_layout);
        // get from db
        Button btnTag = new Button(getActivity());
        btnTag.setText(this.location);
        actionNav.addView(btnTag);
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
