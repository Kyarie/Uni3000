package com.uni3000.uni3000.view.game_play;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.module.McQuestionModule;
import com.uni3000.uni3000.di.ControllerCreator;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.controller.McQuestionController;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import android.support.v4.app.FragmentTransaction;

public class QuestionActivity extends AppCompatActivity implements HasSupportFragmentInjector,
        OptionsFragment.OnQuestionInteractionListener {

    McQuestionController quesController;
    OptionsFragment optionsFragment;
    QuestionHeaderFragment headerFragment;
    int score;
    int totalQuestionNumber;
    int currentQuestionNumber;
    int correctAnswerNumber;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        if (savedInstanceState != null) {
            return;
        }
        optionsFragment = new OptionsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.bottomOptions, optionsFragment).commit();

        ControllerCreator creator = DaggerControllerCreator.builder().mcQuestionModule(new McQuestionModule(this)).build();
        quesController = creator.provideMcQuestionController();
        score = 0;
        totalQuestionNumber = 3; // TODO: get from quest database
        currentQuestionNumber = 0;
        correctAnswerNumber = 0;
        headerFragment = (QuestionHeaderFragment) getSupportFragmentManager().findFragmentById(R.id.topView);
        this.updateScore(false);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void showOptions() {
        quesController.initQuestion();
        optionsFragment.setupOptions(quesController.getOptions(), quesController.getAnswer());
        currentQuestionNumber++;
        String currentQuestion = Integer.toString(currentQuestionNumber) + "/" + Integer.toString(totalQuestionNumber);
        headerFragment.setupQuestion(quesController.getAnswer().getVocabWord().getWord(), currentQuestion);
    }

    public void updateScore(boolean correct) {
        if (correct) {
            score += 10;
            correctAnswerNumber++;
        }
        headerFragment.updateScore(score);
        if (isFinished()) {
            optionsFragment.isFinished();
        }
    }

    public void showResults() {
        GameResultFragment gameResultFragment = new GameResultFragment();
        Bundle result = new Bundle();
        result.putInt("score", score);
        result.putInt("correctNumber", correctAnswerNumber);
        gameResultFragment.setArguments(result);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottomOptions, gameResultFragment);
        transaction.commit();
    }

    public boolean isFinished() {
        return currentQuestionNumber == totalQuestionNumber;
    }
}
