package com.tianli.litemall.tianlilitemall.loadmore;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.tianli.litemall.tianlilitemall.R;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.custom_loadmore_view;
    }

    @Override
    protected int getLoadingViewId() {
        return 0;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
