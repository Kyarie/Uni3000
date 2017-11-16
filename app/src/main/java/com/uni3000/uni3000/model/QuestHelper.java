package com.uni3000.uni3000.model;

import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.DatabaseObject.Action_Button;
import com.uni3000.uni3000.model.DatabaseObject.Location;
import com.uni3000.uni3000.model.Interface.IQuestHelper;

import java.sql.SQLException;
import java.util.List;

public class QuestHelper implements IQuestHelper {

    private DatabaseHelper db;

    public QuestHelper(DatabaseHelper db) {
        this.db = db;
    }

    public List<Action_Button> getActiveActionButtonByLocation(String location) {
        List<Action_Button> actionButtons = null;
        try {
            Location loc = db.getLocationDao().queryBuilder().where().eq(Location.LOCATION_NAME, location).queryForFirst();
            actionButtons = db.getActionButtonDao().queryBuilder().where().eq(Action_Button.LOCATION_ID, loc.getLocationId()).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actionButtons;
    }

    public List<Location> getActiveLocation() {
        List<Location> locations = null;
        try {
            locations = db.getLocationDao().queryBuilder().where().eq(Location.PURCHASE_STATUS, 'B').query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

}
