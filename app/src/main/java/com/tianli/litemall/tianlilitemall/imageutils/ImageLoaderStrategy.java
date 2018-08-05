package com.tianli.litemall.tianlilitemall.imageutils;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public interface ImageLoaderStrategy {
    void showImage(View v, String url, ImageLoaderOptions options);

    void showImage(View v, int drawable,ImageLoaderOptions options);

    void showImage(ImageView imageView,String url);
}
