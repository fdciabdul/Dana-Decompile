package com.alibaba.ariver.kernel.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class RefAware<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f6115a = new AtomicInteger(0);
    private final T b;

    public RefAware(T t) {
        this.b = t;
    }

    public T get() {
        return this.b;
    }

    public void incrementRef() {
        this.f6115a.incrementAndGet();
    }

    public boolean decrementRef() {
        return this.f6115a.get() == 0 || this.f6115a.decrementAndGet() == 0;
    }
}
