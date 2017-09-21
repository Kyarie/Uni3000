package com.uni3000.uni3000.view.game_play;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.model.Vocab;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public class OptionsFragment extends Fragment {
    private OptionsFragment.OnQuestionInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonOK = (Button)getView().findViewById(R.id.buttonOK);
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
    }

    public void setupOptions(List<Vocab> vocabList, Vocab answer) {
        List<RadioButton> options = new ArrayList<RadioButton>();
        options.add((RadioButton) getView().findViewById(R.id.option1));
        options.add((RadioButton) getView().findViewById(R.id.option2));
        options.add((RadioButton) getView().findViewById(R.id.option3));
        options.add((RadioButton) getView().findViewById(R.id.option4));
        options.add((RadioButton) getView().findViewById(R.id.option5));
        int answerIndex = (int)(Math.random() * 5);
        options.get(answerIndex).setText(answer.getVocabDefinition().getDefinition());
        for (int i = 0, j = 0; i < vocabList.size() && j < options.size() + 1; i++, j++) {
            if (answerIndex == j) {
                i--;
                continue;
            }
            options.get(j).setText(vocabList.get(i).getVocabDefinition().getDefinition());
        }
    }
}