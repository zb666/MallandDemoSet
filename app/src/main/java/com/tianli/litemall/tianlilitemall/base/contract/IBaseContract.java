package com.tianli.litemall.tianlilitemall.base.contract;

import android.view.View;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public interface IBaseContract {

    interface IBasePresenter<V extends IBaseView> {

        void startRequest();

        void subscribe();

        void unsubscribe();

        void attachView(V view);

        void detachView();
    }

    interface IBaseView {
        void showDialog();

        void showLogingView();

        void openNewActivity(Class<?> tClass);
    }
}
