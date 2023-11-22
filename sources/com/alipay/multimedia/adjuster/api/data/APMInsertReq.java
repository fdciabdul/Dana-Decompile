package com.alipay.multimedia.adjuster.api.data;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes7.dex */
public class APMInsertReq {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f7327a;
    private final Context b;
    private final String c;
    private final String d;
    private final String e;
    private final Object f;
    private final String g;
    private final String h;
    private final String i;

    private APMInsertReq(Builder builder) {
        this.f7327a = builder.f7328a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    public Uri getUri() {
        return this.f7327a;
    }

    public Context getContext() {
        return this.b;
    }

    public String getMimeType() {
        return this.c;
    }

    public String getDisplayName() {
        return this.d;
    }

    public String getDescription() {
        return this.e;
    }

    public Object getSourceData() {
        return this.f;
    }

    public String getBizType() {
        return this.g;
    }

    public String getSavePrimaryDir() {
        return this.h;
    }

    public String getSaveSecondaryDir() {
        return this.i;
    }

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Uri f7328a;
        private String d;
        private Object f;
        private String h;
        private String i;
        private Context b = null;
        private String c = "";
        private String e = "";
        private String g = null;

        public Builder(Uri uri, Object obj, String str) {
            this.f7328a = uri;
            this.f = obj;
            this.d = str;
        }

        public Builder mimeType(String str) {
            this.c = str;
            return this;
        }

        public Builder description(String str) {
            this.e = str;
            return this;
        }

        public Builder context(Context context) {
            this.b = context;
            return this;
        }

        public Builder bizType(String str) {
            this.g = str;
            return this;
        }

        public Builder setSavePrimaryDir(String str) {
            this.h = str;
            return this;
        }

        public Builder setSaveSecondaryDir(String str) {
            this.i = str;
            return this;
        }

        public APMInsertReq build() {
            return new APMInsertReq(this);
        }
    }
}
