package com.raut.ritetag.ui.influencers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raut.pet_app.R;
import com.raut.ritetag.core.api.response.InflunencerResponseData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Raut Darpan
 */

public class InfluencersListAdapter extends RecyclerView.Adapter<InfluencersListAdapter.ContactViewHolder> {

    private Context context;
    private List<InflunencerResponseData> influnencerResponseDatas;
    private Influencer listClickListner;
    private final LayoutInflater mInflater;

    public InfluencersListAdapter(Context context, Influencer listClickListner, List<InflunencerResponseData> influnencerResponseDatas, LayoutInflater mInflater) {
        this.context = context;
        this.listClickListner = listClickListner;
        this.influnencerResponseDatas = influnencerResponseDatas;
        this.mInflater = mInflater;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(mInflater.inflate(R.layout.row_influerncer, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        InflunencerResponseData influnencerResponseData = influnencerResponseDatas.get(position);
        if (influnencerResponseData.getDate() != null) {
            holder.lblData.setText(influnencerResponseData.getDate());
            holder.lblData.setText("Influencer Data : \n " + "Retweets : " + influnencerResponseData.getRetweets() + "\n" + "Tweets : " + influnencerResponseData.getTweets());
        }
    }


    @Override
    public int getItemCount() {
        if (influnencerResponseDatas != null && influnencerResponseDatas.size() > 0) {
            return influnencerResponseDatas.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.lbl_data)
        TextView lblData;
        @BindView(R.id.lbl_date)
        TextView lbldate;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listClickListner.onClick(getAdapterPosition(), influnencerResponseDatas.get(getAdapterPosition()));
        }
    }

    public interface Influencer {
        void onClick(int position, InflunencerResponseData influnencerResponseData);
    }

}
