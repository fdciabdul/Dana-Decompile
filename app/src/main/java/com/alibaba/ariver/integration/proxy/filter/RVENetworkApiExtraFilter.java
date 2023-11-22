package com.alibaba.ariver.integration.proxy.filter;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.rve.RVEContextPool;
import com.alibaba.ariver.kernel.api.node.Node;

/* loaded from: classes6.dex */
public class RVENetworkApiExtraFilter implements RVEApiExtraFilter {
    @Override // com.alibaba.ariver.ariverexthub.api.provider.RVEApiExtraFilter
    public Bundle handleExtParams(RVEContext rVEContext) {
        NativeCallContext callback = RVEContextPool.getInstance().getCallback(rVEContext);
        if (callback == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        Node node = callback.getNode();
        if (node instanceof Page) {
            bundle.putBundle("startParams", ((Page) node).getStartParams());
        } else {
            bundle.putBundle("startParams", ((App) node.bubbleFindNode(App.class)).getStartParams());
        }
        return bundle;
    }
}
