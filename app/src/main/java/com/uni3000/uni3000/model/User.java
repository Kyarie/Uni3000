package com.uni3000.uni3000.model;

import android.content.Context;

import com.uni3000.uni3000.model.Interface.IUser;

public class User implements IUser {
    private String username;
    private int level;
    private Context context;


    public User(Context context) {
        this.username = this.getCurrentUsername();
        this.level = this.getCurrentUserLevel();
        this.context = context;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    // Helper function

    String getCurrentUsername() {
        // Get from storage
        return "Bob";
    }

    int getCurrentUserLevel() {
        // Get from storage
        return 0;
    }
}
