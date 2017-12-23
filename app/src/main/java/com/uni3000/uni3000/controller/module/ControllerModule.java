package com.uni3000.uni3000.controller.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import com.uni3000.uni3000.data.DatabaseInitializer;
import com.uni3000.uni3000.data.DatabaseManager;
import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.Interface.IStoreManager;
import com.uni3000.uni3000.model.Interface.IMcQuestion;
import com.uni3000.uni3000.model.Interface.IQuestHelper;
import com.uni3000.uni3000.model.Interface.IUser;
import com.uni3000.uni3000.model.LocationHelper;
import com.uni3000.uni3000.model.VocabData;
import com.uni3000.uni3000.model.QuestHelper;
import com.uni3000.uni3000.model.User;

@Module
public class ControllerModule {

    private final Context context;

    public ControllerModule(Context context) {
        this.context = context;
    }

    @Provides //scope is not necessary for parameters stored within the module
    public Context context() {
        return context;
    }

    @Provides @Singleton
    DatabaseInitializer provideDatabaseInitializer(Context context){
        return new DatabaseInitializer(context);
    }

    @Provides @Singleton
    DatabaseHelper provideDatabaseHelper(Context context, DatabaseInitializer initializer){
        return new DatabaseHelper(context, initializer);
    }

    @Provides @Singleton
    DatabaseManager provideAppDatabase(DatabaseHelper dbHelper){
        return new DatabaseManager(dbHelper);
    }

    @Provides
    IMcQuestion provideIMcQuestion(DatabaseHelper dbHelper){
        return new VocabData(dbHelper);
    }

    @Provides
    IQuestHelper provideIQuestHelper(DatabaseHelper dbHelper){
        return new QuestHelper(dbHelper);
    }

    @Provides
    IStoreManager provideIBuildingStore(DatabaseHelper dbHelper) {
        return new LocationHelper(dbHelper);
    }

    @Provides @Singleton
    IUser provideIUser(Context context) {
        return new User(context);
    }
}
