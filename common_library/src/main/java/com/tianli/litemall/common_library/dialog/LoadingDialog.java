package com.tianli.litemall.common_library.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tianli.litemall.common_library.R;


public class LoadingDialog extends AlertDialog {
    TextView tv_msg;
    ProgressBar av_anim;
    String txt;
    public LoadingDialog(Context context, String txt) {
        super(context, R.style.dialog_base);
        this.txt=txt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading_view);
        setCanceledOnTouchOutside(true);
        getWindow().setGravity(Gravity.CENTER);
        initView();
    }

    private void initView() {
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        av_anim = (ProgressBar) findViewById(R.id.av_anim);
        if (!TextUtils.isEmpty(txt)) {
            tv_msg.setText(txt);
        }
    }

    public void dismissLoading() {
        av_anim.setVisibility(View.GONE);
        dismiss();
    }
}
