package com.alibaba.griver.base.common.env;

import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;

/* loaded from: classes6.dex */
public class GriverRVResourceEnvProxyImpl implements RVResourceEnviromentProxy {
    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    public String getConfigVariable() {
        return GriverEnv.getAppName();
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    public String getNewSignPublicKey(String str) {
        return GriverEnv.getVerifyPulickey();
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    public String getLegacySignPublicKey(String str) {
        return GriverEnv.getVerifyPulickey();
    }
}
