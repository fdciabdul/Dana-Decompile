package com.alibaba.ariver.resource.api.models;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class AppInfoQuery {
    public static final String QUERY_HIGHEST_VERSION = "*";

    /* renamed from: a  reason: collision with root package name */
    private String f6209a;
    private String b;
    private AppInfoScene c;
    private boolean d;

    public static AppInfoQuery make(String str) {
        return new AppInfoQuery(str);
    }

    public AppInfoQuery(AppInfoQuery appInfoQuery) {
        this.b = "*";
        this.c = AppInfoScene.ONLINE;
        this.d = false;
        this.f6209a = appInfoQuery.f6209a;
        this.b = appInfoQuery.b;
        this.c = appInfoQuery.c;
    }

    public AppInfoQuery(String str) {
        this.b = "*";
        this.c = AppInfoScene.ONLINE;
        this.d = false;
        this.f6209a = str;
    }

    public AppInfoQuery version(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b = "*";
        } else {
            this.b = str;
        }
        return this;
    }

    public AppInfoQuery disableCache() {
        this.d = true;
        return this;
    }

    public AppInfoQuery scene(AppInfoScene appInfoScene) {
        if (appInfoScene == null) {
            this.c = AppInfoScene.ONLINE;
        } else {
            this.c = appInfoScene;
        }
        return this;
    }

    public String getAppId() {
        return this.f6209a;
    }

    public String getVersion() {
        return this.b;
    }

    public AppInfoScene getScene() {
        return this.c;
    }

    public boolean forHighestVersion() {
        return TextUtils.isEmpty(this.b) || "*".equals(this.b);
    }

    public boolean forSpecificVersion() {
        return (TextUtils.isEmpty(this.b) || this.b.contains("*")) ? false : true;
    }

    public boolean isDisableCache() {
        return this.d;
    }

    public boolean isOnlineScene() {
        return AppInfoScene.ONLINE.equals(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfoQuery{appId=");
        sb.append(this.f6209a);
        sb.append(", version=");
        sb.append(this.b);
        sb.append(", scene=");
        sb.append(this.c);
        sb.append(", disableCache=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
}
