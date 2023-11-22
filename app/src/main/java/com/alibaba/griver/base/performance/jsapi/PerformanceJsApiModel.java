package com.alibaba.griver.base.performance.jsapi;

import com.alibaba.griver.base.common.utils.MapBuilder;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceJsApiModel {

    /* renamed from: a  reason: collision with root package name */
    private int f6330a;
    private int b;
    private int c;
    private long d;

    public void processAdd(long j) {
        this.d += j;
    }

    public void timeOutAdd() {
        this.f6330a++;
    }

    public int getTimeOutCount() {
        return this.f6330a;
    }

    public void beginAdd() {
        this.b++;
    }

    public void endAdd() {
        this.c++;
    }

    private long a() {
        int i = this.c;
        if (i > 0) {
            return this.d / i;
        }
        return 0L;
    }

    public Map<String, String> getUploadMap() {
        MapBuilder.Builder builder = new MapBuilder.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        MapBuilder.Builder map = builder.map("begin", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.c);
        MapBuilder.Builder map2 = map.map("end", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(a());
        return map2.map("avg_cost", sb3.toString()).build();
    }
}
