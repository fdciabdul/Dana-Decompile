package com.alipay.iap.android.common.task.transaction;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public abstract class Transaction implements Runnable {
    private static final AtomicInteger sCount = new AtomicInteger(0);

    /* renamed from: id  reason: collision with root package name */
    final String f6943id;

    public Transaction() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction_");
        sb.append(sCount.getAndIncrement());
        this.f6943id = sb.toString();
    }

    public final String getId() {
        return this.f6943id;
    }
}
