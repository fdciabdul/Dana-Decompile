package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public abstract class e {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str3);
        if (!TextUtils.isEmpty(null)) {
            grsBaseInfo.setAppName(null);
        }
        String synGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl(str, str2);
        if (TextUtils.isEmpty(synGetGrsUrl)) {
            HMSLog.i("QueryGrs", "Query Grs base url is empty.");
            return "";
        }
        HMSLog.i("QueryGrs", "Query Grs base url success.");
        return synGetGrsUrl;
    }
}
