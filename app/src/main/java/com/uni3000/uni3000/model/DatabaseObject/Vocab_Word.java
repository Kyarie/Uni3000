package com.uni3000.uni3000.model;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Vocab_Word {

    @DatabaseField(columnName = "VOCAB_WORD_ID", generatedId=true)
    private int vocabWordId;

    @DatabaseField(columnName = "WORD")
    private String word;

    @DatabaseField(columnName = "STATUS")
    private char status;

    public void setVocabId(int vocabWordId) {
        this.vocabWordId = vocabWordId;
    }

    public int getVocabId() {
        return vocabWordId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getStatus() {
        return status;
    }

    //public String definition;
    //public String partsOfSpeech;
    //public String example;
}
