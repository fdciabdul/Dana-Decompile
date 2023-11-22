package com.xiaomi.mipush.sdk;

/* loaded from: classes8.dex */
/* synthetic */ class k {
    static final /* synthetic */ int[] MyBillsEntityDataFactory;

    static {
        int[] iArr = new int[c.values().length];
        MyBillsEntityDataFactory = iArr;
        try {
            iArr[c.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            MyBillsEntityDataFactory[c.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            MyBillsEntityDataFactory[c.ASSEMBLE_PUSH_COS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            MyBillsEntityDataFactory[c.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
