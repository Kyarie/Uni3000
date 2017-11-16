package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.Location;

import java.util.List;

public interface ILocationHelper {
    public List<Location> getAvailableLocation();
    public void buy(Location item);
}
