package com.uni3000.uni3000.view.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.LearnController;
import com.uni3000.uni3000.controller.module.ControllerModule;
import com.uni3000.uni3000.di.ControllerCreator;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.model.DatabaseObject.Vocab;

import java.util.ArrayList;
import java.util.List;

import dagger.android.AndroidInjection;

public class StudyActivity extends AppCompatActivity {

    LearnController learnController;
    List<Vocab> vocabList;
    EditText vocabFilter;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        ControllerCreator creator = DaggerControllerCreator.builder().controllerModule(new ControllerModule(this)).build();
        learnController = creator.provideLearnController();
        vocabList = learnController.getAllActiveVocab();
        vocabFilter = (EditText) findViewById(R.id.study_search);
        vocabFilter.addTextChangedListener(vocabSearchWatcher);
        setAdapterVocabWords();
    }

    private void setAdapterVocabWords() {
        ArrayList<String> vocabWords = new ArrayList<>();
        for (Vocab vocab : vocabList) {
            vocabWords.add(vocab.getVocabWord().getWord());
        }
        adapter = new ArrayAdapter<>(this, R.layout.study_item, vocabWords);
        ListView listView = (ListView) findViewById(R.id.study_list);
        listView.setAdapter(adapter);
    }

    private TextWatcher vocabSearchWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            adapter.getFilter().filter(s);
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vocabFilter.removeTextChangedListener(vocabSearchWatcher);
    }
}
