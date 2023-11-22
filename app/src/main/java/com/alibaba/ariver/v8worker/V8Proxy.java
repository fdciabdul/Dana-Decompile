package com.alibaba.ariver.v8worker;

import android.os.Bundle;
import android.os.Handler;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.jsengine.Delegate;

/* loaded from: classes6.dex */
public interface V8Proxy extends Proxiable {
    void addAssociatedThread(String str);

    Delegate generateDelegate();

    int getAllowCreatedWorkerMaxCount();

    Handler getDispatchHandler(String str);

    String getPackageName();

    String getSessionId(Render render);

    String[] getV8PluginNameList(String str, Bundle bundle);

    String getWebViewCoreSoPath();

    boolean hasSyncApiPermission(String str);

    int quickVerifyWebViewCoreSo(String str);

    boolean removeWebViewCore();

    boolean unzipWebViewCoreSo();
}
