package com.raut.ritetag.ui.login.dagger.component;

import com.raut.ritetag.application.builder.component.ApiComponent;
import com.raut.ritetag.ui.login.LoginActivity;
import com.raut.ritetag.ui.login.dagger.module.LoginModule;
import com.raut.ritetag.ui.login.dagger.scope.LoginScope;

import dagger.Component;

/**
 * Created by Raut Darpan on 21/04/17.
 */
@LoginScope
@Component(modules = {LoginModule.class}, dependencies = ApiComponent.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
