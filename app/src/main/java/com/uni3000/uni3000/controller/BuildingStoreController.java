package com.uni3000.uni3000.controller;

import com.uni3000.uni3000.model.Interface.IStoreManager;
import com.uni3000.uni3000.model.StoreItem;

import java.util.List;

import javax.inject.Inject;

public class BuildingStoreController {

    IStoreManager buildingStore;

    @Inject
    public BuildingStoreController(IStoreManager buildingStore) {
        this.buildingStore = buildingStore;
    }

    public List<StoreItem> getAvailableItems() {
        return buildingStore.getAvailableItems();
    }

    public void buy(StoreItem item) {
        buildingStore.buy(item);
        // TODO: user profit change
    }

    public void sell(StoreItem item) {
        buildingStore.sell(item);
        // TODO: user profit change
    }
}
