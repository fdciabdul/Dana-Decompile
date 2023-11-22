package com.alibaba.ariver.integration.ipc.server.shadow;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.integration.ipc.server.ServerSideCallbackHolder;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* loaded from: classes3.dex */
public class ServerSideBridge implements NativeBridge {

    /* renamed from: a  reason: collision with root package name */
    private App f6062a;

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void bindEngineRouter(EngineRouter engineRouter) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerSideBridge(App app) {
        this.f6062a = app;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
        return sendToNative(nativeCallContext, sendToNativeCallback, true);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        ServerSideCallbackHolder.getInstance().registerCallback(this.f6062a.getStartToken(), nativeCallContext.getId(), sendToNativeCallback);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT, nativeCallContext);
        bundle.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, z);
        StringBuilder sb = new StringBuilder();
        sb.append("sendToNative with context: ");
        sb.append(nativeCallContext);
        RVLogger.d("AriverInt:ServerSideBridge", sb.toString());
        IpcServerUtils.sendMsgToClient(this.f6062a.getAppId(), this.f6062a.getStartToken(), 8, bundle);
        return true;
    }
}
