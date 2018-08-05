package com.tianli.litemall.tianlilitemall.activity;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;
import com.tianli.litemall.tianlilitemall.base.contract.IBaseContract;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class OtherActivity extends BaseActivity {
    @Override
    protected IBaseContract.IBasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_other;
    }
}
