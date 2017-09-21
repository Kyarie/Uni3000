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

public class QuestionActivity extends AppCompatActivity implements HasSupportFragmentInjector,
        OptionsFragment.OnQuestionInteractionListener, QuestionHeaderFragment.OnHeaderInteractionListener {

    McQuestionController quesController;
    int score;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ControllerCreator creator = DaggerControllerCreator.builder().mcQuestionModule(new McQuestionModule(this)).build();
        quesController = creator.provideMcQuestionController();
        score = 0;
        this.showOptions();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void showOptions() {
        quesController.initQuestion();
        OptionsFragment optionsFragment = (OptionsFragment) getSupportFragmentManager().findFragmentById(R.id.bottomOptions);
        optionsFragment.setupOptions(quesController.getOptions(), quesController.getAnswer());
        QuestionHeaderFragment headerFragment = (QuestionHeaderFragment) getSupportFragmentManager().findFragmentById(R.id.topView);
        headerFragment.setupQuestion(quesController.getAnswer().getVocabWord().getWord());
    }

    public void updateScore() {
        score += 10;
    }
}
