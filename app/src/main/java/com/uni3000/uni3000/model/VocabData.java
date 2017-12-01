package com.uni3000.uni3000.model;

import com.j256.ormlite.stmt.QueryBuilder;
import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.DatabaseObject.Vocab;
import com.uni3000.uni3000.model.DatabaseObject.Vocab_Word;
import com.uni3000.uni3000.model.Interface.IMcQuestion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VocabData implements IMcQuestion{
    Vocab answer;
    List<Vocab> options;
    List<Vocab> usedVocab;
    static final int OPTIONS_COUNT = 4;
    int round;
    private DatabaseHelper db;

    public VocabData(DatabaseHelper db) {
        this.db = db;
        answer = null;
        options = new ArrayList<Vocab>();
        usedVocab = new ArrayList<Vocab>();
        round = 1;
    }

    public void initQuestion() {
        this.answer = this.generateAnswer();
        usedVocab.add(this.answer);
        this.options = this.generateOptions();
    }

    public Vocab getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return answer.getVocabWord().getWord();
    }

    public List<Vocab> getOptions() {
        return options;
    }

    public List<Vocab> getAllActiveVocab() {
        List<Vocab> vocabList = null;
        try {
            QueryBuilder<Vocab_Word,String> vocabWordQuery = db.getVocabWordDao().queryBuilder();
            vocabWordQuery.where().eq(Vocab_Word.STATUS, 'U').or().eq(Vocab_Word.STATUS, 'N');
            vocabList = db.getVocabDao().queryBuilder().where().in(Vocab.VOCAB_WORD_ID, vocabWordQuery.query()).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vocabList;
    }

    // Helper functions
    private Vocab generateAnswer() {
        List<Vocab> vocab = this.getRandomVocab(1);
        // TODO: Exception or assert???
        return vocab.get(0);
    }

    private List<Vocab> generateOptions() {
        List<Vocab> vocab = this.getRandomVocab(OPTIONS_COUNT);
        return vocab;
    }

    private List<Vocab> getRandomVocab(int number) {
        List<Vocab> vocabList = null;
        String query = "SELECT * FROM VOCAB";
        if (this.usedVocab.size() > 0) {
            query += " WHERE VOCAB.VOCAB_ID <> " + this.usedVocab.get(0).getVocabId();
        }
        for (int i = 1; i < this.usedVocab.size(); i++){
            query += " AND VOCAB.VOCAB_ID <> " + this.usedVocab.get(i).getVocabId();
        }
        query += " ORDER BY RANDOM() LIMIT " + Integer.toString(number);
        try {
            vocabList = db.getVocabDao().queryRaw(query, db.getVocabDao().getRawRowMapper()).getResults();
            //vocabList = db.getVocabDao().queryBuilder().where().raw("VOCAB_ID >= (ABS(RANDOM()) % MAX(VOCAB_ID) + 1)").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vocabList;
    }
}
