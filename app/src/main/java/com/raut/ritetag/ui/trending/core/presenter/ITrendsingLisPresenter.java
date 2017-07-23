package com.raut.ritetag.ui.trending.core.presenter;

import com.raut.ritetag.core.api.response.Tag;

import java.util.List;

/**
 * Created by pleximus on 06/05/17.
 */

public interface ITrendsingLisPresenter {

    void onLoad();

    void onLoadTresndingTags(List<Tag> tagList);

    void onError(String error);
}
