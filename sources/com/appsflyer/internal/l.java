package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class l {
    private final boolean AFInAppEventParameterName;
    public final long valueOf;
    public final String values;

    /* loaded from: classes.dex */
    public interface a {
        void AFInAppEventType(String str, String str2, String str3);

        void values(String str);
    }

    l() {
    }

    public l(String str, long j, boolean z) {
        this.values = str;
        this.valueOf = j;
        this.AFInAppEventParameterName = z;
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName;
    }
}
