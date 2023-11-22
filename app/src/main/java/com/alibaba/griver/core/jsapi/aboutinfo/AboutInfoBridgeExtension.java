package com.alibaba.griver.core.jsapi.aboutinfo;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoRequest;
import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoResult;
import com.alibaba.griver.core.rpc.MiniProgramProcessor;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes2.dex */
public class AboutInfoBridgeExtension implements BridgeExtension {
    public static final String PARAM_QUERY_APP_ID = "queryAppId";
    public static final String PARAM_QUERY_APP_VERSION = "queryAppVersion";
    private static final String TAG = "AboutInfoBridgeExtension";

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

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void getAboutInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        String string = BundleUtils.getString(page.getStartParams(), PARAM_QUERY_APP_ID);
        final String string2 = BundleUtils.getString(page.getStartParams(), PARAM_QUERY_APP_VERSION);
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendJSONResponse(getResultFailedResponse(2, RVEConstant.RVEResponse.API_HANDLER_INVALID_ERROR_MSG));
            return;
        }
        new MiniProgramProcessor().getAboutInfo(new GetAboutInfoRequest(string, string2), new OnRpcResultListener<GetAboutInfoResult>() { // from class: com.alibaba.griver.core.jsapi.aboutinfo.AboutInfoBridgeExtension.1
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(GetAboutInfoResult getAboutInfoResult) {
                if (getAboutInfoResult != null && getAboutInfoResult.appInfoDetail != null) {
                    getAboutInfoResult.appInfoDetail.setVersion(string2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAboutInfo");
                    sb.append(JSON.parseObject(JSON.toJSONString(getAboutInfoResult.appInfoDetail)));
                    GriverLogger.d(AboutInfoBridgeExtension.TAG, sb.toString());
                    JSONObject parseObject = JSON.parseObject(JSON.toJSONString(getAboutInfoResult.appInfoDetail));
                    if (parseObject != null) {
                        parseObject.put("success", (Object) SummaryActivity.CHECKED);
                        bridgeCallback.sendJSONResponse(parseObject);
                        return;
                    }
                }
                bridgeCallback.sendJSONResponse(AboutInfoBridgeExtension.this.getResultFailedResponse(3, "unknown error!"));
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAboutInfo");
                sb.append(str);
                GriverLogger.e(AboutInfoBridgeExtension.TAG, sb.toString());
                bridgeCallback.sendJSONResponse(AboutInfoBridgeExtension.this.getResultFailedResponse(i, str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getResultFailedResponse(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) "false");
        jSONObject.put("errorCode", (Object) Integer.valueOf(i));
        jSONObject.put("errorMessage", (Object) str);
        return jSONObject;
    }
}
