package com.alibaba.ariver.app;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class AppUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5958a;
    private static int b;
    private static int c;
    private static float d;

    public static String getAppIdFromNode(Node node) {
        try {
        } catch (Throwable th) {
            RVLogger.w("AriverApp", "getAppIdFromNode exception!", th);
        }
        if (node instanceof App) {
            return ((App) node).getAppId();
        }
        if (node instanceof Page) {
            return ((Page) node).getApp().getAppId();
        }
        return null;
    }

    public static void sendToApp(App app, String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        Page activePage = app.getActivePage();
        if (activePage == null || activePage.getRender() == null) {
            return;
        }
        EngineUtils.sendToRender(activePage.getRender(), str, jSONObject, sendToRenderCallback);
    }

    public static int getContainerWidth(PageContext pageContext) {
        if ((pageContext.getContentView() != null ? pageContext.getContentView().getWidth() : 0) <= 0) {
            a(pageContext.getActivity());
        }
        return b;
    }

    public static int getContainerHeight(PageContext pageContext) {
        if ((pageContext.getContentView() != null ? pageContext.getContentView().getHeight() : 0) <= 0) {
            a(pageContext.getActivity());
        }
        return c;
    }

    private static void a(Context context) {
        if (f5958a) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        d = displayMetrics.density;
        if (i < i2) {
            b = i;
            c = i2;
        } else {
            b = i2;
            c = i;
        }
        f5958a = true;
    }

    public static boolean enableUpdatePkgRes() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_updateNbPkgRes", "yes"));
    }

    public static void filterBundleKey(Bundle bundle, JSONArray jSONArray) {
        if (bundle == null) {
            RVLogger.d("AppUtils", "sourceBundle is null");
        } else if (jSONArray == null || jSONArray.isEmpty()) {
            RVLogger.d("AppUtils", "not filter config");
        } else {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                String string = jSONArray.getString(i);
                if (bundle.containsKey(string)) {
                    bundle.remove(string);
                    StringBuilder sb = new StringBuilder();
                    sb.append("filter startParams on parcel. key=");
                    sb.append(string);
                    RVLogger.d("AppUtils", sb.toString());
                }
            }
        }
    }
}
