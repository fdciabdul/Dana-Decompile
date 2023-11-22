package com.alibaba.ariver.kernel.common.utils;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class LangResourceUtil {
    public static String getString(Context context, int i) {
        if (context != null) {
            return context.getString(i);
        }
        return a(i);
    }

    public static String getString(int i) {
        return a(i);
    }

    private static String a(int i) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
        if (topActivity == null) {
            return rVEnvironmentService.getApplicationContext().getString(i);
        }
        Activity activity = topActivity.get();
        if (activity != null) {
            return activity.getString(i);
        }
        return rVEnvironmentService.getApplicationContext().getString(i);
    }
}
