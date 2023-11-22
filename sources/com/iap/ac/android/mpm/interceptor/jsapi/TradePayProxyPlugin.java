package com.iap.ac.android.mpm.interceptor.jsapi;

import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.js.AlipayJSAPI;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;

/* loaded from: classes8.dex */
public class TradePayProxyPlugin extends TradePayPlugin {
    private static final String TAG = "TradePayProxyPlugin";
    private static final String TRADE_PAY = "tradePayAC";

    @Override // com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin
    @AlipayJSAPI(api = TRADE_PAY)
    public void api(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        ACLog.d(TAG, "api tradePayAC");
        ACLogEvent.newLogger("iapconnect_center", LogConstants.Mpm.AC_INTERCEPTOR_JSAPI).addParams("action", TRADE_PAY).addParams("params", map).event();
        super.api(map, iContainerPresenter, containerBridgeContext);
    }

    @Override // com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin, com.iap.ac.android.common.container.js.plugin.BaseJSPlugin
    public Class<? extends BaseJSPlugin> getJSPluginClass() {
        return TradePayProxyPlugin.class;
    }
}
