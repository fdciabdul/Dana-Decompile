package com.alibaba.ariver.app.api;

/* loaded from: classes3.dex */
public enum EmbedType {
    NO(0),
    FULL(1),
    MINI(2),
    SHARE(3);

    private int mType;

    EmbedType(int i) {
        this.mType = i;
    }

    public final int getTypeValue() {
        return this.mType;
    }

    public final boolean isEmbedPage() {
        return this.mType != NO.getTypeValue();
    }

    public static EmbedType parse(int i) {
        if (i == 1) {
            return FULL;
        }
        if (i == 2) {
            return MINI;
        }
        if (i == 3) {
            return SHARE;
        }
        return NO;
    }
}
