package com.alibaba.griver.map.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alibaba.griver.base.common.utils.ReflectUtils;

/* loaded from: classes6.dex */
public class GPUtils {
    public static boolean isPlayStoreInstalled(Context context) {
        if (ReflectUtils.classExist("com.google.android.gms.common.GooglePlayServicesUtil")) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return false;
    }
}
