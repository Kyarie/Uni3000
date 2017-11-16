package com.uni3000.uni3000.model.Interface;

import com.uni3000.uni3000.model.StoreItem;

import java.util.List;

public interface IStoreManager {
    public List<StoreItem> getAvailableItems();
    public void buy(StoreItem item);
    public void sell(StoreItem item);
}
