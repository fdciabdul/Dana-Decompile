package com.xiaomi.push;

/* loaded from: classes8.dex */
public enum dc {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a  reason: collision with other field name */
    private final int f95a;

    dc(int i) {
        this.f95a = i;
    }

    public static dc a(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return PLUGIN_CONFIG;
        }
        return MISC_CONFIG;
    }

    public final int a() {
        return this.f95a;
    }
}
