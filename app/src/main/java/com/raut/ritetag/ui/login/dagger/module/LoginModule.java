package com.raut.ritetag.ui.login.dagger.module;

import com.raut.ritetag.ui.login.core.presenter.ILoginPresenter;
import com.raut.ritetag.ui.login.core.presenter.LoginPresenterImp;
import com.raut.ritetag.ui.login.core.view.ILoginView;
import com.raut.ritetag.ui.login.dagger.scope.LoginScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raut Darpan on 21/04/17.
 */
@Module
public class LoginModule {

    private ILoginView iLoginView;

    public LoginModule(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @LoginScope
    @Provides
    ILoginView providesILoginView() {
        return iLoginView;
    }

    @LoginScope
    @Provides
    ILoginPresenter providesLoginPresenter(ILoginView iLoginView) {
        return new LoginPresenterImp(iLoginView);
    }

    @LoginScope
    @Provides
    LoginPresenterImp providesLoginPresenterImpl(ILoginView iLoginView) {
        return new LoginPresenterImp(iLoginView);
    }

}
