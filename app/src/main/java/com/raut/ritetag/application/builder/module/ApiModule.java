package com.raut.ritetag.application.builder.module;

import com.raut.ritetag.core.api.APIInteface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Raut Darpan on 21/04/17.
 */
@Module
public class ApiModule {

    @Provides
    APIInteface providesRetrofitApiService(Retrofit retrofit) {
        return retrofit.create(APIInteface.class);
    }

}
