package com.tianli.litemall.tianlilitemall.main;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.tianli.litemall.common_library.utils.AppHandler;
import com.tianli.litemall.common_library.utils.BottomNavigationViewHelper;
import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.app.LiteMallApp;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;

import butterknife.BindView;


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
public class MainActivity extends BaseActivity<IMainContract.IMainView, MainPresenterImpl> implements IMainContract.IMainView, BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.bottom_NavigationView)
    BottomNavigationView bottomNavigationView;

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
        startShowDisplay();
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }


    private void startShowDisplay() {

    }

    @Override
    public void showMainData(String data) {
        LogUtil.d(data);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        LogUtil.d(item.getItemId() + "" + item.hashCode());
        return false;
    }

}
