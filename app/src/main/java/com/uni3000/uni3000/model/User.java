package com.uni3000.uni3000.model;

public class User {
    public String username;
    public int level;


    public User() {
        this.username = this.getCurrentUsername();
        this.level = this.getCurrentUserLevel();
    }

    String getCurrentUsername() {
        // Get from storage
        return "Bob";
    }

    int getCurrentUserLevel() {
        // Get from storage
        return 0;
    }
}
