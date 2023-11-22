package com.alibaba.ariver.kernel.api.track;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class EventTrackerUtils {
    public static final String TAG = "EventTrackerUtils";

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Integer> f6113a = new ConcurrentHashMap();

    public static String getTrackerIdWithIndex(String str) {
        synchronized (EventTrackerUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Map<String, Integer> map = f6113a;
            if (!map.containsKey(str)) {
                map.put(str, 1);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_1");
                return sb.toString();
            }
            int intValue = map.get(str).intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_");
            sb2.append(intValue);
            return sb2.toString();
        }
    }

    public static String getTrackerIdWithIndex(String str, String str2) {
        synchronized (EventTrackerUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Map<String, Integer> map = f6113a;
            if (!map.containsKey(str)) {
                map.put(str, 1);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("_");
                sb.append(str2);
                sb.append("_1");
                return sb.toString();
            }
            int intValue = map.get(str).intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_");
            sb2.append(str2);
            sb2.append("_");
            sb2.append(intValue);
            return sb2.toString();
        }
    }

    public static String getExtraAttrByJoinList(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        Map.Entry<String, Object> next = it.next();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(next.getKey());
        sb.append("=");
        sb.append(next.getValue());
        String obj = sb.toString();
        while (it.hasNext()) {
            Map.Entry<String, Object> next2 = it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(next2.getKey());
            sb2.append("=");
            sb2.append(next2.getValue());
            obj = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("]");
        String obj2 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("getExtraAttrByJoinList ");
        sb4.append(obj2);
        RVLogger.d(TAG, sb4.toString());
        return obj2;
    }

    public static void clearTrackIdIndexDict() {
        synchronized (EventTrackerUtils.class) {
            RVLogger.d(TAG, "clearTrackIdIndexDict");
            f6113a.clear();
        }
    }
}
