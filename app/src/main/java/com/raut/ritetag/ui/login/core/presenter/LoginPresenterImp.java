package com.raut.ritetag.ui.login.core.presenter;

import android.content.Context;

import com.raut.ritetag.ui.base.BasePresenter;
import com.raut.ritetag.ui.login.core.model.IUser;
import com.raut.ritetag.ui.login.core.model.UserModel;
import com.raut.ritetag.ui.login.core.view.ILoginView;

import io.reactivex.disposables.Disposable;


/**
 * Created by Raut Darpan on 21/04/17.
 */

public class LoginPresenterImp extends BasePresenter implements ILoginPresenter {

    private ILoginView iLoginView;
    private IUser user;

    public LoginPresenterImp(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        user = new UserModel();
    }

    @Override
    public void onLoad(Context context) {

    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(Context context, String username, String passwd) {
        boolean isValidUser = user.userInputValidation(username, passwd);
        if (isValidUser) {

        } else {
            iLoginView.onLoginError();
        }

    }

    @Override
    public void onSuccessfulLogin() {
        iLoginView.onLoginResult(true);
    }

    @Override
    public void onLoadRegister() {
        iLoginView.onLoadRegisterActivity();
    }


    /**
     * add disposable
     *
     * @param disposable
     */
    public void addDisposableObserver(Disposable disposable) {
        addDisposable(disposable);
    }

}
