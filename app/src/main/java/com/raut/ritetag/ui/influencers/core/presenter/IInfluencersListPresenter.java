package com.raut.ritetag.ui.influencers.core.presenter;

import com.raut.ritetag.core.api.response.InflunencerResponseData;

import java.util.List;

/**
 * Created by pleximus on 06/05/17.
 */

public interface IInfluencersListPresenter {

    void onLoad();

    void onLoadTagInfluencer(List<InflunencerResponseData> tagList);

    void getInfluerncers(String tag);

    void onError(String error);
}
