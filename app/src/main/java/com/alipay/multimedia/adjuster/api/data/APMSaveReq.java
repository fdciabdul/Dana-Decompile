package com.alipay.multimedia.adjuster.api.data;

import android.content.Context;

/* loaded from: classes7.dex */
public class APMSaveReq {

    /* renamed from: a  reason: collision with root package name */
    private final String f7329a;
    private final Context b;
    private final String c;
    private final String d;

    private APMSaveReq(Builder builder) {
        this.f7329a = builder.f7330a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }

    public String getUri() {
        return this.f7329a;
    }

    public Context getContext() {
        return this.b;
    }

    public String getBizType() {
        return this.c;
    }

    public String getSavePth() {
        return this.d;
    }

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f7330a;
        private Context b = null;
        private String c;
        private String d;

        public Builder(String str, String str2) {
            this.f7330a = str;
            this.c = str2;
        }

        public Builder context(Context context) {
            this.b = context;
            return this;
        }

        public Builder bizType(String str) {
            this.c = str;
            return this;
        }

        public Builder savePath(String str) {
            this.d = str;
            return this;
        }

        public APMSaveReq build() {
            return new APMSaveReq(this);
        }
    }
}
