package com.alibaba.exthub.proxy;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.exthub.lifecycler.ProcessLifecycleExtension;

@DefaultImpl("com.alibaba.exthub.ExtHubProcessLifecycleImpl")
/* loaded from: classes3.dex */
public interface ProcessLifecycleProxy extends Proxiable {
    void registerProcessLifecycle(ProcessLifecycleExtension processLifecycleExtension);
}
