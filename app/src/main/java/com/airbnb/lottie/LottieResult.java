package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class LottieResult<V> {
    final Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    public final V PlaceComponentResult;

    public LottieResult(V v) {
        this.PlaceComponentResult = v;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    public LottieResult(Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        this.PlaceComponentResult = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LottieResult) {
            LottieResult lottieResult = (LottieResult) obj;
            V v = this.PlaceComponentResult;
            if (v == null || !v.equals(lottieResult.PlaceComponentResult)) {
                Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (th == null || lottieResult.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    return false;
                }
                return th.toString().equals(this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2});
    }
}
