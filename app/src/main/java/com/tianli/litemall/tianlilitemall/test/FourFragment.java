package com.tianli.litemall.tianlilitemall.test;

import android.widget.ViewFlipper;

import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class FourFragment extends BaseFragmentImpl {
    @BindView(R.id.vl_main_four)
    ViewFlipper vlMainFour;

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.common_emptyview;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        vlMainFour.startFlipping();
        vlMainFour.setFlipInterval(3000);

        Observable.just("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(@NonNull String s) throws Exception {
                        return Integer.valueOf(s);
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        LogUtil.d("数字是："+integer);
                    }
                });


    }


}
