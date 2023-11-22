package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.R;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public class ScrimInsetsFrameLayout extends FrameLayout implements FSDraw {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {113, 46, 115, -60, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getAuthRequestContext = 107;
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public void fsSuperDraw_a616fdbcde8593f0f2fa5b9a012936f3(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.MyBillsEntityDataFactory(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsFrameLayout.this.insets == null) {
                    ScrimInsetsFrameLayout.this.insets = new Rect();
                }
                ScrimInsetsFrameLayout.this.insets.set(windowInsetsCompat.lookAheadTest(), windowInsetsCompat.initRecordTimeStamp(), windowInsetsCompat.getErrorConfigVersion(), windowInsetsCompat.moveToNextValue());
                ScrimInsetsFrameLayout.this.onInsetsChanged(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.NetworkUserEntityData$$ExternalSyntheticLambda2() || ScrimInsetsFrameLayout.this.insetForeground == null);
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.MyBillsEntityDataFactory();
            }
        });
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.insetForeground = drawable;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.drawTopInsetForeground = z;
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.drawBottomInsetForeground = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        fsSuperDraw_a616fdbcde8593f0f2fa5b9a012936f3(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets == null || this.insetForeground == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground) {
            this.tempRect.set(0, 0, width, this.insets.top);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
        }
        if (this.drawBottomInsetForeground) {
            this.tempRect.set(0, height - this.insets.bottom, width, height);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
        }
        this.tempRect.set(0, this.insets.top, this.insets.left, height - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        this.tempRect.set(width - this.insets.right, this.insets.top, width, height - this.insets.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = com.google.android.material.internal.ScrimInsetsFrameLayout.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            r4 = 4
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 4
            r7 = 0
            r8 = 22
            r1 = r0
            r0 = r11
            r11 = r10
            goto L44
        L15:
            r5 = 97
            r4 = r1
            r6 = 4
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            r4[r7] = r8
            if (r7 != r2) goto L3d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L38
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L38:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3d:
            int r7 = r7 + 1
            r8 = r1[r6]
            r9 = r5
            r5 = r4
            r4 = r9
        L44:
            int r4 = r4 + r8
            int r4 = r4 + (-8)
            int r6 = r6 + 1
            r9 = r5
            r5 = r4
            r4 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ScrimInsetsFrameLayout.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
