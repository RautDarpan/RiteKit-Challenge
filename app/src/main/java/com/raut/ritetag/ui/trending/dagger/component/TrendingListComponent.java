package com.raut.ritetag.ui.trending.dagger.component;

import com.raut.ritetag.application.builder.component.ApiComponent;
import com.raut.ritetag.ui.trending.TrendingListActivity;
import com.raut.ritetag.ui.trending.dagger.module.TrendingListModule;
import com.raut.ritetag.ui.trending.dagger.scope.TrendingListScope;

import dagger.Component;

/**
 * Created by pleximus on 06/05/17.
 */
@TrendingListScope
@Component(modules = TrendingListModule.class, dependencies = ApiComponent.class)
public interface TrendingListComponent {
    void inject(TrendingListActivity trendingListActivity);
}
