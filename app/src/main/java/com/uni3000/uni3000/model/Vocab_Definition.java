package com.uni3000.uni3000.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Vocab_Definition {

    @DatabaseField(columnName = "VOCAB_DEFINITION_ID", generatedId=true)
    private int vocabDefinitionId;

    @DatabaseField(columnName = "PARTS_OF_SPEECH")
    private String partsOfSpeech;

    @DatabaseField(columnName = "DEFINITION")
    private String definition;

    @DatabaseField(columnName = "EXAMPLE")
    private String example;

    public void setVocabDefinitionId(int vocabDefinitionId) {
        this.vocabDefinitionId = vocabDefinitionId;
    }

    public int getVocabDefinitionId() {
        return vocabDefinitionId;
    }

    public void setPartsOfSpeech(String partsOfSpeech) {
        this.partsOfSpeech = partsOfSpeech;
    }

    public String getPartsOfSpeech() {
        return partsOfSpeech;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }
}

