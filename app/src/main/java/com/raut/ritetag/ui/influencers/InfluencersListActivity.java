package com.raut.ritetag.ui.influencers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.raut.pet_app.R;
import com.raut.ritetag.RiteKitApplication;
import com.raut.ritetag.core.api.APIInteface;
import com.raut.ritetag.core.api.response.InfluencersResponse;
import com.raut.ritetag.core.api.response.InflunencerResponseData;
import com.raut.ritetag.core.api.response.Tag;
import com.raut.ritetag.ui.influencers.adapter.InfluencersListAdapter;
import com.raut.ritetag.ui.influencers.core.presenter.InfluencersListPresenterImpl;
import com.raut.ritetag.ui.influencers.core.view.IInfluencersListView;
import com.raut.ritetag.ui.influencers.dagger.component.DaggerInfluencersListComponent;
import com.raut.ritetag.ui.influencers.dagger.module.InfluencersListModule;
import com.raut.ritetag.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class InfluencersListActivity extends AppCompatActivity implements IInfluencersListView, InfluencersListAdapter.Influencer {

    private Context context;
    private InfluencersListAdapter influencersListAdapter;

    @BindView(R.id.recycleview_influencer)
    RecyclerView recyclerView;
    @BindView(R.id.lbl_tag)
    TextView lblTag;

    @Inject
    InfluencersListPresenterImpl influencersListPresenter;
    @Inject
    APIInteface apiInteface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influerncers);
        ButterKnife.bind(this);
        context = this;
        Intent intent = getIntent();
        Tag tag = (Tag) intent.getSerializableExtra(AppConstants.TAG);
        initaliseDagger();
        if (tag != null) {
            influencersListPresenter.getInfluerncers(tag.getTag());
            lblTag.setText(tag.getTag());
        }
        influencersListPresenter.onLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();
        influencersListPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        influencersListPresenter.onDestroy();
    }

    /**
     * initialise dependencies
     */
    private void initaliseDagger() {
        DaggerInfluencersListComponent.builder()
                .apiComponent(RiteKitApplication.getAppComponent())
                .influencersListModule(new InfluencersListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void getInfluencersForTag(String tag) {
        influencersListPresenter.addDisposableObserver(apiInteface.getInfluencers(tag)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<InfluencersResponse>() {
                    @Override
                    public void onNext(InfluencersResponse influencersResponse) {
                        if (influencersResponse != null) {
                            if (influencersResponse.isResult()) {
                                influencersListPresenter.onLoadTagInfluencer(influencersResponse.getData());
                            } else {
                                influencersListPresenter.onError(influencersResponse.getMessage());
                            }
                        } else {
                            influencersListPresenter.onError("Please try again later");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        influencersListPresenter.onError("Please try again later");
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void onLoadTagInfluencers(List<InflunencerResponseData> influnencerResponseData) {
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        influencersListAdapter = new InfluencersListAdapter(context, this, influnencerResponseData, getLayoutInflater());
        recyclerView.setAdapter(influencersListAdapter);
    }

    @Override
    public void onError(String error) {
        //TODO error when recived
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(int position, InflunencerResponseData influnencerResponseData) {

    }
}
