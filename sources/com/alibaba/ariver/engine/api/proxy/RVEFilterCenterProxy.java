package com.alibaba.ariver.engine.api.proxy;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.RVEFilterCenterProxyImpl")
/* loaded from: classes3.dex */
public interface RVEFilterCenterProxy extends Proxiable {
    boolean initFilters();
}
