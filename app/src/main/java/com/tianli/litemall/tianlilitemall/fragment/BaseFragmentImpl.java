package com.tianli.litemall.tianlilitemall.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.tianlilitemall.base.contract.BaseActivity;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.base.contract.IBaseContract;
import com.tianli.litemall.tianlilitemall.model.IBaseModel;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

/**
 *  Fragment懒加载的基类
 * @param <P>
 * @param <E>
 */
public abstract class BaseFragmentImpl<P extends BasePresenterImpl, E extends IBaseModel> extends Fragment implements IBasePresenter {

    protected P mPresenter;
    protected BaseActivity mParentActivity;
    protected View mRootView;
    //界面是否已经对用户开始可见
    protected boolean isVisible;
    //界面初始化是否已经完毕
    protected boolean isPrepared;
    //是否为第一次加载
    protected boolean isFirst = true;
    protected Unbinder unbinder = null;

    protected static int SUCCESS_VIEW = 0;
    protected static int FAIL_VIEW = 1;
    protected static int EMPTY_VIEW = 2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null && context instanceof BaseActivity) {
            mParentActivity = (BaseActivity) context;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        //判断是否使用MVP模式
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((IBaseContract.IBaseView) this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(bindLayout(), container, false);
            unbinder = ButterKnife.bind(this, mRootView);
            initView();
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Activity界面已经创建完毕了
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public boolean isRefershOrLoadmore() {
        return false;
    }

    @Override
    public void addDisposable(Disposable subscription) {

    }

    @Override
    public void unDisposable() {

    }

    @Override
    public void setRefershOrLoadmore(boolean isShow) {

    }

    protected void lazyLoad() {
        //对用户开始可见 并且已经准备好了 View已经初始化完毕
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        LogUtil.d(getClass().getSimpleName() + "数据开始加载了");
        initData();
        isFirst = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) mRootView.getParent()).removeView(mRootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
        unDisposable();
    }

    @Override
    public boolean isShowLoading() {
        return false;
    }

    @Override
    public void setShowLoading(boolean isShow) {

    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            //mPresenter.setShowLoading(false);
        }
    }

    protected <T extends View> T findView(int resId) {
        return (T) (mRootView.findViewById(resId));
    }

    protected void setOnClickLisenter(int resId, View.OnClickListener listener) {
        if (listener != null) {
            findView(resId).setOnClickListener(listener);
        }
    }

    protected void setOnClickLisenter(View viewparent, int resId, View.OnClickListener listener) {
        if (listener != null) {
            viewparent.findViewById(resId).setOnClickListener(listener);
        }
    }

    //用于创建Presenter和判断是否使用MVP模式(由子类实现)
    protected abstract P createPresenter();

    //得到当前界面的布局文件id(由子类实现)
    protected abstract int bindLayout();

    public abstract void initView();

    public abstract void initData();

    protected void onInvisible() {

    }

    public void startActivity(Class activity) {
        Intent intent = new Intent(mParentActivity, activity);
        startActivity(intent);
    }

    public void startActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(mParentActivity, activity);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }

    public void startActivityAndClearTask(Class activity) {
        Intent intent = new Intent(mParentActivity, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        mParentActivity.finish();
    }

    public void startActivityAndClearTop(Class activity) {
        Intent intent = new Intent(mParentActivity, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void immersionInit() {

    }

}
