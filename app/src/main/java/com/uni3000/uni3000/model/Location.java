package com.uni3000.uni3000.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Location {

    public static final String LOCATION_ID = "LOCATION_ID";
    public static final String LOCATION_NAME = "LOCATION_NAME";
    public static final String LOCATION_TYPE = "LOCATION_TYPE";
    public static final String LOCATION_COST = "LOCATION_COST";
    public static final String LOCATION_BASE_PROFIT = "LOCATION_BASE_PROFIT";
    public static final String PURCHASE_STATUS = "PURCHASE_STATUS";

    @DatabaseField(columnName = LOCATION_ID, generatedId=true)
    private int locationId;

    @DatabaseField(columnName = LOCATION_NAME)
    private String locationName;

    @DatabaseField(columnName = LOCATION_TYPE)
    private char locationType;

    @DatabaseField(columnName = LOCATION_COST)
    private int locationCost;

    @DatabaseField(columnName = LOCATION_BASE_PROFIT)
    private int locationBaseProfit;

    @DatabaseField(columnName = PURCHASE_STATUS)
    private char purhcaseStatus;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public char getLocationType() {
        return locationType;
    }

    public void setLocationType(char locationType) {
        this.locationType = locationType;
    }

    public int getLocationCost() {
        return locationCost;
    }

    public void setLocationCost(int locationCost) {
        this.locationCost = locationCost;
    }

    public int getLocationBaseProfit() {
        return locationBaseProfit;
    }

    public void setLocationBaseProfit(int locationBaseProfit) {
        this.locationBaseProfit = locationBaseProfit;
    }

    public char getPurhcaseStatus() {
        return purhcaseStatus;
    }

    public void setPurhcaseStatus(char purhcaseStatus) {
        this.purhcaseStatus = purhcaseStatus;
    }
}
