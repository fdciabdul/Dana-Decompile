package com.synnapps.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class CarouselViewPager extends ViewPager {
    private ImageClickListener imageClickListener;
    private CarouselViewPagerScroller mScroller;
    private float newX;
    private float oldX;
    private float sens;

    public void setImageClickListener(ImageClickListener imageClickListener) {
        this.imageClickListener = imageClickListener;
    }

    public CarouselViewPager(Context context) {
        super(context);
        this.oldX = 0.0f;
        this.newX = 0.0f;
        this.sens = 5.0f;
        this.mScroller = null;
        postInitViewPager();
    }

    public CarouselViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oldX = 0.0f;
        this.newX = 0.0f;
        this.sens = 5.0f;
        this.mScroller = null;
        postInitViewPager();
    }

    private void postInitViewPager() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            CarouselViewPagerScroller carouselViewPagerScroller = new CarouselViewPagerScroller(getContext(), (Interpolator) declaredField2.get(null));
            this.mScroller = carouselViewPagerScroller;
            declaredField.set(this, carouselViewPagerScroller);
        } catch (Exception unused) {
        }
    }

    public void setTransitionVelocity(int i) {
        this.mScroller.setmScrollDuration(i);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldX = motionEvent.getX();
        } else if (action == 1) {
            float x = motionEvent.getX();
            this.newX = x;
            if (Math.abs(this.oldX - x) < this.sens) {
                ImageClickListener imageClickListener = this.imageClickListener;
                if (imageClickListener != null) {
                    imageClickListener.onClick(getCurrentItem());
                }
                return true;
            }
            this.oldX = 0.0f;
            this.newX = 0.0f;
        }
        return super.onTouchEvent(motionEvent);
    }
}
