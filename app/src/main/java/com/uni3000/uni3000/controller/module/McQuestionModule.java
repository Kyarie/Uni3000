package com.uni3000.uni3000.controller.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import com.uni3000.uni3000.data.DatabaseInitializer;
import com.uni3000.uni3000.data.DatabaseManager;
import com.uni3000.uni3000.data.DatabaseHelper;
import com.uni3000.uni3000.model.Interface.IMcQuestion;
import com.uni3000.uni3000.model.McQuestion;

@Module
public class McQuestionModule {

    private final Context context;

    public McQuestionModule(Context context) {
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
        return new McQuestion(dbHelper);
    }
}
