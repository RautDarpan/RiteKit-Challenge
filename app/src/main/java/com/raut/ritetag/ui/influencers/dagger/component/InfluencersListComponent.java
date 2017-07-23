package com.raut.ritetag.ui.influencers.dagger.component;

import com.raut.ritetag.application.builder.component.ApiComponent;
import com.raut.ritetag.ui.influencers.InfluencersListActivity;
import com.raut.ritetag.ui.influencers.dagger.module.InfluencersListModule;
import com.raut.ritetag.ui.influencers.dagger.scope.InfluencersListScope;

import dagger.Component;

/**
 * Created by pleximus on 06/05/17.
 */
@InfluencersListScope
@Component(modules = InfluencersListModule.class, dependencies = ApiComponent.class)
public interface InfluencersListComponent {
    void inject(InfluencersListActivity influencersListActivity);
}
