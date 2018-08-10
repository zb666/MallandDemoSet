package com.tianli.litemall.tianlilitemall.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.bumptech.glide.Glide;
import com.tianli.litemall.tianlilitemall.configinit.InitService;
import com.tianli.litemall.tianlilitemall.netimpl.NetRequest;
import com.tianli.litemall.tianlilitemall.netstrategy.OkhttpStrategy;

/**
 * Created by zhoubo30110 on 2018/8/1.
 */

public class LiteMallApp extends Application {

    public static boolean isFinishInit = false;

    private static LiteMallApp sLiteMallApp;

    private Context mContext;//上下文

    private static final NetRequest NET_REQUEST = new NetRequest();

    @Override
    public void onCreate() {
        super.onCreate();
        InitService.startService(this);
        //初始化该对象
        mContext = getApplicationContext();
        NET_REQUEST.setNetProxy(new OkhttpStrategy());
    }

    public synchronized static LiteMallApp getInstance() {
        if (null == sLiteMallApp) {
            sLiteMallApp = new LiteMallApp();
        }
        return sLiteMallApp;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    /**
     * 重启当前应用
     */
    public void restart() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext
                .getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }


}
