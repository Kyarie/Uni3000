package com.uni3000.uni3000.model;

import com.uni3000.uni3000.model.Interface.IUser;

public class User implements IUser {
    public String username;
    public int level;


    public User() {
        this.username = this.getCurrentUsername();
        this.level = this.getCurrentUserLevel();
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
