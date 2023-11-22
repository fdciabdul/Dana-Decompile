package com.iap.ac.android.common.task.transaction;

import com.iap.ac.android.common.a.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public abstract class Transaction implements Runnable {
    public static final AtomicInteger sCount = new AtomicInteger(0);

    /* renamed from: id  reason: collision with root package name */
    public final String f7551id;

    public Transaction() {
        StringBuilder a2 = a.a("Transaction_");
        a2.append(sCount.getAndIncrement());
        this.f7551id = a2.toString();
    }

    public final String getId() {
        return this.f7551id;
    }
}
