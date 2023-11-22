package com.alibaba.griver.base.common.logger;

import com.alibaba.griver.api.common.logger.GriverLoggerProxy;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.android.iaptinylog.IAPTinyLogger;

/* loaded from: classes3.dex */
public class GriverLogcatLogger implements GriverLoggerProxy {
    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public boolean isEnable() {
        return GriverEnv.getDebuggable() && GriverEnv.isDebuggable() && IAPTinyLogger.KClassImpl$Data$declaredNonStaticMembers$2().size() == 0;
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void debug(String str, String str2) {
        if (isEnable()) {
            InstrumentInjector.log_d(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void d(String str, String str2) {
        if (isEnable()) {
            InstrumentInjector.log_d(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void w(String str, String str2) {
        if (isEnable()) {
            InstrumentInjector.log_w(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void w(String str, String str2, Throwable th) {
        if (isEnable()) {
            InstrumentInjector.log_w(str, str2, th);
        }
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void e(String str, String str2) {
        if (isEnable()) {
            InstrumentInjector.log_e(str, str2);
        }
    }

    @Override // com.alibaba.griver.api.common.logger.GriverLoggerProxy
    public void e(String str, String str2, Throwable th) {
        if (isEnable()) {
            InstrumentInjector.log_e(str, str2, th);
        }
    }
}
