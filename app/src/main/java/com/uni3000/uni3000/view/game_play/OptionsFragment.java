package com.uni3000.uni3000.view.game_play;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.model.DatabaseObject.Vocab;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public class OptionsFragment extends Fragment implements OnClickListener {
    private OptionsFragment.OnQuestionInteractionListener mListener;
    private Button buttonOk;
    private Button buttonNext;
    private RadioButton correctButton;
    private RadioGroup optionsGroup;
    private List<RadioButton> options;
    private boolean finished = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonNext = (Button)getView().findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
        buttonOk = (Button)getView().findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(this);
        optionsGroup = (RadioGroup)getView().findViewById(R.id.options_list);
        options = new ArrayList<RadioButton>();
        options.add((RadioButton) getView().findViewById(R.id.option1));
        options.add((RadioButton) getView().findViewById(R.id.option2));
        options.add((RadioButton) getView().findViewById(R.id.option3));
        options.add((RadioButton) getView().findViewById(R.id.option4));
        options.add((RadioButton) getView().findViewById(R.id.option5));
        mListener.showOptions();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof OnQuestionInteractionListener) {
            mListener = (OnQuestionInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnQuestionInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnQuestionInteractionListener {
        public void showOptions();
        public void updateScore(boolean correct);
        public void showResults();
    }

    public void setupOptions(List<Vocab> vocabList, Vocab answer) {
        int answerIndex = (int)(Math.random() * 5);
        options.get(answerIndex).setText(answer.getVocabDefinition().getDefinition());
        for (int i = 0, j = 0; i < vocabList.size() && j < options.size() + 1; i++, j++) {
            if (answerIndex == j) {
                correctButton = options.get(j);
                i--;
                continue;
            }
            options.get(j).setOnClickListener(this);
            options.get(j).setText(vocabList.get(i).getVocabDefinition().getDefinition());
        }
    }

    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.buttonNext:
                if (finished) {
                    mListener.showResults();
                } else {
                    optionsGroup.clearCheck();
                    mListener.showOptions();
                    buttonNext.setVisibility(View.GONE);
                    this.controlRadioGroup(true);
                }
                break;
            case R.id.buttonOk:
                buttonOk.setVisibility(View.GONE);
                buttonNext.setVisibility(View.VISIBLE);
                this.controlRadioGroup(false);
                this.showCorrectAnswer();
                mListener.updateScore(isCorrectAnswer());
                break;
            case R.id.option1:
            case R.id.option2:
            case R.id.option3:
            case R.id.option4:
            case R.id.option5:
                buttonOk.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void isFinished() {
        finished = true;
    }

    // Helper functions
    private void showCorrectAnswer() {
        correctButton.setTextColor(Color.GREEN);
    }

    private boolean isCorrectAnswer() {
        return correctButton.isChecked();
    }

    private void controlRadioGroup(boolean enabled) {
        for (int i = 0; i < options.size(); i++) {
            if (enabled) {
                options.get(i).setTextColor(Color.BLACK);
            } else {
                options.get(i).setTextColor(Color.GRAY);
            }
            options.get(i).setEnabled(enabled);
        }
    }
}