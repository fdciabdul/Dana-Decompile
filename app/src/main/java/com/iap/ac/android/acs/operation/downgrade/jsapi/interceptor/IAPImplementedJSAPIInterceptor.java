package com.iap.ac.android.acs.operation.downgrade.jsapi.interceptor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.biz.region.utils.RegionUtils;
import com.iap.ac.android.acs.operation.core.ConfigInterceptor;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.operation.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.operation.downgrade.utils.DisableJSAPIManager;
import com.iap.ac.android.acs.operation.interceptor.BaseInterceptor;
import com.iap.ac.android.acs.operation.utils.Constants;
import com.iap.ac.android.acs.operation.utils.MonitorUtil;
import com.iap.ac.android.acs.operation.utils.Utils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.AcBizUtils;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAPImplementedJSAPIInterceptor implements BridgeInterceptor {
    public static final String JS_API_PARAM_KEY_METHOD = "method";
    public static final String JS_API_PARAM_KEY_NAME = "name";
    public static final String JS_API_PARAM_KEY_REQUEST_DATA = "requestData";
    public static final String JS_API_PARAM_VALUE_DEDUCT = "deduct";
    public static final String TAG = Utils.logTag("ConfigInterceptor");
    public long startTime;

    private boolean checkParam(String str, BridgeInterceptor.InterceptContext interceptContext) {
        if (TextUtils.isEmpty(str)) {
            ACLog.d(TAG, "IAPConnectInterceptor#checkParam, jsapi is empty");
            return false;
        } else if (interceptContext == null || interceptContext.context == null) {
            ACLog.d(TAG, "IAPConnectInterceptor#checkParam, context is empty");
            return false;
        } else {
            return true;
        }
    }

    private String convertAppxrpc(IAPConnectPluginContext iAPConnectPluginContext) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.d(TAG, "IAPConnectInterceptor#convertAppxrpc, jsParameters is null");
            return "";
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestData");
        if (optJSONArray != null && optJSONArray.length() != 0 && optJSONArray.optJSONObject(0) != null) {
            String optString = optJSONArray.optJSONObject(0).optString("method");
            if (TextUtils.isEmpty(optString)) {
                ACLog.d(TAG, "IAPConnectInterceptor#convertAppxrpc, requestData does not contain method");
                return "";
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPConnectInterceptor#convertAppxrpc, method: ");
            sb.append(optString);
            ACLog.d(str, sb.toString());
            return optString;
        }
        ACLog.d(TAG, "IAPConnectInterceptor#convertAppxrpc, requestData is empty");
        return "";
    }

    private IAPConnectPluginCallback convertCallback(final String str, final BridgeCallback bridgeCallback) {
        return new IAPConnectPluginCallback() { // from class: com.iap.ac.android.acs.operation.downgrade.jsapi.interceptor.IAPImplementedJSAPIInterceptor.1
            @Override // com.iap.ac.android.acs.operation.core.IAPConnectPluginCallback
            public void onResult(JSONObject jSONObject) {
                String str2 = IAPImplementedJSAPIInterceptor.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("IAPConnectInterceptor#callback: ");
                sb.append(jSONObject);
                ACLog.d(str2, sb.toString());
                MonitorUtil.monitorFinish(str, SystemClock.elapsedRealtime() - IAPImplementedJSAPIInterceptor.this.startTime);
                BridgeCallback bridgeCallback2 = bridgeCallback;
                if (bridgeCallback2 != null) {
                    bridgeCallback2.sendJSONResponse(jSONObject);
                }
            }
        };
    }

    private IAPConnectPluginContext convertContext(BridgeInterceptor.InterceptContext interceptContext) {
        IAPConnectPluginContext iAPConnectPluginContext = new IAPConnectPluginContext(interceptContext.context);
        iAPConnectPluginContext.setActivity(interceptContext.activity);
        iAPConnectPluginContext.miniProgramPageURL = interceptContext.miniProgramPageURL;
        iAPConnectPluginContext.pluginId = interceptContext.pluginId;
        iAPConnectPluginContext.miniProgramAppID = interceptContext.miniProgramAppID;
        iAPConnectPluginContext.miniProgramName = interceptContext.miniProgramName;
        iAPConnectPluginContext.sourceSite = interceptContext.sourceSite;
        iAPConnectPluginContext.newSourceSite = interceptContext.newSourceSite;
        iAPConnectPluginContext.acquireSite = interceptContext.acquireSite;
        iAPConnectPluginContext.jsParameters = interceptContext.jsParameters;
        iAPConnectPluginContext.isMiniProgram = interceptContext.isMiniProgram;
        iAPConnectPluginContext.acParams = interceptContext.acParams;
        return iAPConnectPluginContext;
    }

    private String convertJSAPI(String str, IAPConnectPluginContext iAPConnectPluginContext) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectInterceptor#convertJSAPI, jsapi: ");
        sb.append(str);
        ACLog.d(str2, sb.toString());
        if ("startBizService".equals(str)) {
            ACLog.d(str2, "IAPConnectInterceptor#convertJSAPI, jsapi is startBizService");
            return convertStartBizService(iAPConnectPluginContext);
        } else if ("appxrpc".equals(str)) {
            ACLog.d(str2, "IAPConnectInterceptor#convertJSAPI, jsapi is appxrpc");
            return convertAppxrpc(iAPConnectPluginContext);
        } else {
            return str;
        }
    }

    private String convertStartBizService(IAPConnectPluginContext iAPConnectPluginContext) {
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        if (jSONObject == null) {
            ACLog.d(TAG, "IAPConnectInterceptor#convertStartBizService, jsParameters is null");
            return "";
        } else if ("deduct".equals(jSONObject.optString("name"))) {
            ACLog.d(TAG, "IAPConnectInterceptor#convertStartBizService, name is deduct so convert");
            return "paySignCenter";
        } else {
            ACLog.d(TAG, "IAPConnectInterceptor#convertStartBizService, name is not deduct");
            return "";
        }
    }

    private boolean innerIntercept(String str, IAPConnectPluginContext iAPConnectPluginContext, IAPConnectPluginCallback iAPConnectPluginCallback) {
        Class<? extends BaseInterceptor> cls = Constants.JS_INTERCEPTOR_MAP.get(str);
        if (cls == null) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPConnectInterceptor#innerIntercept, interceptor class is null, jsapi: ");
            sb.append(str);
            ACLog.d(str2, sb.toString());
            return false;
        }
        try {
            BaseInterceptor newInstance = cls.newInstance();
            String str3 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IAPConnectInterceptor#innerIntercept, start to intercept by ");
            sb2.append(newInstance.getClass().getSimpleName());
            ACLog.d(str3, sb2.toString());
            MonitorUtil.monitorEnter(str);
            this.startTime = SystemClock.elapsedRealtime();
            newInstance.handle(iAPConnectPluginContext, iAPConnectPluginCallback);
            return true;
        } catch (Exception e) {
            String str4 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IAPConnectInterceptor#innerIntercept, inner intercept fail, interceptorClass: ");
            sb3.append(cls);
            sb3.append(", ");
            sb3.append(e);
            ACLog.e(str4, sb3.toString());
            return false;
        }
    }

    @Override // com.iap.ac.android.common.container.interceptor.BridgeInterceptor
    public boolean willHandleJSAPI(String str, BridgeInterceptor.InterceptContext interceptContext, BridgeCallback bridgeCallback) {
        if (!checkParam(str, interceptContext)) {
            ACLog.e(TAG, "IAPConnectInterceptor#willHandleJSAPI, check param, false");
            return false;
        }
        ConfigCenter.INSTANCE.refreshConfigs();
        IAPConnectPluginContext convertContext = convertContext(interceptContext);
        String convertJSAPI = convertJSAPI(str, convertContext);
        if (TextUtils.isEmpty(convertJSAPI)) {
            ACLog.d(TAG, "IAPConnectInterceptor#willHandleJSAPI, js api is empty after converting");
            return false;
        }
        String channel = AcBizUtils.getChannel(convertContext.acParams, convertJSAPI);
        if (TextUtils.isEmpty(channel)) {
            boolean isAcBizMiniProgram = AcBizUtils.isAcBizMiniProgram(convertContext.miniProgramAppID, convertContext.sourceSite, convertContext.newSourceSite);
            boolean isRegionMiniProgram = RegionUtils.isRegionMiniProgram(convertContext.miniProgramAppID, convertContext.sourceSite);
            if (!isAcBizMiniProgram && !isRegionMiniProgram) {
                String str2 = TAG;
                StringBuilder a2 = a.a("IAPConnectInterceptor#willHandleJSAPI, current mini program is neither AC business nor Region business, appId: ");
                a2.append(convertContext.miniProgramAppID);
                a2.append(", sourceSite: ");
                a2.append(convertContext.sourceSite);
                ACLog.d(str2, a2.toString());
                return false;
            }
        } else if (!"B15".equals(channel)) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPConnectInterceptor#willHandleJSAPI, channel: ");
            sb.append(channel);
            ACLog.d(str3, sb.toString());
            return false;
        }
        if (DisableJSAPIManager.getInstance().isDisabled(convertContext.miniProgramAppID, convertJSAPI)) {
            String str4 = TAG;
            StringBuilder a3 = a.a("IAPConnectInterceptor#willHandleJSAPI, current mini program jsapi is disabled,appId: ");
            a3.append(convertContext.miniProgramAppID);
            a3.append(",jsapi:");
            a3.append(convertJSAPI);
            ACLog.d(str4, a3.toString());
            return false;
        }
        IAPConnectPluginCallback convertCallback = convertCallback(convertJSAPI, bridgeCallback);
        Boolean handle = ConfigInterceptor.handle(convertJSAPI, convertContext, convertCallback);
        if (handle != null) {
            String str5 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IAPConnectInterceptor#willHandleJSAPI, intercepted by config:");
            sb2.append(handle);
            ACLog.d(str5, sb2.toString());
            return handle.booleanValue();
        }
        return innerIntercept(convertJSAPI, convertContext, convertCallback);
    }
}
