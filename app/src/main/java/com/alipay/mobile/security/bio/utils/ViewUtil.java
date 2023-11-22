package com.alipay.mobile.security.bio.utils;

import android.view.View;

/* loaded from: classes7.dex */
public class ViewUtil {
    public static <T> T findView(View view, int i, Class<T> cls) {
        try {
            return (T) view.findViewById(i);
        } catch (Exception unused) {
            return null;
        }
    }
}
