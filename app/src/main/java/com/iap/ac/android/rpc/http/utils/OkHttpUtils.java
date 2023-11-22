package com.iap.ac.android.rpc.http.utils;

import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.config.IACConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class OkHttpUtils {
    public static final String KEY_HTTP_2_0 = "http_2_0";
    public static final String KEY_HTTP_2_0_ENABLE = "enable";
    public static final String TAG = "OkhttpUtils";
    public static final boolean VALUE_HTTP_2_0_ENABLE_DEFAULT = true;
    public static Boolean canUseHttp_2_0;

    public static boolean canUseOkhttp(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return false;
        }
        try {
            if (HttpTransportUtils.checkClassExist("okhttp3.OkHttpClient")) {
                return getConfigHttp2Enable();
            }
            return false;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("OkhttpUtils#canUseOkhttp exception: ");
            sb.append(th);
            ACLog.e(TAG, sb.toString());
            return false;
        }
    }

    public static boolean getConfigHttp2Enable() {
        boolean booleanValue;
        synchronized (OkHttpUtils.class) {
            if (canUseHttp_2_0 == null) {
                canUseHttp_2_0 = Boolean.TRUE;
                IACConfig aCConfig = ACConfig.getInstance("ac_biz");
                JSONObject sectionConfig = aCConfig != null ? aCConfig.getSectionConfig("ACConfig") : null;
                if (sectionConfig != null) {
                    try {
                        JSONObject jSONObject = (JSONObject) sectionConfig.get(KEY_HTTP_2_0);
                        if (jSONObject != null) {
                            canUseHttp_2_0 = Boolean.valueOf(jSONObject.optBoolean("enable", true));
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("OkhttpUtils#getEnable exception: ");
                        sb.append(th);
                        ACLog.e(TAG, sb.toString());
                    }
                }
            }
            booleanValue = canUseHttp_2_0.booleanValue();
        }
        return booleanValue;
    }

    public static boolean canUseOkhttp(RpcRequest rpcRequest) {
        if (rpcRequest == null) {
            return false;
        }
        try {
            if (HttpTransportUtils.checkClassExist("okhttp3.OkHttpClient")) {
                return getConfigHttp2Enable();
            }
            return false;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("OkhttpUtils#canUseOkhttp exception: ");
            sb.append(th);
            ACLog.e(TAG, sb.toString());
            return false;
        }
    }
}
