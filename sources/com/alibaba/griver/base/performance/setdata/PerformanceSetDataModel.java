package com.alibaba.griver.base.performance.setdata;

import android.os.SystemClock;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.huawei.hms.framework.common.ContainerUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceSetDataModel {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, List<PerformanceSetDataSize>> f6340a = new ConcurrentHashMap<>();

    public void setData(String str, int i, long j) {
        List<PerformanceSetDataSize> list;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(i);
        String obj = sb.toString();
        if (this.f6340a.containsKey(obj)) {
            list = this.f6340a.get(obj);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f6340a.put(obj, arrayList);
            list = arrayList;
        }
        if (list.size() == 0) {
            list.add(new PerformanceSetDataSize(0L, SystemClock.elapsedRealtime(), j));
            return;
        }
        list.add(new PerformanceSetDataSize(SystemClock.elapsedRealtime() - list.get(list.size() - 1).setTime, SystemClock.elapsedRealtime(), j));
    }

    public void clear() {
        this.f6340a.clear();
    }

    /* loaded from: classes6.dex */
    public static class PerformanceSetDataSize {
        public long setTime;
        public long size;
        public long time;

        public PerformanceSetDataSize(long j, long j2, long j3) {
            this.time = j;
            this.setTime = j2;
            this.size = j3;
        }
    }

    public Map<String, String> getUploadMap() {
        if (this.f6340a.size() == 0) {
            return null;
        }
        MapBuilder.Builder builder = new MapBuilder.Builder();
        for (Map.Entry<String, List<PerformanceSetDataSize>> entry : this.f6340a.entrySet()) {
            builder.map(entry.getKey(), parsePerformanceSetDataSize(entry.getValue()));
        }
        return builder.build();
    }

    public String parsePerformanceSetDataSize(List<PerformanceSetDataSize> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            PerformanceSetDataSize performanceSetDataSize = list.get(i);
            sb.append(performanceSetDataSize.time);
            sb.append("=");
            sb.append(performanceSetDataSize.size);
            if (i != list.size() - 1) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb.toString();
    }
}
