package com.raut.ritetag.ui.influencers.core.presenter;

import com.raut.ritetag.core.api.response.InflunencerResponseData;
import com.raut.ritetag.ui.base.BasePresenter;
import com.raut.ritetag.ui.influencers.core.view.IInfluencersListView;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by pleximus on 06/05/17.
 */

public class InfluencersListPresenterImpl extends BasePresenter implements IInfluencersListPresenter {

    private IInfluencersListView iInfluencersListView;

    public InfluencersListPresenterImpl(IInfluencersListView iInfluencersListView) {
        this.iInfluencersListView = iInfluencersListView;
    }

    @Override
    public void onLoad() {
        // post event to get contacts list for the user
       // RiteKitApplication.bus().send(new ContactsContract());
        iInfluencersListView.onLoad();
    }


    @Override
    public void onLoadTagInfluencer(List<InflunencerResponseData> influnencerResponseDatas) {
        iInfluencersListView.onLoadTagInfluencers(influnencerResponseDatas);
    }

    @Override
    public void getInfluerncers(String tag) {
        iInfluencersListView.getInfluencersForTag(tag);
    }

    @Override
    public void onError(String error) {
        iInfluencersListView.onError(error);
    }

    /**
     * add disposable
     *
     * @param disposable
     */
    public void addDisposableObserver(Disposable disposable) {
        addDisposable(disposable);
    }
}
