package com.alibaba.ariver.engine.api.bridge.model;

/* loaded from: classes3.dex */
public class LoadParams {
    public boolean forceLoad;
    public boolean isFirstLoad;
    public boolean isReload;
    public String url;

    public LoadParams() {
    }

    public LoadParams(LoadParams loadParams) {
        this.url = loadParams.url;
        this.isFirstLoad = loadParams.isFirstLoad;
        this.isReload = loadParams.isReload;
        this.forceLoad = loadParams.forceLoad;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadParams{url=");
        sb.append(this.url);
        sb.append('}');
        return sb.toString();
    }
}
