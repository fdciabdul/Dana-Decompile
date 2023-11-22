package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;
import com.alibaba.griver.lottie.L;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class LogcatLogger implements LottieLogger {
    private static final Set<String> getAuthRequestContext = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public final void PlaceComponentResult(String str, Throwable th) {
        Set<String> set = getAuthRequestContext;
        if (set.contains(str)) {
            return;
        }
        InstrumentInjector.log_w(L.TAG, str, th);
        set.add(str);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public final void BuiltInFictitiousFunctionClassFactory(String str, Throwable th) {
        if (com.airbnb.lottie.L.getAuthRequestContext) {
            InstrumentInjector.log_d(L.TAG, str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (com.airbnb.lottie.L.getAuthRequestContext) {
            InstrumentInjector.log_d(L.TAG, str, null);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public final void getAuthRequestContext(String str) {
        Set<String> set = getAuthRequestContext;
        if (set.contains(str)) {
            return;
        }
        InstrumentInjector.log_w(L.TAG, str, null);
        set.add(str);
    }
}
