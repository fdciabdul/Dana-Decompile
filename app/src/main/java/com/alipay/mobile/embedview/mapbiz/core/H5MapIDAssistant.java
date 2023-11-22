package com.alipay.mobile.embedview.mapbiz.core;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class H5MapIDAssistant {
    public static final H5MapIDAssistant INSTANCE = new H5MapIDAssistant();

    /* renamed from: a  reason: collision with root package name */
    private AtomicLong f7139a = new AtomicLong();

    private H5MapIDAssistant() {
    }

    public String obtainID() {
        StringBuilder sb = new StringBuilder();
        sb.append("5aCH6Iqx");
        sb.append(this.f7139a.incrementAndGet());
        return sb.toString();
    }
}
