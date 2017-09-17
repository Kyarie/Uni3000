package com.uni3000.uni3000.controller;

import javax.inject.Inject;
import com.uni3000.uni3000.data.DatabaseManager;
import com.uni3000.uni3000.model.Vocab_Word;
import com.uni3000.uni3000.model.Interface.IMcQuestion;

import java.util.List;

public class McQuestionController {
    private IMcQuestion mcQues;

    @Inject
    public McQuestionController(IMcQuestion mcQues) {
        this.mcQues = mcQues;
    }

    public String getWord() {
        mcQues.initQuestion();
        return "success";
    }
}
