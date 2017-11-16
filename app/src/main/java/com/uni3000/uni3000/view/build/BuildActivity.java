package com.uni3000.uni3000.view.build;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.controller.BuildingStoreController;
import com.uni3000.uni3000.controller.module.ControllerModule;
import com.uni3000.uni3000.di.ControllerCreator;
import com.uni3000.uni3000.di.DaggerControllerCreator;
import com.uni3000.uni3000.model.StoreItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BuildActivity extends AppCompatActivity implements HasSupportFragmentInjector,
        StoreFragment.OnFragmentInteractionListener {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    BuildingStoreController buildingStoreController;
    Map<String, StoreItem> storeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);
        ControllerCreator creator = DaggerControllerCreator.builder().controllerModule(new ControllerModule(this)).build();
        buildingStoreController = creator.provideBuildingStoreController();
        storeItems = new HashMap<String, StoreItem>();
        this.loadStoreItems();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void loadStoreItems() {
        List<StoreItem> availableItem = buildingStoreController.getAvailableItems();
        StoreFragment storeFragment = (StoreFragment) getSupportFragmentManager().findFragmentById(R.id.item_list);
        for (StoreItem item : availableItem) {
            storeItems.put(item.nameId, item);
            storeFragment.showItems(item);
        }
    }

    public void buyItem(String itemName) {
        buildingStoreController.buy(storeItems.get(itemName));
    }

    public void sellItem(String itemName) { buildingStoreController.sell(storeItems.get(itemName));}

}

