package io.reactivex.internal.util;

/* loaded from: classes.dex */
public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
