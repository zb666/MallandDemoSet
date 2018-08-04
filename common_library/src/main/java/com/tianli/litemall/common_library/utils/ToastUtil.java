package com.tianli.litemall.common_library.utils;

import android.content.Context;
import android.widget.Toast;

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
}
