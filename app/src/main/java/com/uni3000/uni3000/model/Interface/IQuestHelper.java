package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.Action_Button;
import com.uni3000.uni3000.model.Location;
import com.uni3000.uni3000.model.Quest_Action;

import java.util.List;

public interface IQuestHelper {
    public List<Action_Button> getActiveActionButtonByLocation(String location);
    public List<Location> getActiveLocation();
}
