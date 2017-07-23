package com.raut.ritetag.ui.login.core.view;

/**
 * Created by Raut Darpan on 21/04/17.
 */

public interface ILoginView {

    void onClearText();

    void onLoginResult(boolean isValid);

    void onLoginError();

    void onLoadRegisterActivity();
}
