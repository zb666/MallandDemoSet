package com.tianli.litemall.tianlilitemall.netapi;

import com.tianli.litemall.tianlilitemall.base.BaseData;

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
   //刷新token
    @FormUrlEncoded
    @POST("member/name/check")
    Call<BaseData<String>> getMobileRegCapCode(@Field("mobile") String mobile);
}
