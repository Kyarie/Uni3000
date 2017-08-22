package com.uni3000.uni3000.controller.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import com.uni3000.uni3000.data.AppDatabase;
import com.uni3000.uni3000.data.DatabaseOpenHelper;

@Module
public class VocabModule {

    private final Context context;

    public VocabModule (Context context) {
        this.context = context;
    }

    @Provides //scope is not necessary for parameters stored within the module
    public Context context() {
        return context;
    }

    @Provides @Singleton
    DatabaseOpenHelper provideUser(Context context){
        return new DatabaseOpenHelper(context);
    }

    @Provides @Singleton
    AppDatabase provideAppDatabase(DatabaseOpenHelper dbHelper){
        return new AppDatabase(dbHelper);
    }
}
