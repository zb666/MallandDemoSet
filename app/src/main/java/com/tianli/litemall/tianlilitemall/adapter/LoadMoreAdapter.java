package com.tianli.litemall.tianlilitemall.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.imageutils.ImageLoaderUtils;
import com.tianli.litemall.tianlilitemall.model.DouBanBean;
import com.tianli.litemall.tianlilitemall.viewholder.LoadMoreHolder;

import java.util.List;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class LoadMoreAdapter extends BaseQuickAdapter<DouBanBean.SubjectsBean,LoadMoreHolder> {


    public LoadMoreAdapter(@LayoutRes int layoutResId, @Nullable List<DouBanBean.SubjectsBean> data) {
        super(layoutResId, data);
    }

    public LoadMoreAdapter(@Nullable List<DouBanBean.SubjectsBean> data) {
        super(data);
    }

    public LoadMoreAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(LoadMoreHolder helper, DouBanBean.SubjectsBean item) {
        helper.setText(R.id.tv_loadmore,item.getTitle());
        ImageLoaderUtils.getInstance().showImage(helper.ivLoadMore,item.getImages().getSmall());
    }


}
