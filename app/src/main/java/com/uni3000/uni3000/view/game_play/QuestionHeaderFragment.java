package com.uni3000.uni3000.view.game_play;

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

public class QuestionHeaderFragment extends Fragment {
    private OnHeaderInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_header, container, false);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof OnHeaderInteractionListener) {
            mListener = (OnHeaderInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnHeaderInteractionListener {
        public void updateScore();
    }

    public void setupQuestion(String question) {
        TextView questionText = (TextView) getView().findViewById(R.id.questionText);
        questionText.setText(question);
    }
}
