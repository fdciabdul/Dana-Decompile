package com.alibaba.griver.beehive.lottie.util;

import android.text.TextUtils;
import com.alibaba.griver.beehive.lottie.player.LottieHelper;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes6.dex */
public class SceneUtils {
    public static String buildScene(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2) || !str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                if (TextUtils.isEmpty(str2) || !str2.startsWith("/")) {
                    return !TextUtils.isEmpty(str3) ? str3 : "";
                }
                return LottieHelper.getTinyFullPath(str2);
            }
            return str2;
        }
        return str;
    }

    public static String getResourceId(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2) || !str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith("/")) {
                    return LottieHelper.getTinyFullPath(str2);
                }
                if (TextUtils.isEmpty(str3) || str3.startsWith("file:///[asset]/")) {
                    return !TextUtils.isEmpty(str3) ? str3 : "empty_resource";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("file:///[asset]/");
                sb.append(str3);
                return sb.toString();
            }
            return str2;
        }
        return str;
    }
}
