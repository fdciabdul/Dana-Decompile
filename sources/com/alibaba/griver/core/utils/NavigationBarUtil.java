package com.alibaba.griver.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowInsets;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class NavigationBarUtil {
    private static String d;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6479a = true;
    private final int b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface OnNavigationStateListener {
        void onNavigationState(boolean z, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                d = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                d = null;
            }
        }
    }

    public NavigationBarUtil(Activity activity) {
        this.c = activity.getResources().getConfiguration().orientation == 1;
        this.b = a(activity);
        a(activity, new OnNavigationStateListener() { // from class: com.alibaba.griver.core.utils.NavigationBarUtil.1
            @Override // com.alibaba.griver.core.utils.NavigationBarUtil.OnNavigationStateListener
            public void onNavigationState(boolean z, int i) {
                NavigationBarUtil.this.f6479a = z;
            }
        });
    }

    private int a(Context context) {
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT < 14 || !b(context)) {
            return 0;
        }
        return a(resources, this.c ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    private boolean b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(d)) {
                return false;
            }
            if ("0".equals(d)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    private void a(final Activity activity, final OnNavigationStateListener onNavigationStateListener) {
        if (activity == null) {
            return;
        }
        final int a2 = a(activity);
        if (Build.VERSION.SDK_INT >= 20) {
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.alibaba.griver.core.utils.NavigationBarUtil.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    int i;
                    boolean z = false;
                    if (windowInsets != null) {
                        i = windowInsets.getSystemWindowInsetBottom();
                        if (i == a2) {
                            z = true;
                        }
                    } else {
                        i = -1;
                    }
                    OnNavigationStateListener onNavigationStateListener2 = onNavigationStateListener;
                    if (onNavigationStateListener2 != null && i <= a2) {
                        onNavigationStateListener2.onNavigationState(z, i);
                    }
                    return activity.getWindow().getDecorView().onApplyWindowInsets(windowInsets);
                }
            });
        }
    }

    private int a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public boolean hasNavigationBar() {
        return this.f6479a;
    }

    public int getNavigationBarHeight() {
        return this.b;
    }
}
