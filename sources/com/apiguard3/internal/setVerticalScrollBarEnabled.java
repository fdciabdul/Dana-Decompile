package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setVerticalScrollBarEnabled {
    public static final setPivotX AGState;
    public static final setPivotX APIGuard;
    private static int getRequestHeaders = 1;
    private static int getSharedInstance;
    public static final setPivotX valueOf;
    public static final boolean values;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            getSharedInstance = (getRequestHeaders + 67) % 128;
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        values = z;
        if ((z ? '\t' : '8') != '\t') {
            AGState = null;
            valueOf = null;
            APIGuard = null;
            return;
        }
        int i = getSharedInstance + 33;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            AGState = setScrollBarDefaultDelayBeforeFade.AGState;
            valueOf = setScrollBarFadeDuration.valueOf;
            APIGuard = setScrollBarSize.getSharedInstance;
            return;
        }
        AGState = setScrollBarDefaultDelayBeforeFade.AGState;
        valueOf = setScrollBarFadeDuration.valueOf;
        APIGuard = setScrollBarSize.getSharedInstance;
        throw new ArithmeticException();
    }
}
