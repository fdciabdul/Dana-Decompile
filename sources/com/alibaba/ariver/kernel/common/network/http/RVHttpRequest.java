package com.alibaba.ariver.kernel.common.network.http;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVHttpRequest {
    public static final String APP_ID = "appId";
    public static final String PLUGIN_ID = "pluginId";

    /* renamed from: a  reason: collision with root package name */
    private String f6147a;
    private String b;
    private Map<String, String> c;
    private byte[] d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private Map<String, String> i;

    public static Builder newBuilder() {
        return new Builder();
    }

    private RVHttpRequest() {
        this.i = new HashMap();
    }

    public String getUrl() {
        return this.f6147a;
    }

    public String getMethod() {
        return TextUtils.isEmpty(this.b) ? "GET" : this.b;
    }

    public Map<String, String> getHeaders() {
        return this.c;
    }

    public byte[] getRequestData() {
        return this.d;
    }

    public long getTimeout() {
        return this.e;
    }

    public boolean isUseSpdy() {
        return this.f;
    }

    public boolean isUseCache() {
        return this.h;
    }

    public boolean isPackageRequest() {
        return this.g;
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private RVHttpRequest f6148a = new RVHttpRequest();

        public Builder url(String str) {
            this.f6148a.f6147a = str;
            return this;
        }

        public Builder method(String str) {
            this.f6148a.b = str;
            return this;
        }

        public Builder headers(Map<String, String> map) {
            this.f6148a.c = map;
            return this;
        }

        public Builder requestData(byte[] bArr) {
            this.f6148a.d = bArr;
            return this;
        }

        public Builder timeout(long j) {
            this.f6148a.e = j;
            return this;
        }

        public Builder useSpdy(boolean z) {
            this.f6148a.f = z;
            return this;
        }

        public Builder useCache(boolean z) {
            this.f6148a.h = z;
            return this;
        }

        public Builder setPackageRequest(boolean z) {
            this.f6148a.g = z;
            return this;
        }

        public RVHttpRequest build() {
            return this.f6148a;
        }
    }

    public void addExtParams(String str, String str2) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put(str, str2);
    }

    public String getExtParams(String str) {
        Map<String, String> map = this.i;
        return (map == null || !map.containsKey(str)) ? "" : this.i.get(str);
    }
}
