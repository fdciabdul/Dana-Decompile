package com.alibaba.exthub.api;

import android.app.Activity;
import com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.exthub.bridge.BridgeDispatchCallContext;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class ExtHubCallContext extends BridgeDispatchCallContext {

    /* renamed from: a  reason: collision with root package name */
    private String f6253a;
    private JSONObject b;
    private ExtHubApiResponse c;
    private String d;
    private String e;
    private Activity f;

    /* loaded from: classes6.dex */
    public static class ExtHubCallContextBiz {
        public static final String BIRDNEST_HOST = "birdnest";
        public static final String CARDSDK_HOST = "cardsdk";
        public static final String JSRUNTIME_HOST = "jsruntime";
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public String getId() {
        return null;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public String getName() {
        return null;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public Node getNode() {
        return null;
    }

    private ExtHubCallContext() {
    }

    public ExtHubCallContext(String str, String str2, Activity activity, String str3, JSONObject jSONObject, ExtHubApiResponse extHubApiResponse) {
        this.e = str;
        this.d = str2;
        this.f = activity;
        this.f6253a = str3;
        this.b = jSONObject;
        this.c = extHubApiResponse;
    }

    public String getApiName() {
        return this.f6253a;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public JSONObject getParams() {
        return this.b;
    }

    public String getBizType() {
        return this.d;
    }

    public Activity getActivity() {
        Activity activity = this.f;
        return activity == null ? RVEProxyCenter.getInstance().getTopActivity() : activity;
    }

    public ExtHubApiResponse getApiResponse() {
        return this.c;
    }

    public String getAppId() {
        return this.e;
    }
}
