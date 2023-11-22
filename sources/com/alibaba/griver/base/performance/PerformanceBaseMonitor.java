package com.alibaba.griver.base.performance;

import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.utils.StringUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class PerformanceBaseMonitor implements PerformanceMonitor {
    protected static final String KEY_SUMMARY = "summary";

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getExtendInfo(App app, Map map) {
        return new MapBuilder.Builder().map("summary", encodeMap(map)).map(GriverMonitorConstants.KEY_NEED_ASYNC_APP_TYPE, Boolean.TRUE.toString()).map("appId", app.getAppId()).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getExtendInfo(App app, List<String> list) {
        return new MapBuilder.Builder().map("summary", encodeArray(list)).map(GriverMonitorConstants.KEY_NEED_ASYNC_APP_TYPE, Boolean.TRUE.toString()).map("appId", app.getAppId()).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String encodeArray(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(URLEncoder.encode(it.next()));
        }
        return URLEncoder.encode(StringUtils.join(arrayList.toArray(), ContainerUtils.FIELD_DELIMITER));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String encodeMap(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof Integer)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(URLEncoder.encode(str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(String.valueOf(obj)));
                    arrayList.add(sb.toString());
                } else if (obj instanceof Map) {
                    Map<String, Object> map2 = (Map) obj;
                    if (map2.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(URLEncoder.encode(str));
                        sb2.append("=");
                        sb2.append(encodeMap(map2));
                        arrayList.add(sb2.toString());
                    }
                }
            }
        }
        return URLEncoder.encode(StringUtils.join(arrayList.toArray(), ContainerUtils.FIELD_DELIMITER));
    }
}
