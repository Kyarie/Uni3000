package com.uni3000.uni3000.view.dialog.quest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.uni3000.uni3000.R;

import dagger.android.support.AndroidSupportInjection;

public class QuestFragment extends android.support.v4.app.DialogFragment {
    private QuestFragment.OnFragmentInteractionListener mListener;

    public QuestFragment() {
        // Required empty public constructor
    }

    public static QuestFragment newInstance() {
        QuestFragment fragment = new QuestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quest, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonOK = (Button)getView().findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        RadioButton option1 = (RadioButton) getView().findViewById(R.id.option1);
        option1.setText(R.string.option1);
        RadioButton option2 = (RadioButton) getView().findViewById(R.id.option2);
        option2.setText(R.string.option2);
        RadioButton option3 = (RadioButton) getView().findViewById(R.id.option3);
        option3.setText(R.string.option3);
        RadioButton option4 = (RadioButton) getView().findViewById(R.id.option4);
        option4.setText(R.string.option4);
        RadioButton option5 = (RadioButton) getView().findViewById(R.id.option5);
        option5.setText(R.string.option5);

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