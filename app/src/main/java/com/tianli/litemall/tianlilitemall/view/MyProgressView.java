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

import com.tianli.litemall.common_library.utils.DensityUtil;
import com.tianli.litemall.common_library.utils.LogUtil;

/**
 * Created by zhoubo30110 on 2018/8/9.
 */

public class MyProgressView extends View {

    private Paint mPaint;
    private Paint mDashPaint;
    private Path mPath;
    private Path mDashPath;
    private int mFixDpi;

    private int isDashPaint = 0;

    private static final int DASH_PAINT_LINE = 0;

    private static final int FILL_PAINT_LINE = 1;

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

        mFixDpi = DensityUtil.dip2px(getContext(), 50);

        //虚线所需要的画笔
        mDashPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDashPaint.setStyle(Paint.Style.STROKE);
        mDashPaint.setColor(Color.BLUE);
        mDashPaint.setStrokeWidth(2);
        //绘制实线
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);

        mDashPath = new Path();
        mDashPath.moveTo(mFixDpi, DensityUtil.dip2px(getContext(), 190));
        mDashPath.lineTo(mFixDpi, DensityUtil.dip2px(getContext(), 290));
        PathEffect pathEffect = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
        mDashPaint.setPathEffect(pathEffect);

    }

    public void setPath(Path path) {
        mDashPath.addPath(path);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        canvas.drawCircle(mFixDpi, mFixDpi, DensityUtil.dip2px(getContext(), 20), mPaint);
        //画实线
        canvas.drawLine(mFixDpi, DensityUtil.dip2px(getContext(), 70), mFixDpi, DensityUtil.dip2px(getContext(), 170), mPaint);
        //画圆
        canvas.drawCircle(mFixDpi, DensityUtil.dip2px(getContext(), 180), DensityUtil.dip2px(getContext(), 10), mPaint);
        //画虚线
        if (isDashPaint == DASH_PAINT_LINE) {
            canvas.drawPath(mDashPath, mDashPaint);
        } else if (isDashPaint == FILL_PAINT_LINE) {
            LogUtil.d("重新进行绘制");
            canvas.drawLine(mFixDpi, DensityUtil.dip2px(getContext(), 190), mFixDpi, DensityUtil.dip2px(getContext(), 290), mPaint);
        }
        //结束点的圆
        canvas.drawCircle(mFixDpi, DensityUtil.dip2px(getContext(), 300), DensityUtil.dip2px(getContext(), 10), mPaint);
    }

    public void setPayStatus(int payStatus) {
        if (payStatus == FILL_PAINT_LINE) {
            this.isDashPaint = payStatus;
            mDashPaint.setColor(Color.RED);
            mPaint.setColor(Color.RED);
            postInvalidate();
        }
    }

}
