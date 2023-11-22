package com.alibaba.ariver.resource.api.appinfo;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;

/* loaded from: classes6.dex */
public class UpdatePluginParam {

    /* renamed from: a  reason: collision with root package name */
    private String f6203a;
    private String b;
    private String c;
    private ApiContext d;
    private App e;
    private Bundle f;

    public UpdatePluginParam(String str, String str2) {
        this.f6203a = str;
        this.b = str2;
    }

    public Bundle getRequestParams() {
        return this.f;
    }

    public void setRequestParams(Bundle bundle) {
        this.f = bundle;
    }

    public String getHostAppId() {
        return this.f6203a;
    }

    public void setHostAppId(String str) {
        this.f6203a = str;
    }

    public String getPluginId() {
        return this.b;
    }

    public void setPluginId(String str) {
        this.b = str;
    }

    public String getRequiredVersion() {
        return this.c;
    }

    public void setRequiredVersion(String str) {
        this.c = str;
    }

    public ApiContext getApiContext() {
        return this.d;
    }

    public void setApiContext(ApiContext apiContext) {
        this.d = apiContext;
    }

    public App getApp() {
        return this.e;
    }

    public void setApp(App app) {
        this.e = app;
    }
}
