package com.iap.ac.android.biz.internal;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.model.CommonConfig;

/* loaded from: classes8.dex */
public class IAPConnectRoute {

    /* loaded from: classes8.dex */
    public enum a {
        AC,
        PA
    }

    public static a getScenarioTypeByRegion(String str) {
        if (TextUtils.isEmpty(str)) {
            return a.PA;
        }
        a aVar = a.PA;
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        return (commonConfig == null || TextUtils.equals(commonConfig.defaultRegion, str)) ? aVar : a.AC;
    }
}
