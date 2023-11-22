package com.alibaba.ariver.engine.api.bridge.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface ApiContext {
    void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z);

    Activity getActivity();

    Context getAppContext();

    String getAppId();

    String getBizType();

    String getBridgeId();

    Resource getContent(String str);

    View getInternalView();

    int getPageId();

    String getPluginId();

    Render getRender();

    int getRenderId();

    String getSourceProcess();

    Bundle getStartParams();

    boolean isFromRemote();

    void sendEvent(String str, JSONObject jSONObject, SendToRenderCallback sendToRenderCallback);

    void setBizType(String str);

    void startActivity(Intent intent);
}
