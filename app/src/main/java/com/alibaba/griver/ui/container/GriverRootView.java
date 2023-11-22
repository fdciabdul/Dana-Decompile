package com.alibaba.griver.ui.container;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class GriverRootView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f6709a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    public GriverRootView(Context context) {
        super(context);
        this.f6709a = "H5FragmentRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    public GriverRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6709a = "H5FragmentRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    public GriverRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6709a = "H5FragmentRootView@";
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    public void init(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6709a);
        sb.append(hashCode());
        String obj = sb.toString();
        this.f6709a = obj;
        if (z) {
            RVLogger.d(obj, "disable mEnableNewAdjustInput by fullScreen.");
            this.b = false;
        }
        String str = this.f6709a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mEnableNewAdjustInput: ");
        sb2.append(this.b);
        RVLogger.d(str, sb2.toString());
        if (this.b) {
            this.e = StatusBarUtils.getStatusBarHeight(context);
            setFitsSystemWindows(true);
            if (context instanceof Activity) {
                ((Activity) context).getWindow().setSoftInputMode(16);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b) {
            String str = this.f6709a;
            StringBuilder sb = new StringBuilder();
            sb.append("onAttachedToWindow mNeedRestoreWindowInsets: ");
            sb.append(this.c);
            RVLogger.d(str, sb.toString());
            if (this.c) {
                a();
                this.c = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b) {
            String str = this.f6709a;
            StringBuilder sb = new StringBuilder();
            sb.append("onDetachedFromWindow mWindowInsetBottom: ");
            sb.append(this.d);
            RVLogger.d(str, sb.toString());
            if (this.d > 0) {
                this.c = true;
            }
        }
    }

    private void a() {
        if (Build.VERSION.SDK_INT > 19) {
            requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            requestFitSystemWindows();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsets2;
        if (!this.b) {
            return super.onApplyWindowInsets(windowInsets);
        }
        if (Build.VERSION.SDK_INT > 19) {
            int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop() - this.e;
            if (systemWindowInsetTop < 0) {
                systemWindowInsetTop = 0;
            }
            int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
            int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            this.d = systemWindowInsetBottom;
            windowInsets2 = windowInsets.replaceSystemWindowInsets(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, systemWindowInsetBottom);
        } else {
            windowInsets2 = windowInsets;
        }
        String str = this.f6709a;
        StringBuilder sb = new StringBuilder();
        sb.append("onApplyWindowInsets, before: ");
        sb.append(windowInsets);
        sb.append(", after: ");
        sb.append(windowInsets2);
        RVLogger.d(str, sb.toString());
        return super.onApplyWindowInsets(windowInsets2);
    }
}
