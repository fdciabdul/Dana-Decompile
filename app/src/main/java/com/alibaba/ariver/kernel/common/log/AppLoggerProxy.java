package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.kernel.common.log.DefaultAppLoggerImpl")
/* loaded from: classes3.dex */
public interface AppLoggerProxy extends Proxiable {
    String getBizType();

    int getQosLevel();

    void log(BaseAppLog baseAppLog);
}
