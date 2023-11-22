package com.alibaba.griver.api.bridge;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public interface BridgeInterceptor {

    /* loaded from: classes6.dex */
    public static class InterceptContext {
        public JSONObject acParams;
        public String acquireSite;
        public Context context;
        public JSONObject jsParameters;
        public String miniProgramAppID;
        public String miniProgramName;
        public String miniProgramPageURL;
        public String newSourceSite;
        public Page page;
        public String pluginId;
        public String sourceSite;
        public Bundle startParams;
    }

    boolean willHandleJSAPI(String str, InterceptContext interceptContext, BridgeCallback bridgeCallback);
}
