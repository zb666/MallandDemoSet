package com.tianli.litemall.tianlilitemall.imageutils;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
* @Description: 具体实现层
* @ClassName: GlideStrategy
* @Author: zhoub
* @Date: 2018/8/5 23:59
 * *@Copyright: 版权归所有 <ModifyLog>
 * @ModifyContent:
 * @Author:
 * @Date: </ModifyLog>
*/
public class GlideStrategy implements ImageLoaderStrategy{


    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {

    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {

    }

    @Override
    public void showImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
