package com.iap.ac.android.common.container.interceptor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface BridgeInterceptor {

    /* loaded from: classes3.dex */
    public static class InterceptContext {
        public JSONObject acParams;
        public String acquireSite;
        public Activity activity;
        public Context context;
        public boolean isMiniProgram;
        public JSONObject jsParameters;
        public String miniProgramAppID;
        public String miniProgramName;
        public String miniProgramPageURL;
        public String newSourceSite;
        public String pluginId;
        public String sourceSite;
        public Bundle startParams;
    }

    boolean willHandleJSAPI(String str, InterceptContext interceptContext, BridgeCallback bridgeCallback);
}
