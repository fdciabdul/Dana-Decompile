package com.alipay.mobile.security.bio.service.local.language;

/* loaded from: classes3.dex */
public enum Language {
    UNKNOWN(0, "en"),
    ZH_HANS(1, "zh-Hans"),
    ZH_HANT(2, "zh-Hant"),
    ZH_HK(3, "zh-HK"),
    EN(4, "en");

    String name;
    int value;

    Language(int i, String str) {
        this.value = i;
        this.name = str;
    }
}
