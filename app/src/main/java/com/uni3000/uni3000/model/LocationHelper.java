package com.uni3000.uni3000.model;

import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.Interface.IBuildingStore;

import java.sql.SQLException;
import java.util.List;

public class BuildingStore implements IBuildingStore {

    private DatabaseHelper db;

    public BuildingStore(DatabaseHelper db) {
        this.db = db;
    }

    public List<Location> getAvailableItems() {
        List<Location> buildings = null;
        try {
            buildings = db.getLocationDao().queryBuilder().where().eq(Location.PURCHASE_STATUS, 'A').query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    public void buy(Location item) {
        item.setPurhcaseStatus('B');
        try {
            db.getLocationDao().update(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
