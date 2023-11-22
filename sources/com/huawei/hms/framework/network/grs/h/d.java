package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {
    private static final Map<String, a> KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap(16);

    /* loaded from: classes8.dex */
    public static class a {
        private final long BuiltInFictitiousFunctionClassFactory;
        private final long PlaceComponentResult;

        public a(long j, long j2) {
            this.PlaceComponentResult = j;
            this.BuiltInFictitiousFunctionClassFactory = j2;
        }

        public final boolean PlaceComponentResult() {
            return SystemClock.elapsedRealtime() - this.BuiltInFictitiousFunctionClassFactory <= this.PlaceComponentResult;
        }
    }

    public static a BuiltInFictitiousFunctionClassFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of get is before:");
        Map<String, a> map = KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        a aVar = map.get(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of get is after:");
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
        return aVar;
    }

    public static void MyBillsEntityDataFactory(String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of put is before:");
        Map<String, a> map = KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        map.put(str, aVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of put is after:");
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
    }
}
