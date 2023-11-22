package com.alibaba.griver.api.appinfo;

/* loaded from: classes3.dex */
public enum AppType {
    UNKNOWN,
    WEB_H5,
    WEB_MIX,
    WEB_TINY,
    WEB_TINY_INNER,
    NATIVE_RN,
    NATIVE_CUBE,
    TINY_HYBRID,
    TINY_GAME;

    public static AppType parse(String str) {
        try {
            return valueOf(str);
        } catch (Throwable unused) {
            return UNKNOWN;
        }
    }

    public final boolean isTiny() {
        return this == WEB_TINY || this == WEB_TINY_INNER || this == NATIVE_CUBE || this == TINY_GAME || this == TINY_HYBRID;
    }

    public final boolean isWeb() {
        return this == WEB_H5 || this == WEB_TINY || this == WEB_TINY_INNER;
    }

    public final boolean isTinyGame() {
        return this == TINY_GAME;
    }
}
