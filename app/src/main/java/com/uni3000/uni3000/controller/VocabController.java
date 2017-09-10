package com.uni3000.uni3000.controller;

import javax.inject.Inject;
import com.uni3000.uni3000.data.DatabaseManager;
import com.uni3000.uni3000.model.Vocab_Word;

import java.util.List;

public class VocabController {
    private DatabaseManager db;

    @Inject
    public VocabController(DatabaseManager db) {
        this.db = db;
    }

    public String getWord() {
        List<Vocab_Word> vw = db.getAllVocabWord();
        return "success";
    }
}
