package com.alibaba.griver.core.prefetch;

/* loaded from: classes2.dex */
public class PrefetchInner {
    String appId;
    String path;
    String type;

    public PrefetchInner(String str, String str2, String str3) {
        this.appId = str;
        this.path = str2;
        this.type = str3;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPath() {
        return this.path;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrefetchInner prefetchInner = (PrefetchInner) obj;
        return this.appId.equals(prefetchInner.appId) && this.path.equals(prefetchInner.path) && this.type.equals(prefetchInner.type);
    }

    public int hashCode() {
        return (this.appId.hashCode() << ((this.path.length() + this.type.length()) + this.path.hashCode())) << (this.type.length() + this.type.hashCode());
    }
}
