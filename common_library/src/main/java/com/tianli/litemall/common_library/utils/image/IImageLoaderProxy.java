package com.tianli.litemall.common_library.utils.image;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public interface IImageLoaderProxy {
    void loadUrl(Context context,String url, ImageView targetView);
    void loadFile(Context context, File file, ImageView targetView);
    void loadDisk(Context context,String url, ImageView targetView);
    void recycleImageMomory();
}
