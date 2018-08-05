package com.tianli.litemall.tianlilitemall.test;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;

import okhttp3.OkHttpClient;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class TwoFragment extends BaseFragmentImpl {
    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_album_select;
    }

    @Override
    public void initView() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

    }

    @Override
    public void initData() {

    }
}
