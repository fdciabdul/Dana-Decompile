package com.alibaba.griver.core.liteprocess;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.StartupParamsUtils;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.keepalive.KeepAliveAppManager;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes3.dex */
public class LiteProcessHandler implements IpcMessageHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f6431a = new Bundle();

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.f6431a;
        }
        int i = data.getInt(IpcMessageConstants.EXTRA_LPID);
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        String string = data.getString("appId");
        StringBuilder sb = new StringBuilder();
        sb.append("LiteProcessHandler received msg what: ");
        sb.append(message.what);
        sb.append(" lpid: ");
        sb.append(i);
        sb.append(" token: ");
        sb.append(j);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LiteProcessHandler received pid: ");
        sb2.append(ipcMessage.pid);
        sb2.append(" lpid: ");
        sb2.append(ipcMessage.lpid);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb2.toString());
        int i2 = message.what;
        if (i2 == 1) {
            a(j, i, ipcMessage.pid);
            a(string, j);
        } else if (i2 == 2) {
            b(j, i, ipcMessage.pid);
            b(string, j);
        } else if (i2 == 9001) {
            a(string, data.getBundle("startParams"));
        }
    }

    private void a(String str, long j) {
        KeepAliveAppManager.getInstance().setAliveActivityRunningByAppId(str, j);
    }

    private void b(String str, long j) {
        KeepAliveAppManager.getInstance().resetAliveActivityByAppId(str, j);
    }

    private void a(long j, int i, int i2) {
        if (i == 0) {
            LiteProcessManager.getInstance().getMainProcess().setStartToken(j);
            LiteProcessManager.getInstance().getMainProcess().setPid(i2);
            LiteProcessManager.getInstance().getMainProcess().setState(2);
            return;
        }
        LiteProcess findProcessByLpid = LiteProcessManager.getInstance().findProcessByLpid(i);
        if (findProcessByLpid == null) {
            RVLogger.e(IpcServerUtils.LOG_TAG, "process is running, nut LiteProcess not found");
            return;
        }
        findProcessByLpid.setState(2);
        findProcessByLpid.setPid(i2);
        findProcessByLpid.setStartToken(j);
        StringBuilder sb = new StringBuilder();
        sb.append("pid: ");
        sb.append(i2);
        sb.append("is running ");
        sb.append(i);
        sb.append(SemanticAttributes.MessagingOperationValues.PROCESS);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
    }

    private void b(long j, int i, int i2) {
        if (i == 0) {
            LiteProcessManager.getInstance().getMainProcess().reset();
            return;
        }
        LiteProcess findProcessByLpid = LiteProcessManager.getInstance().findProcessByLpid(i);
        if (findProcessByLpid == null) {
            RVLogger.e(IpcServerUtils.LOG_TAG, "process is running, nut LiteProcess not found");
        } else {
            findProcessByLpid.reset();
        }
    }

    private void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Griver.openApp(GriverEnv.getApplicationContext(), str, StartupParamsUtils.filterBundle(str, "", bundle, false));
    }
}
