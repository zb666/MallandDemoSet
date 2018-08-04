package com.tianli.litemall.ui_factory;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by zhoubo30110 on 2018/8/3.
 */

public class CustomCommonView extends FrameLayout{
    public CustomCommonView(@NonNull Context context) {
        this(context,null);
    }

    public CustomCommonView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomCommonView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View customView = LayoutInflater.from(getContext()).inflate(R.layout.custom_empty_view,this);
    }
}
