package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class DefaultAppLoggerImpl implements AppLoggerProxy {
    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public String getBizType() {
        return "Ariver";
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public int getQosLevel() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public void log(BaseAppLog baseAppLog) {
        RVLogger.d(baseAppLog.toString());
    }
}
