package com.tianli.litemall.tianlilitemall.main;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.tianli.litemall.common_library.utils.AppHandler;
import com.tianli.litemall.common_library.utils.BottomNavigationViewHelper;
import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.app.LiteMallApp;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;
import com.tianli.litemall.tianlilitemall.test.FourFragment;
import com.tianli.litemall.tianlilitemall.test.OneFragment;
import com.tianli.litemall.tianlilitemall.test.ThreeFragment;
import com.tianli.litemall.tianlilitemall.test.TwoFragment;

import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.bottom_NavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fl_container)
    ViewPager flContainer;

    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    AppHandler<MainActivity> appHandler = new AppHandler<MainActivity>(this) {
        @Override
        public void handleMessage(Message msg) {
            if (LiteMallApp.isFinishInit) {
                LogUtil.d("初始化完成");
                mCommonView.showSuccessView();
            } else {
                //0.1秒做一寸轮训检查是否初始化完毕
                sendEmptyMessageDelayed(0, 200);
                mCommonView.showSuccessView();
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
        showProgressDialog();
        mPresenter.startTask("XMM");
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        startShowDisplay();
        //取消导航栏切换的功能
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        appHandler.sendEmptyMessage(0);

        cancleProgressDialog();


    }


    private void startShowDisplay() {
        final List<Fragment> list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new ThreeFragment());
        list.add(new TwoFragment());
        list.add(new FourFragment());
        flContainer.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    public void showMainData(String data) {
        LogUtil.d(data);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        flContainer.setCurrentItem(1);
        switch (itemId) {
            case R.id.navigation_home:
                flContainer.setCurrentItem(0,false);
                break;
            case R.id.navigation_dashboard:
                flContainer.setCurrentItem(1,false);
                break;
            case R.id.navigation_notifications:
                flContainer.setCurrentItem(2,false);
                break;
            case R.id.navigation_person:
                flContainer.setCurrentItem(3,false);
                break;
            default:
                break;
        }
        return true;
    }

}
