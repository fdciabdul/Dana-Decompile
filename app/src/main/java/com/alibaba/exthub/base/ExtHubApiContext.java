package com.alibaba.exthub.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class ExtHubApiContext implements ApiContext {

    /* renamed from: a  reason: collision with root package name */
    private String f6257a;
    private Activity b;
    private String c;

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBridgeId() {
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
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getPluginId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Render getRender() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getRenderId() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getSourceProcess() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Bundle getStartParams() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public boolean isFromRemote() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void sendEvent(String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void startActivity(Intent intent) {
    }

    public ExtHubApiContext(String str, Activity activity, String str2) {
        this.f6257a = str;
        this.b = activity;
        this.c = str2;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getAppId() {
        return this.f6257a;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Context getAppContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Activity getActivity() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBizType() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void setBizType(String str) {
        this.c = str;
    }
}
