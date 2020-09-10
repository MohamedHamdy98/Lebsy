package com.momoandroid.lebsy.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.momoandroid.lebsy.BR;

public class Users extends BaseObservable {
    private String email;
    private String password;

    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
