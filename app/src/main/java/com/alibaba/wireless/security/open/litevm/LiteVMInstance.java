package com.alibaba.wireless.security.open.litevm;

/* loaded from: classes6.dex */
public class LiteVMInstance {

    /* renamed from: a  reason: collision with root package name */
    private Object f6815a;
    private String b;
    private String c;

    public LiteVMInstance(Object obj, String str, String str2) {
        this.b = str;
        this.c = str2;
        this.f6815a = obj;
    }

    public String getAuthCode() {
        return this.b;
    }

    public String getBizId() {
        return this.c;
    }

    public Object getImpl() {
        return this.f6815a;
    }
}
