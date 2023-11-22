package com.iap.ac.android.acs.plugin.utils;

import com.iap.ac.android.acs.plugin.interceptor.BaseInterceptor;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4exitApp;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAppToken;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getUdtid;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4navigateToBizScene;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4startApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Constants {
    public static final String ACTION_CHOOSE_CITY = "com.iap.ac.android.acs.plugin.action.CHOOSE_CITY";
    public static final String ACTION_GET_PHONE_NUMBER = "com.iap.ac.android.acs.plugin.action.GET_PHONE_NUMBER";
    public static final String ACTION_THIRD_PARTY_AUTH_FOR_AC = "com.iap.ac.android.acs.plugin.action.THIRD_PARTY_AUTH_FOR_AC";
    public static final String AC_BIZ_CODE = "ac_biz";
    public static final String BIZ_CODE_FOR_REGION = "region_biz";
    public static final String CACHE_KEY_BATCH_QUERY_BY_STAGE_CODE = "batchQueryByStageCode";
    public static final String JS_API_APPX_RPC = "appxrpc";
    public static final String JS_API_AP_DISABLE_JSAPI = "apDisableJSAPI";
    public static final String JS_API_CHOOSE_CITY = "chooseCity";
    public static final List<String> JS_API_EXCLUDE_LIST;
    public static final String JS_API_EXIT_APP = "exitApp";
    public static final String JS_API_GET_APP_TOKEN = "getAppToken";
    public static final String JS_API_GET_AUTH_CODE = "getAuthCode";
    public static final String JS_API_GET_COMPONENT_AUTH = "getComponentAuth";
    public static final String JS_API_GET_OPEN_USER_INFO = "getOpenUserInfo";
    public static final String JS_API_GET_PAYMENT_CODE = "getPaymentCode";
    public static final String JS_API_GET_PHONE_NUMBER = "getPhoneNumber";
    public static final String JS_API_GET_SERVER_TIME = "getServerTime";
    public static final String JS_API_GET_SETTING = "getSetting";
    public static final String JS_API_GET_SITE_INFO = "getSiteInfo";
    public static final String JS_API_GET_UDTID = "getUTDID";
    public static final String JS_API_INQUIRE_QUOTE = "inquireQuote";
    public static final String JS_API_IS_INSTALLED_APP = "isInstalledApp";
    public static final List<String> JS_API_LIST;
    public static final String JS_API_NAVIGATE_TO_BIZ_SCENE = "navigateToBizScene";
    public static final String JS_API_OPEN_SCHEME_WITH_BACKING = "openSchemeWithBacking";
    public static final String JS_API_PAY_SIGN_CENTER = "paySignCenter";
    public static final String JS_API_REGION_RPC = "APRegionRPC";
    public static final String JS_API_RPC = "rpc";
    public static final String JS_API_SCAN = "scan";
    public static final String JS_API_SIGN_CONTRACT = "signContract";
    public static final String JS_API_START_APP = "startApp";
    public static final String JS_API_START_BIZ_SERVICE = "startBizService";
    public static final String JS_API_THIRD_PARTY_AUTH_FOR_AC = "thirdPartyAuthForAc";
    public static final String JS_API_TRADE_PAY = "tradePay";
    public static final String JS_API_UPLOAD_APDID_TOKEN = "uploadApdidToken";
    public static final Map<String, Class<? extends BaseInterceptor>> JS_INTERCEPTOR_MAP;
    public static final Map<String, String> JS_INTERCEPTOR_TODO_MAP;
    public static final String KEY_AC_PARAMS = "acParams";
    public static final String KEY_AUTH_CODE = "authCode";
    public static final String KEY_AUTH_RESULT_CODE = "authResultCode";
    public static final String KEY_AUTH_STATE = "authState";
    public static final String KEY_CITY_CODE = "cityCode";
    public static final String KEY_CITY_NAME = "cityName";
    public static final String KEY_FLAG_REGION_TINYAPP = "isRegion";
    public static final String KEY_IS_NOT_REGION_TINYAPP = "NO";
    public static final String KEY_IS_REGION_TINYAPP = "YES";
    public static final String KEY_PHONE_NUMBER = "phoneNumber";
    public static final String KEY_REGION_CODE = "regionCode";
    public static final String PRESET_CONFIG_FILE_EXTENSION = ".json";
    public static final String PRESET_CONFIG_FILE_NAME = "iapconnect_config";
    public static final String SECTION_AC_CONFIG = "ACConfig";
    public static final String SECTION_KEY_BLACK_LIST = "blackList";
    public static final String SECTION_KEY_JSAPI_MODE = "ACJSAPIMode";
    public static final String SECTION_KEY_RESOURCE_JSAPI_MODE = "jsapiMode";
    public static final String SECTION_KEY_WHITE_LIST = "whiteList";
    public static final String TAG = "IAPConnectPlugin";
    public static final String UNDERSCORE = "_";

    static {
        ArrayList arrayList = new ArrayList();
        JS_API_LIST = arrayList;
        ArrayList arrayList2 = new ArrayList();
        JS_API_EXCLUDE_LIST = arrayList2;
        HashMap hashMap = new HashMap();
        JS_INTERCEPTOR_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        JS_INTERCEPTOR_TODO_MAP = hashMap2;
        arrayList2.add(JS_API_GET_SITE_INFO);
        arrayList2.add(JS_API_GET_AUTH_CODE);
        arrayList2.add(JS_API_SIGN_CONTRACT);
        arrayList.add(JS_API_CHOOSE_CITY);
        arrayList.add(JS_API_EXIT_APP);
        arrayList.add(JS_API_GET_APP_TOKEN);
        arrayList.add(JS_API_GET_AUTH_CODE);
        arrayList.add(JS_API_GET_COMPONENT_AUTH);
        arrayList.add("getPaymentCode");
        arrayList.add(JS_API_GET_SERVER_TIME);
        arrayList.add(JS_API_GET_SETTING);
        arrayList.add(JS_API_GET_SITE_INFO);
        arrayList.add(JS_API_INQUIRE_QUOTE);
        arrayList.add(JS_API_IS_INSTALLED_APP);
        arrayList.add("rpc");
        arrayList.add("scan");
        arrayList.add(JS_API_SIGN_CONTRACT);
        arrayList.add("startApp");
        arrayList.add(JS_API_THIRD_PARTY_AUTH_FOR_AC);
        arrayList.add(JS_API_NAVIGATE_TO_BIZ_SCENE);
        arrayList.add(JS_API_OPEN_SCHEME_WITH_BACKING);
        arrayList.add("appxrpc");
        arrayList.add("startBizService");
        arrayList.add(JS_API_UPLOAD_APDID_TOKEN);
        arrayList.add("apDisableJSAPI");
        arrayList.add(JS_API_GET_UDTID);
        hashMap.put(JS_API_EXIT_APP, Interceptor4exitApp.class);
        hashMap.put(JS_API_GET_APP_TOKEN, Interceptor4getAppToken.class);
        hashMap.put(JS_API_NAVIGATE_TO_BIZ_SCENE, Interceptor4navigateToBizScene.class);
        hashMap.put("startApp", Interceptor4startApp.class);
        hashMap.put(JS_API_GET_UDTID, Interceptor4getUdtid.class);
        hashMap2.put(JS_API_GET_AUTH_CODE, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAuthCode");
        hashMap2.put(JS_API_GET_COMPONENT_AUTH, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getComponentAuth");
        hashMap2.put(JS_API_GET_OPEN_USER_INFO, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getOpenUserInfo");
        hashMap2.put("getPaymentCode", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getPaymentCode");
        hashMap2.put("getPhoneNumber", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getPhoneNumber");
        hashMap2.put(JS_API_GET_SERVER_TIME, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getServerTime");
        hashMap2.put(JS_API_GET_SETTING, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getSetting");
        hashMap2.put(JS_API_GET_SITE_INFO, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4getSiteInfo");
        hashMap2.put(JS_API_INQUIRE_QUOTE, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4inquireQuote");
        hashMap2.put(JS_API_IS_INSTALLED_APP, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4isInstalledApp");
        hashMap2.put("paySignCenter", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4paySignCenter");
        hashMap2.put("rpc", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4rpc");
        hashMap2.put("scan", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4scan");
        hashMap2.put(JS_API_SIGN_CONTRACT, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4signContract");
        hashMap2.put(JS_API_THIRD_PARTY_AUTH_FOR_AC, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4thirdPartyAuthForAc");
        hashMap2.put(JS_API_OPEN_SCHEME_WITH_BACKING, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4openSchemeWithBacking");
        hashMap2.put(JS_API_UPLOAD_APDID_TOKEN, "com.iap.ac.android.acs.plugin.interceptor.Interceptor4uploadApdidToken");
        hashMap2.put("apDisableJSAPI", "com.iap.ac.android.acs.plugin.interceptor.Interceptor4apDisableJSAPI");
    }
}
