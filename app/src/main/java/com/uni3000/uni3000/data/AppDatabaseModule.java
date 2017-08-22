package com.uni3000.uni3000.data;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import android.content.Context;

@Module
public class AppDatabaseModule {
    private final Context context;

    public AppDatabaseModule (Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }

    @Provides @Singleton
    DatabaseOpenHelper provideUser(Context context){
        return new DatabaseOpenHelper(context);
    }

}
