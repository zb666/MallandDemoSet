package com.tianli.litemall.tianlilitemall.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;
import com.tianli.litemall.tianlilitemall.vlayout.OneDragNActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class OneFragmeng extends BaseFragmentImpl {
    @BindView(R.id.textView)
    Button textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    Unbinder unbinder;

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.main_fragment_one;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.textView, R.id.button, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView:
                startActivity(OneDragNActivity.class);
                break;
            case R.id.button:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
        }
    }

}
