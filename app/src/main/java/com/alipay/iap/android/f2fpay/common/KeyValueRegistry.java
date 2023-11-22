package com.alipay.iap.android.f2fpay.common;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class KeyValueRegistry {
    public static final String QUERY_COUNT = "QUERY_COUNT";
    public static final String QUERY_INTERVAL = "QUERY_INTERVAL";
    private static KeyValueRegistry c;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f6956a;
    private Map<String, KeyValueAccessor> b = new HashMap();

    private KeyValueRegistry() {
    }

    public static KeyValueRegistry getInstance() {
        if (c == null) {
            c = new KeyValueRegistry();
        }
        return c;
    }

    public KeyValueAccessor accessor(String str) {
        KeyValueAccessor keyValueAccessor;
        SharedPreferences sharedPreferences;
        synchronized (this) {
            keyValueAccessor = this.b.get(str);
            if (keyValueAccessor == null && (sharedPreferences = this.f6956a) != null) {
                keyValueAccessor = new KeyValueAccessor(sharedPreferences, str);
                this.b.put(str, keyValueAccessor);
            }
        }
        return keyValueAccessor;
    }

    public void initialize(Context context) {
        if (this.f6956a == null) {
            this.f6956a = context.getSharedPreferences("f2fpay_config", 0);
        }
    }
}
