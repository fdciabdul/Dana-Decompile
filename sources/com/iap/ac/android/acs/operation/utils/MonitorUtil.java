package com.iap.ac.android.acs.operation.utils;

import com.iap.ac.android.acs.operation.biz.region.RegionConstants;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class MonitorUtil {
    public static String BIZ_CODE = "region_biz";
    public static final String CONFIG_INTERCEPT_BY_APP_ID = "CONFIG_INTERCEPT_BY_APP_ID";
    public static final String CONFIG_INTERCEPT_BY_RESULT = "CONFIG_INTERCEPT_BY_RESULT";
    public static final String CONFIG_INTERCEPT_BY_URL = "CONFIG_INTERCEPT_BY_URL";
    public static final String CONFIG_NONE = "CONFIG_NONE";
    public static final String CONFIG_NOT_INTERCEPT = "CONFIG_NOT_INTERCEPT";
    public static final String ERROR_CODE_EMPTY = "10";
    public static final String ERROR_PLUGIN_WHITE_BLACK_LIST_ERROR = "plugin_enabled_jsapi_list";
    public static final String EVENT_GET_AUTH_CODE = "mini_get_auth_code";
    public static final String EVENT_GET_OPEN_USER_INFO = "mini_get_open_user_info";
    public static final String EVENT_ID_AC_COMMON_NETWORK_PROXY = "ac_region_rpc_spi_call_record";
    public static final String FETCH_STAGE_INFO_ERROR = "fetch_stage_info_error";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_APP_NAME = "appName";
    public static final String KEY_APP_VERSION = "version";
    public static final String KEY_CITY = "city";
    public static final String KEY_CODE = "code";
    public static final String KEY_DEPLOY_VERSION = "deployVersion";
    public static final String KEY_ENV = "env";
    public static final String KEY_ERROR = "error";
    public static final String KEY_ERRORCODE = "errorCode";
    public static final String KEY_ERRORMESSAGE = "errorMessage";
    public static final String KEY_HOT_BOOT_INIT_CONFIG = "hotBootInitConfig";
    public static final String KEY_JSAPI = "jsapi";
    public static final String KEY_LIST = "list";
    public static final String KEY_OPERATION_TYPE = "operationType";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_REGION = "region";
    public static final String KEY_REGION_BIZ_NETWORK_PROXY_IS_EMPTY = "regionBizNetworkProxyIsEmpty";
    public static final String KEY_REGION_BIZ_START_SUCCESS = "regionBizStartSuccess";
    public static final String KEY_REGION_IS_INIT = "isInit";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String KEY_RESULT_MESSAGE = "resultMessage";
    public static final String KEY_RESULT_STRATEGY = "strategy";
    public static final String KEY_TIME_COST = "timeCost";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String KEY_URI = "uri";
    public static final String KEY_URL = "url";
    public static final String KEY_USE_HOT_BOOT_INIT = "useHotBootInit";
    public static final String MINI_OPERATION_MONITOR_BIZ_TYPE = "mini_program_operation";
    public static final String RESULT_REGION_RPC_PROXY_ERROR_CODE = "errorCode";
    public static final String RESULT_REGION_RPC_PROXY_REQUEST_DATA = "proxyRequestData";
    public static final String RESULT_REGION_RPC_PROXY_REQUEST_HEADER = "proxyRequestHeader";
    public static final String RESULT_REGION_RPC_PROXY_RESPONSE_DATA = "proxyResponseData";
    public static final String RESULT_REGION_RPC_PROXY_RESPONSE_HEADER = "proxyResponseHeader";
    public static final String SEED_JS_API_AP_DISABLED_JSAPI_ARRAY = "ap_disabled_jsapi_array";
    public static final String SEED_JS_API_PLUGIN_CONFIG = "ac_js_api_plugin_config";
    public static final String SEED_JS_API_PLUGIN_ERROR = "ac_js_api_plugin_error";
    public static final String SEED_JS_API_PLUGIN_FAIL = "ac_js_api_plugin_fail";
    public static final String SEED_PLUGIN_BLACK_JSAPI_LIST = "plugin_black_jsapi_list";
    public static final String SEED_PLUGIN_ENABLED_JSAPI_LIST = "plugin_enabled_jsapi_list";
    public static final String SEED_PLUGIN_WHITE_JSAPI_LIST = "plugin_white_jsapi_list";
    public static final String SEED_THIRD_PARTY_AUTH_BACK = "acs_third-party-auth_back";
    public static final String SEED_THIRD_PARTY_NAV_BACK = "acs_third-party-nav_back";
    public static final String TAG = "IAPConnectPlugin";
    public static final String USE_REGION_BIZ_HOT_BOOT = "useRegionBizHotBoot";

    public static void logEvent(String str, Map<String, String> map) {
        WebContainer.getInstance("ac_biz").logEvent(str, map);
    }

    public static void monitorAuthBack(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorReceiveAuthCode, appName: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorChooseCity(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorChooseCity, city: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorDisabledJSAPI(String str, Set<String> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorDisabledJSAPI, appId: ");
        sb.append(str);
        sb.append(", jsapi: ");
        sb.append(set);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorEnter(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorEnter, jsapi: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorError, errorMessage: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACLogEvent.newLogger("mini_program_operation", "ac_js_api_plugin_error").addParams("resultMessage", str).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void monitorFinish(String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorFinish, jsapi: ");
        sb.append(str);
        sb.append(", cost time: ");
        sb.append(j);
        sb.append("ms");
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorGetPhoneNumber(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorGetPhoneNumber, region: ");
        sb.append(str);
        sb.append(", phone: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorInterceptConfig(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorConfig, jsapi: ");
        sb.append(str);
        sb.append(", strategy: ");
        sb.append(str2);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorJSAPIBlackList(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorJSAPIBlackList:");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorJSAPIListError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorJSAPIListError:");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACLogEvent.newLogger("mini_program_operation", "plugin_enabled_jsapi_list").addParams("error", str).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void monitorJSAPIRegisterList(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorJSAPIRegisterList:");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorJSAPIWhiteList(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorJSAPIWhiteList:");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorJSONError(String str, JSONException jSONException) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorJSONError, jsapi: ");
        sb.append(str);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACLogEvent addParams = ACLogEvent.newLogger("mini_program_operation", "ac_js_api_plugin_fail").addParams("jsapi", str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("convert result to JSON error in ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(jSONException);
        addParams.addParams("resultMessage", sb2.toString()).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void monitorOpenSchemeBack() {
        ACLog.d("IAPConnectPlugin", "MonitorUtil#monitorOpenSchemeBack");
    }

    public static void monitorProxyRequest(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorProxyRequest, requestHeader=");
        sb.append(str);
        sb.append(",requestData=");
        sb.append(str2);
        sb.append(",responseHeader=");
        sb.append(str3);
        sb.append(",responseData=");
        sb.append(str4);
        sb.append(",errorCode=");
        sb.append(str5);
        ACLog.d(RegionConstants.TAG, sb.toString());
        ACLogEvent.newLogger("mini_program_operation", "ac_region_rpc_spi_call_record").addParams("proxyRequestHeader", str).addParams("proxyRequestData", str2).addParams("proxyResponseHeader", str3).addParams("proxyResponseData", str4).addParams("errorCode", str5).event(BIZ_CODE);
    }

    public static void monitorRPC(String str, long j, BaseRpcResult baseRpcResult) {
        if (baseRpcResult == null) {
            ACLog.e("IAPConnectPlugin", "MonitorUtil#monitorRPC, rpc result is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorRPC, operationType: ");
        sb.append(str);
        sb.append(", timeCost: ");
        sb.append(j);
        sb.append(", success: ");
        sb.append(baseRpcResult.success);
        sb.append(", resultCode: ");
        sb.append(baseRpcResult.errorCode);
        sb.append(", resultMessage: ");
        sb.append(baseRpcResult.errorMessage);
        sb.append(", traceId: ");
        sb.append(baseRpcResult.traceId);
        ACLog.d("IAPConnectPlugin", sb.toString());
    }

    public static void monitorRPCError(String str, String str2, String str3) {
        ACLogEvent.newLogger("mini_program_operation", str).addParams("errorCode", str2).addParams("errorMessage", str3).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void regionBizBootMonitor(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        String json = JsonUtils.toJson(RegionRPCConfigCenter.INSTANCE.getRegionConfig());
        StringBuilder sb = new StringBuilder();
        sb.append(json);
        sb.append(" useRegionHootBoot:");
        sb.append(RegionRPCConfigCenter.INSTANCE.getRegionBizHotBootToggle());
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initRegion is starting.isInit:");
        sb2.append(bool);
        sb2.append(" isUseHotBoot:");
        sb2.append(bool2);
        sb2.append(" startSuccess:");
        sb2.append(bool3);
        sb2.append(" useNetworkProxy:");
        sb2.append(bool4);
        sb2.append(" config:");
        sb2.append(obj);
        ACLog.i(RegionConstants.TAG, sb2.toString());
        ACLogEvent.newLogger("mini_program_operation", "useRegionBizHotBoot").addParams("useHotBootInit", bool2.toString()).addParams("regionBizNetworkProxyIsEmpty", bool4.toString()).addParams("regionBizStartSuccess", bool3.toString()).addParams("hotBootInitConfig", obj).addParams("isInit", bool).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void monitorError(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorError, jsapi: ");
        sb.append(str);
        sb.append(", resultCode: ");
        sb.append(str2);
        sb.append(", resultMessage: ");
        sb.append(str3);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACLogEvent.newLogger("mini_program_operation", "ac_js_api_plugin_fail").addParams("jsapi", str).addParams("resultCode", str2).addParams("resultMessage", str3).setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }

    public static void monitorError(String str, String str2, String str3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("MonitorUtil#monitorError, jsapi: ");
        sb.append(str);
        sb.append(", resultCode: ");
        sb.append(str2);
        sb.append(", resultMessage: ");
        sb.append(str3);
        ACLog.d("IAPConnectPlugin", sb.toString());
        ACLogEvent addParams = ACLogEvent.newLogger("mini_program_operation", "ac_js_api_plugin_fail").addParams("jsapi", str).addParams("resultCode", str2).addParams("resultMessage", str3);
        if (map != null && !map.isEmpty()) {
            for (String str4 : map.keySet()) {
                addParams.addParams(str4, map.get(str4));
            }
        }
        addParams.setEventType(LogEventType.CRUCIAL_LOG).event(BIZ_CODE);
    }
}
