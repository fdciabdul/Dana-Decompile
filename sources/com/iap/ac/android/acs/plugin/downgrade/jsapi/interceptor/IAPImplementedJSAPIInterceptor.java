package com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.ConfigInterceptor;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.DisableJSAPIManager;
import com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.utils.AcBizUtils;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAPImplementedJSAPIInterceptor implements BridgeInterceptor {
    public static final String JS_API_PARAM_KEY_METHOD = "method";
    public static final String JS_API_PARAM_KEY_NAME = "name";
    public static final String JS_API_PARAM_KEY_REQUEST_DATA = "requestData";
    public static final String JS_API_PARAM_VALUE_DEDUCT = "deduct";
    public static final String TAG = ApiDowngradeUtils.logTag("ConfigInterceptor");
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
        return new IAPConnectPluginCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.jsapi.interceptor.IAPImplementedJSAPIInterceptor.1
            @Override // com.iap.ac.android.acs.plugin.core.IAPConnectPluginCallback
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
        iAPConnectPluginContext.miniProgramAppID = interceptContext.miniProgramAppID;
        iAPConnectPluginContext.miniProgramName = interceptContext.miniProgramName;
        iAPConnectPluginContext.pluginId = interceptContext.pluginId;
        iAPConnectPluginContext.sourceSite = interceptContext.sourceSite;
        iAPConnectPluginContext.newSourceSite = interceptContext.newSourceSite;
        iAPConnectPluginContext.acquireSite = interceptContext.acquireSite;
        iAPConnectPluginContext.jsParameters = interceptContext.jsParameters;
        iAPConnectPluginContext.isMiniProgram = interceptContext.isMiniProgram;
        iAPConnectPluginContext.acParams = interceptContext.acParams;
        iAPConnectPluginContext.startParams = interceptContext.startParams;
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
        BaseInterceptor baseInterceptor;
        Class<? extends BaseInterceptor> cls = Constants.JS_INTERCEPTOR_MAP.get(str);
        String str2 = Constants.JS_INTERCEPTOR_TODO_MAP.get(str);
        if (cls == null && !Utils.checkClassExist(str2)) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IAPConnectInterceptor#innerIntercept, interceptor class is null, jsapi: ");
            sb.append(str);
            ACLog.d(str3, sb.toString());
            return false;
        }
        try {
            if (cls != null) {
                baseInterceptor = cls.newInstance();
            } else {
                baseInterceptor = (BaseInterceptor) Class.forName(str2).newInstance();
            }
            String str4 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IAPConnectInterceptor#innerIntercept, start to intercept by ");
            sb2.append(baseInterceptor.getClass().getSimpleName());
            ACLog.d(str4, sb2.toString());
            MonitorUtil.monitorEnter(str);
            this.startTime = SystemClock.elapsedRealtime();
            baseInterceptor.handle(iAPConnectPluginContext, iAPConnectPluginCallback);
            return true;
        } catch (Throwable th) {
            String str5 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IAPConnectInterceptor#innerIntercept, inner intercept fail, interceptorClass: ");
            sb3.append(cls);
            sb3.append(", ");
            sb3.append(th);
            ACLog.e(str5, sb3.toString());
            return false;
        }
    }

    private boolean isRegionApp(IAPConnectPluginContext iAPConnectPluginContext) {
        JSONObject jSONObject = iAPConnectPluginContext.acParams;
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("acParams"))) {
            try {
                return TextUtils.equals(new JSONObject(iAPConnectPluginContext.acParams.optString("acParams")).optString("isRegion"), "YES");
            } catch (JSONException unused) {
            }
        }
        return false;
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
            if (!AcBizUtils.isAcBizMiniProgram(convertContext.miniProgramAppID, convertContext.sourceSite, convertContext.newSourceSite) && !isRegionApp(convertContext)) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("IAPConnectInterceptor#willHandleJSAPI, current mini program is neither AC business nor Region business, appId: ");
                sb.append(convertContext.miniProgramAppID);
                sb.append(", sourceSite: ");
                sb.append(convertContext.sourceSite);
                ACLog.d(str2, sb.toString());
                return false;
            }
        } else if (!"B15".equals(channel)) {
            String str3 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IAPConnectInterceptor#willHandleJSAPI, channel");
            sb2.append(channel);
            ACLog.d(str3, sb2.toString());
            return false;
        }
        if (DisableJSAPIManager.getInstance().isDisabled(convertContext.miniProgramAppID, convertJSAPI)) {
            String str4 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("IAPConnectInterceptor#willHandleJSAPI, current mini program jsapi is disabled,appId: ");
            sb3.append(convertContext.miniProgramAppID);
            sb3.append(",jsapi:");
            sb3.append(convertJSAPI);
            ACLog.d(str4, sb3.toString());
            return false;
        }
        IAPConnectPluginCallback convertCallback = convertCallback(convertJSAPI, bridgeCallback);
        Boolean handle = ConfigInterceptor.handle(convertJSAPI, convertContext, convertCallback);
        if (handle != null) {
            String str5 = TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("IAPConnectInterceptor#willHandleJSAPI, intercepted by config:");
            sb4.append(handle);
            ACLog.d(str5, sb4.toString());
            return handle.booleanValue();
        }
        return innerIntercept(convertJSAPI, convertContext, convertCallback);
    }
}
