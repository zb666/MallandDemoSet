package com.tianli.litemall.tianlilitemall.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhoubo30110 on 2018/8/9.
 */

public class MyProgressView extends View {

    private Paint mPaint;
    private Paint mDashPaint;
    private Path mPath;
    private Path mDashPath;

    public MyProgressView(Context context) {
        this(context, null);
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        //虚线所需要的画笔
        mDashPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDashPaint.setStyle(Paint.Style.STROKE);
        mDashPaint.setColor(Color.DKGRAY);
        mDashPaint.setStrokeWidth(2);

        mDashPath = new Path();
        mDashPath.moveTo(30,30);
        mDashPath.lineTo(30,100);
        PathEffect pathEffect = new DashPathEffect(new float[]{5,5,5,5},1);
        mDashPaint.setPathEffect(pathEffect);

    }

    public void setPath(Path path){
        mDashPath.addPath(path);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mDashPath,mDashPaint);

    }
}
