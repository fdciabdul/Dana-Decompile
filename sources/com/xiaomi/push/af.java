package com.xiaomi.push;

/* loaded from: classes8.dex */
public class af {
    int BuiltInFictitiousFunctionClassFactory;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    long MyBillsEntityDataFactory;
    long PlaceComponentResult;
    String getAuthRequestContext;

    public af() {
        this(0, 0L, 0L, null);
    }

    public af(int i, long j, long j2, Exception exc) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = j;
        this.PlaceComponentResult = j2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
        if (exc != null) {
            this.getAuthRequestContext = exc.getClass().getSimpleName();
        }
    }
}
