package com.alibaba.griver.biz.jsapi.open;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverWhiteScreenStageMonitor;
import com.alibaba.griver.base.utils.MiniProgramExtendUtils;
import com.alibaba.griver.biz.R;
import com.alibaba.griver.biz.WalletAPIUtils;
import com.alipay.iap.android.wallet.acl.WalletServiceManager;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.member.MemberInfo;
import com.alipay.iap.android.wallet.acl.member.MemberInfoResult;
import com.alipay.iap.android.wallet.acl.member.MemberInfoScope;
import com.alipay.iap.android.wallet.acl.member.MemberService;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthPageConfirmResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthScopeQueryResult;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.alipay.iap.android.wallet.acl.payment.PaymentRequest;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentService;
import com.alipay.iap.android.wallet.acl.payment.PaymentType;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAuthCode;
import com.iap.ac.android.acs.plugin.utils.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class OpenAPIBridgeExtension extends SimpleBridgeExtension {
    private static final String SCOPE_AUTH_USER_INFO = "auth_user";
    private static final String SCOPE_USER_INFO = "userInfo";
    private static final String TAG = "OpenAPIBridgeExtension";
    private static final int USER_CANCEL = 11;
    private static final Map<String, String> scopesMap;

    /* JADX INFO: Access modifiers changed from: private */
    public String ifNullConvertToEmpty(String str) {
        return str == null ? "" : str;
    }

    static {
        HashMap hashMap = new HashMap();
        scopesMap = hashMap;
        hashMap.put("userInfo", "auth_user");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackWhiteGetAuthCode(Page page, boolean z) {
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverWhiteScreenStageMonitor.getMonitorToken(page.getApp(), page.getPageURI()));
        if (stageMonitor != null) {
            stageMonitor.addParam(GriverMonitorConstants.KEY_IS_AUTHING, Boolean.valueOf(z));
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void getAuthCode(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({"extInfo"}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingParam({"landscape"}) String str4, @BindingParam({"paladinMode"}) String str5, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingRequest JSONObject jSONObject2, @BindingApiContext ApiContext apiContext) {
        getAuthCodeInternal(str, jSONArray, jSONObject, str2, str3, z, str4, str5, page, bridgeCallback, jSONObject2, apiContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeGetAuthCode(final String str, final APIContext aPIContext, final Set<String> set, final Page page, final BridgeCallback bridgeCallback, final int i, final boolean z, final String str2) {
        String str3;
        final OAuthService oAuthService;
        final Map<String, String> extendInfoFromApp;
        OAuthCodeFlowType oAuthCodeFlowType;
        try {
            oAuthService = (OAuthService) WalletServiceManager.getInstance().getService(OAuthService.class);
            extendInfoFromApp = getExtendInfoFromApp(page.getApp(), str2);
            trackWhiteGetAuthCode(page, true);
            oAuthCodeFlowType = OAuthCodeFlowType.LOCAL_MINI_PROGRAM;
            str3 = TAG;
        } catch (WalletServiceManager.ServiceNotFoundException e) {
            e = e;
            str3 = TAG;
        } catch (Throwable th) {
            th = th;
            str3 = TAG;
        }
        try {
            oAuthService.getAuthCode(str, set, oAuthCodeFlowType, extendInfoFromApp, aPIContext, new Callback<OAuthResult>() { // from class: com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(OAuthResult oAuthResult) {
                    String str4;
                    String str5;
                    if (oAuthResult == null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    } else if (oAuthResult.isHasError()) {
                        if (oAuthResult.getResultError().errorCode == 2001) {
                            AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                            if (appModel == null || appModel.getAppInfoModel() == null) {
                                str4 = "";
                                str5 = str4;
                            } else {
                                String name = appModel.getAppInfoModel().getName();
                                str5 = appModel.getAppInfoModel().getLogo();
                                str4 = name;
                            }
                            oAuthService.showAuthPage(str, str4, str5, set, extendInfoFromApp, aPIContext, new Callback<OAuthPageConfirmResult>() { // from class: com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension.1.1
                                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                                public void result(OAuthPageConfirmResult oAuthPageConfirmResult) {
                                    if (oAuthPageConfirmResult.isHasError()) {
                                        if (oAuthPageConfirmResult.getResultError().errorCode == 1001) {
                                            bridgeCallback.sendJSONResponse(OpenAPIBridgeExtension.getError(11, Interceptor4getAuthCode.USER_CANCEL_MESSAGE, true));
                                        } else if (oAuthPageConfirmResult.getResultError().errorCode == 1005) {
                                            bridgeCallback.sendJSONResponse(OpenAPIBridgeExtension.getError(10, "Empty Data", true));
                                        } else {
                                            bridgeCallback.sendJSONResponse(OpenAPIBridgeExtension.getError(3, "unknown error!", true));
                                        }
                                    } else if (i > 0) {
                                        OpenAPIBridgeExtension.this.executeGetAuthCode(str, aPIContext, set, page, bridgeCallback, i - 1, true, str2);
                                    } else {
                                        bridgeCallback.sendJSONResponse(OpenAPIBridgeExtension.getError(3, "unknown error!", true));
                                    }
                                }
                            });
                            return;
                        }
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("authCode", (Object) oAuthResult.authCode);
                        jSONObject.put("authErrorScopes", (Object) oAuthResult.authErrorScopes);
                        jSONObject.put("authSuccessScopes", (Object) oAuthResult.authSuccessScopes);
                        jSONObject.put(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, (Object) Boolean.valueOf(z));
                        bridgeCallback.sendJSONResponse(jSONObject);
                        OpenAPIBridgeExtension.this.trackWhiteGetAuthCode(page, false);
                    }
                }
            });
        } catch (WalletServiceManager.ServiceNotFoundException e2) {
            e = e2;
            RVLogger.e(str3, "getAuthCode failed", e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } catch (Throwable th2) {
            th = th2;
            RVLogger.e(str3, "getAuthCode failed", th);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    public static JSONObject getError(int i, String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", (Object) Integer.valueOf(i));
            jSONObject.put("errorMessage", (Object) str);
            jSONObject.put(GriverMonitorConstants.KEY_SHOW_AUTH_PAGE_FIRED, (Object) Boolean.valueOf(z));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getExtendInfoFromApp(App app, String str) {
        HashMap hashMap = new HashMap();
        if (app == null) {
            RVLogger.d(TAG, "app is null, return empty extend info");
            return hashMap;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            RVLogger.d(TAG, "app model is null in app, return empty extend info");
            return hashMap;
        }
        JSONObject extendInfos = appModel.getExtendInfos();
        if (extendInfos == null) {
            RVLogger.d(TAG, "extend info in app model is null, return empty extend info");
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : extendInfos.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
        }
        JSONObject jsApiExecuteConfig = MiniProgramExtendUtils.getJsApiExecuteConfig(appModel, extendInfos, str);
        if (jsApiExecuteConfig != null) {
            if (jsApiExecuteConfig.containsKey("authClientId")) {
                String string = jsApiExecuteConfig.getString("authClientId");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty((CharSequence) hashMap.get("authClientId"))) {
                    hashMap.put("authClientId", string);
                }
            }
            if (jsApiExecuteConfig.containsKey("merchantId")) {
                String string2 = jsApiExecuteConfig.getString("merchantId");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty((CharSequence) hashMap.get("merchantId"))) {
                    hashMap.put("merchantId", string2);
                }
            }
        }
        return hashMap;
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void crossPay(@BindingApiContext ApiContext apiContext, @BindingParam({"tradeNO"}) String str, @BindingParam({"orderStr"}) String str2, @BindingParam({"paymentUrl"}) String str3, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        tradePayInternal(apiContext, str, str2, str3, app, page, bridgeCallback, "crossPay");
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void tradePay(@BindingApiContext ApiContext apiContext, @BindingParam({"tradeNO"}) String str, @BindingParam({"orderStr"}) String str2, @BindingParam({"paymentUrl"}) String str3, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        tradePayInternal(apiContext, str, str2, str3, app, page, bridgeCallback, Constants.JS_API_TRADE_PAY);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getComponentAuth(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({"extInfo"}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        if (page == null || page.getApp() == null || page.isExited() || page.isDestroyed()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
        } else if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else {
            String appId = TextUtils.isEmpty(str2) ? page.getApp().getAppId() : str2;
            if (TextUtils.isEmpty(appId)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            try {
                HashSet hashSet = new HashSet();
                for (int i = 0; i < jSONArray.size(); i++) {
                    String string = jSONArray.getString(i);
                    Map<String, String> map = scopesMap;
                    if (map.containsKey(string)) {
                        string = map.get(string);
                    }
                    hashSet.add(string);
                }
                executeGetAuthCode(appId, WalletAPIUtils.createApiContext(page, Constants.JS_API_GET_COMPONENT_AUTH), hashSet, page, bridgeCallback, 3, false, Constants.JS_API_GET_COMPONENT_AUTH);
            } catch (Throwable th) {
                RVLogger.e(TAG, "getAuthCode failed", th);
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            }
        }
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void appxrpc(@BindingParam({"operationType"}) String str, @BindingParam({"headers"}) JSONObject jSONObject, @BindingParam({"requestData"}) JSONArray jSONArray, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        if (page == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(3, "page is null"));
            RVLogger.d(TAG, "page is null");
        } else if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "operationType is null"));
            RVLogger.d(TAG, "operationType is null");
        } else if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "requestData is null"));
            RVLogger.d(TAG, "requestData is null");
        } else {
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            if (!jSONObject2.containsKey("method")) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "request method is null"));
                RVLogger.d(TAG, "request method is null");
                return;
            }
            String string = jSONObject2.getString("method");
            string.hashCode();
            if (string.equals(Constants.JS_API_GET_OPEN_USER_INFO)) {
                getUserInfo(app, WalletAPIUtils.createApiContext(page, string), apiContext, bridgeCallback, string);
            }
        }
    }

    private void getAuthCodeInternal(String str, JSONArray jSONArray, JSONObject jSONObject, String str2, String str3, boolean z, String str4, String str5, Page page, BridgeCallback bridgeCallback, JSONObject jSONObject2, ApiContext apiContext) {
        if (jSONArray == null || jSONArray.size() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (page == null || page.getApp() == null || page.isExited() || page.isDestroyed()) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } else {
            String appId = TextUtils.isEmpty(str2) ? page.getApp().getAppId() : str2;
            if (TextUtils.isEmpty(appId)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.size(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
            executeGetAuthCode(appId, WalletAPIUtils.createApiContext(page, Constants.JS_API_GET_AUTH_CODE), hashSet, page, bridgeCallback, 3, false, Constants.JS_API_GET_AUTH_CODE);
        }
    }

    private void tradePayInternal(ApiContext apiContext, String str, String str2, String str3, App app, Page page, final BridgeCallback bridgeCallback, String str4) {
        PaymentRequest paymentRequest;
        PaymentRequest paymentRequest2;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            RVLogger.w(TAG, "tradePay but params are empty, return");
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        try {
            PaymentService paymentService = (PaymentService) WalletServiceManager.getInstance().getService(PaymentService.class);
            if (!TextUtils.isEmpty(str3)) {
                paymentRequest2 = new PaymentRequest(PaymentType.CASHIER_URL, str3, null, getExtendInfoFromApp(app, str4));
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    paymentRequest = new PaymentRequest(PaymentType.ORDER_STRING, str2, null, getExtendInfoFromApp(app, str4));
                } else {
                    paymentRequest = new PaymentRequest(PaymentType.ORDER_ID, str, null, getExtendInfoFromApp(app, str4));
                }
                paymentRequest2 = paymentRequest;
            }
            paymentService.pay(paymentRequest2, WalletAPIUtils.createApiContext(page, str4), new Callback<PaymentResult>() { // from class: com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension.2
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(PaymentResult paymentResult) {
                    if (paymentResult == null) {
                        RVLogger.w(OpenAPIBridgeExtension.TAG, "tradePay failed with empty payment result");
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        return;
                    }
                    RVLogger.d(OpenAPIBridgeExtension.TAG, "tradePay succeeds");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", (Object) paymentResult.getResultCode());
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            });
        } catch (WalletServiceManager.ServiceNotFoundException e) {
            RVLogger.e(TAG, "tradePay failed", e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } catch (Throwable th) {
            RVLogger.e(TAG, "tradePay failed", th);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    private void getUserInfo(final App app, final APIContext aPIContext, final ApiContext apiContext, final BridgeCallback bridgeCallback, final String str) {
        try {
            try {
                ((OAuthService) WalletServiceManager.getInstance().getService(OAuthService.class)).getAuthorizedScopes(app.getAppId(), getExtendInfoFromApp(app, str), aPIContext, new Callback<OAuthScopeQueryResult>() { // from class: com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension.3
                    @Override // com.alipay.iap.android.wallet.acl.base.Callback
                    public void result(OAuthScopeQueryResult oAuthScopeQueryResult) {
                        if (oAuthScopeQueryResult == null) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10, apiContext.getAppContext().getString(R.string.griver_biz_user_unauthorized)));
                            return;
                        }
                        String[] authorizedScopes = oAuthScopeQueryResult.getAuthorizedScopes();
                        if (authorizedScopes == null || authorizedScopes.length == 0) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10, apiContext.getAppContext().getString(R.string.griver_biz_user_unauthorized)));
                            return;
                        }
                        Arrays.sort(authorizedScopes);
                        if (Arrays.binarySearch(authorizedScopes, "auth_user") < 0) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(10, apiContext.getAppContext().getString(R.string.griver_biz_user_unauthorized)));
                            return;
                        }
                        try {
                            MemberService memberService = (MemberService) WalletServiceManager.getInstance().getService(MemberService.class);
                            HashSet hashSet = new HashSet();
                            hashSet.add("auth_user");
                            memberService.getMemberInfo(MemberService.MemberInfoFetchStrategy.REMOTE_FETCH, new MemberInfoScope(app.getAppId(), hashSet, OpenAPIBridgeExtension.this.getExtendInfoFromApp(app, str)), aPIContext, new Callback<MemberInfoResult>() { // from class: com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension.3.1
                                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                                public void result(MemberInfoResult memberInfoResult) {
                                    if (memberInfoResult == null || memberInfoResult.getMemberInfo() == null) {
                                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                        return;
                                    }
                                    MemberInfo memberInfo = memberInfoResult.getMemberInfo();
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("avatar", (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(memberInfo.avatar));
                                    jSONObject.put("nickName", (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(memberInfo.userName));
                                    jSONObject.put("gender", (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(memberInfo.gender));
                                    if (memberInfo.getExtendedInfo() != null) {
                                        Map<String, String> extendedInfo = memberInfo.getExtendedInfo();
                                        jSONObject.put(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(extendedInfo.get(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE)));
                                        jSONObject.put("province", (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(extendedInfo.get("province")));
                                        jSONObject.put("city", (Object) OpenAPIBridgeExtension.this.ifNullConvertToEmpty(extendedInfo.get("city")));
                                    } else {
                                        jSONObject.put(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, (Object) "");
                                        jSONObject.put("province", (Object) "");
                                        jSONObject.put("city", (Object) "");
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("response", (Object) jSONObject);
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("response", (Object) JSON.toJSONString(jSONObject2));
                                    bridgeCallback.sendJSONResponse(jSONObject3);
                                }
                            });
                        } catch (WalletServiceManager.ServiceNotFoundException e) {
                            RVLogger.e(OpenAPIBridgeExtension.TAG, "getOpenUserInfo failed", e);
                            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        } catch (Throwable th) {
                            RVLogger.e(OpenAPIBridgeExtension.TAG, "getOpenUserInfo failed", th);
                            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        }
                    }
                });
            } catch (Exception e) {
                e = e;
                RVLogger.e(TAG, "getOpenUserInfo failed", e);
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
