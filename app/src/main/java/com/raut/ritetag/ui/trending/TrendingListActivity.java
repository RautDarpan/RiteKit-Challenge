package com.raut.ritetag.ui.trending;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.raut.pet_app.R;
import com.raut.ritetag.RiteKitApplication;
import com.raut.ritetag.core.api.APIInteface;
import com.raut.ritetag.core.api.response.Tag;
import com.raut.ritetag.core.api.response.TrendingResponseData;
import com.raut.ritetag.ui.influencers.InfluencersListActivity;
import com.raut.ritetag.ui.trending.adapter.TrendingListAdapter;
import com.raut.ritetag.ui.trending.core.presenter.TrendsingListPresenterImpl;
import com.raut.ritetag.ui.trending.core.view.ITrendsingListView;
import com.raut.ritetag.ui.trending.dagger.component.DaggerTrendingListComponent;
import com.raut.ritetag.ui.trending.dagger.module.TrendingListModule;
import com.raut.ritetag.utils.AppConstants;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TrendingListActivity extends AppCompatActivity implements ITrendsingListView, TrendingListAdapter.TrendingListClickListner {

    private Context context;
    private TrendingListAdapter trendingListAdapter;

    @BindView(R.id.recycleview_tags)
    RecyclerView recyclerView;
    @Inject
    TrendsingListPresenterImpl trendsingListPresenter;
    @Inject
    APIInteface apiInteface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_list);
        ButterKnife.bind(this);
        context = this;
        initaliseDagger();
        trendsingListPresenter.onCreate();
        trendsingListPresenter.onLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();
        trendsingListPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        trendsingListPresenter.onDestroy();
    }

    /**
     * initialise dependencies
     */
    private void initaliseDagger() {
        DaggerTrendingListComponent.builder()
                .apiComponent(RiteKitApplication.getAppComponent())
                .trendingListModule(new TrendingListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void getTagsList() {
        trendsingListPresenter.addDisposableObserver(apiInteface.getTrendingTags()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TrendingResponseData>() {
                    @Override
                    public void onNext(TrendingResponseData trendingResponseData) {
                        if (trendingResponseData != null) {
                            if (trendingResponseData.isResult()) {
                                trendsingListPresenter.onLoadTresndingTags(trendingResponseData.getTags());
                            } else {
                                trendsingListPresenter.onError(trendingResponseData.getMessage());
                            }
                        } else {
                            trendsingListPresenter.onError("Please try again later");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        trendsingListPresenter.onError("Please try again later");
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    /**
     * display all trending tags
     *
     * @param tagList
     */
    @Override
    public void onLoadTresndingTags(List<Tag> tagList) {
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        trendingListAdapter = new TrendingListAdapter(context, this, tagList, getLayoutInflater());
        recyclerView.setAdapter(trendingListAdapter);
    }


    @Override
    public void onError(String error) {
        //TODO error when recived
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTagClick(int position, Tag tag) {
        Intent influencer = new Intent(context, InfluencersListActivity.class);
        influencer.putExtra(AppConstants.TAG, (Serializable) tag);
        startActivity(influencer);
    }
}
