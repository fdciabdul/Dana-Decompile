package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.R;

/* loaded from: classes7.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat implements FSDraw, FSDispatchDraw {
    private Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;
    public static final byte[] PlaceComponentResult = {4, -87, 42, 65, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 88;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        fsSuperDispatchDraw_ab615463d0f7b9caa58e1cfc2c57a46a(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_ab615463d0f7b9caa58e1cfc2c57a46a(canvas, view, j);
    }

    public void fsSuperDispatchDraw_ab615463d0f7b9caa58e1cfc2c57a46a(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_ab615463d0f7b9caa58e1cfc2c57a46a(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public void fsSuperDraw_ab615463d0f7b9caa58e1cfc2c57a46a(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selfBounds = new Rect();
        this.overlayBounds = new Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.foregroundGravity = obtainStyledAttributes.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.ForegroundLinearLayout_android_foreground);
        if (__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d != null) {
            setForeground(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d);
        }
        this.mForegroundInPadding = obtainStyledAttributes.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.foregroundGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.foregroundGravity = i;
            if (i == 119 && this.foreground != null) {
                this.foreground.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.foreground;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.foreground;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.foreground.setState(getDrawableState());
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.foreground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.foreground);
            }
            this.foreground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.foregroundGravity == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.foreground;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.foregroundBoundsChanged = z | this.foregroundBoundsChanged;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.foregroundBoundsChanged = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        fsSuperDraw_ab615463d0f7b9caa58e1cfc2c57a46a(canvas);
        Drawable drawable = this.foreground;
        if (drawable != null) {
            if (this.foregroundBoundsChanged) {
                this.foregroundBoundsChanged = false;
                Rect rect = this.selfBounds;
                Rect rect2 = this.overlayBounds;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.mForegroundInPadding) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.foregroundGravity, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:15:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r8, int r9) {
        /*
            byte[] r0 = com.google.android.material.internal.ForegroundLinearLayout.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 97
            r3 = 3
            r4 = -1
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 3
            r5 = 3
            r6 = -1
            r1 = r0
            r0 = r9
            r9 = r8
            goto L4b
        L14:
            r2 = r1
            r3 = 97
            r4 = 3
            r5 = -1
            r1 = r0
            r0 = r9
            r9 = r8
        L1c:
            int r4 = r4 + 1
            int r5 = r5 + 1
            byte r6 = (byte) r3
            r2[r5] = r6
            r6 = 22
            if (r5 != r6) goto L43
            java.lang.String r1 = new java.lang.String
            r3 = 0
            r1.<init>(r2, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r8 = r1.isInstance(r8)
            if (r8 == 0) goto L3e
            android.content.Context r9 = (android.content.Context) r9
            android.graphics.drawable.Drawable r8 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r9, r0)
            return r8
        L3e:
            android.graphics.drawable.Drawable r8 = r9.getDrawable(r0)
            return r8
        L43:
            r6 = r1[r4]
            r7 = r3
            r3 = r2
            r2 = r6
            r6 = r5
            r5 = r4
            r4 = r7
        L4b:
            int r2 = -r2
            int r4 = r4 + r2
            int r2 = r4 + (-8)
            r4 = r5
            r5 = r6
            r7 = r3
            r3 = r2
            r2 = r7
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ForegroundLinearLayout.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
