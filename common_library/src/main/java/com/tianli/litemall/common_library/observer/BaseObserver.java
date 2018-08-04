package com.tianli.litemall.common_library.observer;

import android.app.Activity;

import com.tianli.litemall.common_library.response.BaseDTO;

import io.reactivex.disposables.Disposable;
import rx.Observer;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public abstract class BaseObserver<T> implements Observer<BaseDTO> {

    private static final String TAG = "TAG--BaseObserver";
    private Activity mContext;
    private boolean isShowLoading = true;
    private boolean isCanDispose = true;//是否可以手动取消网络请求（取消订阅）
    private String loadingMsg = "加载中";
    private Disposable mDisposable;
    private boolean isRefershOrLoadmore = false;
    private boolean isShowErrorToast = true;

    public BaseObserver(Activity context) {
        this(context, true);
    }

    /**
     * @param context
     * @param isShowLoading 是否显示loading 默认true
     */
    public BaseObserver(Activity context, boolean isShowLoading) {
        this(context, isShowLoading, "", false);
    }

    /**
     * @param context
     * @param isShowLoading 是否显示loading 默认true
     * @param loadingMsg    loading信息 默认"加载中..."
     */
    public BaseObserver(Activity context, boolean isShowLoading, String loadingMsg) {
        this(context, isShowLoading, loadingMsg, false);
    }

    /**
     * @param context
     * @param isShowLoading       是否显示loading 默认true
     * @param isRefershOrLoadmore 是否是下拉刷新或上拉加载状态,是则不显示loading，默认false
     */
    public BaseObserver(Activity context, boolean isShowLoading, boolean isRefershOrLoadmore) {
        this(context, isShowLoading, "", isRefershOrLoadmore, true);
    }

    /**
     * @param context
     * @param isShowLoading       是否显示loading 默认true
     * @param isRefershOrLoadmore 是否是下拉刷新或上拉加载状态,是则不显示loading，默认false
     * @param isShowErrorToast    是否显示错误的Toast
     */
    public BaseObserver(Activity context,
                        boolean isShowLoading,
                        boolean
                                isRefershOrLoadmore,
                        boolean isShowErrorToast) {
        this(context, isShowLoading, "", isRefershOrLoadmore, isShowErrorToast);
    }

    /**
     * @param context
     * @param isShowLoading       是否显示loading 默认true
     * @param loadingMsg          loading信息 默认"加载中..."
     * @param isRefershOrLoadmore 是否是下拉刷新或上拉加载状态,是则不显示loading，默认false
     */
    public BaseObserver(Activity context, boolean isShowLoading, String loadingMsg, boolean
            isRefershOrLoadmore) {
        this(context, isShowLoading, loadingMsg, isRefershOrLoadmore, true);
    }

    /**
     * @param context
     * @param isShowLoading       是否显示loading 默认true
     * @param loadingMsg          loading信息 默认"加载中..."
     * @param isRefershOrLoadmore 是否是下拉刷新或上拉加载状态,是则不显示loading，默认false
     * @param isShowErrorToast    是否显示error Toast
     */
    public BaseObserver(Activity context, boolean isShowLoading, String loadingMsg, boolean
            isRefershOrLoadmore, boolean isShowErrorToast) {
        this.mContext = context;
        this.isShowLoading = isShowLoading;
        this.loadingMsg = loadingMsg;
        this.isRefershOrLoadmore = isRefershOrLoadmore;
        this.isShowErrorToast = isShowErrorToast;
    }



}
