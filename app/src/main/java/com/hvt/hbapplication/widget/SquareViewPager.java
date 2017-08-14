package com.hvt.hbapplication.widget;

import android.content.Context;
import android.util.AttributeSet;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Hado on 8/14/17.
 */

public class SquareViewPager extends AutoScrollViewPager {

    public SquareViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = width;
        setMeasuredDimension(width, height);
    }
}