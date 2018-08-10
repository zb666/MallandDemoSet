package com.tianli.litemall.tianlilitemall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.imageutils.ImageLoaderUtils;
import com.tianli.litemall.tianlilitemall.model.DouBanBean;
import com.tianli.litemall.tianlilitemall.viewholder.LoadMoreHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class LoadAdapter extends RecyclerView.Adapter<LoadMoreHolder> {

    private List<DouBanBean.SubjectsBean> mDataList;

    private Context mContext;

    public LoadAdapter(List<DouBanBean.SubjectsBean> mDataList, Context mContext) {
        this.mDataList = mDataList == null ? new ArrayList<DouBanBean.SubjectsBean>() : mDataList;
        this.mContext = mContext;
    }

    @Override
    public LoadMoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoadMoreHolder(LayoutInflater.from(mContext).inflate(R.layout.item_loadmore, parent,false));
    }

    @Override
    public void onBindViewHolder(LoadMoreHolder holder, int position) {
        holder.tvLoadMore.setText(mDataList.get(position).getTitle());
        ImageLoaderUtils.getInstance().showImage(holder.ivLoadMore, mDataList.get(position).getImages().getMedium());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
