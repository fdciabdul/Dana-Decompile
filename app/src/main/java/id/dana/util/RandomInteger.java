package id.dana.util;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class RandomInteger {
    private static final AtomicInteger MyBillsEntityDataFactory = new AtomicInteger(1000);

    private RandomInteger() {
    }

    public static int BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory.incrementAndGet();
    }
}
