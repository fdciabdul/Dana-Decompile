package com.alipay.iap.android.f2fpay.b.a;

import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes6.dex */
public class b {
    public static void a(Window window) {
        window.setFlags(8192, 8192);
    }

    public static void a(Window window, float f) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.screenBrightness < f) {
            attributes.screenBrightness = f;
            window.setAttributes(attributes);
        }
    }
}
