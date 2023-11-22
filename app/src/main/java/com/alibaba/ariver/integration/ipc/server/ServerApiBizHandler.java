package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;

/* loaded from: classes3.dex */
public class ServerApiBizHandler implements IpcMessageHandler {

    /* renamed from: a */
    private final Bundle f6058a = new Bundle();
    private ServerSideRemoteApiCaller b;

    public ServerApiBizHandler(ExtensionManager extensionManager) {
        this.b = null;
        this.b = new ServerSideRemoteApiCaller(extensionManager);
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RemoteCallArgs remoteCallArgs;
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.f6058a;
        }
        int i = data.getInt(IpcMessageConstants.EXTRA_LPID);
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        long j2 = data.getLong(IpcMessageConstants.EXTRA_NODE_ID);
        boolean z = data.getBoolean(IpcMessageConstants.EXTRA_FROM_LITE_PROCESS);
        StringBuilder sb = new StringBuilder();
        sb.append("ServerApiBizHandler received msg what: ");
        sb.append(message.what);
        sb.append(" lpid: ");
        sb.append(i);
        sb.append(" token: ");
        sb.append(j);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        int i2 = message.what;
        if (i2 == 2) {
            if (z) {
                ShadowNodePool.getInstance().unBindStartToken(j);
                ShadowNodePool.getInstance().onNodeExit(j2);
            }
        } else if (i2 == 3) {
            if (z) {
                ShadowNodePool.getInstance().bindStartToken(j, j2);
            }
        } else if (i2 == 4) {
            if (z) {
                ShadowNodePool.getInstance().bindStartToken(j, j2);
            }
        } else if (i2 == 5) {
            if (z) {
                ShadowNodePool.getInstance().onNodeExit(j2);
            }
        } else if (i2 != 6) {
            if (i2 != 9 || (remoteCallArgs = (RemoteCallArgs) BundleUtils.getParcelable(message.getData(), IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS)) == null) {
                return;
            }
            this.b.remoteRVECall(remoteCallArgs);
        } else {
            RemoteCallArgs remoteCallArgs2 = (RemoteCallArgs) BundleUtils.getParcelable(message.getData(), IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS);
            if (remoteCallArgs2 != null) {
                this.b.remoteCall(remoteCallArgs2);
            }
        }
    }
}
