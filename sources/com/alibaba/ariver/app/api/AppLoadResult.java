package com.alibaba.ariver.app.api;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class AppLoadResult {
    public String appType;
    public String appVersion;
    public String mainHtmlUrl;
    public String mainJsUrl;
    public Callable<Boolean> waitLoadFuture;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLoadResult{mainJsUrl='");
        sb.append(this.mainJsUrl);
        sb.append('\'');
        sb.append(", mainHtmlUrl='");
        sb.append(this.mainHtmlUrl);
        sb.append('\'');
        sb.append(", appType=");
        sb.append(this.appType);
        sb.append(", appVersion='");
        sb.append(this.appVersion);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
