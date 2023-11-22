package com.alibaba.griver.core.proxy;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;

/* loaded from: classes6.dex */
public class GriverRemoteDebugProxy implements RVRemoteDebugProxy {
    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean enableTyroBlock(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean supportRemoteDebug(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean tyroRequestHasPermission(String str, String str2) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrl(String str, String str2) {
        String format = String.format("%s/group/connect/%s?scene=tinyAppDebug&roleType=TINYAPP&roleId=%s", GriverConfig.getConfig(GriverConfigConstants.KEY_WEBSOCKET_HOST_URL, ""), str2, str);
        StringBuilder sb = new StringBuilder();
        sb.append("getRemoteDebugWebSocketUrl == ");
        sb.append(format);
        RVLogger.d("GriverRemoteDebugProxy", sb.toString());
        return format;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrlForDebug(String str, String str2) {
        String format = String.format("%s/group/connect/%s?scene=tinyAppDebug&roleType=TINYAPP&roleId=%s", GriverConfig.getConfig(GriverConfigConstants.KEY_WEBSOCKET_HOST_URL, ""), str2, str);
        StringBuilder sb = new StringBuilder();
        sb.append("getRemoteDebugWebSocketUrlForDebug == ");
        sb.append(format);
        RVLogger.d("GriverRemoteDebugProxy", sb.toString());
        return format;
    }
}
