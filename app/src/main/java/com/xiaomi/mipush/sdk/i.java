package com.xiaomi.mipush.sdk;

/* loaded from: classes8.dex */
/* synthetic */ class i {
    static final /* synthetic */ int[] getAuthRequestContext;

    static {
        int[] iArr = new int[c.values().length];
        getAuthRequestContext = iArr;
        try {
            iArr[c.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            getAuthRequestContext[c.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            getAuthRequestContext[c.ASSEMBLE_PUSH_COS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            getAuthRequestContext[c.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
