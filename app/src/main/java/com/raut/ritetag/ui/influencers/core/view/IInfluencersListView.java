package com.raut.ritetag.ui.influencers.core.view;

import com.raut.ritetag.core.api.response.InflunencerResponseData;

import java.util.List;

/**
 * Created by pleximus on 06/05/17.
 */

public interface IInfluencersListView {

    void onLoad();

   void getInfluencersForTag(String tag);

    void onLoadTagInfluencers(List<InflunencerResponseData> influnencerResponseData);

    void onError(String error);
}
