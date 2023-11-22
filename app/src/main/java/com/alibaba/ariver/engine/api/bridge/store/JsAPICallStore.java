package com.alibaba.ariver.engine.api.bridge.store;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class JsAPICallStore {
    public final AtomicInteger totalJsapiCount = new AtomicInteger(0);
    public final ConcurrentHashMap<String, AtomicInteger> data = new ConcurrentHashMap<>();

    public void append(String str) {
        synchronized (this) {
            append(str, 1);
        }
    }

    public void append(String str, int i) {
        synchronized (this) {
            if (this.data.containsKey(str)) {
                this.data.get(str).addAndGet(i);
            } else {
                this.data.put(str, new AtomicInteger(i));
            }
            this.totalJsapiCount.addAndGet(i);
        }
    }

    public void append(JsAPICallStore jsAPICallStore) {
        synchronized (this) {
            for (Map.Entry<String, AtomicInteger> entry : jsAPICallStore.data.entrySet()) {
                append(entry.getKey(), entry.getValue().get());
            }
        }
    }
}
