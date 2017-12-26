package com.uni3000.uni3000.controller;

import android.content.Context;

import javax.inject.Inject;

import com.uni3000.uni3000.model.User;
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

    public void setCurrentUsername(Context context,String input){
        User.setCurrentUsername(context,input);
    }

}
