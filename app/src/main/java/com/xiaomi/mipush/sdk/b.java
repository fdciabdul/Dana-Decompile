package com.xiaomi.mipush.sdk;

import android.content.Context;

/* loaded from: classes8.dex */
public class b {
    public static String MyBillsEntityDataFactory(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".permission.MIPUSH_RECEIVE");
        return sb.toString();
    }
}
