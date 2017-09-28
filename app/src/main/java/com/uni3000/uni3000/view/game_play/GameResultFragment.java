package com.uni3000.uni3000.view.game_play;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.view.bar.BarActivity;

import dagger.android.support.AndroidSupportInjection;

public class GameResultFragment extends Fragment implements OnClickListener {
    TextView scoreResult;
    TextView correctAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_result, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle result = getArguments();
        int score = result.getInt("score");
        scoreResult = (TextView) getView().findViewById(R.id.scoreResult);
        scoreResult.setText("Score: " + Integer.toString(score));
        int correctNumber = result.getInt("correctNumber");
        correctAnswer = (TextView) getView().findViewById(R.id.correctAnswer);
        correctAnswer.setText("Correct: " + Integer.toString(correctNumber));
        Button buttonExit = (Button)getView().findViewById(R.id.buttonExitQuestion);
        buttonExit.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.buttonExitQuestion:
                Intent intent = new Intent(getActivity(), BarActivity.class);
                startActivity(intent);
                break;
        }
    }
}
