package com.raut.ritetag.application.builder.module;

import com.raut.ritetag.core.bus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raut Darpan on 25/04/17.
 */
@Module
public class RxModule {


    @Provides
    RxBus provideRxBus() {
        return new RxBus();
    }
}
