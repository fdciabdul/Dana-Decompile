package com.alibaba.exthub;

import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class ExtHubLoggerImpl implements ExtHubLogger.Proxy {
    @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
    public void d(String str, String str2) {
    }

    @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
    public void debug(String str, String str2) {
    }

    @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
    public void w(String str, String str2, Throwable th) {
    }

    @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
    public void e(String str, String str2, Throwable th) {
        GriverLogger.e(str, str2, th);
    }
}
