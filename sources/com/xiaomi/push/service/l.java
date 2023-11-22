package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;

/* loaded from: classes8.dex */
public class l {
    public static boolean BuiltInFictitiousFunctionClassFactory(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ComponentName PlaceComponentResult(Context context, Intent intent) {
        if (intent != null) {
            try {
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    return new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
