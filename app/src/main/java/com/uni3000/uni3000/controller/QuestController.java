package com.uni3000.uni3000.controller;

import com.uni3000.uni3000.model.Action_Button;
import com.uni3000.uni3000.model.Interface.IMcQuestion;
import com.uni3000.uni3000.model.Interface.IQuestHelper;

import java.util.List;

import javax.inject.Inject;

public class QuestController {

    IQuestHelper questHelper;

    @Inject
    public QuestController(IQuestHelper questHelper) {
        this.questHelper = questHelper;
    }

    public List<Action_Button> getActiveActionButtonByLocation(String location) {
        return questHelper.getActiveActionButtonByLocation(location);
    }
}
