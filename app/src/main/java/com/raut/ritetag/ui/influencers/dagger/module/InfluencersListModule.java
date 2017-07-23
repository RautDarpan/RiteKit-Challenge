package com.raut.ritetag.ui.influencers.dagger.module;

import com.raut.ritetag.ui.influencers.core.presenter.IInfluencersListPresenter;
import com.raut.ritetag.ui.influencers.core.presenter.InfluencersListPresenterImpl;
import com.raut.ritetag.ui.influencers.core.view.IInfluencersListView;
import com.raut.ritetag.ui.influencers.dagger.scope.InfluencersListScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pleximus on 06/05/17.
 */
@Module
public class InfluencersListModule {

    private IInfluencersListView iInfluencersListView;

    public InfluencersListModule(IInfluencersListView iInfluencersListView) {
        this.iInfluencersListView = iInfluencersListView;
    }

    @InfluencersListScope
    @Provides
    IInfluencersListView providesContactView() {
        return iInfluencersListView;
    }

    @InfluencersListScope
    @Provides
    IInfluencersListPresenter providesContactsPresneter(IInfluencersListView iInfluencersListView) {
        return new InfluencersListPresenterImpl(iInfluencersListView);
    }

    @InfluencersListScope
    @Provides
    InfluencersListPresenterImpl providesPresneter(IInfluencersListView iInfluencersListView) {
        return new InfluencersListPresenterImpl(iInfluencersListView);
    }
}
