package com.xiaomi.push;

/* loaded from: classes8.dex */
public final class f {
    static final int BuiltInFictitiousFunctionClassFactory = 26;
    static final int KClassImpl$Data$declaredNonStaticMembers$2 = 16;
    static final int MyBillsEntityDataFactory = 11;
    static final int getAuthRequestContext = 12;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return (i << 3) | i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int MyBillsEntityDataFactory(int i) {
        return i & 7;
    }

    public static int getAuthRequestContext(int i) {
        return i >>> 3;
    }
}
