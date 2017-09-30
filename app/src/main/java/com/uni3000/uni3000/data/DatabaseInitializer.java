package com.uni3000.uni3000.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseInitializer extends SQLiteOpenHelper{

    private static final String DATABASE_PATH = "/data/data/com.uni3000.uni3000/databases/";
    private static final String DATABASE_NAME = "uni3000_db.sqlite";

    private SQLiteDatabase database;
    private final Context context;

    public DatabaseInitializer(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    public void createDatabase() throws IOException {

        boolean dbExist = checkDatabase();

        if(!dbExist){
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }

    }

    private  boolean checkDatabase() {
        File dbFile = this.context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    private void copyDatabase() throws IOException{
        File dir = new File(DATABASE_PATH);
        dir.mkdirs();
        InputStream myInput = context.getAssets().open("databases/" + DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public synchronized void close() {
        if(database != null)
            database.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
