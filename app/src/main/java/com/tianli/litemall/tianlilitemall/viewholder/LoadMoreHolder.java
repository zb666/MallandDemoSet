package com.tianli.litemall.tianlilitemall.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.tianli.litemall.tianlilitemall.R;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class LoadMoreHolder extends BaseViewHolder {

    public TextView tvLoadMore;
    public ImageView ivLoadMore;
    public LoadMoreHolder(View view) {
        super(view);
        tvLoadMore = (TextView) view.findViewById(R.id.tv_loadmore);
        ivLoadMore = (ImageView) view.findViewById(R.id.iv_loadmore);
    }

}
