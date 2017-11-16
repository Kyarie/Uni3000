package com.uni3000.uni3000.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Vocab {

    @DatabaseField(columnName = "VOCAB_ID", generatedId=true)
    private int vocabId;

    @DatabaseField(columnName = "VOCAB_WORD_ID", foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
    private Vocab_Word vocabWord;

    @DatabaseField(columnName = "VOCAB_DEFINITION_ID", foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
    private Vocab_Definition vocabDefinition;

    public void setVocabId(int vocabId) {
        this.vocabId = vocabId;
    }

    public int getVocabId() {
        return vocabId;
    }

    public void setVocabWord(Vocab_Word vocabWord) {
        this.vocabWord = vocabWord;
    }

    public Vocab_Word getVocabWord() {
        return vocabWord;
    }

    public void setVocabDefinition(Vocab_Definition vocabDefinition) {
        this.vocabDefinition = vocabDefinition;
    }

    public Vocab_Definition getVocabDefinition() {
        return vocabDefinition;
    }

}
