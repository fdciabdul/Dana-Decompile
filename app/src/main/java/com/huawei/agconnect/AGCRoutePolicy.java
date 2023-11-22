package com.huawei.agconnect;

import java.util.Arrays;

/* loaded from: classes7.dex */
public final class AGCRoutePolicy {
    public final int getErrorConfigVersion;
    public static final AGCRoutePolicy getAuthRequestContext = new AGCRoutePolicy(0);
    public static final AGCRoutePolicy MyBillsEntityDataFactory = new AGCRoutePolicy(1);
    public static final AGCRoutePolicy KClassImpl$Data$declaredNonStaticMembers$2 = new AGCRoutePolicy(2);
    public static final AGCRoutePolicy BuiltInFictitiousFunctionClassFactory = new AGCRoutePolicy(3);
    public static final AGCRoutePolicy PlaceComponentResult = new AGCRoutePolicy(4);

    private AGCRoutePolicy(int i) {
        this.getErrorConfigVersion = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.getErrorConfigVersion == ((AGCRoutePolicy) obj).getErrorConfigVersion;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.getErrorConfigVersion)});
    }
}
