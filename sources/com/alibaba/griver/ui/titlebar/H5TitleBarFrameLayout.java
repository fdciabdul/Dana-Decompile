package com.alibaba.griver.ui.titlebar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class H5TitleBarFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ColorDrawable f6766a;
    private boolean b;

    public H5TitleBarFrameLayout(Context context) {
        super(context);
        this.f6766a = null;
        this.b = true;
        a();
    }

    public H5TitleBarFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6766a = null;
        this.b = true;
        a();
    }

    public H5TitleBarFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6766a = null;
        this.b = true;
        a();
    }

    private void a() {
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.griver_nav_bar));
        this.f6766a = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public ColorDrawable getContentBgView() {
        return this.f6766a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.b;
    }

    public void setPreventTouchEvent(boolean z) {
        this.b = z;
    }
}
