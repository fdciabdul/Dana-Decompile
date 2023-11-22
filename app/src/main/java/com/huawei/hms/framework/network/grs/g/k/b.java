package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class b {
    public final Future<com.huawei.hms.framework.network.grs.g.d> BuiltInFictitiousFunctionClassFactory;
    private final long KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.BuiltInFictitiousFunctionClassFactory = future;
    }

    public final boolean MyBillsEntityDataFactory() {
        return SystemClock.elapsedRealtime() - this.KClassImpl$Data$declaredNonStaticMembers$2 <= 300000;
    }
}
