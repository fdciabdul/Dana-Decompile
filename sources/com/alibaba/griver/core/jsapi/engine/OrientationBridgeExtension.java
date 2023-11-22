package com.alibaba.griver.core.jsapi.engine;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class OrientationBridgeExtension implements BridgeExtension {
    private static final String PARAM_SCREEN_ORIENTATION = "orientation";
    private static final String TAG = "AriverAPI:OrientationBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getScreenOrientation(@BindingNode(Page.class) Page page) {
        if (page == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        Activity activity = page.getRender().getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        String activityGetScreenOrientation = activityGetScreenOrientation(activity);
        if (TextUtils.isEmpty(activityGetScreenOrientation)) {
            return BridgeResponse.newError(3, "get screen orientation return null");
        }
        RVLogger.d(TAG, "getScreenOrientation success ");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put(PARAM_SCREEN_ORIENTATION, (Object) activityGetScreenOrientation);
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setScreenOrientation(@BindingParam({"orientation"}) String str, @BindingNode(Page.class) Page page) {
        if (!TextUtils.equals(str, "portrait") && !TextUtils.equals(str, "landscape")) {
            return BridgeResponse.INVALID_PARAM;
        }
        Activity activity = page.getRender().getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.newError(2, "activity is null");
        }
        boolean screenOrientation = ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).setScreenOrientation(activity, str, page);
        StringBuilder sb = new StringBuilder();
        sb.append("setScreenOrientation result ");
        sb.append(screenOrientation);
        RVLogger.d(TAG, sb.toString());
        return screenOrientation ? BridgeResponse.SUCCESS : BridgeResponse.INVALID_PARAM;
    }

    private String activityGetScreenOrientation(Activity activity) {
        int i = activity.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return "landscape";
        }
        return "portrait";
    }
}
