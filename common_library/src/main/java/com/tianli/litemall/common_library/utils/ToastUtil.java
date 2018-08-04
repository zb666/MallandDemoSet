package com.tianli.litemall.common_library.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.tianli.litemall.common_library.R;


/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public class ToastUtil {
    static Toast mToast;

    /***
     * 单例Toast
     */
    public static void showMsg(Context mContext, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    public static void show(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    public static void showCustomToast(Context context) {
        if (context == null) return;
        Toast toast = new Toast(context.getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        View mView = LayoutInflater.from(context).inflate(R.layout.custom_empty_view, null);
        toast.setView(mView);
        toast.setGravity(Gravity.CENTER, 0, 70);
        toast.show();
    }
}
