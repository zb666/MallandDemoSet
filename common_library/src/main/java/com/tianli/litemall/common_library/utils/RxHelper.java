package com.tianli.litemall.common_library.utils;


import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observable;
import rx.functions.Action0;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */
public class RxHelper<T> {
    //子线程运行，主线程回调
    //注意这里不能设置成静态，设置成静态之后泛型就不能用了。这也是我之前为什么subcribe的泛型只能为Object的原因，现在博客已经更新。
   @SuppressWarnings("unchecked")
    public Observable.Transformer<T, T> io_main(final RxAppCompatActivity context) {
        return new Observable.Transformer<T, T>() {

            @Override
            public Observable<T> call(Observable<T> tObservable) {

                return (Observable<T>) tObservable
                        .subscribeOn(rx.schedulers.Schedulers.io())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                //ProgressDialogUtil.showProgress中实现了弱引用，不会造成内存泄漏。
                               // ProgressDialogUtil.showProgress(context, "正在加载，请稍候");
                            }
                        })
                        .subscribeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                        .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                        .compose(RxLifecycle.bindUntilEvent(context.lifecycle(), ActivityEvent.STOP));

            }
        };
    }
}
