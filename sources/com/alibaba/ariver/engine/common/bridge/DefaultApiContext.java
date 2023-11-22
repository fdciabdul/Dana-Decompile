package com.alibaba.ariver.engine.common.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ExtHubConstants;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class DefaultApiContext implements ApiContext {

    /* renamed from: a  reason: collision with root package name */
    private Node f6030a;
    private String b;
    private String c;

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBizType() {
        return ExtHubConstants.KEY_NEBULA;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public boolean isFromRemote() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void setBizType(String str) {
    }

    public DefaultApiContext(Node node, String str, String str2) {
        this.f6030a = node;
        this.b = str;
        this.c = str2;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getPluginId() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getBridgeId() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getSourceProcess() {
        return ProcessUtils.getProcessName();
    }

    private App a() {
        Node node = this.f6030a;
        if (node instanceof Page) {
            return (App) node.bubbleFindNode(App.class);
        }
        if (node instanceof App) {
            return (App) node;
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Render getRender() {
        Page activePage;
        Node node = this.f6030a;
        if (node instanceof Page) {
            activePage = (Page) node;
        } else {
            activePage = node instanceof App ? ((App) node).getActivePage() : null;
        }
        if (activePage == null) {
            return null;
        }
        return activePage.getRender();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getAppId() {
        App a2 = a();
        return a2 == null ? "" : a2.getAppId();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Context getAppContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Resource getContent(String str) {
        ResourceLoadContext resourceLoadContext = new ResourceLoadContext();
        resourceLoadContext.uri = Uri.parse(str);
        resourceLoadContext.originUrl = str;
        resourceLoadContext.canUseFallback = true;
        resourceLoadContext.canAsyncFallback = false;
        resourceLoadContext.isMainDoc = false;
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(a()).create()).load(resourceLoadContext);
        if (load != null) {
            return load;
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Activity getActivity() {
        AppContext appContext;
        PageContext pageContext;
        Page page = (Page) this.f6030a.bubbleFindNode(Page.class);
        if (page != null && (pageContext = page.getPageContext()) != null && pageContext.getActivity() != null) {
            return pageContext.getActivity();
        }
        App app = (App) this.f6030a.bubbleFindNode(App.class);
        if (app != null && (appContext = app.getAppContext()) != null && (appContext.getContext() instanceof Activity)) {
            return (Activity) appContext.getContext();
        }
        Render render = getRender();
        if (render == null) {
            return null;
        }
        return render.getActivity();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void startActivity(Intent intent) {
        getActivity().startActivity(intent);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public View getInternalView() {
        Render render = getRender();
        if (render == null) {
            return null;
        }
        return render.getView();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Bundle getStartParams() {
        Render render = getRender();
        if (render == null) {
            return a().getStartParams();
        }
        return render.getStartParams();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getPageId() {
        if (getRender() != null) {
            return getRender().getPageId();
        }
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getRenderId() {
        if (getRender() != null) {
            return TypeUtils.parseInt(getRender().getRenderId());
        }
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void sendEvent(String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback) {
        if (getRender() != null) {
            EngineUtils.sendToRender(getRender(), str, jSONObject, sendToRenderCallback);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendEvent but render not ready!!! stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print!!!")));
        RVLogger.e(sb.toString());
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        if (a() == null) {
            return;
        }
        nativeCallContext.setPluginId(this.b);
        a().getEngineProxy().getBridge().sendToNative(nativeCallContext, sendToNativeCallback, z);
    }
}
