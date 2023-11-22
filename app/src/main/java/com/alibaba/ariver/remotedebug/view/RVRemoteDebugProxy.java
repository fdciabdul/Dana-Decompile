package com.alibaba.ariver.remotedebug.view;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.remotedebug.core.DefaultRemoteDebugProxyImpl")
/* loaded from: classes6.dex */
public interface RVRemoteDebugProxy extends Proxiable {
    boolean enableTyroBlock(String str);

    String getRemoteDebugWebSocketUrl(String str, String str2);

    String getRemoteDebugWebSocketUrlForDebug(String str, String str2);

    boolean supportRemoteDebug(String str);

    boolean tyroRequestHasPermission(String str, String str2);
}
