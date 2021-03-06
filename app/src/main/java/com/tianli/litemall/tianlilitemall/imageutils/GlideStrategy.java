package com.tianli.litemall.tianlilitemall.imageutils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tianli.litemall.tianlilitemall.R;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void showImage(ImageView imageView, String url) {
        RequestOptions requestOptions = RequestOptions.centerCropTransform();
        requestOptions.placeholder(imageView.getContext().getDrawable(R.drawable.no_network_pic));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
}
