package com.svs.nhatro.others.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by DangQuang on 04/19/17.
 **/

public class NotScrollViewPager extends ViewPager {

    private boolean isPagingEnabled = false;

    public NotScrollViewPager(Context context) {
        super(context);
    }

    public NotScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @SuppressWarnings("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }
}
