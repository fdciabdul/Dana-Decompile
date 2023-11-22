package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class e {
    private static final String PlaceComponentResult = "e";

    public static boolean MyBillsEntityDataFactory(Long l) {
        if (l == null) {
            Logger.v(PlaceComponentResult, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.v(PlaceComponentResult, "isSpExpire spValue NumberFormatException.");
        }
        if (l.longValue() - System.currentTimeMillis() >= 0) {
            Logger.i(PlaceComponentResult, "isSpExpire false.");
            return false;
        }
        Logger.i(PlaceComponentResult, "isSpExpire true.");
        return true;
    }

    public static boolean getAuthRequestContext(Long l) {
        if (l == null) {
            Logger.v(PlaceComponentResult, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l.longValue() - (System.currentTimeMillis() + 300000) >= 0) {
                Logger.v(PlaceComponentResult, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(PlaceComponentResult, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
