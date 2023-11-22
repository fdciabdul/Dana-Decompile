package com.alipay.mobile.security.bio.utils;

import android.content.Context;
import android.os.Binder;

/* loaded from: classes7.dex */
public class PermissionHelper {
    public static int checkCallingOrSelfPermission(Context context, String str) {
        if (str == null || context == null) {
            throw new IllegalArgumentException("context or permission is null");
        }
        return context.checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid());
    }
}
