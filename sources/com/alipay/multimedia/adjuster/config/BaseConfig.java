package com.alipay.multimedia.adjuster.config;

/* loaded from: classes2.dex */
public class BaseConfig {
    public static final int OFF = 0;
    public static final int ON = 1;

    /* renamed from: a  reason: collision with root package name */
    private long f7332a = 0;

    public boolean needUpdate() {
        return Math.abs(System.currentTimeMillis() - this.f7332a) > 1800000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateTime() {
        this.f7332a = System.currentTimeMillis();
    }

    public void setNeedUpdate() {
        this.f7332a = 0L;
    }
}
