package com.uni3000.uni3000.model;

import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.DatabaseObject.Location;
import com.uni3000.uni3000.model.Interface.IStoreManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationHelper implements IStoreManager {

    private DatabaseHelper db;

    public LocationHelper(DatabaseHelper db) {
        this.db = db;
    }

    public List<StoreItem> getAvailableItems() {
        List<Location> buildings = null;
        try {
            buildings = db.getLocationDao().queryBuilder().where().eq(Location.LOCATION_TYPE, 'B').query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return multipleLocationToStoreItem(buildings);
    }

    public void buy(StoreItem item) {
        Location loc = getLocationByName(item.nameId);
        loc.setPurhcaseStatus('B');
        try {
            db.getLocationDao().update(loc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sell(StoreItem item) {
        Location loc = getLocationByName(item.nameId);
        loc.setPurhcaseStatus('A');
        try {
            db.getLocationDao().update(loc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper functions
    private List<StoreItem> multipleLocationToStoreItem(List<Location> locs) {
        List<StoreItem> storeItemList = new ArrayList<StoreItem>();
        for (Location loc : locs) {
            storeItemList.add(singleLocationToStoreItem(loc));
        }
        return storeItemList;
    }

    private StoreItem singleLocationToStoreItem(Location loc) {
        StoreItem storeItem = new StoreItem();
        storeItem.nameId = loc.getLocationName();
        storeItem.label = loc.getLocationName();
        storeItem.price = loc.getLocationCost();
        storeItem.profit = loc.getLocationBaseProfit();
        storeItem.status = loc.getPurhcaseStatus();
        return storeItem;
    }

    private Location getLocationByName(String name) {
        Location loc = null;
        try {
            loc = db.getLocationDao().queryBuilder().where().eq(Location.LOCATION_NAME, name).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loc;
    }

}
