package com.alibaba.griver.base.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class NavigationBarCompat {
    public static int getHeight(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), "navigationbar_is_min", 0) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), "force_fsg_nav_bar", 0) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), "navigation_gesture_on", 0) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (android.provider.Settings.Secure.getInt(r3.getContentResolver(), "manual_hide_navigationbar", 0) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isShown(android.app.Activity r3) {
        /*
            boolean r0 = a(r3)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r0 >= r2) goto Lf
            return r1
        Lf:
            java.lang.String r0 = android.os.Build.BRAND
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L18
            return r1
        L18:
            java.lang.String r2 = "HUAWEI"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L2d
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.lang.String r0 = "navigationbar_is_min"
            int r3 = android.provider.Settings.Global.getInt(r3, r0, r1)
            if (r3 != 0) goto L71
            goto L6b
        L2d:
            java.lang.String r2 = "XIAOMI"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L42
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.lang.String r0 = "force_fsg_nav_bar"
            int r3 = android.provider.Settings.Global.getInt(r3, r0, r1)
            if (r3 != 0) goto L71
            goto L6b
        L42:
            java.lang.String r2 = "VIVO"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L57
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.lang.String r0 = "navigation_gesture_on"
            int r3 = android.provider.Settings.Global.getInt(r3, r0, r1)
            if (r3 != 0) goto L71
            goto L6b
        L57:
            java.lang.String r2 = "OPPO"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L6d
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.lang.String r0 = "manual_hide_navigationbar"
            int r3 = android.provider.Settings.Secure.getInt(r3, r0, r1)
            if (r3 != 0) goto L71
        L6b:
            r1 = 1
            goto L71
        L6d:
            boolean r1 = a(r3)
        L71:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "navigationBar isShown:"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "NavigationBarCompat"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.NavigationBarCompat.isShown(android.app.Activity):boolean");
    }

    private static boolean a(Context context) {
        String str;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        if (z) {
            return true;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
        } catch (Exception e) {
            RVLogger.e("NavigationBarCompat", e);
        }
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        return z;
    }

    private static boolean a(Activity activity) {
        try {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup == null) {
                return false;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                int id2 = viewGroup.getChildAt(i).getId();
                if (id2 != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(id2))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            RVLogger.e("NavigationBarCompat", th);
            return false;
        }
    }
}
