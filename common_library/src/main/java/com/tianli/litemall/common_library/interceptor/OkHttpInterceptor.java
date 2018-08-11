package com.tianli.litemall.common_library.interceptor;

import com.tianli.litemall.common_library.utils.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhoubo30110 on 2018/8/11.
 */

public class OkHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        LogUtil.d(originalRequest.toString());

        //然后是加工之后的请求
        //也可以使用请求体的方式去配置一些列的请求体

//        FormBody formBody = new FormBody.Builder().add("key值", "加密之后的数据").build();
//        //添加请求体 在这里进行请求参数的加密和解密的操作
//        Request updatedRequest = originalRequest.newBuilder()
//                    .post(formBody)
//                    .header("token", "这是一串token头数据")
//                    .addHeader("厉害了", "头数据")
//                    .build();
//        LogUtil.d(updatedRequest.toString());
        return chain.proceed(originalRequest);
    }
}
