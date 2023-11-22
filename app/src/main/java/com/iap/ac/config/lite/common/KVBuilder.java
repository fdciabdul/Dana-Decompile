package com.iap.ac.config.lite.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class KVBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f7628a = new HashMap();

    private KVBuilder() {
    }

    public static KVBuilder newBuilder() {
        return new KVBuilder();
    }

    public Map<String, String> build() {
        return this.f7628a;
    }

    public KVBuilder put(String str, Object obj) {
        if (obj != null) {
            this.f7628a.put(str, String.valueOf(obj));
        } else {
            this.f7628a.put(str, "");
        }
        return this;
    }
}
