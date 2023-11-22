package com.alibaba.ariver.ariverexthub.api.instance;

import android.text.TextUtils;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class RVEExtraHandlerCenter {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<List<String>, RVEApiExtraFilter>> f6000a;
    private final CopyOnWriteArraySet<String> b;

    public static RVEExtraHandlerCenter getInstance() {
        return RVEFilterCenterHolder.f6001a;
    }

    /* loaded from: classes3.dex */
    static class RVEFilterCenterHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RVEExtraHandlerCenter f6001a = new RVEExtraHandlerCenter();

        private RVEFilterCenterHolder() {
        }
    }

    private RVEExtraHandlerCenter() {
        this.f6000a = new ConcurrentHashMap<>();
        this.b = new CopyOnWriteArraySet<>();
    }

    public boolean needHandleFilter(String str) {
        return this.b.contains(str);
    }

    public RVEApiExtraFilter getApiFilter(String str, String str2) {
        ConcurrentHashMap<List<String>, RVEApiExtraFilter> concurrentHashMap = this.f6000a.get(str);
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return null;
        }
        for (Map.Entry<List<String>, RVEApiExtraFilter> entry : concurrentHashMap.entrySet()) {
            if (entry.getKey().contains(str2)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void registerFilters(String str, Map<List<String>, RVEApiExtraFilter> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return;
        }
        Iterator<Map.Entry<List<String>, RVEApiExtraFilter>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.b.addAll(it.next().getKey());
        }
        if (this.f6000a.containsKey(str)) {
            ConcurrentHashMap<List<String>, RVEApiExtraFilter> concurrentHashMap = this.f6000a.get(str);
            concurrentHashMap.putAll(map);
            this.f6000a.put(str, concurrentHashMap);
            return;
        }
        this.f6000a.put(str, new ConcurrentHashMap<>(map));
    }
}
