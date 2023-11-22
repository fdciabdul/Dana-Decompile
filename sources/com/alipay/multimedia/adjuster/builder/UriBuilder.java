package com.alipay.multimedia.adjuster.builder;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.griver.h5.permission.GriverJSAPIPermission;
import com.alipay.multimedia.adjuster.api.data.ITraceId;
import com.alipay.multimedia.adjuster.config.ConfigMgr;
import com.alipay.multimedia.adjuster.utils.AliCdnUtils;
import com.alipay.multimedia.adjuster.utils.Log;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes7.dex */
public class UriBuilder {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ITraceId f7331a;
    private static final Log b = Log.getLogger("UriBuilder");

    public static boolean isOnline() {
        return true;
    }

    private static String a(String str, String str2, String str3, boolean z) {
        if (!a(str) && AliCdnUtils.isHttp(Uri.parse(str))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "mm_other";
            }
            String substring = str.substring(str.lastIndexOf("//") + 2, str.length());
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("/uri/file/");
            sb.append(substring);
            if (substring.contains("?")) {
                sb.append("&bz=");
                sb.append(str3);
            } else {
                sb.append("?bz=");
                sb.append(str3);
                sb.append("&tid=");
                sb.append(a());
            }
            if (z) {
                sb.append("&tid=");
                sb.append(a());
            }
            return sb.toString();
        }
        return str;
    }

    public static String buildAftsFilecCdnUrl(String str, String str2, boolean z) {
        return a(str, getAftsCdnHost(), str2, z);
    }

    public static String buildAftsFileMasterUrl(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String aftsMasterHost = getAftsMasterHost();
        String[] aftsCdnPrefixs = getAftsCdnPrefixs();
        if (aftsCdnPrefixs != null && aftsCdnPrefixs.length > 0) {
            int length = aftsCdnPrefixs.length;
            for (int i = 0; i < length; i++) {
                String str3 = aftsCdnPrefixs[i];
                if (str.contains(str3)) {
                    String replace = str.replace(GriverJSAPIPermission.PROTOCOL_HTTP, GriverJSAPIPermission.PROTOCOL_HTTPS);
                    if (!str3.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://");
                        sb.append(str3);
                        str3 = sb.toString();
                    }
                    return replace.replace(str3, aftsMasterHost);
                }
            }
        }
        return a(str, aftsMasterHost, str2, z);
    }

    private static String a() {
        String str;
        try {
            str = f7331a != null ? f7331a.genTraceId() : null;
        } catch (Exception unused) {
            str = "afts_traceId";
        }
        return TextUtils.isEmpty(str) ? "afts_traceId" : str;
    }

    private static boolean a(String str) {
        String[] aftsCdnPrefixs = getAftsCdnPrefixs();
        if (!TextUtils.isEmpty(str) && aftsCdnPrefixs != null && aftsCdnPrefixs.length > 0) {
            for (String str2 : aftsCdnPrefixs) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getAftsCdnHost() {
        return isOnline() ? ConfigMgr.getInc().getCdnConfigItem().aftsCdnHost : "";
    }

    public static String getAftsMasterHost() {
        return isOnline() ? ConfigMgr.getInc().getCdnConfigItem().aftsMasterHost : "https://mdgwdev.alipay.net";
    }

    public static String[] getAftsCdnPrefixs() {
        return ConfigMgr.getInc().getCdnConfigItem().aftsCdnPrefixs;
    }

    public static void registerITraceId(ITraceId iTraceId) {
        f7331a = iTraceId;
    }
}
