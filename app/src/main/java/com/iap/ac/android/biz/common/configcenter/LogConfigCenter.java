package com.iap.ac.android.biz.common.configcenter;

import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LogConfigCenter {
    public static LogConfigCenter sInstance;

    public static LogConfigCenter getInstance() {
        if (sInstance == null) {
            synchronized (LogConfigCenter.class) {
                if (sInstance == null) {
                    sInstance = new LogConfigCenter();
                }
            }
        }
        return sInstance;
    }

    public <T> T getKeyOrDefault(JSONObject jSONObject, String str, T t) {
        synchronized (this) {
            if (jSONObject == null) {
                return t;
            }
            try {
                T t2 = (T) jSONObject.get(str);
                if (t2 != null && t2.getClass() == t.getClass()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ConfigCenter, get value from config center success, key: ");
                    sb.append(str);
                    sb.append(", value: ");
                    sb.append(t2);
                    ACLog.i(Constants.TAG, sb.toString());
                    return t2;
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getKeyOrDefault exception: ");
                sb2.append(th);
                ACLog.e(Constants.TAG, sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ConfigCenter, get value from config center fail, key: ");
            sb3.append(str);
            sb3.append(", use default value.");
            ACLog.e(Constants.TAG, sb3.toString());
            return t;
        }
    }

    public Map getMap(JSONObject jSONObject, String str, Map map) {
        synchronized (this) {
            try {
                Map map2 = (Map) JsonUtils.fromJson((JSONObject) getKeyOrDefault(jSONObject, str, new JSONObject(map)), Map.class);
                if (map2 != null) {
                    return map2;
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getMap exception:");
                sb.append(th);
                ACLog.e(Constants.TAG, sb.toString());
            }
            return map;
        }
    }
}
