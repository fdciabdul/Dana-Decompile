package com.alibaba.griver.base.common.logger;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class GriverRVLoggerProxyImpl implements RVLogger.Proxy {
    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void d(String str, String str2) {
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void debug(String str, String str2) {
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void e(String str, String str2, Throwable th) {
        GriverLogger.e(str, str2, th);
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void w(String str, String str2, Throwable th) {
        GriverLogger.w(str, str2, th);
    }
}
