package com.iap.ac.android.acs.operation.interceptor;

import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.utils.CallbackUtil;
import com.iap.ac.android.acs.operation.utils.Constants;
import com.iap.ac.android.acs.operation.utils.Utils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Interceptor4batchQueryCdpSpaceInfo extends BaseInterceptor {
    public static final String PARAM_SPACE_CODE_LIST = "spaceCodeList";
    public static final String TAG = "IAPConnectPlugin";

    @Override // com.iap.ac.android.acs.operation.interceptor.BaseInterceptor
    public void handle(IAPConnectPluginContext iAPConnectPluginContext, final IAPConnectPluginCallback iAPConnectPluginCallback) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Interceptor4batchQueryCdpSpaceInfo#handle, jsParameters is null");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_BATCH_QUERY_CDP_SPACE_INFO, "jsParameters is null"));
            return;
        }
        List<String> jsonArray2StringList = Utils.jsonArray2StringList(jSONObject.optJSONArray(PARAM_SPACE_CODE_LIST));
        if (jsonArray2StringList.isEmpty()) {
            ACLog.e("IAPConnectPlugin", "Interceptor4batchQueryCdpSpaceInfo#handle, spaceCodes is empty");
            iAPConnectPluginCallback.onResult(CallbackUtil.getInvalidParamError(Constants.JS_API_BATCH_QUERY_CDP_SPACE_INFO, "spaceCodes is empty"));
            return;
        }
        WalletCdpKit.getInstance().getSpaceInfoMap(iAPConnectPluginContext.getContext(), jsonArray2StringList, new GetSpaceInfoCallback() { // from class: com.iap.ac.android.acs.operation.interceptor.Interceptor4batchQueryCdpSpaceInfo.1
            @Override // com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback
            public void onFailure(Exception exc) {
                iAPConnectPluginCallback.onResult(CallbackUtil.getInternalError(Constants.JS_API_BATCH_QUERY_CDP_SPACE_INFO, exc.getMessage()));
                StringBuilder sb = new StringBuilder();
                sb.append("Interceptor4batchQueryCdpSpaceInfo#handle, error: ");
                sb.append(exc.getMessage());
                ACLog.e("IAPConnectPlugin", sb.toString());
            }

            @Override // com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback
            public void onSuccess(Map<String, CdpSpaceInfo> map) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", new JSONObject(JsonUtils.toJson(map)));
                    iAPConnectPluginCallback.onResult(jSONObject2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Interceptor4batchQueryCdpSpaceInfo#handle, result: ");
                    sb.append(jSONObject2);
                    ACLog.d("IAPConnectPlugin", sb.toString());
                } catch (Throwable th) {
                    onFailure(new Exception(th));
                }
            }
        });
    }
}
