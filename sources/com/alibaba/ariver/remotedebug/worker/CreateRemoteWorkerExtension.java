package com.alibaba.ariver.remotedebug.worker;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.utils.RemoteDebugUtils;

/* loaded from: classes6.dex */
public class CreateRemoteWorkerExtension implements CreateWorkerPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint
    public Worker createWorker(Context context, Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        if (RemoteDebugUtils.isRemoteDebugMode(app.getStartParams()) && RemoteDebugUtils.supportRemoteDebugMode(app.getAppId())) {
            RVLogger.d("AriverRemoteDebug:CreateRemoteWorkerExtension", "CreateRemoteWorkerExtension create RemoteDebugWorker");
            return new RemoteDebugWorker(context, node, str, str2);
        }
        return null;
    }
}
