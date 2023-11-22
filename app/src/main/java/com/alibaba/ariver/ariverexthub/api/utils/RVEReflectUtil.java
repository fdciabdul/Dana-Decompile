package com.alibaba.ariver.ariverexthub.api.utils;

import android.text.TextUtils;
import com.alibaba.ariver.ariverexthub.api.RVEApiHandler;

/* loaded from: classes3.dex */
public class RVEReflectUtil {
    public static <T> T newInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) RVEReflectUtil.class.getClassLoader().loadClass(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<? extends RVEApiHandler> getApiClassForApiName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (Exception e) {
            ExtHubLogger.e("AriverExthub-RVEReflectUtil", "RVEReflectUtil.getApiClassForApiName", e);
            return null;
        }
    }
}
