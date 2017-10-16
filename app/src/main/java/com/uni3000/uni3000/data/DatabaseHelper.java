package com.uni3000.uni3000.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import java.io.IOException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.uni3000.uni3000.model.Vocab_Word;
import com.uni3000.uni3000.model.Vocab_Definition;
import com.uni3000.uni3000.model.Vocab;
import com.uni3000.uni3000.model.Action_Button;
import com.uni3000.uni3000.model.Location;
import com.uni3000.uni3000.model.Quest;
import com.uni3000.uni3000.model.Quest_Action;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "uni3000_db.sqlite";
    private static final int DATABASE_VERSION = 3;
    //private static final String DATABASE_PATH = "/data/data/com.uni3000.uni3000/databases/";

    // the DAO object we use to access the SimpleData table
    private Dao<Vocab_Word, String> vocabWordDao = null;
    private Dao<Vocab_Definition, String> vocabWordDefinitionDao = null;
    private Dao<Vocab, String> vocabDao = null;
    private Dao<Action_Button, String> actionButtonDao = null;
    private Dao<Location, String> locationDao = null;
    private Dao<Quest, String> questDao = null;
    private Dao<Quest_Action, String> questActionDao = null;
    private final Context context;
    private final DatabaseInitializer initializer;

    public DatabaseHelper(Context context, DatabaseInitializer initializer) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        this.initializer = initializer;
        try {
            initializer.createDatabase();
            initializer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase database,ConnectionSource connectionSource) {
        Log.i(DatabaseHelper.class.getName(), "onCreate");
        /*try {
            TableUtils.createTable(connectionSource, Vocab_Word.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.i(DatabaseHelper.class.getName(), "onUpgrade");
        try {
            initializer.overrideOldDatabase();
            /*
            List<String> allSql = new ArrayList<String>();
            switch(oldVersion)
            {
                case 1:
                    //allSql.add("alter table AdData add column `new_col` VARCHAR");
                    //allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql) {
                db.execSQL(sql);
            }*/
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Vocab_Word, String> getVocabWordDao() {
        if (null == vocabWordDao) {
            try {
                vocabWordDao = getDao(Vocab_Word.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return vocabWordDao;
    }

    public Dao<Vocab_Definition, String> getVocabDefinitionDao() {
        if (null == vocabWordDefinitionDao) {
            try {
                vocabWordDefinitionDao = getDao(Vocab_Definition.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return vocabWordDefinitionDao;
    }

    public Dao<Vocab, String> getVocabDao() {
        if (null == vocabDao) {
            try {
                vocabDao = getDao(Vocab.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return vocabDao;
    }

    public Dao<Action_Button, String> getActionButtonDao() {
        if (null == actionButtonDao) {
            try {
                actionButtonDao = getDao(Action_Button.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return actionButtonDao;
    }

    public Dao<Location, String> getLocationDao() {
        if (null == locationDao) {
            try {
                locationDao = getDao(Location.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return locationDao;
    }

    public Dao<Quest, String> getQuestDao() {
        if (null == questDao) {
            try {
                questDao = getDao(Quest.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return questDao;
    }

    public Dao<Quest_Action, String> getQuestActionDao() {
        if (null == questActionDao) {
            try {
                questActionDao = getDao(Quest_Action.class);
            }catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return questActionDao;
    }
}