package com.raut.ritetag.ui.login.core.model;

public interface IUser {

    String getUserName();

    String getPassword();

    int checkUserValidity(String name, String passwd);

    boolean userInputValidation(String name, String passwd);

}