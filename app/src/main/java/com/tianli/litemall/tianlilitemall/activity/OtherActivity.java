package com.tianli.litemall.tianlilitemall.activity;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;
import com.tianli.litemall.tianlilitemall.base.contract.IBaseContract;
import com.tianli.litemall.tianlilitemall.view.CommonStateLayout;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class OtherActivity extends BaseActivity implements CommonStateLayout.OnReloadListener {

    @Override
    protected IBaseContract.IBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_other;
    }

    @Override
    protected void initViewData() {
        //super.initViewData();
        mCommonView.showLoadingView();
        mCommonView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCommonView.showSuccessView();
            }
        },2000);
    }

    @Override
    public void onReload() {

    }


}
