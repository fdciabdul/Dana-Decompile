package id.dana.utils;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class RandomInteger {
    private static final AtomicInteger KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicInteger(1000);

    private RandomInteger() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2.incrementAndGet();
    }
}
