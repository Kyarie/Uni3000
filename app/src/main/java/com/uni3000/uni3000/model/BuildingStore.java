package com.uni3000.uni3000.model;

import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.Interface.IBuildingStore;

import java.util.List;

public class BuildingBuildingStore implements IBuildingStore {

    private DatabaseHelper db;

    public BuildingBuildingStore(DatabaseHelper db) {
        this.db = db;
    }

    public List<Location> getAvailableItems() {
        List<Location> buildings = 

    }

    public void buy(String itemName) {

    }
}
