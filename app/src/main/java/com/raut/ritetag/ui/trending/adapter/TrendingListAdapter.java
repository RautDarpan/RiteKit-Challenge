package com.raut.ritetag.ui.trending.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raut.pet_app.R;
import com.raut.ritetag.core.api.response.Tag;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Raut Darpan
 */

public class TrendingListAdapter extends RecyclerView.Adapter<TrendingListAdapter.ContactViewHolder> {

    private Context context;
    private List<Tag> trendingResponseDataList;
    private TrendingListClickListner listClickListner;
    private final LayoutInflater mInflater;

    public TrendingListAdapter(Context context, TrendingListClickListner listClickListner, List<Tag> trendingResponseDataList, LayoutInflater mInflater) {
        this.context = context;
        this.listClickListner = listClickListner;
        this.trendingResponseDataList = trendingResponseDataList;
        this.mInflater = mInflater;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(mInflater.inflate(R.layout.row_trendin_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Tag dbUserContact = trendingResponseDataList.get(position);
        if (dbUserContact.getTag() != null){
            holder.lblTagName.setText(dbUserContact.getTag());
        }
        holder.lblRetweets.setText(dbUserContact.getRetweets() + " ");
    }


    @Override
    public int getItemCount() {
        if (trendingResponseDataList != null && trendingResponseDataList.size() > 0) {
            return trendingResponseDataList.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.lbl_tag_name)
        TextView lblTagName;
        @BindView(R.id.lbl_retweets)
        TextView lblRetweets;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listClickListner.onTagClick(getAdapterPosition(), trendingResponseDataList.get(getAdapterPosition()));
        }
    }

    public interface TrendingListClickListner {
        void onTagClick(int position, Tag tag);
    }

}
