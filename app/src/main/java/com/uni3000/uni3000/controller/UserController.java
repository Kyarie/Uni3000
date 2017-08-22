package com.uni3000.uni3000.controller;

import javax.inject.Inject;

import com.uni3000.uni3000.viewmodel.UserViewModel;
import com.uni3000.uni3000.model.Interface.IUser;

public class UserController {

    private IUser user;

    @Inject
    public UserController(IUser user) {
        this.user = user;
    }

    public UserViewModel getCurrentUserInfo() {
        return new UserViewModel(this.user.getUsername(), this.user.getLevel());
    }
}
