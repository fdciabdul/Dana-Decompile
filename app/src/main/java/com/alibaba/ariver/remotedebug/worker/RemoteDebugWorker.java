package com.alibaba.ariver.remotedebug.worker;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.core.RemoteDebugController;

/* loaded from: classes6.dex */
public class RemoteDebugWorker extends BaseWorkerImpl {

    /* renamed from: a  reason: collision with root package name */
    private final String f6196a;
    private final RemoteDebugController b;
    private final JsApiHandler c;

    public RemoteDebugWorker(Context context, Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        app.getStartParams();
        this.b = new RemoteDebugController(context, this, app, str);
        this.mStartupParams = app.getStartParams();
        StringBuilder sb = new StringBuilder();
        sb.append("AriverRemoteDebug:RemoteDebugWorker:");
        sb.append(app.getAppId());
        this.f6196a = sb.toString();
        this.c = new JsApiHandler(this, app.getEngineProxy().getEngineRouter());
        init(str2, this.mStartupParams);
    }

    public void init(String str, Bundle bundle) {
        this.b.registerWorker(str, bundle);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.f6196a;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        RVLogger.e(this.f6196a, "tryToInjectStartupParamsAndPushWorker");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            RemoteDebugController remoteDebugController = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append(RDConstant.JAVASCRIPT_SCHEME);
            sb.append(a());
            remoteDebugController.remoteLoadUrl(sb.toString());
        } catch (Throwable th) {
            RVLogger.e(this.f6196a, "tryToInjectStartupParamsAndPushWorker error: ", th);
        }
        String str = this.f6196a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("tryToInjectStartupParamsAndPushWorker cost = ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.e(str, sb2.toString());
        setWorkerReady();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(null, null, str, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        RemoteDebugController remoteDebugController = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.JAVASCRIPT_SCHEME);
        sb.append(a(str3));
        remoteDebugController.sendMessageToRemoteWorker(sb.toString());
        sendPushCallBack(str, str2, sendToWorkerCallback);
    }

    public void sendMessageToRemoteWorker(String str) {
        this.b.sendMessageToRemoteWorker(str);
    }

    public boolean isRemoteDebugConnected() {
        RVLogger.d(this.f6196a, "isRemoteDebugConnected.");
        return this.b.isRemoteDebugConnected();
    }

    public void exitRemoteDebug() {
        RVLogger.d(this.f6196a, "exitRemoteDebug");
        this.b.exitRemoteDebug();
    }

    private String a() {
        String jSONString = BundleUtils.toJSONObject(this.mStartupParams).toJSONString();
        StringBuilder sb = new StringBuilder();
        sb.append("__appxStartupParams=");
        sb.append(jSONString);
        sb.append(";var __workerjs=\"self.__appxStartupParams=\" + JSON.stringify(__appxStartupParams) + \";importScripts('");
        sb.append(this.mWorkerId);
        sb.append("');\";worker.postMessage({action:'exec',data:__workerjs});");
        return sb.toString();
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.worker.postMessage({\"action\":\"callBridge\",\"data\":");
        sb.append(str);
        sb.append("})");
        return sb.toString();
    }

    public JsApiHandler getJsApiHandler() {
        return this.c;
    }
}
