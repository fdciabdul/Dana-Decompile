package com.xiaomi.push;

/* loaded from: classes8.dex */
public enum dd {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a  reason: collision with other field name */
    private final int f97a;

    dd(int i) {
        this.f97a = i;
    }

    public static dd a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}
