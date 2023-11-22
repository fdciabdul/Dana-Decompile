package com.alibaba.ariver.kernel.common.log;

import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class DefaultAppLogConfigProxyImpl implements AppLogConfigProxy {
    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public int getAPILengthLimit() {
        return 1000;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public String getCurrentEnv() {
        return "";
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getErrorIgnoreAPIList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getIgnoreAPIList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public int getIgnoreApiLogCount() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getIgnoreErrorResourceHostList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getIgnoreEventList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getIgnoreInputAPIList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Set<String> getIgnoreOutputAPIList() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLogConfigProxy
    public Map<String, Map<String, String>> getNotIgnoreAPIForSpecificParam() {
        return null;
    }
}
