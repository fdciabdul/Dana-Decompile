package com.alipay.mobile.apmap.util;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public abstract class DynamicMapView extends FrameLayout implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7117a;
    private boolean b;
    private boolean c;
    protected long mCreateBeginTime;
    protected long mCreateEndTime;
    protected boolean mCreateMapFailed;

    protected abstract void onCreateMapView(Context context, AttributeSet attributeSet, int i);

    public DynamicMapView(Context context) {
        this(context, null);
    }

    public DynamicMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7117a = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f7117a = false;
        this.mCreateBeginTime = System.currentTimeMillis();
        try {
            onCreateMapView(context, attributeSet, i);
        } catch (Throwable th) {
            this.mCreateMapFailed = true;
            RVLogger.e("DynamicMapView", th);
            a();
        }
        this.mCreateEndTime = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public boolean isCreateMapFailed() {
        return this.mCreateMapFailed;
    }

    public void setCreateMapTracked(boolean z) {
        this.c = z;
    }

    private void a() {
        removeAllViews();
        TextView textView = new TextView(getContext());
        textView.setBackgroundColor(-1974820);
        textView.setTextColor(-11119018);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setText("load map failed，please try again later。");
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(textView);
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.f7117a;
    }

    public void setMatchScreenSize(boolean z) {
        this.b = z;
    }

    public boolean isMatchScreenSize() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View decorView;
        int i3;
        super.onMeasure(i, i2);
        if (this.b && (decorView = getDecorView()) != null) {
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            int i4 = width * height;
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (i4 <= 0 || measuredWidth * measuredHeight <= i4) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("measure size overflow: ");
            sb.append(measuredWidth);
            sb.append(",");
            sb.append(measuredHeight);
            sb.append(" > ");
            sb.append(width);
            sb.append(",");
            sb.append(height);
            RVLogger.d("DynamicMapView", sb.toString());
            if (measuredWidth > width) {
                i3 = i4 / height;
            } else {
                i3 = i4 / measuredWidth;
                width = measuredWidth;
            }
            setMeasuredDimension(width, i3);
            measureChildren(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fix measure size after overflow: ");
            sb2.append(width);
            sb2.append(",");
            sb2.append(i3);
            RVLogger.d("DynamicMapView", sb2.toString());
        }
    }

    private View getDecorView() {
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getWindow() == null) {
                return null;
            }
            return activity.getWindow().getDecorView();
        }
        return null;
    }
}
