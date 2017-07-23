package com.raut.ritetag.ui.trending.dagger.module;

import com.raut.ritetag.ui.trending.core.presenter.ITrendsingLisPresenter;
import com.raut.ritetag.ui.trending.core.presenter.TrendsingListPresenterImpl;
import com.raut.ritetag.ui.trending.core.view.ITrendsingListView;
import com.raut.ritetag.ui.trending.dagger.scope.TrendingListScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pleximus on 06/05/17.
 */
@Module
public class TrendingListModule {

    private ITrendsingListView iTrendsingListView;

    public TrendingListModule(ITrendsingListView iTrendsingListView) {
        this.iTrendsingListView = iTrendsingListView;
    }

    @TrendingListScope
    @Provides
    ITrendsingListView providesTrendingView() {
        return iTrendsingListView;
    }

    @TrendingListScope
    @Provides
    ITrendsingLisPresenter providesITrendingPresneter(ITrendsingListView iTrendsingListView) {
        return new TrendsingListPresenterImpl(iTrendsingListView);
    }

    @TrendingListScope
    @Provides
    TrendsingListPresenterImpl providesPresneter(ITrendsingListView iTrendsingListView) {
        return new TrendsingListPresenterImpl(iTrendsingListView);
    }
}
