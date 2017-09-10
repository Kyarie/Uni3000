package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.Vocab_Word;

import java.util.ArrayList;

public interface IMcQuestion {
    public void initQuestion();
    public Vocab_Word getAnswer();
    public String getQuestion();
    public ArrayList<Vocab_Word> getOptions();
}
