package com.alibaba.ariver.app.api;

import android.util.Log;
import com.alibaba.ariver.app.api.point.error.JsErrorPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class JsErrorAssist {
    public static void postJsErrorMessage(App app, String str) {
        if (app == null) {
            RVLogger.d("V8WorkerAssist", "app is null");
        } else {
            ((JsErrorPoint) ExtensionPoint.as(JsErrorPoint.class).node(app).create()).onJsErrorMessage(str, app.getActivePage());
        }
    }

    public static void postJsErrorMessage(String str, Page page) {
        if (page == null || page.getApp() == null) {
            RVLogger.d("V8WorkerAssist", "page or app is null");
        } else {
            ((JsErrorPoint) ExtensionPoint.as(JsErrorPoint.class).node(page.getApp()).create()).onJsErrorMessage(str, page);
        }
    }

    public static String getStackTraceString(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception e) {
            RVLogger.e("V8WorkerAssist", "getStackTraceString exception:", e);
            return "";
        }
    }
}
