package com.alibaba.griver.lottie.utils;

import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.L;
import com.alibaba.griver.lottie.LottieLogger;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages = new HashSet();

    @Override // com.alibaba.griver.lottie.LottieLogger
    public void debug(String str) {
        debug(str, null);
    }

    @Override // com.alibaba.griver.lottie.LottieLogger
    public void debug(String str, Throwable th) {
        if (L.DBG) {
            InstrumentInjector.log_d(L.TAG, str, th);
        }
    }

    @Override // com.alibaba.griver.lottie.LottieLogger
    public void warning(String str) {
        warning(str, null);
    }

    @Override // com.alibaba.griver.lottie.LottieLogger
    public void warning(String str, Throwable th) {
        Set<String> set = loggedMessages;
        if (set.contains(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",");
        sb.append(th);
        GriverLogger.w(L.TAG, sb.toString());
        set.add(str);
    }
}
