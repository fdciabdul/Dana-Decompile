package com.alibaba.griver.biz.jsapi.open;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class GetUserInfoBridgeExtension extends SimpleBridgeExtension {
    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getUserInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", "INVALID");
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
