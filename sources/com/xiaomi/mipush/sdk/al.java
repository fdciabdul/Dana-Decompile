package com.xiaomi.mipush.sdk;

/* loaded from: classes8.dex */
/* synthetic */ class al {
    static final /* synthetic */ int[] MyBillsEntityDataFactory;

    static {
        int[] iArr = new int[am.values().length];
        MyBillsEntityDataFactory = iArr;
        try {
            iArr[am.DISABLE_PUSH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            MyBillsEntityDataFactory[am.ENABLE_PUSH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            MyBillsEntityDataFactory[am.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            MyBillsEntityDataFactory[am.UPLOAD_FCM_TOKEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            MyBillsEntityDataFactory[am.UPLOAD_COS_TOKEN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            MyBillsEntityDataFactory[am.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
