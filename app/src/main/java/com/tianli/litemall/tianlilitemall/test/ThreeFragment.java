package com.tianli.litemall.tianlilitemall.test;

import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianli.litemall.common_library.utils.ToastUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.view.MyProgressView;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class ThreeFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.activity_other,null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView.findViewById(R.id.progressView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(getActivity(),"点击成功");
                Path path = new Path();
                path.moveTo(300,300);
                path.lineTo(300,600);
                ((MyProgressView)v).setPath(path);
                v.postInvalidate();
            }
        });
    }
}
