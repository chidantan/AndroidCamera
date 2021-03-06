package com.example.lyn.androidcamera.view.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2018/6/6.
 */

public class AutoFitSurfaceView extends SurfaceView {
    private int mRatioWidth = 0;
    private int mRatioHeight = 0;


    public AutoFitSurfaceView(Context context) {
        super(context);
    }

    public AutoFitSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAspectRatio(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (0 == mRatioWidth || 0 == mRatioHeight) {
            setMeasuredDimension(width, height);
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                height = width * mRatioHeight / mRatioWidth;
                setMeasuredDimension(width, height);
            } else {
                width = height * mRatioWidth / mRatioHeight;
                setMeasuredDimension(width, height);
            }
        }
    }
}
