package com.tianli.litemall.tianlilitemall.base.contract;

import java.lang.ref.WeakReference;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public class BasePresenterImpl<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<V> {

    protected V mParentView;

    private WeakReference<V> mWeakReferenceView;

    @Override
    public void startRequest() {

    }

    //用于rxjava的订阅和接触订阅
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void attachView(V view) {
        this.mParentView = view;
        this.mWeakReferenceView = new WeakReference<>(mParentView);
    }

    @Override
    public void detachView() {
        if (mWeakReferenceView != null) {
            mWeakReferenceView.clear();
            mWeakReferenceView = null;
            mParentView = null;
        }
    }
}
