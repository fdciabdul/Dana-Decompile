package com.iap.ac.android.container.adapter.griver.event;

import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.griver.api.bridge.GriverBridgeCallNotFoundEvent;
import com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.IAPBridgeCallbackAdapter;
import com.iap.ac.android.container.adapter.griver.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class BridgeCallNotFoundEventHandler implements GriverBridgeCallNotFoundEvent {

    /* renamed from: a  reason: collision with root package name */
    private static final List<NotFoundJSAPIInterceptor> f7557a = Collections.synchronizedList(new ArrayList());

    public static void registerNotFoundJSAPIInterceptor(NotFoundJSAPIInterceptor notFoundJSAPIInterceptor) {
        f7557a.add(notFoundJSAPIInterceptor);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        ACLog.d("BridgeCallNotFoundEventHandler", "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        ACLog.d("BridgeCallNotFoundEventHandler", "onFinalized");
    }

    @Override // com.alibaba.griver.api.bridge.GriverBridgeCallNotFoundEvent
    public boolean handleBridgeCallNotFound(GriverBridgeCallNotFoundEvent.BridgeContext bridgeContext, BridgeCallback bridgeCallback) {
        ACLog.i("BridgeCallNotFoundEventHandler", String.format("handleBridgeCallNotFound: appId = %s, jsapiName = %s, params = %s", bridgeContext.miniProgramAppID, bridgeContext.jsapiName, bridgeContext.jsParameters));
        NotFoundJSAPIInterceptor.NotFoundJSAPIContext notFoundJSAPIContext = new NotFoundJSAPIInterceptor.NotFoundJSAPIContext();
        notFoundJSAPIContext.context = bridgeContext.context;
        notFoundJSAPIContext.jsParameters = Utils.fastJsonToJson(bridgeContext.jsParameters);
        notFoundJSAPIContext.miniProgramAppID = bridgeContext.miniProgramAppID;
        notFoundJSAPIContext.pluginId = bridgeContext.pluginId;
        notFoundJSAPIContext.miniProgramPageURL = bridgeContext.miniProgramPageURL;
        notFoundJSAPIContext.sourceSite = bridgeContext.sourceSite;
        notFoundJSAPIContext.acParams = Utils.fastJsonToJson(bridgeContext.acParams);
        notFoundJSAPIContext.miniProgramName = bridgeContext.miniProgramName;
        notFoundJSAPIContext.jsapiName = bridgeContext.jsapiName;
        notFoundJSAPIContext.startParams = bridgeContext.startParams;
        PageContext pageContext = bridgeContext.page.getPageContext();
        if (pageContext != null) {
            notFoundJSAPIContext.activity = pageContext.getActivity();
        }
        IAPBridgeCallbackAdapter from = IAPBridgeCallbackAdapter.from(bridgeCallback);
        for (NotFoundJSAPIInterceptor notFoundJSAPIInterceptor : new ArrayList(f7557a)) {
            if (notFoundJSAPIInterceptor.handleNotFoundJSAPI(notFoundJSAPIContext, from)) {
                ACLog.i("BridgeCallNotFoundEventHandler", String.format("[handleNotFoundJSAPI] interceptor success: appId = %s, jsapiName = %s, interceptor = %s", bridgeContext.miniProgramAppID, bridgeContext.jsapiName, notFoundJSAPIInterceptor.getClass().getName()));
                return true;
            }
        }
        ACLog.e("BridgeCallNotFoundEventHandler", String.format("[handleNotFoundJSAPI] interceptor failure: appId = %s, jsapiName = %s", bridgeContext.miniProgramAppID, bridgeContext.jsapiName));
        return false;
    }
}
