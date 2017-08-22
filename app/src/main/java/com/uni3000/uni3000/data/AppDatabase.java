package com.uni3000.uni3000.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import javax.inject.Inject;

//import android.database.Cursor;

public class AppDatabase {
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;
    //private static AppDatabase instance;

    // Private constructor to aboid object creation from outside classes.
    @Inject
    public AppDatabase(DatabaseOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    /**
     * Return a singleton instance of AppDatabase.
     *
     * @param context the Context
     * @return the instance of DabaseAccess

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context);
        }
        return instance;
    }*/

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = dbHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes

    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM quotes", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }*/
}