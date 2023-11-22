package com.alibaba.exthub.proxy;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.exthub.ExtHubTaskControlManagerImpl")
/* loaded from: classes6.dex */
public interface TaskControlManagerProxy extends Proxiable {
    void end();

    void start();
}
