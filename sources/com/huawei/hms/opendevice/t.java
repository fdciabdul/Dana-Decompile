package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class t {
    public static boolean getAuthRequestContext(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
