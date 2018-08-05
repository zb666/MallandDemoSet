package com.tianli.litemall.tianlilitemall.fragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public interface IBasePresenter {
    void setShowLoading(boolean isShow);

    boolean isShowLoading();

    void setRefershOrLoadmore(boolean isShow);

    boolean isRefershOrLoadmore();

    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    void addDisposable(Disposable subscription);

    //注销所有请求
    void unDisposable();

    void immersionInit();
}
