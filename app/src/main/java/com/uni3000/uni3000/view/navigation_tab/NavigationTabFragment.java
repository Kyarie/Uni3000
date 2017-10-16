package com.uni3000.uni3000.view.navigation_tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.location.BarActivity;
import com.uni3000.uni3000.view.build.BuildActivity;
import com.uni3000.uni3000.view.location.LibraryActivity;
import com.uni3000.uni3000.view.location.MapActivity;

import dagger.android.support.AndroidSupportInjection;

public class NavigationTabFragment extends Fragment implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.setupButton();
    }

    public void setupButton() {
        Button universityTab = (Button)getView().findViewById(R.id.university_tab);
        universityTab.setOnClickListener(this);
        Button libraryTab = (Button)getView().findViewById(R.id.library_tab);
        libraryTab.setOnClickListener(this);
        Button barTab = (Button)getView().findViewById(R.id.bar_tab);
        barTab.setOnClickListener(this);
        Button buildTab = (Button)getView().findViewById(R.id.build_tab);
        buildTab.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.university_tab:
                startActivity(new Intent(getActivity(),MapActivity.class));
                break;
            case R.id.library_tab:
                startActivity(new Intent(getActivity(),LibraryActivity.class));
                break;
            case R.id.bar_tab:
                startActivity(new Intent(getActivity(),BarActivity.class));
                break;
            case R.id.build_tab:
                startActivity(new Intent(getActivity(),BuildActivity.class));
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}