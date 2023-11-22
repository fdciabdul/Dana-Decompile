package com.alipay.mobile.verifyidentity.business.activity;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultClientLogKit implements ClientLogKit {
    @Override // com.alipay.mobile.verifyidentity.business.activity.ClientLogKit
    public void log(String str, String[] strArr, Map<String, String> map, String str2, String str3, String str4, String str5, boolean z) {
        String str6;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String str7 : strArr) {
                stringBuffer.append(str7);
                stringBuffer.append(",");
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            str6 = stringBuffer.toString();
        } else {
            str6 = "";
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("timestamp", String.valueOf(currentTimeMillis));
        map.put("verifyId", str5);
        map.put("bizContent", str6);
        map.put("seed", str3);
        MonitorWrapper.behaviour(str3, map);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        LoggerWrapper.d("IAPLogTypeSecVICode", jSONObject.toString());
    }
}
