package com.tianli.litemall.tianlilitemall.configinit;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.tianli.litemall.tianlilitemall.app.LiteMallApp;
import com.tianli.litemall.tianlilitemall.imageutils.ImageUtilFactorty;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public class InitService extends IntentService {

    public static void startService(Context context) {
        Intent intent = new Intent(context, IntentService.class);
        context.startService(intent);
    }

    public InitService() {
        super("InitService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LiteMall.init(this)
                .withApiHost("http://47.98.65.195:8082/wx/")
                .withLoaderDelayed(1000)
                .withLeakCanary((Application) getApplicationContext())
                .withImageUtilInit(ImageUtilFactorty.createImageLoader())
                .initTimer()
                .configure();

        LiteMallApp.isFinishInit = true;
    }
}
