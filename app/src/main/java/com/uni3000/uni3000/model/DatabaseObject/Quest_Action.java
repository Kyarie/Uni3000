package com.uni3000.uni3000.model.DatabaseObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Quest_Action {

    public static final String QUEST_ACTION_ID = "QUEST_ACTION_ID";

    @DatabaseField(columnName = QUEST_ACTION_ID, generatedId=true)
    private int questActionId;

    @DatabaseField(columnName = "QUEST_ID", foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
    private Quest quest;

    @DatabaseField(columnName = "ACTION_BUTTON_ID", foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
    private Action_Button actionButton;

    @DatabaseField(columnName = "PROGRESS")
    private int progress;

    @DatabaseField(columnName = "TOTAL_ACTION")
    private int totalAction;

    public int getQuestActionId() {
        return questActionId;
    }

    public void setQuestActionId(int questActionId) {
        this.questActionId = questActionId;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Action_Button getActionButton() {
        return actionButton;
    }

    public void setActionButton(Action_Button actionButton) {
        this.actionButton = actionButton;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getTotalAction() {
        return totalAction;
    }

    public void setTotalAction(int totalAction) {
        this.totalAction = totalAction;
    }
}
