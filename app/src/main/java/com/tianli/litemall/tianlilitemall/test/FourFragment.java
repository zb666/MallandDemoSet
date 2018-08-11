package com.tianli.litemall.tianlilitemall.test;

import android.view.View;
import android.widget.ViewFlipper;

import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;

import butterknife.BindView;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class FourFragment extends BaseFragmentImpl{
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
        vlMainFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mParent.showProgressDialog();
            }
        });
    }

    @Override
    public void initData() {
        vlMainFour.startFlipping();
        vlMainFour.setFlipInterval(3000);


    }


}
