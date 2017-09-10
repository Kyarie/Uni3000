package com.uni3000.uni3000.data;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

import com.uni3000.uni3000.model.Vocab_Word;

public class DatabaseManager {

    private DatabaseHelper dbHelper;

    @Inject
    public DatabaseManager(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Vocab_Word> getAllVocabWord() {
        List<Vocab_Word> vocabWord = null;
        try {
            vocabWord = this.dbHelper.getVocabWordDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vocabWord;
    }
}