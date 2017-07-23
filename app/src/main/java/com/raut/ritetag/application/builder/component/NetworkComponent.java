package com.raut.ritetag.application.builder.component;

import com.raut.ritetag.application.builder.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Raut Darpan on 18/04/17.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    Retrofit retrofit();

}
