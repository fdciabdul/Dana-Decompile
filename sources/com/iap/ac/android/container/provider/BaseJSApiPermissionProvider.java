package com.iap.ac.android.container.provider;

import android.text.TextUtils;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.ACContainer;
import com.iap.ac.android.container.utils.UrlUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class BaseJSApiPermissionProvider implements JsApiPermissionProvider {
    private static final String PROTOCOL_HTTP = "http:";
    private static final String PROTOCOL_HTTPS = "https:";
    public static final String TAG = "BaseJsPermissionProvider";

    public abstract Map<String, List<String>> getJSApiPermissionConfig();

    @Override // com.iap.ac.android.common.container.provider.JsApiPermissionProvider
    public boolean hasDomainPermission(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSAPI call rejected. url is empty! action = ");
            sb.append(str);
            ACLog.d(TAG, sb.toString());
            return false;
        } else if (!ACContainer.DEBUG && !str2.startsWith("http:") && !str2.startsWith("https:")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JSAPI call rejected by http check action = ");
            sb2.append(str);
            sb2.append(", url = ");
            sb2.append(str2);
            ACLog.d(TAG, sb2.toString());
            return false;
        } else if (isBannedJSAPI(str, str2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("JSAPI call rejected by isBannedJSAPI. action = ");
            sb3.append(str);
            sb3.append(", url = ");
            sb3.append(str2);
            ACLog.d(TAG, sb3.toString());
            return false;
        } else {
            return true;
        }
    }

    public final boolean isBannedJSAPI(String str, String str2) {
        if (ACContainer.DEBUG || str2.startsWith("http:") || str2.startsWith("https:")) {
            String purifyUrl = UrlUtils.purifyUrl(str2);
            Map<String, List<String>> jSApiPermissionConfig = getJSApiPermissionConfig();
            return (jSApiPermissionConfig != null && jSApiPermissionConfig.containsKey(str)) && !inWhitelist(purifyUrl, jSApiPermissionConfig.get(str));
        }
        return true;
    }

    public boolean inWhitelist(String str, List<String> list) {
        if (list == null || list.isEmpty() || list.contains(str)) {
            return true;
        }
        boolean z = false;
        for (String str2 : list) {
            if (z || !UrlUtils.isDomainMatch(str2, str)) {
                if (!UrlUtils.isDomainMatch(UrlUtils.getHost(str2), str)) {
                    continue;
                } else if (!TextUtils.isEmpty(UrlUtils.getPath(str2))) {
                    return false;
                }
            }
            z = true;
        }
        return z;
    }
}
