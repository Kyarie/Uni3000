package com.uni3000.uni3000.controller;

import com.uni3000.uni3000.model.DatabaseObject.Vocab;
import com.uni3000.uni3000.model.Interface.IMcQuestion;

import java.util.List;

import javax.inject.Inject;

public class LearnController {
    private IMcQuestion mcQues;

    @Inject
    public LearnController(IMcQuestion mcQues) {
        this.mcQues = mcQues;
    }

    public List<Vocab> getAllActiveVocab() {
        return mcQues.getAllActiveVocab();
    }
}
