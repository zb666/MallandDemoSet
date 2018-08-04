package com.tianli.litemall.common_library.utils.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

//简单封装下
public class ImageUtils {

    public static void loadUrl(Context context, String url, ImageView targetView) {
        Glide.with(context)
                .load(url)
                .into(targetView);
    }

    public static void loadFile(Context context, File file, ImageView targetView) {
        Glide.with(context)
                .load(file)
                .into(targetView);
    }


    public static void loadDisk(Context context, String url, ImageView targetView) {
        Glide.with(context)
                .load(url)
                .into(targetView);
    }


    public static void recycleImageMomory() {

    }
}
