package com.alibaba.griver.core.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class AndroidBug5497Workaround {

    /* renamed from: a  reason: collision with root package name */
    private View f6476a;
    private int b;
    private FrameLayout.LayoutParams c;
    private int d;
    private NavigationBarUtil e;
    private Rect f = new Rect();

    public static void assistActivity(Activity activity, boolean z) {
        try {
            new AndroidBug5497Workaround(activity, z);
        } catch (Throwable th) {
            GriverLogger.e("H5AndroidBug5497Workaround", "assistActivity failed", th);
        }
    }

    private AndroidBug5497Workaround(Activity activity, final boolean z) {
        this.e = new NavigationBarUtil(activity);
        this.f6476a = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        try {
            this.d = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Throwable th) {
            GriverLogger.e("H5AndroidBug5497Workaround", "construct AndroidBug5497Workaround failed", th);
        }
        this.f6476a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alibaba.griver.core.utils.AndroidBug5497Workaround.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    AndroidBug5497Workaround.this.a(z);
                } catch (Throwable th2) {
                    GriverLogger.e("H5AndroidBug5497Workaround", "get view tree observer failed", th2);
                }
            }
        });
        this.c = (FrameLayout.LayoutParams) this.f6476a.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int height;
        int height2;
        int a2 = a();
        if (a2 == this.b || (height2 = (height = this.f6476a.getRootView().getHeight()) - a2) < 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("heightDifference ");
        sb.append(height2);
        sb.append(" usableHeightSansKeyboard ");
        sb.append(height);
        sb.append(" statusBarHeight:");
        sb.append(this.d);
        sb.append(" hasNavigationBar ");
        sb.append(this.e.hasNavigationBar());
        sb.append(" NavigationBarHeight ");
        sb.append(this.e.getNavigationBarHeight());
        GriverLogger.d("H5AndroidBug5497Workaround", sb.toString());
        if (height2 > height / 4) {
            if (H5StatusBarUtils.isSupport() && H5StatusBarUtils.isConfigSupport() && !z) {
                this.c.height = (height - height2) + this.d;
            } else {
                this.c.height = height - height2;
                if (H5StatusBarUtils.isSupport()) {
                    this.c.topMargin = this.d;
                }
            }
        } else if (H5StatusBarUtils.isSupport() && H5StatusBarUtils.isConfigSupport() && !z) {
            this.c.height = height;
            if (this.e.hasNavigationBar()) {
                this.c.height -= this.e.getNavigationBarHeight();
            }
        } else {
            this.c.height = height - this.d;
            if (H5StatusBarUtils.isSupport()) {
                this.c.topMargin = this.d;
            }
        }
        this.f6476a.requestLayout();
        this.b = a2;
    }

    private int a() {
        this.f6476a.getWindowVisibleDisplayFrame(this.f);
        return this.f.bottom - this.f.top;
    }
}
