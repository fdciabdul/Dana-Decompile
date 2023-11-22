package com.alibaba.ariver.integration.ipc.server;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.integration.ipc.server.shadow.ServerSideEngine;
import com.alibaba.ariver.integration.ipc.server.shadow.ServerSideRender;

/* loaded from: classes3.dex */
public class ServerSideNodeUtils {
    ServerSideNodeUtils() {
    }

    public static void setupPage(Page page) {
        if ((page instanceof PageNode) && page.getRender() == null) {
            ((PageNode) page).setRender(new ServerSideRender(page.getApp().getEngineProxy(), null, page, null));
        }
    }

    public static void setupApp(App app) {
        if ((app instanceof AppNode) && app.getEngineProxy() == null) {
            ((AppNode) app).setEngineProxy(new ServerSideEngine(app));
        }
    }
}
