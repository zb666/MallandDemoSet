package com.tianli.litemall.common_library.request;

import com.alibaba.fastjson.JSON;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.adapter.rxjava2.Result;

/**
* @Description:
* @ClassName: RxRequestManager
* @Author: zhoub@hsyuntai.com
* @Date: 2018/7/31 20:20
 * *@Copyright: 版权归 Hundsun 所有 <ModifyLog>
 * @ModifyContent:
 * @Author:
 * @Date: </ModifyLog>
*/
public class RxRequestManager {

    //为了用fastJson而进行这样的转化
   public static <T> Observable<T> testResponse(final Observable<Result<String>> observable, final Class<T> clazz) {
        return observable
                .compose(new ObservableTransformer<Result<String>, T>() {
                    @Override public ObservableSource<T> apply(@NonNull Observable<Result<String>> upstream) {
                        return upstream.map(new Function<Result<String>, T>() {
                            @Override public T apply(@NonNull Result<String> stringResult) throws Exception {
                                //fastJson数据解析器
                                return JSON.parseObject(stringResult.response().body(), clazz);
                            }
                        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                    }
                });
    }
}
