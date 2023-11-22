package com.alibaba.exthub.api;

import android.app.Activity;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class RVEContextProviderImpl extends RVEContextProvider {

    /* renamed from: a  reason: collision with root package name */
    private Activity f6255a;
    private String b;
    private String c;

    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider
    public boolean sendEvent(RVEContext rVEContext, String str, JSONObject jSONObject) {
        return false;
    }

    private RVEContextProviderImpl() {
    }

    private RVEContextProviderImpl(Builder builder) {
        this.f6255a = builder.f6256a;
        this.b = builder.b;
        this.c = builder.c;
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Activity f6256a;
        private String b;
        private String c;

        public Builder appId(String str) {
            this.b = str;
            return this;
        }

        public Builder activity(Activity activity) {
            this.f6256a = activity;
            return this;
        }

        public Builder pageUrl(String str) {
            this.c = str;
            return this;
        }

        public RVEContextProviderImpl build() {
            return new RVEContextProviderImpl(this);
        }
    }

    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider
    public String getAppId() {
        return this.b;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider
    public Activity getCurrentActivity() {
        return this.f6255a;
    }

    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider
    public String getPageUrl() {
        return this.c;
    }
}
