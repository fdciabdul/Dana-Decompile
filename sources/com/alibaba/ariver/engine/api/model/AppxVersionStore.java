package com.alibaba.ariver.engine.api.model;

/* loaded from: classes6.dex */
public class AppxVersionStore {
    public String renderVersion;
    public String workerVersion;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppxVersionStore{renderVersion='");
        sb.append(this.renderVersion);
        sb.append('\'');
        sb.append(", workerVersion='");
        sb.append(this.workerVersion);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
