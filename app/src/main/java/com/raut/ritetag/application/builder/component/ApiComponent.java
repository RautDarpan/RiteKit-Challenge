package com.raut.ritetag.application.builder.component;

import com.raut.ritetag.application.builder.module.ApiModule;
import com.raut.ritetag.application.builder.module.DatabaseModule;
import com.raut.ritetag.application.builder.module.RxModule;
import com.raut.ritetag.application.builder.scope.AppScope;
import com.raut.ritetag.core.api.APIInteface;
import com.raut.ritetag.core.bus.RxBus;
import com.raut.ritetag.core.db.DatabaseManager;

import dagger.Component;

/**
 * Created by Raut Darpan on 21/04/17.
 */
@AppScope
@Component(modules = {ApiModule.class, RxModule.class, DatabaseModule.class}, dependencies = {NetworkComponent.class})
public interface ApiComponent {

    APIInteface provideApiInterface();

    RxBus rxBus();

    DatabaseManager databaseManager();

}
