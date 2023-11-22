package com.alibaba.ariver.kernel.common.rpc;

import java.util.Map;

/* loaded from: classes6.dex */
public class RVRpcConfig {

    /* renamed from: a  reason: collision with root package name */
    private Long f6150a;
    private String b;
    private Map<String, String> c;
    private Map<String, String> d;
    private Boolean e;
    private String f;
    private String g;
    private String h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Boolean n;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f6151o;
    private Boolean p;
    private Boolean q;
    private Boolean r;
    private Boolean s;
    private Boolean t;
    private Boolean u;
    private String v;
    private Boolean w;
    private String x;
    private Boolean y;
    private String z;

    public Long getTimeout() {
        return this.f6150a;
    }

    public String getGwUrl() {
        return this.b;
    }

    public Map<String, String> getRequestHeader() {
        return this.c;
    }

    public Map<String, String> getExtParams() {
        return this.d;
    }

    public Boolean isCompress() {
        return this.e;
    }

    public String getAppKey() {
        return this.f;
    }

    public String getAppId() {
        return this.g;
    }

    public String getTinyAppId() {
        return this.h;
    }

    public Boolean isResetCookie() {
        return this.i;
    }

    public Boolean isBgRpc() {
        return this.j;
    }

    public Boolean isAllowRetry() {
        return this.k;
    }

    public Boolean isUrgent() {
        return this.l;
    }

    public Boolean isRpcV2() {
        return this.m;
    }

    public Boolean isAllowBgLogin() {
        return this.n;
    }

    public Boolean isAllowNonNet() {
        return this.f6151o;
    }

    public Boolean isSwitchUserLoginRpc() {
        return this.p;
    }

    public Boolean isGetMethod() {
        return this.q;
    }

    public Boolean isDisableEncrypt() {
        return this.r;
    }

    public Boolean isEnableEncrypt() {
        return this.s;
    }

    public Boolean isRpcLoggerLevel() {
        return this.t;
    }

    public Boolean isShortLinkOnly() {
        return this.u;
    }

    public String getShortLinkIPList() {
        return this.v;
    }

    public Boolean isNeedSignature() {
        return this.w;
    }

    public Boolean isUseMultiplexLink() {
        return this.y;
    }

    public String getBizLog() {
        return this.z;
    }

    public String getRegion() {
        return this.x;
    }

    private RVRpcConfig(Builder builder) {
        this.f6150a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f6151o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.f6150a = builder.f6152a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.f6151o = builder.f6153o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.y = builder.x;
        this.z = builder.y;
        this.x = builder.z;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f6152a;
        private String b;
        private Map<String, String> c;
        private Map<String, String> d;
        private Boolean e;
        private String f;
        private String g;
        private String h;
        private Boolean i;
        private Boolean j;
        private Boolean k;
        private Boolean l;
        private Boolean m;
        private Boolean n;

        /* renamed from: o  reason: collision with root package name */
        private Boolean f6153o;
        private Boolean p;
        private Boolean q;
        private Boolean r;
        private Boolean s;
        private Boolean t;
        private Boolean u;
        private String v;
        private Boolean w;
        private Boolean x;
        private String y;
        private String z;

        public final Builder timeout(Long l) {
            this.f6152a = l;
            return this;
        }

        public final Builder gwUrl(String str) {
            this.b = str;
            return this;
        }

        public final Builder requestHeader(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public final Builder extParasm(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public final Builder compress(Boolean bool) {
            this.e = bool;
            return this;
        }

        public final Builder appKey(String str) {
            this.f = str;
            return this;
        }

        public final Builder appId(String str) {
            this.g = str;
            return this;
        }

        public final Builder tinyAppId(String str) {
            this.h = str;
            return this;
        }

        public final Builder resetCookie(Boolean bool) {
            this.i = bool;
            return this;
        }

        public final Builder bgRpc(Boolean bool) {
            this.j = bool;
            return this;
        }

        public final Builder allowRetry(Boolean bool) {
            this.k = bool;
            return this;
        }

        public final Builder urgent(Boolean bool) {
            this.l = bool;
            return this;
        }

        public final Builder rpcV2(Boolean bool) {
            this.m = bool;
            return this;
        }

        public final Builder allowBgLogin(Boolean bool) {
            this.n = bool;
            return this;
        }

        public final Builder allowNonNet(Boolean bool) {
            this.f6153o = bool;
            return this;
        }

        public final Builder switchUserLoginRpc(Boolean bool) {
            this.p = bool;
            return this;
        }

        public final Builder getMethod(Boolean bool) {
            this.q = bool;
            return this;
        }

        public final Builder disableEncrypt(Boolean bool) {
            this.r = bool;
            return this;
        }

        public final Builder enableEncrypt(Boolean bool) {
            this.s = bool;
            return this;
        }

        public final Builder rpcLoggerLevel(Boolean bool) {
            this.t = bool;
            return this;
        }

        public final Builder shortLinkOnly(Boolean bool) {
            this.u = bool;
            return this;
        }

        public final Builder shortLinkIPList(String str) {
            this.v = str;
            return this;
        }

        public final Builder needSignature(Boolean bool) {
            this.w = bool;
            return this;
        }

        public final Builder useMultiplexLink(Boolean bool) {
            this.x = bool;
            return this;
        }

        public final Builder bizLog(String str) {
            this.y = str;
            return this;
        }

        public final Builder region(String str) {
            this.z = str;
            return this;
        }

        public final RVRpcConfig build() {
            return new RVRpcConfig(this);
        }
    }
}
