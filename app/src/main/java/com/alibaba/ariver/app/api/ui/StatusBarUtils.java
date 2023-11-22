package com.alibaba.ariver.app.api.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.Window;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;

/* loaded from: classes2.dex */
public class StatusBarUtils {

    /* renamed from: a  reason: collision with root package name */
    private static int f5971a;

    public static boolean isSupport() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void setTransparentColor(Activity activity, int i) {
        if (!isSupport() || activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(APEncodeOptions.DEFAULT_MAX_LEN);
        window.setStatusBarColor(i);
    }

    public static int getStatusBarHeight(Context context) {
        if (f5971a < 3) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
            f5971a = dimensionPixelSize;
            if (dimensionPixelSize < 3 && (context instanceof Activity)) {
                try {
                    Rect rect = new Rect();
                    ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    f5971a = rect.top;
                    StringBuilder sb = new StringBuilder();
                    sb.append(" status bar height rect height = ");
                    sb.append(f5971a);
                    RVLogger.d("StatusBarUtils", sb.toString());
                } catch (Throwable unused) {
                }
            }
        }
        return f5971a;
    }

    public static boolean isConfigSupport() {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_supportStatusBar", true);
    }
}
