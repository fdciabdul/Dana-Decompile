package com.alibaba.griver.core.embedview;

/* loaded from: classes6.dex */
public class H5EmbedViewConfig {
    public static final String TAG = "H5EmbedViewConfig";

    /* renamed from: a  reason: collision with root package name */
    private String f6398a;
    private String b;
    private String c;

    public H5EmbedViewConfig(String str, String str2, String str3) {
        this.f6398a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getBundleName() {
        return this.f6398a;
    }

    public String getClassName() {
        return this.b;
    }

    public String getType() {
        return this.c;
    }
}
