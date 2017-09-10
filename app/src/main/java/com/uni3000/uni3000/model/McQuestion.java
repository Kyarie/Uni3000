package com.uni3000.uni3000.model;

import com.uni3000.uni3000.data.DatabaseManager;
import com.uni3000.uni3000.model.Interface.IMcQuestion;

import java.util.ArrayList;

public class McQuestion implements IMcQuestion{
    Vocab_Word answer;
    ArrayList<Vocab_Word> options;
    private DatabaseManager db;

    McQuestion(DatabaseManager db) {
        this.db = db;
    }

    public Vocab_Word getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return answer.word;
    }

    public ArrayList<Vocab_Word> getOptions() {
        return options;
    }

    public void initQuestion() {
        /*db.openRead();
        Cursor cursor = db.rawQuery("SELECT VC.VOCAB_ID, VW.WORD, VW.STATUS, VD.DEFINITION, VD.PARTS_OF_SPEECH, VD.EXAMPLE FROM VOCAB_WORD VW, VOCAB VC, VOCAB_DEFINITION VD WHERE VW.VOCAB_WORD_ID = VC.VOCAB_WORD_ID AND VC.VOCAB_DEFINITION_ID = VD.VOCAB_DEFINITION_ID ORDER BY RANDOM() LIMIT 5", null);
        cursor.moveToFirst();*/
    }

}
