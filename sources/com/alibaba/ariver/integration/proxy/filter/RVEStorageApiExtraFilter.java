package com.alibaba.ariver.integration.proxy.filter;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.rve.RVEContextPool;

/* loaded from: classes6.dex */
public class RVEStorageApiExtraFilter implements RVEApiExtraFilter {
    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter
    public Bundle handleExtParams(RVEContext rVEContext) {
        NativeCallContext callback = RVEContextPool.getInstance().getCallback(rVEContext);
        if (callback == null) {
            return null;
        }
        App app = (App) callback.getNode().bubbleFindNode(App.class);
        String pluginId = callback.getPluginId();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(pluginId)) {
            bundle.putString("isolatedId", pluginId);
        }
        bundle.putBoolean("isolation", app.isTinyApp());
        bundle.putString("businessId", app.getAppId());
        return bundle;
    }
}
