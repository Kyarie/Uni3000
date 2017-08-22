package com.uni3000.uni3000.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import com.uni3000.uni3000.data.AppDatabaseModule;
import com.uni3000.uni3000.data.AppDatabase;

@Component(modules={AppDatabaseModule.class})
@Singleton
public interface DatabaseComponent {
    Context context();

    void inject(AppDatabase appDatabase);
}