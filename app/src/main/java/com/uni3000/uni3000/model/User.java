package com.uni3000.uni3000.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.uni3000.uni3000.model.Interface.IUser;

public class User implements IUser {
    private String username;
    private int level;
    //private Context context;

    //create shared preference
    private static final String PREFS_NAME="prefs";

    public User(Context context) {
        this.username = User.getCurrentUsername(context);
        this.level = User.getCurrentUserLevel(context);
        //this.context = context;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    //set Shared Preference
    public static void setCurrentUsername(Context context, String input) {
        //SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("username_key", input);
        editor.apply();
    }

    public static void setCurrentUserLevel(Context context, int input) {
        //SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putInt("userLevel_key", input);
        editor.apply();
    }

    //get Shared Preference
    public static String getCurrentUsername(Context context){
        //SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return getPrefs(context).getString("username_key", "default_username");
    }

    public static int getCurrentUserLevel(Context context){
        //SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,0);
        return getPrefs(context).getInt("userLevel_key", 1);
    }
}
