package com.apiguard3.internal;

/* loaded from: classes7.dex */
public class setLayoutAnimation {
    private static int AGState = 0;
    private static int values = 1;
    private final int APIGuard;
    private final int valueOf;

    public setLayoutAnimation(int i, int i2) {
        this.valueOf = i;
        this.APIGuard = i2;
    }

    public int getSharedInstance() {
        int i = values;
        AGState = (i + 69) % 128;
        int i2 = this.valueOf;
        int i3 = i + 95;
        AGState = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 2 : (char) 19) != 2) {
            return i2;
        }
        throw null;
    }

    public int valueOf() {
        AGState = (values + 77) % 128;
        return this.APIGuard;
    }
}
