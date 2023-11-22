package com.alibaba.griver.base.performance.network;

import android.text.TextUtils;
import com.alibaba.griver.base.common.utils.MapBuilder;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetworkResourceModel {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, ResourceModel> f6334a = new ConcurrentHashMap<>();

    public void setNetworkResourceModel(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || j <= 0 || j2 <= 0) {
            return;
        }
        ResourceModel resourceModel = this.f6334a.get(str);
        if (resourceModel != null) {
            resourceModel.count++;
            resourceModel.cost += j;
            resourceModel.size += j2;
        } else {
            resourceModel = new ResourceModel();
            resourceModel.count = 1L;
            resourceModel.cost = 0L;
            resourceModel.size = 0L;
        }
        this.f6334a.put(str, resourceModel);
    }

    public Map<String, Map<String, String>> getUploadMap() {
        if (this.f6334a.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ResourceModel> entry : this.f6334a.entrySet()) {
            hashMap.put(entry.getKey(), a(entry.getValue()));
        }
        return hashMap;
    }

    private Map<String, String> a(ResourceModel resourceModel) {
        MapBuilder.Builder builder = new MapBuilder.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append(resourceModel.count);
        return builder.map("count", sb.toString()).map("ave_cost", String.valueOf(resourceModel.cost / resourceModel.count)).map("ave_size", String.valueOf(resourceModel.size / resourceModel.count)).build();
    }

    public void clear() {
        this.f6334a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ResourceModel {
        public long cost;
        public long count;
        public long size;

        private ResourceModel() {
        }
    }
}
