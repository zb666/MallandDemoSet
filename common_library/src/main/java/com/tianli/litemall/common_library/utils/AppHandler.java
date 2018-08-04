package com.tianli.litemall.common_library.utils;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by zhoubo30110 on 2018/8/2.
 */

public class AppHandler<T> extends Handler {

    private final WeakReference<T> mT; //WeakReference是弱引用，不会影响mT对象的回收

    public AppHandler(T t) {
        mT = new WeakReference<T>(t);
    }

    public T getT() {
        return mT.get();
    }
}
