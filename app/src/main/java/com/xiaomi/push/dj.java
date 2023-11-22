package com.xiaomi.push;

/* loaded from: classes8.dex */
public enum dj {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a  reason: collision with other field name */
    private final int f150a;

    dj(int i) {
        this.f150a = i;
    }

    public static dj a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Init;
            }
            return PackageUnregistered;
        }
        return RegIdExpired;
    }

    public final int a() {
        return this.f150a;
    }
}
