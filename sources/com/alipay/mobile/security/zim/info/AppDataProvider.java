package com.alipay.mobile.security.zim.info;

import android.content.Context;

/* loaded from: classes3.dex */
public interface AppDataProvider {
    String getApdidToken(Context context);

    String getAppName(Context context);

    String getAppVersion(Context context);

    String getDeviceModel();

    String getDeviceType();

    String getOsVersion();
}
