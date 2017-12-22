package com.uni3000.uni3000.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.uni3000.uni3000.model.Interface.IUser;

public class User implements IUser {
    private String username;
    private int level;
    private Context context;

    //create shared preference
    private static final String PREFS_NAME="prefs";


    public User(Context context) {
        this.username = this.getCurrentUsername(context);
        this.level = this.getCurrentUserLevel(context);
        this.context = context;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    //set Shared Preference
    public static void setCurrentUsername(Context context, String input) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username_key", input);
        editor.commit();
    }

    public static void setCurrentUserLevel(Context context, int input) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("userLevel_key", input);
        editor.commit();
    }

    //get Shared Preference
    public static String getCurrentUsername(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return settings.getString("username_key", "default_username");
    }

    public static int getCurrentUserLevel(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return settings.getInt("userLevel_key", 1);
    }
}
