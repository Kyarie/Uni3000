package com.uni3000.uni3000.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.uni3000.uni3000.model.Interface.IUser;

public class User implements IUser {
    private static String username;
    private static int level;
    private static Context context;

    //create shared preference
    private static final String PREFS_NAME="prefs";


    public User(Context context) {
        User.username = User.getCurrentUsername();
        User.level = User.getCurrentUserLevel();
        User.context = context;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    //set Shared Preference
    public static void setCurrentUsername(String input) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username_key", input);
        editor.apply();
    }

    public static void setCurrentUserLevel(int input) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("userLevel_key", input);
        editor.apply();
    }

    //get Shared Preference
    public static String getCurrentUsername(){
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return settings.getString("username_key", "default_username");
    }

    public static int getCurrentUserLevel(){
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return settings.getInt("userLevel_key", 1);
    }
}
