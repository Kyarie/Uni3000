package com.uni3000.uni3000.view.navigation_tab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.bar.BarActivity;
import com.uni3000.uni3000.view.build.BuildActivity;
import com.uni3000.uni3000.view.location.LibraryActivity;
import com.uni3000.uni3000.view.map.MapActivity;

import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NavigationTabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NavigationTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationTabFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public NavigationTabFragment() {
        // Required empty public constructor
    }

    public static NavigationTabFragment newInstance() {
        NavigationTabFragment fragment = new NavigationTabFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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


        Button universityTab = (Button)getView().findViewById(R.id.universityTab);
        universityTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        Button libraryTab = (Button)getView().findViewById(R.id.libraryTab);
        libraryTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LibraryActivity.class);
                startActivity(intent);
            }
        });

        Button barTab = (Button)getView().findViewById(R.id.barTab);
        barTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BarActivity.class);
                startActivity(intent);
            }
        });
        Button buildTab = (Button)getView().findViewById(R.id.buildTab);
        buildTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BuildActivity.class);
                startActivity(intent);
            }
        });

    }

    /*public void ButtonOnClick(View v) {
        switch (v.getId()) {
            case R.id.universityTab:
                startActivity(new Intent(getActivity(),MapActivity.class));
                break;
            case R.id.libraryTab:
                startActivity(new Intent(getActivity(),LibraryActivity.class));
                break;
            case R.id.barTab:
                startActivity(new Intent(getActivity(),BarActivity.class));
                break;
            case R.id.buildTab:
                startActivity(new Intent(getActivity(),BuildActivity.class));
                break;
        }
    }*/

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the TestActivity and potentially other fragments contained in that
     * TestActivity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}