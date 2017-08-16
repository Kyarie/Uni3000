package com.uni3000.uni3000.controller;

import dagger.Module;

import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.Provides;
import com.uni3000.uni3000.model.User;
import com.uni3000.uni3000.viewmodel.UserViewModel;

public class UserController {

    @Inject
    public UserController() {
        this.user = new User();
    }

    User user;

    public UserViewModel getCurrentUserInfo() {
        return new UserViewModel(this.user.username, this.user.level);
    }
}
