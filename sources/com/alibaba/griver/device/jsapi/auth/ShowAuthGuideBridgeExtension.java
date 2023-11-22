package com.alibaba.griver.device.jsapi.auth;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.permission.api.extension.PermissionGuildePoint;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class ShowAuthGuideBridgeExtension extends SimpleBridgeExtension {
    private static final Set<String> AUTH_GUIDE_AUTHTYPE;
    private static final String TAG = "ShowAuthGuideBridgeExtension";

    static {
        HashSet hashSet = new HashSet();
        AUTH_GUIDE_AUTHTYPE = hashSet;
        hashSet.add("SELFSTARTING");
        hashSet.add("ADDRESSBOOK");
        hashSet.add("CAMERA");
        hashSet.add("PHOTO");
        hashSet.add("LBS");
        hashSet.add("LBSSERVICE");
        hashSet.add("NOTIFICATION");
        hashSet.add("MICROPHONE");
        hashSet.add("SHINFO");
        hashSet.add("SHORTCUT");
        hashSet.add("BACKGROUNDER");
        hashSet.add("LBSSERVICE");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void showAuthGuide(@BindingParam({"issue"}) String str, @BindingParam({"source"}) String str2, @BindingParam({"option"}) String str3, @BindingParam({"authType"}) String str4, @BindingParam({"bizType"}) String str5, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str4) || page == null || !AUTH_GUIDE_AUTHTYPE.contains(str4) || TextUtils.isEmpty(str5)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("showAuthGuide bizType = ");
        sb.append(str5);
        GriverLogger.d(TAG, sb.toString());
        boolean z = ((PermissionGuildePoint) ExtensionPoint.as(PermissionGuildePoint.class).node(page.getApp()).create()).startPermissionGuide(str4, str5) == 1;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showAuthGuide, isShown: ");
        sb2.append(z);
        GriverLogger.d(TAG, sb2.toString());
        jSONObject.put("shown", (Object) Boolean.valueOf(z));
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
