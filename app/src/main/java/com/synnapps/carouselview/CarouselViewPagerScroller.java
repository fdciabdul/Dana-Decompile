package com.synnapps.carouselview;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes8.dex */
public class CarouselViewPagerScroller extends Scroller {
    private int mScrollDuration;

    public CarouselViewPagerScroller(Context context) {
        super(context);
        this.mScrollDuration = 600;
    }

    public CarouselViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mScrollDuration = 600;
    }

    public int getmScrollDuration() {
        return this.mScrollDuration;
    }

    public void setmScrollDuration(int i) {
        this.mScrollDuration = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.mScrollDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.mScrollDuration);
    }
}
