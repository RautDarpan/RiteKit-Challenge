package com.raut.ritetag.ui.trending.core.presenter;

import com.raut.ritetag.core.api.response.Tag;
import com.raut.ritetag.ui.base.BasePresenter;
import com.raut.ritetag.ui.trending.core.view.ITrendsingListView;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by pleximus on 06/05/17.
 */

public class TrendsingListPresenterImpl extends BasePresenter implements ITrendsingLisPresenter {

    private ITrendsingListView iTrendsingListView;

    public TrendsingListPresenterImpl(ITrendsingListView iTrendsingListView) {
        this.iTrendsingListView = iTrendsingListView;
    }

    @Override
    public void onLoad() {
        // post event to get contacts list for the user
       // RiteKitApplication.bus().send(new ContactsContract());
        iTrendsingListView.getTagsList();
    }


    @Override
    public void onLoadTresndingTags(List<Tag> tagList) {
        iTrendsingListView.onLoadTresndingTags(tagList);
    }

    @Override
    public void onError(String error) {
        iTrendsingListView.onError(error);
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
