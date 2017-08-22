package com.uni3000.uni3000.controller;

import javax.inject.Inject;
import com.uni3000.uni3000.data.AppDatabase;

public class VocabController {
    private AppDatabase db;

    @Inject
    public VocabController(AppDatabase db) {
        this.db = db;
    }

    public String getWord() {
        return db.getWord();
    }
}
