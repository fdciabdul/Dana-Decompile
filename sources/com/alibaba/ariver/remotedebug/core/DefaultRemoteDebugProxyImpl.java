package com.alibaba.ariver.remotedebug.core;

/* loaded from: classes6.dex */
public class DefaultRemoteDebugProxyImpl implements RVRemoteDebugProxy {
    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean enableTyroBlock(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrl(String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrlForDebug(String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean supportRemoteDebug(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean tyroRequestHasPermission(String str, String str2) {
        return true;
    }
}
