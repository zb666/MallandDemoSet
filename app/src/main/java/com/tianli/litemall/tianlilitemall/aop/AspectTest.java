package com.tianli.litemall.tianlilitemall.aop;

import com.tianli.litemall.common_library.utils.LogUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by zhoubo30110 on 2018/8/7.
 */

@Aspect
public class AspectTest {

    private static final String TAG = "ASPECT";

    @Before("execution(* android.app.Activity.on**(..))")
    public void onNeedActivityLogin(JoinPoint joinPoint) throws Throwable{
        String key = joinPoint.getSignature().toString();
        LogUtil.d(key);
    }

}
