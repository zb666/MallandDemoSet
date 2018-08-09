package com.tianli.litemall.tianlilitemall.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.tianli.litemall.tianlilitemall.R;

/**
 * Created by zhoubo30110 on 2018/8/9.
 */

public class CommonStateLayout extends FrameLayout {

    private View mLoadingView, mErrorView, mEmptyView, mSuccessView;

    public static final int SUCCESS = 3;
    public static final int ERROR = 0;
    public static final int EMPTY = 1;
    public static final int LOADING = 2;

    private SparseArray<View> mStateSparse = new SparseArray<>();

    public CommonStateLayout(@NonNull Context context) {
        this(context, null);
    }

    public CommonStateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonStateLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //正在加载中的视图
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        mLoadingView = layoutInflater.inflate(R.layout.custom_progress_layout, null);
        addView(mLoadingView);
        mErrorView = layoutInflater.inflate(R.layout.custom_error_view, null);
        mErrorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示loadingView
                changeViewByState(LOADING);
                if (mReloadListener != null) {
                    //请求重新加载
                    mReloadListener.onReload();
                }
            }
        });
        //添加失败视图
        addView(mErrorView);
        //添加空视图
        mEmptyView = layoutInflater.inflate(R.layout.custom_empty_view, null);
        addView(mEmptyView);
        //将所有的View进行保存
        initStateView();
        //一开始就隐藏所有的界面
        hideAll();
    }

    private void initStateView() {
        mStateSparse.put(ERROR, mErrorView);
        mStateSparse.put(EMPTY, mEmptyView);
        mStateSparse.put(LOADING, mLoadingView);
    }

    //根据索引动态的改变View的显示和隐藏
    private void changeViewByState(int state) {
        int size = mStateSparse.size();
        //判断索引是否越界或者或者未绑定成功的视图
        if (state < 0 || state > 3) return;
        for (int i = 0; i < size; i++) {
            View view = mStateSparse.get(state);
            view.setVisibility(state == i ? VISIBLE : GONE);
        }
    }

    public void showEmptyView() {
       // changeViewByState(CommonStateLayout.EMPTY);
        mEmptyView.setVisibility(VISIBLE);
        mSuccessView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
    }

    public void showErrorView() {
        //changeViewByState(CommonStateLayout.ERROR);
        mErrorView.setVisibility(VISIBLE);
        mSuccessView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
        mLoadingView.setVisibility(GONE);
    }

    public void showLoadingView() {
        //changeViewByState(CommonStateLayout.LOADING);
        mLoadingView.setVisibility(VISIBLE);
        mSuccessView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
    }

    public void showSuccessView(){
        mSuccessView.setVisibility(VISIBLE);
        mLoadingView.setVisibility(GONE);
        mEmptyView.setVisibility(GONE);
        mErrorView.setVisibility(GONE);
    }

    //隐藏所有的布局
    private void hideAll() {
        int size = mStateSparse.size();
        for (int i = 0; i < size; i++) {
            mStateSparse.get(i).setVisibility(GONE);
        }
        if (mSuccessView != null) {
            mSuccessView.setVisibility(GONE);
        }
    }

    public void bindSuccessView(int layoutResId) {
        this.mSuccessView = LayoutInflater.from(getContext()).inflate(layoutResId, null);
        mStateSparse.put(SUCCESS, mSuccessView);
        addView(mSuccessView);
    }

    private OnReloadListener mReloadListener;

    public void setOnReloadListener(OnReloadListener listener) {
        this.mReloadListener = listener;
    }

    public interface OnReloadListener {
        /**
         * 当重新加载的按钮被点击的时候调用
         */
        void onReload();
    }


}
