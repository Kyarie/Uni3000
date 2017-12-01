package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.DatabaseObject.Vocab;

import java.util.List;

public interface IMcQuestion {
    public void initQuestion();
    public Vocab getAnswer();
    public String getQuestion();
    public List<Vocab> getOptions();
    public List<Vocab> getAllActiveVocab();
}
