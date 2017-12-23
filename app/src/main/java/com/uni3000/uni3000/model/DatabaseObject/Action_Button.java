package com.uni3000.uni3000.model.DatabaseObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Action_Button {

    public static final String ACTION_BUTTON_ID = "ACTION_BUTTON_ID";
    public static final String ACTION_BUTTON_LABEL = "ACTION_BUTTON_LABEL";
    public static final String LOCATION_ID = "LOCATION_ID";
    public static final String ACTION_ACTIVITY = "ACTION_ACTIVITY";
    public static final String TYPE = "TYPE";

    @DatabaseField(columnName = ACTION_BUTTON_ID, generatedId=true)
    private int actionButtonId;

    @DatabaseField(columnName = ACTION_BUTTON_LABEL)
    private String actionButtonLabel;

    @DatabaseField(columnName = LOCATION_ID, foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
    private Location location;

    @DatabaseField(columnName = ACTION_ACTIVITY)
    private String actionActivity;

    @DatabaseField(columnName = TYPE)
    private char type;

    public String getActionActivity() {
        return actionActivity;
    }

    public void setActionActivity(String actionActivity) {
        this.actionActivity = actionActivity;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getActionButtonId() {
        return actionButtonId;
    }

    public void setActionButtonId(int actionButtonId) {
        this.actionButtonId = actionButtonId;
    }

    public String getActionButtonLabel() {
        return actionButtonLabel;
    }

    public void setActionButtonLabel(String actionButtonLabel) {
        this.actionButtonLabel = actionButtonLabel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
