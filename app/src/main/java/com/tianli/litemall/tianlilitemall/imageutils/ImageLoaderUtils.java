package com.tianli.litemall.tianlilitemall.imageutils;

import android.widget.ImageView;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public final class ImageLoaderUtils implements ImageLoader {

    private ImageLoaderStrategy imageLoaderStrategy;

    private ImageLoaderUtils() {
        imageLoaderStrategy = new GlideStrategy();
    }

    private static final class HOLDER {
        private static final ImageLoaderUtils INSTANCE = new ImageLoaderUtils();
    }

    public static ImageLoaderUtils getInstance() {
        return HOLDER.INSTANCE;
    }

    @Override
    public void showImage(ImageView imageView, String targetUrl) {
        //具体的抽象行为，由具体的策略类来进行实现
        if (imageLoaderStrategy == null)
            throw new NullPointerException("please give the image strategy before you invoke this method-=>showImage(ImageView imageView, String targetUrl)");
        imageLoaderStrategy.showImage(imageView, targetUrl);
    }
}
