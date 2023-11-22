package com.iap.ac.android.mpm.interceptor.provider;

import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.log.ACLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ACJsApiPermissionProvider implements JsApiPermissionProvider {
    private static final String TAG = "ACJsApiPermissionProvider";

    @Override // com.iap.ac.android.common.container.provider.JsApiPermissionProvider
    public boolean hasDomainPermission(String str, String str2) {
        return hasPermission(str, str2);
    }

    private boolean hasPermission(String str, String str2) {
        List<String> domains = getDomains(str);
        if (domains == null) {
            return true;
        }
        Iterator<String> it = domains.iterator();
        while (it.hasNext()) {
            if (Utils.isDomainMatch(it.next(), str2)) {
                return true;
            }
        }
        ACLog.d(TAG, String.format("JSAPI call rejected domains = %s, url = %s:", domains, str2));
        return false;
    }

    protected List<String> getDomains(String str) {
        return ConfigCenter.INSTANCE.getDomains(str);
    }
}
