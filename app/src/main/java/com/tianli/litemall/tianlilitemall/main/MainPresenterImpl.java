package com.tianli.litemall.tianlilitemall.main;

import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public class MainPresenterImpl extends BasePresenterImpl<IMainContract.IMainView> implements IMainContract.IMainPresenter {

    @Override
    public void startTask(String data) {
        mParentView.showMainData("加工之后的数据"+data);
    }

}
