package com.tianli.litemall.tianlilitemall.imageutils;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class IamgeUtilFactorty {

    public static ImageLoaderStrategy getIamgeUtilStrategy(){
        //这里应该进行一些类的初始化操作
        return new GlideStrategy();
    }

}
