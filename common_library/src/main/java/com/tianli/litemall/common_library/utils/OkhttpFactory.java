package com.tianli.litemall.common_library.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by zhoubo30110 on 2018/8/10.
 */

public class OkhttpFactory {

    public static OkHttpClient genericClient(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
        return httpClient;
    }
}
