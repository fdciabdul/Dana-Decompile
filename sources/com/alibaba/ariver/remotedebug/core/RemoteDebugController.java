package com.alibaba.ariver.remotedebug.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.core.state.RemoteDebugState;
import com.alibaba.ariver.remotedebug.datachannel.DataChannel;
import com.alibaba.ariver.remotedebug.datachannel.DataChannelFactory;
import com.alibaba.ariver.remotedebug.utils.RemoteDebugUtils;
import com.alibaba.ariver.remotedebug.view.StateViewController;
import com.alibaba.ariver.remotedebug.worker.RemoteDebugWorker;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.verifyidentity.uitools.POPUIType;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class RemoteDebugController implements NetworkUtil.NetworkListener, DataChannel.DataStatusChangedListener {

    /* renamed from: a */
    private final DataChannel f6187a;
    private final String b;
    private final Context c;
    private final String d;
    private final RemoteDebugWorker e;
    private boolean f;
    private StateViewController g;
    private App h;

    /* loaded from: classes6.dex */
    public interface RemoteDebugExitClickListener {
        void onRemoteDebugExitClick();
    }

    public RemoteDebugController(Context context, RemoteDebugWorker remoteDebugWorker, App app, String str) {
        this.h = app;
        String appId = app.getAppId();
        this.b = appId;
        this.c = context;
        this.d = str;
        this.e = remoteDebugWorker;
        this.f6187a = DataChannelFactory.createDataChannel(1, appId, this);
        a(app);
    }

    private void a(final App app) {
        final Activity activity = (Activity) app.getAppContext().getContext();
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.core.RemoteDebugController.1
            {
                RemoteDebugController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                RemoteDebugController.this.g = new StateViewController(app, new RemoteDebugExitClickListener() { // from class: com.alibaba.ariver.remotedebug.core.RemoteDebugController.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // com.alibaba.ariver.remotedebug.core.RemoteDebugController.RemoteDebugExitClickListener
                    public void onRemoteDebugExitClick() {
                        RemoteDebugController.this.exitRemoteDebug();
                    }
                });
                RemoteDebugController.this.g.setContext(activity);
            }
        });
    }

    public void registerWorker(String str, Bundle bundle) {
        String string = BundleUtils.getString(bundle, "channelId");
        if (TextUtils.isEmpty(string)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "registerWorker...channelId is null");
            return;
        }
        NetworkUtil.addListener(this.c, this);
        final String a2 = a(string);
        final HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.USER_AGENT, str);
        ExecutorUtils.execute(ExecutorType.NORMAL, new Runnable() { // from class: com.alibaba.ariver.remotedebug.core.RemoteDebugController.2
            {
                RemoteDebugController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RemoteDebugController.this.f6187a.connect(a2, hashMap, null);
                } catch (Exception e) {
                    RVLogger.e("AriverRemoteDebug:RemoteDebugController", "registerWorker connect error! ", e);
                }
            }
        });
    }

    public void remoteLoadUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("remoteLoadUrl: ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        this.f6187a.send(str);
    }

    public void sendMessageToRemoteWorker(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("sendMessageToRemoteWorker: ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        this.f6187a.send(str);
    }

    public void exitRemoteDebug() {
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", "exitRemoteDebug.");
        sendMessageToRemoteWorker(RemoteDebugCommand.CMD_LOCAL_DISCONNECTED);
        this.f6187a.close(POPUIType.TOAST_ERROR, "user_exit_debug");
        NetworkUtil.removeListener(this.c, this);
        this.h.exit();
    }

    public boolean isRemoteDebugConnected() {
        StringBuilder sb = new StringBuilder();
        sb.append("isRemoteDebugConnected  ");
        sb.append(this.f);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        return this.f;
    }

    private String a(String str) {
        RVRemoteDebugProxy rVRemoteDebugProxy = (RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class);
        if (RVKernelUtils.isDebug()) {
            String remoteDebugUrlForDebug = RemoteDebugUtils.getRemoteDebugUrlForDebug(this.b, str);
            StringBuilder sb = new StringBuilder();
            sb.append("generateRemoteDebugUrl getRemoteDebugUrlForDebug: ");
            sb.append(remoteDebugUrlForDebug);
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
            if (!TextUtils.isEmpty(remoteDebugUrlForDebug)) {
                return remoteDebugUrlForDebug;
            }
        }
        String remoteDebugWebSocketUrl = rVRemoteDebugProxy.getRemoteDebugWebSocketUrl(this.b, str);
        if (!TextUtils.isEmpty(remoteDebugWebSocketUrl)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(remoteDebugWebSocketUrl);
            sb2.append(str);
            String obj = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("generateRemoteDebugUrl getWebSocketHostUrl from proxy ");
            sb3.append(obj);
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb3.toString());
            return obj;
        }
        String format = String.format(RDConstant.WEBSOCKET_HOST_URL_OPEN_CHANNEL, str, this.b);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("generateRemoteDebugUrl getWebSocketHostUrl: ");
        sb4.append(format);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb4.toString());
        return format;
    }

    private boolean b(String str) {
        if (str.startsWith(RemoteDebugCommand.CMD_REMOTE_DISCONNECTED)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRemoteDebugMessage CMD_REMOTE_DISCONNECTED");
            this.g.notifyStateChanged(RemoteDebugState.STATE_REMOTE_DISCONNECTED);
            return true;
        } else if (str.startsWith(RemoteDebugCommand.CMD_HIT_BREAKPOINT)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRemoteDebugMessage CMD_HIT_BREAKPOINT");
            this.g.notifyStateChanged(RemoteDebugState.STATE_HIT_BREAKPOINT);
            return true;
        } else if (str.startsWith(RemoteDebugCommand.CMD_RELEASE_BREAKPOINT)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRemoteDebugMessage CMD_RELEASE_BREAKPOINT");
            this.g.notifyStateChanged(RemoteDebugState.STATE_RELEASE_BREAKPOINT);
            return true;
        } else if (str.startsWith(RemoteDebugCommand.CMD_RECV_RENDER_DEBUG)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRemoteDebugMessage CMD_RECV_RENDER_DEBUG");
            return c(str);
        } else if (str.startsWith(RemoteDebugCommand.CMD_DEBUG_JS)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRemoteDebugMessage CMD_DEBUG_JS");
            return d(str);
        } else {
            return false;
        }
    }

    private boolean c(String str) {
        String replaceFirst = str.replaceFirst(RemoteDebugCommand.CMD_RECV_RENDER_DEBUG, "");
        if (TextUtils.isEmpty(replaceFirst)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "handleRecvRenderDebug msgText is empty.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", (Object) replaceFirst);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        return this.e.getJsApiHandler().handleMessageToTopRender(jSONObject2, RDConstant.RENDER_DEBUG_MESSAGE);
    }

    private boolean d(String str) {
        JSONObject parseObject = JSONUtils.parseObject(str.replaceFirst(RemoteDebugCommand.CMD_DEBUG_JS, ""));
        if (parseObject == null || parseObject.isEmpty()) {
            return false;
        }
        return this.e.getJsApiHandler().handleMessage(parseObject, RDConstant.SOCKET_MESSAGE);
    }

    @Override // com.alibaba.ariver.kernel.common.network.NetworkUtil.NetworkListener
    public void onNetworkChanged(NetworkUtil.Network network, NetworkUtil.Network network2) {
        if (network2 == NetworkUtil.Network.NETWORK_NO_CONNECTION) {
            this.g.notifyStateChanged(RemoteDebugState.STATE_NETWORK_UNAVAILABLE);
        }
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void onConnectSuccess(String str) {
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", "onConnectSuccess");
        this.f = true;
        this.f6187a.send(String.format(RemoteDebugCommand.CMD_WORKERID_AND_PLATFORM, this.d, "Android"));
        this.e.onAlipayJSBridgeReady();
        this.g.notifyStateChanged(RemoteDebugState.STATE_CONNECTED);
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void onConnectFailed() {
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", "onConnectFailed");
        this.f = false;
        this.g.notifyStateChanged(RemoteDebugState.STATE_CONNECT_FAILED);
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void onConnectClosed(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectClosed id:");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        this.f = false;
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void onConnectError(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectClosed id:");
        sb.append(str);
        sb.append(" code: ");
        sb.append(i);
        sb.append(" errorMsg:");
        sb.append(str2);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        this.f = false;
        this.g.notifyStateChanged(RemoteDebugState.STATE_CONNECT_FAILED);
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void recv(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("recv message: ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", sb.toString());
        if (TextUtils.isEmpty(str)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "recv message is empty！");
        } else if (b(str)) {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "recv message handleRemoteDebugMessage");
        } else {
            RVLogger.d("AriverRemoteDebug:RemoteDebugController", "recv message handleMsgFromWorker");
            this.e.getJsApiHandler().handleMsgFromWorker(str);
        }
    }

    @Override // com.alibaba.ariver.remotedebug.datachannel.DataChannel.DataStatusChangedListener
    public void recv(byte[] bArr) {
        RVLogger.d("AriverRemoteDebug:RemoteDebugController", "recv bytes[]");
        recv(new String(bArr));
    }
}
