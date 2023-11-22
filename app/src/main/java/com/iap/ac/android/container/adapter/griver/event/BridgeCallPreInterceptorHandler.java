package com.iap.ac.android.container.adapter.griver.event;

import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.griver.api.bridge.GriverBridgeCallPreInterceptEvent;
import com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.IAPBridgeCallbackAdapter;
import com.iap.ac.android.container.adapter.griver.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class BridgeCallPreInterceptorHandler implements GriverBridgeCallPreInterceptEvent {

    /* renamed from: a  reason: collision with root package name */
    private static final List<BridgeJSAPIPreInterceptor> f7558a = Collections.synchronizedList(new ArrayList());

    public static void registerJSAPIPreInterceptor(BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor) {
        f7558a.add(bridgeJSAPIPreInterceptor);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        ACLog.d("BridgeCallPreInterceptorHandler", "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        ACLog.d("BridgeCallPreInterceptorHandler", "onFinalized");
    }

    @Override // com.alibaba.griver.api.bridge.GriverBridgeCallPreInterceptEvent
    public boolean handleBridgeCallPreIntercept(GriverBridgeCallPreInterceptEvent.PreInterceptBridgeContext preInterceptBridgeContext, BridgeCallback bridgeCallback) {
        ACLog.i("BridgeCallPreInterceptorHandler", String.format("handleBridgeCallPreIntercept: appId = %s, jsapiName = %s, params = %s", preInterceptBridgeContext.miniProgramAppID, preInterceptBridgeContext.jsapiName, preInterceptBridgeContext.jsParameters));
        BridgeJSAPIPreInterceptor.JSAPIPreInterceptContext jSAPIPreInterceptContext = new BridgeJSAPIPreInterceptor.JSAPIPreInterceptContext();
        jSAPIPreInterceptContext.context = preInterceptBridgeContext.context;
        jSAPIPreInterceptContext.jsParameters = Utils.fastJsonToJson(preInterceptBridgeContext.jsParameters);
        jSAPIPreInterceptContext.miniProgramAppID = preInterceptBridgeContext.miniProgramAppID;
        jSAPIPreInterceptContext.pluginId = preInterceptBridgeContext.pluginId;
        jSAPIPreInterceptContext.miniProgramPageURL = preInterceptBridgeContext.miniProgramPageURL;
        jSAPIPreInterceptContext.sourceSite = preInterceptBridgeContext.sourceSite;
        jSAPIPreInterceptContext.acParams = Utils.fastJsonToJson(preInterceptBridgeContext.acParams);
        jSAPIPreInterceptContext.miniProgramName = preInterceptBridgeContext.miniProgramName;
        jSAPIPreInterceptContext.jsapiName = preInterceptBridgeContext.jsapiName;
        jSAPIPreInterceptContext.startParams = preInterceptBridgeContext.startParams;
        jSAPIPreInterceptContext.newSourceSite = preInterceptBridgeContext.newSourceSite;
        jSAPIPreInterceptContext.acquireSite = preInterceptBridgeContext.acquireSite;
        PageContext pageContext = preInterceptBridgeContext.page.getPageContext();
        if (pageContext != null) {
            jSAPIPreInterceptContext.activity = pageContext.getActivity();
        }
        IAPBridgeCallbackAdapter from = IAPBridgeCallbackAdapter.from(bridgeCallback);
        for (BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor : new ArrayList(f7558a)) {
            if (bridgeJSAPIPreInterceptor.handleJSAPIPreIntercept(jSAPIPreInterceptContext, from)) {
                ACLog.i("BridgeCallPreInterceptorHandler", String.format("[handleBridgeCallPreIntercept] interceptor success: appId = %s, jsapiName = %s, interceptor = %s", preInterceptBridgeContext.miniProgramAppID, preInterceptBridgeContext.jsapiName, bridgeJSAPIPreInterceptor.getClass().getName()));
                return true;
            }
        }
        ACLog.e("BridgeCallPreInterceptorHandler", String.format("[handleBridgeCallPreIntercept] interceptor failure: appId = %s, jsapiName = %s", preInterceptBridgeContext.miniProgramAppID, preInterceptBridgeContext.jsapiName));
        return false;
    }
}
