package com.uni3000.uni3000.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Quest {

    @DatabaseField(columnName = "QUEST_ID", generatedId=true)
    private int questID;

    @DatabaseField(columnName = "QUEST_NAME")
    private String questName;

    @DatabaseField(columnName = "UNLOCK_LEVEL")
    private int unlockLevel;

    @DatabaseField(columnName = "QUEST_TYPE")
    private char questType;

    @DatabaseField(columnName = "QUEST_STATUS")
    private char questStatus;

    public int getQuestID() {
        return questID;
    }

    public void setQuestID(int questID) {
        this.questID = questID;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public int getUnlockLevel() {
        return unlockLevel;
    }

    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }

    public char getQuestType() {
        return questType;
    }

    public void setQuestType(char questType) {
        this.questType = questType;
    }

    public char getQuestStatus() {
        return questStatus;
    }

    public void setQuestStatus(char questStatus) {
        this.questStatus = questStatus;
    }
}
