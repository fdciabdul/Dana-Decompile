package com.apiguard3.internal;

import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes3.dex */
public final class setForegroundGravity {
    public static final Object AGState = new Object();
    public static char APIGuard = 0;
    private static int getSharedInstance = 0;
    public static int valueOf = 0;
    private static int values = 1;

    static {
        int i = getSharedInstance + 85;
        values = i % 128;
        if ((i % 2 == 0 ? (char) 3 : InputCardNumberView.DIVIDER) == ' ') {
            return;
        }
        throw new ArithmeticException();
    }
}
