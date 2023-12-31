package com.alibaba.ariver.app.api;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class AppRestartResult {
    public boolean canRestart;
    public boolean closeAllWindow;
    public Bundle startParam;
    public String startUrl;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppRestartResult{canRestart=");
        sb.append(this.canRestart);
        sb.append(", closeAllWindow=");
        sb.append(this.closeAllWindow);
        sb.append(", startUrl=");
        sb.append(this.startUrl);
        sb.append('}');
        return sb.toString();
    }
}
