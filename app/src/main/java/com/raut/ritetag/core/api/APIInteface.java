package com.raut.ritetag.core.api;

import com.raut.ritetag.core.api.response.InfluencersResponse;
import com.raut.ritetag.core.api.response.TrendingResponseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Raut Darpan on 21/04/17.
 */

public interface APIInteface {

    @GET("v1/search/trending/")
    Observable<TrendingResponseData> getTrendingTags();

    @GET("v1/stats/history/{tag}")
    Observable<InfluencersResponse> getInfluencers(@Path("tag") String queryTag);

}
