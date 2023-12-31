package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;

/* loaded from: classes6.dex */
public class DefaultExtensionServiceImpl implements RVExtensionService {
    @Override // com.alibaba.ariver.kernel.common.service.RVExtensionService
    public ExtensionManager getExtensionManager() {
        return RVInitializer.getExtensionManager();
    }
}
