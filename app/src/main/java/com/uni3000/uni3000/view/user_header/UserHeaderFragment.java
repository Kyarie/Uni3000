package com.uni3000.uni3000.view.user_header;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni3000.uni3000.R;
import dagger.android.support.AndroidSupportInjection;
import com.uni3000.uni3000.controller.UserController;
import com.uni3000.uni3000.controller.McQuestionController;

import com.uni3000.uni3000.controller.module.ControllerModule;
import com.uni3000.uni3000.viewmodel.UserViewModel;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.di.ControllerCreator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserHeaderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserHeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserHeaderFragment extends Fragment {

    UserController userController;

    UserViewModel user;

    McQuestionController vocabController;

    private OnFragmentInteractionListener mListener;

    public UserHeaderFragment() {
        // Required empty public constructor
    }

    public static UserHeaderFragment newInstance() {
        UserHeaderFragment fragment = new UserHeaderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ControllerCreator creator = DaggerControllerCreator.builder().controllerModule(new ControllerModule(this.getContext())).build();
        userController = creator.provideUserController();
        user = userController.getCurrentUserInfo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_header, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView usernameText = (TextView)getView().findViewById(R.id.username);
        usernameText.setText(user.username);
        TextView levelText = (TextView)getView().findViewById(R.id.userLevel);
        levelText.setText(Integer.toString(user.level));
    }

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
        /*
        if (context instanceof OnFragmentInteractionListener) {
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
