package com.raut.ritetag.ui.trending.core.view;

import com.raut.ritetag.core.api.response.Tag;

import java.util.List;

/**
 * Created by pleximus on 06/05/17.
 */

public interface ITrendsingListView {

    void onLoad();
   void getTagsList();

    void onLoadTresndingTags(List<Tag> tagList);

    void onError(String error);
}
