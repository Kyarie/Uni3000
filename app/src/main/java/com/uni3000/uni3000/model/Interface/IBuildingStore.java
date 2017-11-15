package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.Location;

import java.util.List;

public interface IStoreHelper {
    public List<Location> getAvailableItems();
    public void buy(String itemName);
}
