package com.tianli.litemall.tianlilitemall.loadmore;

import com.chad.library.adapter.base.loadmore.LoadMoreView;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected int getLoadingViewId() {
        return 0;
    }

    @Override
    protected int getLoadFailViewId() {
        return 0;
    }

    @Override
    protected int getLoadEndViewId() {
        return 0;
    }
}
