package com.iap.ac.android.common.instance;

import android.content.Context;

/* loaded from: classes.dex */
public class InstanceInfo {
    public static final String TAG = "InstanceInfo";
    public static IInstanceInfo instanceInfo;

    public static String getInstanceId(Context context) {
        IInstanceInfo iInstanceInfo = instanceInfo;
        if (iInstanceInfo != null) {
            return iInstanceInfo.getInstanceId(context);
        }
        return null;
    }

    public static IInstanceInfo getInstanceInfoImpl() {
        return instanceInfo;
    }

    public static String getTid(Context context) {
        IInstanceInfo iInstanceInfo = instanceInfo;
        if (iInstanceInfo != null) {
            return iInstanceInfo.getTid(context);
        }
        return null;
    }

    public static void setInstanceInfoImpl(IInstanceInfo iInstanceInfo) {
        instanceInfo = iInstanceInfo;
    }
}
