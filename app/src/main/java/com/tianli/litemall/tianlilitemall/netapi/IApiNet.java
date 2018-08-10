package com.tianli.litemall.tianlilitemall.netapi;

import com.tianli.litemall.tianlilitemall.base.BaseData;
import com.tianli.litemall.tianlilitemall.model.DouBanBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zhoubo30110 on 2018/8/5.
 *     //发送注册验证码
 @FormUrlEncoded
 @POST(HttpUrl.SENDREGISTERCAPTCHA)
 Observable<BaseBean<BaseBoolData>> sendcaptcha(@FieldMap HashMap<String, String> hashMap);
 */

public interface IApiNet {
   //刷新token http://47.98.65.195:8082/wx/auth/regCaptcha
    @FormUrlEncoded
    @POST("auth/regCaptcha")
    Call<BaseData<String>> getMobileRegCapCode(@Field("mobile") String mobile);

    //https://api.douban.com/v2/movie/top250?start=1&count=10
    @FormUrlEncoded
    @POST("movie/top250")
    Call<DouBanBean> getDouban(@Field("start") String start, @Field("count") String count);

}
