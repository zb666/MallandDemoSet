package com.tianli.litemall.tianlilitemall.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;
import com.tianli.litemall.tianlilitemall.view.MyProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class ThreeFragment extends BaseFragmentImpl {


    @BindView(R.id.progressView)
    MyProgressView progressView;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.bt_request)
    Button btRequest;
    Unbinder unbinder;

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_other;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.button4, R.id.button5, R.id.bt_request})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button4:
                mParent.showProgressDialog();
                break;
            case R.id.button5:
                mParent.cancleProgressDialog();
                break;
            case R.id.bt_request:
                break;
        }
    }
}
