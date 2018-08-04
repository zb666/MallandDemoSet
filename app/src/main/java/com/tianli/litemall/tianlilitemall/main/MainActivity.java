package com.tianli.litemall.tianlilitemall.main;

import android.os.Message;

import com.tianli.litemall.common_library.utils.AppHandler;
import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.app.LiteMallApp;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;
import com.tianli.litemall.tianlilitemall.vlayout.OneDragNActivity;

/**
 * @Description:
 * @ClassName: MainActivity
 * @Author: zhoubo@tianli
 * @Date: 2018/7/31 18:10
 * *@Copyright: 版权归 tianli 所有 <ModifyLog>
 * @ModifyContent:
 * @Author:
 * @Date: </ModifyLog>
 */
public class MainActivity extends BaseActivity<IMainContract.IMainView, MainPresenterImpl> implements IMainContract.IMainView {

    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    AppHandler<MainActivity> appHandler = new AppHandler<MainActivity>(this) {
        @Override
        public void handleMessage(Message msg) {
            if (LiteMallApp.isFinishInit) {
                LogUtil.d("初始化完成");
            } else {
                //0.1秒做一寸轮训检查是否初始化完毕
                sendEmptyMessageDelayed(0, 100);
            }
        }
    };

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewData() {
        super.initViewData();
        mPresenter.startTask("XMM");
        appHandler.sendEmptyMessage(0);
        if (LiteMallApp.isFinishInit) {

        }
        openNewActivity(OneDragNActivity.class);
    }

    @Override
    public void showMainData(String data) {
        LogUtil.d(data);
    }

}