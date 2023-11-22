package com.alibaba.griver.map.jsapi;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.map.GoogleMapKeyUtils;
import com.alipay.mobile.embedview.callback.H5JsCallbackHook;
import com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchHelper;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;

/* loaded from: classes6.dex */
public class CalculateRouteExtension extends SimpleBridgeExtension {
    public static final String ACTION_CALCULATE_ROUTE = "calculateRoute";

    @ActionFilter(ACTION_CALCULATE_ROUTE)
    public void calculateRoute(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getApp() == null || page.getApp().getAppContext() == null || page.getApp().getAppContext().getContext() == null) {
            GriverLogger.e("CalculateRouteExtension", "page or app context null");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (TextUtils.isEmpty(GoogleMapKeyUtils.getGoogleMapApiKey(page.getApp().getAppId(), H5MapUtils.getStringValue(jSONObject, GoogleMapKeyUtils.G_API_KEY, "")))) {
            GriverLogger.e("CalculateRouteExtension", "please set google maps key first!");
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        RouteSearchHelper routeSearchHelper = new RouteSearchHelper(null);
        routeSearchHelper.setEnv(page.getApp().getAppContext().getContext(), null, jSONObject, new H5JsCallbackHook(page, bridgeCallback, null));
        routeSearchHelper.showRoute(page.getApp().getAppId());
    }
}
