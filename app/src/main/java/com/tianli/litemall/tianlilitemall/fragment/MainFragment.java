package com.tianli.litemall.tianlilitemall.fragment;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.main.MainPresenterImpl;
import com.tianli.litemall.tianlilitemall.model.MainModel;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class MainFragment extends BaseFragmentImpl<MainPresenterImpl, MainModel> {

    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected int bindLayout() {
        return R.layout.home_fragment_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
