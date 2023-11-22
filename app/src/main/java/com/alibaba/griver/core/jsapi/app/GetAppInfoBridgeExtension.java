package com.alibaba.griver.core.jsapi.app;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.model.applist.FetchAppListResult;
import com.alibaba.griver.core.model.applist.FetchAppsByKeyWordsRequest;
import com.alibaba.griver.core.rpc.MiniProgramProcessor;
import java.util.List;

/* loaded from: classes2.dex */
public class GetAppInfoBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverApp:GetAppInfoBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void fetchAppInfoListByIds(@BindingParam({"appIdList"}) List<String> list, @BindingParam({"category"}) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        GriverLogger.d(TAG, "fetchAppInfoListByIds jsapi has been invoke");
        new MiniProgramProcessor().requestAppInfosByIds(list, str, new OnRpcResultListener<FetchAppListResult>() { // from class: com.alibaba.griver.core.jsapi.app.GetAppInfoBridgeExtension.1
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(FetchAppListResult fetchAppListResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("fetchAppInfoListByIds jsapi has been invoke ");
                sb.append(JSON.toJSONString(fetchAppListResult));
                GriverLogger.d(GetAppInfoBridgeExtension.TAG, sb.toString());
                bridgeCallback.sendJSONResponse(JSONUtils.parseObject(JSON.toJSONString(fetchAppListResult)));
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) Integer.valueOf(i));
                jSONObject.put("errorMessage", (Object) str2);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void fetchAppInfoListByKeyword(@BindingParam({"keyword"}) String str, @BindingParam({"category"}) String str2, @BindingParam({"queryStartIndex"}) Integer num, @BindingParam({"querySize"}) Integer num2, @BindingCallback final BridgeCallback bridgeCallback) {
        RVLogger.d(TAG, "fetchAppInfoListByKeyword jsapi has been invoke");
        new MiniProgramProcessor().fetchAppInfoListByKeyword(new FetchAppsByKeyWordsRequest(str, num.intValue(), num2.intValue(), str2), new OnRpcResultListener<FetchAppListResult>() { // from class: com.alibaba.griver.core.jsapi.app.GetAppInfoBridgeExtension.2
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(FetchAppListResult fetchAppListResult) {
                bridgeCallback.sendJSONResponse(JSONUtils.parseObject(JSON.toJSONString(fetchAppListResult)));
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str3) {
                JSONObject jSONObject = new JSONObject();
                if (i == 2) {
                    try {
                        FetchAppListResult fetchAppListResult = (FetchAppListResult) JSON.parseObject(str3, FetchAppListResult.class);
                        jSONObject.put("error", (Object) fetchAppListResult.errorCode);
                        jSONObject.put("errorMessage", (Object) fetchAppListResult.errorMessage);
                        jSONObject.put("errorCode", (Object) fetchAppListResult.errorCode);
                        jSONObject.put("success", (Object) Boolean.valueOf(fetchAppListResult.success));
                        jSONObject.put("totalCount", (Object) Integer.valueOf(fetchAppListResult.getTotalCount()));
                    } catch (Exception unused) {
                        jSONObject.put("error", (Object) Integer.valueOf(i));
                        jSONObject.put("errorMessage", (Object) str3);
                    }
                } else {
                    jSONObject.put("error", (Object) Integer.valueOf(i));
                    jSONObject.put("errorMessage", (Object) str3);
                }
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(TAG, "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        RVLogger.d(TAG, "onFinalized");
    }
}
