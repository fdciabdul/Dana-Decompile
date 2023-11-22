package com.alibaba.ariver.engine.rve;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class RVEContextUtil {
    public static boolean sendToRender(RVEContext rVEContext, String str, JSONObject jSONObject) {
        Page activePage;
        NativeCallContext callback = RVEContextPool.getInstance().getCallback(rVEContext);
        if (callback != null) {
            Node node = callback.getNode();
            if (node instanceof Page) {
                activePage = (Page) node;
            } else {
                activePage = node instanceof App ? ((App) node).getActivePage() : null;
            }
            if (activePage != null) {
                EngineUtils.sendToRender(activePage.getRender(), str, jSONObject, null);
                return true;
            }
            return false;
        }
        return false;
    }
}
