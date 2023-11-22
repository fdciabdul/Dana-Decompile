package com.alibaba.ariver.integration.ipc.server;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class ServerSideApiContext implements ApiContext {

    /* renamed from: a */
    private long f6059a;
    private String b;
    private Bundle c;
    private Render d;
    private String e;
    private String f;
    private String g;

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBizType() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Resource getContent(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public View getInternalView() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getPageId() {
        return -1;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getRenderId() {
        return -1;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public boolean isFromRemote() {
        return true;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void setBizType(String str) {
    }

    public ServerSideApiContext(Render render, long j, String str, Bundle bundle, String str2, String str3, String str4) {
        this.d = render;
        this.f6059a = j;
        this.b = str;
        this.c = bundle;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getPluginId() {
        return this.f;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBridgeId() {
        return this.g;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getSourceProcess() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Render getRender() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getAppId() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Context getAppContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Activity getActivity() {
        WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
        if (topActivity != null) {
            return topActivity.get();
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void startActivity(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        StringBuilder sb = new StringBuilder();
        sb.append("startActivity by serverSide: ");
        sb.append(intent);
        RVLogger.d("AriverInt:ServerSideApiContext", sb.toString());
        IpcServerUtils.sendMsgToClient(this.b, this.f6059a, 11, bundle);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Bundle getStartParams() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void sendEvent(String str, JSONObject jSONObject, final SendToRenderCallback sendToRenderCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("serverEvent_");
        sb.append(System.currentTimeMillis());
        String obj = sb.toString();
        if (sendToRenderCallback != null) {
            ServerSideCallbackHolder.getInstance().registerCallback(this.f6059a, obj, new SendToNativeCallback() { // from class: com.alibaba.ariver.integration.ipc.server.ServerSideApiContext.1
                {
                    ServerSideApiContext.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                public void onCallback(JSONObject jSONObject2, boolean z) {
                    sendToRenderCallback.onCallBack(jSONObject2);
                }
            });
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_EVENT, str);
        bundle.putString("clientId", obj);
        bundle.putByteArray("data", JSONUtils.marshallJSONObject(jSONObject));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendEvent by serverSide: ");
        sb2.append(str);
        sb2.append(", data: ");
        sb2.append(jSONObject);
        sb2.append(", eventCallId: ");
        sb2.append(obj);
        RVLogger.d("AriverInt:ServerSideApiContext", sb2.toString());
        IpcServerUtils.sendMsgToClient(this.b, this.f6059a, 9, bundle);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        if (nativeCallContext == null) {
            RVLogger.e("AriverInt:ServerSideApiContext", "callApi with nativeCallContext == null!!");
            return;
        }
        nativeCallContext.setPluginId(this.f);
        ServerSideCallbackHolder.getInstance().registerCallback(this.f6059a, nativeCallContext.getId(), sendToNativeCallback);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT, nativeCallContext);
        bundle.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, z);
        StringBuilder sb = new StringBuilder();
        sb.append("sendToNative with context: ");
        sb.append(nativeCallContext);
        RVLogger.d("AriverInt:ServerSideApiContext", sb.toString());
        IpcServerUtils.sendMsgToClient(this.b, this.f6059a, 8, bundle);
    }
}
