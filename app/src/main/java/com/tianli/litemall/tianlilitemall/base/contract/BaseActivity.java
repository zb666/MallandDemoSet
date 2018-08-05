package com.tianli.litemall.tianlilitemall.base.contract;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.configinit.LiteMall;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public abstract class BaseActivity<V extends IBaseContract.IBaseView, P extends IBaseContract.IBasePresenter<V>> extends AppCompatActivity implements IBaseContract.IBaseView {

    protected P mPresenter;
    private View mLoadingView;
    private FrameLayout mContentView;
    private View mErrorView;
    protected Unbinder mParentBind;

    protected abstract P createPresenter();

    protected static final int EMPTY_VIEW = 1;

    protected static final int ERROR_VIEW = 2;

    protected static final int SUCCESS_VIEW = 3;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建P层
        mPresenter = createPresenter();
        //创建View和P层的连接
        if (mPresenter!=null) {
            mPresenter.attachView((V) this);
        }
        //管理Activity
        LiteMall.getConfigurator().withActivity(this);
        //初始化布局
        setContentView(initLayout());
        //APT生成findViewByID和绑定点击事件的操作
        mParentBind = ButterKnife.bind(this);
        //沉浸式状态栏
        StatusBarUtil.setTransparent(this);
        //设置数据
        initViewData();
    }

    //初始化数据
    protected void initViewData() {
        FrameLayout mContentView = (FrameLayout) getWindow().getDecorView().findViewById(android.R.id.content);
       // mContentView.addView(View.inflate(this, R.layout.custom_empty_view, null));
    }

    protected abstract int initLayout();

    @Override
    public void showDialog() {
        //父类的显示对话框
    }

    @Override
    public void showLogingView() {
        if (mLoadingView == null) {
            mLoadingView = LayoutInflater.from(this).inflate(R.layout.common_emptyview, null);
            mContentView = (FrameLayout) getWindow().getDecorView().findViewById(android.R.id.content);
            mContentView.addView(mLoadingView);
        }
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showErrorView();
            }
        });
    }

    protected void showErrorView() {
        mContentView.removeView(mLoadingView);
        if (mErrorView == null) {
            mErrorView = LayoutInflater.from(this).inflate(R.layout.common_errorview, null);
            mContentView = (FrameLayout) getWindow().getDecorView().findViewById(android.R.id.content);
            mContentView.addView(mErrorView);
        }
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void openNewActivity(Class<?> tClass) {
        startActivity(new Intent(this, tClass));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (mParentBind!=null){
            mParentBind.unbind();
        }
    }
}
