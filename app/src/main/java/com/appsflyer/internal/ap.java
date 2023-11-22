package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class ap {
    public static void valueOf(String str, DeepLinkResult.Error error) {
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            AFLogger.values("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventParameterName(new DeepLinkResult(null, error));
            return;
        }
        AFInAppEventType(str);
    }

    public static void AFInAppEventParameterName(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            try {
                try {
                    DeepLink valueOf = DeepLink.valueOf(map);
                    valueOf.AFInAppEventParameterName.put("is_deferred", false);
                    deepLinkResult = new DeepLinkResult(valueOf, null);
                } catch (JSONException e) {
                    AFLogger.AFInAppEventParameterName("[DDL] Error occurred", e);
                    deepLinkResult = new DeepLinkResult(null, DeepLinkResult.Error.UNEXPECTED);
                }
                AFInAppEventParameterName(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFInAppEventParameterName(new DeepLinkResult(null, null));
                throw th;
            }
        }
        AFInAppEventType(map);
    }

    public static void AFInAppEventParameterName(DeepLinkResult deepLinkResult) {
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.values(sb.toString());
            try {
                j.AFInAppEventType().AFInAppEventParameterName.onDeepLinking(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFLogger.AFInAppEventType(th.getLocalizedMessage(), th);
                return;
            }
        }
        AFLogger.values("[DDL] skipping, no callback registered");
    }

    private static void AFInAppEventType(Map<String, String> map) {
        if (ae.valueOf != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.values(sb.toString());
                ae.valueOf.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.AFInAppEventType(th.getLocalizedMessage(), th);
            }
        }
    }

    private static void AFInAppEventType(String str) {
        if (ae.valueOf != null) {
            try {
                AFLogger.values("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                ae.valueOf.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.AFInAppEventType(th.getLocalizedMessage(), th);
            }
        }
    }
}
