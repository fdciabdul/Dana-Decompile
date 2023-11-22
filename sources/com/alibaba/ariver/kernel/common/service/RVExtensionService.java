package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultExtensionServiceImpl")
/* loaded from: classes6.dex */
public interface RVExtensionService extends Proxiable {
    ExtensionManager getExtensionManager();
}
