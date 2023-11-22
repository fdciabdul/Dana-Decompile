package com.alibaba.griver.base.resource.cache;

/* loaded from: classes3.dex */
class MemoryCacheBean {

    /* renamed from: a  reason: collision with root package name */
    private String f6360a;
    private long b;

    public MemoryCacheBean(String str, long j) {
        this.f6360a = str;
        this.b = j;
    }

    public String getValue() {
        return this.f6360a;
    }

    public void setValue(String str) {
        this.f6360a = str;
    }

    public long getExpiredTime() {
        return this.b;
    }

    public void setExpiredTime(long j) {
        this.b = j;
    }
}
