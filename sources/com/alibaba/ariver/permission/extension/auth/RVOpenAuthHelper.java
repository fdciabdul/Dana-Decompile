package com.alibaba.ariver.permission.extension.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.common.log.IgnoreLogUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.R;
import com.alibaba.ariver.permission.api.OnGetAuthListener;
import com.alibaba.ariver.permission.api.RVFlag;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.AuthSettingProxy;
import com.alibaba.ariver.permission.api.proxy.H5OpenAuthProxy;
import com.alibaba.ariver.permission.api.proxy.Oauth2AuthCodeService;
import com.alibaba.ariver.permission.api.proxy.TBAuthDialogProxy;
import com.alibaba.ariver.permission.model.AuthProtocol;
import com.alibaba.ariver.permission.openauth.model.request.AuthExecuteRequestModel;
import com.alibaba.ariver.permission.openauth.model.request.AuthSkipRequestModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthAgreementModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthExecuteResultModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel;
import com.alibaba.ariver.permission.view.IOpenAuthDialog;
import com.alibaba.ariver.permission.view.IOpenAuthDialogCheck;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.cashier.view.InputCardNumberView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.B;

/* loaded from: classes6.dex */
public class RVOpenAuthHelper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final String ERROR_CODE_CANCEL = "11";
    public static final String ERROR_CODE_FATIGUE = "12";
    private static short[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final String PLATFORM_AP = "AP";
    public static final String PLATFORM_TB = "TB";
    private static byte[] PlaceComponentResult = null;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6179a = false;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private OnGetAuthListener b;
    private BridgeCallback c;
    private String d;
    private List<String> e;
    private Context f;
    private App g;

    static {
        MyBillsEntityDataFactory();
        try {
            int i = getErrorConfigVersion + 97;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if ((i % 2 != 0 ? 'G' : (char) 20) != 20) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = 1257195729;
        MyBillsEntityDataFactory = -523405259;
        PlaceComponentResult = new byte[]{87, 59, TarHeader.LF_NORMAL, 35, -97};
        getAuthRequestContext = -1093780946;
    }

    static /* synthetic */ void access$000(RVOpenAuthHelper rVOpenAuthHelper, Page page, String str, String str2, String str3, byte[] bArr, boolean z) {
        int i = getErrorConfigVersion + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        rVOpenAuthHelper.a(page, str, str2, str3, bArr, z);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ BridgeCallback access$100(RVOpenAuthHelper rVOpenAuthHelper) {
        int i = getErrorConfigVersion + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            BridgeCallback bridgeCallback = rVOpenAuthHelper.c;
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
                getErrorConfigVersion = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return bridgeCallback;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return bridgeCallback;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$1300(RVOpenAuthHelper rVOpenAuthHelper, String str, App app, Page page, String str2, String str3, List list, boolean z, String str4, Map map, Map map2, AuthSkipResultModel authSkipResultModel) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            rVOpenAuthHelper.a(str, app, page, str2, str3, list, z, str4, map, map2, authSkipResultModel);
            try {
                int i3 = getErrorConfigVersion + 97;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$1500(RVOpenAuthHelper rVOpenAuthHelper, App app, Page page, AuthSkipResultModel authSkipResultModel, String str, String str2, String str3, List list, boolean z, String str4, Map map, Map map2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        getErrorConfigVersion = i % 128;
        char c = i % 2 == 0 ? InputCardNumberView.DIVIDER : '%';
        rVOpenAuthHelper.a(app, page, authSkipResultModel, str, str2, str3, list, z, str4, map, map2);
        if (c != '%') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public RVOpenAuthHelper(Context context, App app, BridgeCallback bridgeCallback, String str) {
        this.f = context;
        this.g = app;
        this.c = bridgeCallback;
        this.d = str;
    }

    public RVOpenAuthHelper(Context context, App app, BridgeCallback bridgeCallback, String str, OnGetAuthListener onGetAuthListener) {
        this.f = context;
        this.g = app;
        this.c = bridgeCallback;
        this.d = str;
        this.b = onGetAuthListener;
    }

    public void getAuthContentOrAutoAuth(final String str, final Page page, String str2, String str3, List<String> list, String str4, Map<String, String> map, final boolean z, Map<String, String> map2, Bundle bundle) {
        String str5;
        AuthSkipRequestModel authSkipRequestModel = new AuthSkipRequestModel();
        authSkipRequestModel.setAppId(str2);
        authSkipRequestModel.setCurrentPageUrl(str3);
        authSkipRequestModel.setFromSystem("mobilegw_android");
        authSkipRequestModel.setScopeNicks(list);
        authSkipRequestModel.setState("QnJpbmcgc21hbGwgYW5kIGJlYXV0aWZ1bCBjaGFuZ2VzIHRvIHRoZSB3b3JsZA==");
        authSkipRequestModel.setIsvAppId(str4);
        authSkipRequestModel.setExtInfo(map);
        authSkipRequestModel.setAppExtInfo(map2);
        this.e = list;
        try {
            final AuthSkipResultModel authSkipResultPB = TextUtils.equals("TB", str) ? TRVOpenAuthHelper.getAuthSkipResultPB(str, this.g, authSkipRequestModel) : ((Oauth2AuthCodeService) RVProxy.get(Oauth2AuthCodeService.class)).getAuthSkipResult(str, this.g, authSkipRequestModel);
            if (authSkipResultPB == null) {
                return;
            }
            if (authSkipResultPB.getSuccess() != null && !authSkipResultPB.getSuccess().booleanValue()) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAuthContentOrAutoAuth rpc !isSuccess");
                sb.append(authSkipResultPB.getErrorCode());
                sb.append(" ");
                sb.append(authSkipResultPB.getErrorMsg());
                RVLogger.d("AriverPermission:RVOpenAuthHelper", sb.toString());
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RVOpenAuthHelper.access$000(RVOpenAuthHelper.this, page, str, authSkipResultPB.getErrorCode(), authSkipResultPB.getErrorMsg(), authSkipResultPB.getData(), z);
                    }
                });
                return;
            }
            try {
                if ((authSkipResultPB.getCanSkipAuth() == null || !authSkipResultPB.getCanSkipAuth().booleanValue()) && (authSkipResultPB.getShowType() == null || !authSkipResultPB.getShowType().equalsIgnoreCase("CALLBACK"))) {
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", "getAuthContentOrAutoAuth rpc !canSkipAuth");
                    H5OpenAuthProxy h5OpenAuthProxy = (H5OpenAuthProxy) RVProxy.get(H5OpenAuthProxy.class);
                    if (authSkipResultPB.getShowType() != null && authSkipResultPB.getShowType().equalsIgnoreCase("H5")) {
                        if ((h5OpenAuthProxy != null ? '\n' : '3') == '\n') {
                            a(h5OpenAuthProxy, page, authSkipResultPB.getH5AuthParams(), bundle);
                            App app = this.g;
                            if (app != null) {
                                app.putStringValue("lastCalledJsApi", Constants.JS_API_GET_AUTH_CODE);
                                return;
                            }
                            return;
                        }
                    }
                    if (authSkipResultPB.getAuthContentResult() != null) {
                        RVLogger.d("AriverPermission:RVOpenAuthHelper", "getAuthContentOrAutoAuth rpc begin present auth dialog");
                        str5 = "AriverPermission:RVOpenAuthHelper";
                        try {
                            ExecutorUtils.runOnMain(new H5AuthRunnable(this.g, page, authSkipResultPB, str, str2, str3, list, z, str4, map, map2));
                            int i = getErrorConfigVersion + 75;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                            int i2 = i % 2;
                            return;
                        } catch (Exception e) {
                            e = e;
                            RVLogger.e(str5, "getAuthContentOrAutoAuth rpc exception ", e);
                            a(page, e);
                            return;
                        }
                    }
                    return;
                }
                RVLogger.d("AriverPermission:RVOpenAuthHelper", "getAuthContentOrAutoAuth rpc canSkipAuth");
                if (authSkipResultPB.getAuthExecuteResult() != null) {
                    String authCode = authSkipResultPB.getAuthExecuteResult().getAuthCode();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getAuthContentOrAutoAuth rpc authCode is ");
                    sb2.append(authCode);
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", sb2.toString());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("authCode", (Object) authCode);
                    jSONObject.put("authcode", (Object) authCode);
                    JSONArray jSONArray = new JSONArray();
                    if (authSkipResultPB.getAuthExecuteResult() != null) {
                        if (!(CollectionUtils.isEmpty(authSkipResultPB.getAuthExecuteResult().getSuccessScopes()))) {
                            int i3 = getErrorConfigVersion + 7;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                            int i4 = i3 % 2;
                            Iterator<String> it = authSkipResultPB.getAuthExecuteResult().getSuccessScopes().iterator();
                            while (it.hasNext()) {
                                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                                getErrorConfigVersion = i5 % 128;
                                int i6 = i5 % 2;
                                jSONArray.add(it.next());
                            }
                        }
                    }
                    jSONObject.put("authSuccessScopes", (Object) jSONArray);
                    JSONObject jSONObject2 = new JSONObject();
                    if (!(authSkipResultPB.getAuthExecuteResult() == null) && !CollectionUtils.isEmpty(authSkipResultPB.getAuthExecuteResult().getErrorScopes())) {
                        try {
                            int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
                            getErrorConfigVersion = i7 % 128;
                            int i8 = i7 % 2;
                            Iterator<Map.Entry<String, String>> it2 = authSkipResultPB.getAuthExecuteResult().getErrorScopes().entrySet().iterator();
                            while (it2.hasNext()) {
                                int i9 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
                                getErrorConfigVersion = i9 % 128;
                                if (i9 % 2 == 0) {
                                    Map.Entry<String, String> next = it2.next();
                                    jSONObject2.put(next.getKey(), (Object) next.getValue());
                                    Object obj = null;
                                    obj.hashCode();
                                } else {
                                    Map.Entry<String, String> next2 = it2.next();
                                    jSONObject2.put(next2.getKey(), (Object) next2.getValue());
                                }
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    jSONObject.put("authErrorScopes", (Object) jSONObject2);
                    if (!(!"TB".equals(str))) {
                        int i10 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
                        getErrorConfigVersion = i10 % 128;
                        int i11 = i10 % 2;
                        if (authSkipResultPB.getAuthExecuteResult().getExtInfo() != null) {
                            int i12 = getErrorConfigVersion + 113;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i12 % 128;
                            int i13 = i12 % 2;
                            jSONObject.put("accessToken", (String) authSkipResultPB.getAuthExecuteResult().getExtInfo().get("accessToken"));
                        }
                    }
                    if (this.c != null && list != null) {
                        if (list.contains(OAuthService.SCOPE_AUTH_USER)) {
                            RVFlag.setOpenAuthGrantFlag(this.d, true);
                        }
                    }
                    sendResult(page, jSONObject);
                }
            } catch (Exception e3) {
                throw e3;
            }
        } catch (Exception e4) {
            e = e4;
            str5 = "AriverPermission:RVOpenAuthHelper";
        }
    }

    public void setOpenAuthGrantFlag() {
        try {
            List<String> list = this.e;
            if (list != null) {
                try {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
                    getErrorConfigVersion = i % 128;
                    int i2 = i % 2;
                    if (list.contains(OAuthService.SCOPE_AUTH_USER)) {
                        RVFlag.setOpenAuthGrantFlag(this.d, true);
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = getErrorConfigVersion + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void sendResult(Page page, JSONObject jSONObject) {
        if (13 == JSONUtils.getInt(jSONObject, "error")) {
            f6179a = true;
        } else {
            try {
                f6179a = false;
            } catch (Exception e) {
                throw e;
            }
        }
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("result for provider: ");
            sb.append(jSONObject.toString());
            RVLogger.d("AriverPermission:RVOpenAuthHelper", sb.toString());
            this.b.onResult(jSONObject);
        } else {
            try {
                if (this.c != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("result for jsbridge: ");
                    sb2.append(jSONObject.toString());
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", sb2.toString());
                    this.c.sendJSONResponse(jSONObject);
                    int i = getErrorConfigVersion + 15;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                    int i2 = i % 2;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (page != null) {
            if ((page.getRender() != null ? ')' : '*') != '*') {
                int i3 = getErrorConfigVersion + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                Object obj = null;
                if (i3 % 2 != 0) {
                    EngineUtils.sendToRender(page.getRender(), "alipayAuthChange", jSONObject, null);
                    obj.hashCode();
                    return;
                }
                EngineUtils.sendToRender(page.getRender(), "alipayAuthChange", jSONObject, null);
            }
        }
    }

    private void a(Page page, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        if (exc.getClass().getName().contains("RpcException")) {
            jSONObject.put("error", (Object) 12);
            jSONObject.put("errorMessage", "Network Error");
            int i = getErrorConfigVersion + 79;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
        } else {
            try {
                jSONObject.put("error", (Object) 10);
                jSONObject.put("errorMessage", (Object) exc.toString());
            } catch (Exception e) {
                throw e;
            }
        }
        sendResult(page, jSONObject);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 30 : Typography.greater) != '>') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(final com.alibaba.ariver.app.api.App r17, final com.alibaba.ariver.app.api.Page r18, final com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel r19, final java.lang.String r20, final java.lang.String r21, final java.lang.String r22, final java.util.List<java.lang.String> r23, final boolean r24, final java.lang.String r25, final java.util.Map<java.lang.String, java.lang.String> r26, final java.util.Map<java.lang.String, java.lang.String> r27) {
        /*
            r16 = this;
            r0 = r17
            if (r0 == 0) goto L7c
            int r1 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion
            int r1 = r1 + 79
            int r2 = r1 % 128
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r1 = r1 % 2
            boolean r1 = r17.isDestroyed()
            if (r1 != 0) goto L7c
            boolean r1 = r17.isExited()     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L1c
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 == 0) goto L20
            goto L7c
        L20:
            com.alibaba.ariver.app.api.AppContext r1 = r17.getAppContext()
            if (r1 == 0) goto L7c
            java.lang.Class<com.alibaba.ariver.permission.api.proxy.AuthDialogProxy> r1 = com.alibaba.ariver.permission.api.proxy.AuthDialogProxy.class
            java.lang.Object r1 = com.alibaba.ariver.kernel.common.RVProxy.get(r0, r1)
            com.alibaba.ariver.permission.api.proxy.AuthDialogProxy r1 = (com.alibaba.ariver.permission.api.proxy.AuthDialogProxy) r1
            com.alibaba.ariver.app.api.AppContext r2 = r17.getAppContext()
            android.content.Context r2 = r2.getContext()
            com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog r15 = r1.getAuthNoticeDialog(r2)
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper$2 r14 = new com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper$2
            r1 = r14
            r2 = r16
            r3 = r15
            r4 = r19
            r5 = r17
            r6 = r18
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r0 = r14
            r14 = r27
            r1.<init>()
            r15.setPositiveListener(r0)
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper$3 r0 = new com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper$3
            r1 = r16
            r2 = r18
            r0.<init>()
            r15.setNegativeListener(r0)
            r15.show()
            int r0 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion
            int r0 = r0 + 99
            int r2 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r0 = r0 % 2
            goto L7e
        L77:
            r0 = move-exception
            r1 = r16
            r2 = r0
            throw r2
        L7c:
            r1 = r16
        L7e:
            int r0 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 5
            int r2 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion = r2
            int r0 = r0 % 2
            r2 = 75
            if (r0 != 0) goto L8f
            r0 = 31
            goto L91
        L8f:
            r0 = 75
        L91:
            if (r0 == r2) goto L99
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L96
            return
        L96:
            r0 = move-exception
            r2 = r0
            throw r2
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.a(com.alibaba.ariver.app.api.App, com.alibaba.ariver.app.api.Page, com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel, java.lang.String, java.lang.String, java.lang.String, java.util.List, boolean, java.lang.String, java.util.Map, java.util.Map):void");
    }

    private void a(final String str, App app, final Page page, String str2, String str3, List<String> list, final boolean z, String str4, Map<String, String> map, Map<String, String> map2, AuthSkipResultModel authSkipResultModel) {
        final AuthExecuteResultModel executeAuth;
        JSONObject parseObject;
        Iterator<String> it;
        AuthExecuteRequestModel authExecuteRequestModel = new AuthExecuteRequestModel();
        authExecuteRequestModel.setAppId(str2);
        authExecuteRequestModel.setCurrentPageUrl(str3);
        authExecuteRequestModel.setFromSystem("mobilegw_android");
        authExecuteRequestModel.setScopeNicks(list);
        authExecuteRequestModel.setState("QnJpbmcgc21hbGwgYW5kIGJlYXV0aWZ1bCBjaGFuZ2VzIHRvIHRoZSB3b3JsZA==");
        authExecuteRequestModel.setIsvAppId(str4);
        authExecuteRequestModel.setExtInfo(map);
        authExecuteRequestModel.setAppExtInfo(map2);
        try {
            if ((TextUtils.equals("TB", str) ? (char) 27 : (char) 4) != 4) {
                int i = getErrorConfigVersion + 103;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                executeAuth = TRVOpenAuthHelper.getAuthResult(app, authExecuteRequestModel, authSkipResultModel, str);
            } else {
                executeAuth = ((Oauth2AuthCodeService) RVProxy.get(Oauth2AuthCodeService.class)).executeAuth(authExecuteRequestModel);
            }
            if (executeAuth != null) {
                if (executeAuth.getSuccess() != null && !executeAuth.getSuccess().booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("executeAuth rpc !isSuccess ");
                    sb.append(executeAuth.getErrorCode());
                    sb.append(" ");
                    sb.append(executeAuth.getErrorMsg());
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", sb.toString());
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.4
                        @Override // java.lang.Runnable
                        public void run() {
                            RVOpenAuthHelper.access$000(RVOpenAuthHelper.this, page, str, executeAuth.getErrorCode(), executeAuth.getErrorMsg(), executeAuth.getData(), z);
                        }
                    });
                    return;
                }
                RVLogger.d("AriverPermission:RVOpenAuthHelper", "executeAuth rpc isSuccess");
                String authCode = executeAuth.getAuthCode();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("executeAuth rpc authCode is ");
                sb2.append(authCode);
                RVLogger.d("AriverPermission:RVOpenAuthHelper", sb2.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("authCode", (Object) authCode);
                jSONObject.put("authcode", (Object) authCode);
                JSONArray jSONArray = new JSONArray();
                if ((executeAuth.getSuccessScopes() != null ? 'D' : (char) 24) == 'D') {
                    if (!executeAuth.getSuccessScopes().isEmpty()) {
                        jSONArray.addAll(executeAuth.getSuccessScopes());
                    }
                }
                jSONObject.put("authSuccessScopes", (Object) jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                if (executeAuth.getErrorScopes() != null) {
                    if ((!executeAuth.getErrorScopes().isEmpty() ? '\n' : ']') != ']') {
                        for (Map.Entry<String, String> entry : executeAuth.getErrorScopes().entrySet()) {
                            jSONObject2.put(entry.getKey(), (Object) entry.getValue());
                        }
                    }
                }
                if (executeAuth.getExtInfo() != null && TextUtils.equals("TB", str)) {
                    jSONObject.put("accessToken", (String) executeAuth.getExtInfo().get("accessToken"));
                    try {
                        if (executeAuth.getExtInfo().get("publicInfo") != null) {
                            int i3 = getErrorConfigVersion + 103;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                            if (!(i3 % 2 != 0)) {
                                parseObject = JSONObject.parseObject(executeAuth.getExtInfo().get("publicInfo"));
                                it = parseObject.keySet().iterator();
                            } else {
                                parseObject = JSONObject.parseObject(executeAuth.getExtInfo().get("publicInfo"));
                                it = parseObject.keySet().iterator();
                                int i4 = 14 / 0;
                            }
                            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
                            getErrorConfigVersion = i5 % 128;
                            int i6 = i5 % 2;
                            while (true) {
                                if (!(it.hasNext())) {
                                    break;
                                }
                                try {
                                    int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
                                    try {
                                        getErrorConfigVersion = i7 % 128;
                                        int i8 = i7 % 2;
                                        String next = it.next();
                                        jSONObject.put(next, parseObject.get(next));
                                    } catch (Exception e) {
                                        throw e;
                                    }
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                jSONObject.put("authErrorScopes", (Object) jSONObject2);
                if (this.c != null) {
                    if ((list != null ? 'C' : Typography.dollar) == 'C' && list.contains(OAuthService.SCOPE_AUTH_USER)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("executeAuth setOpenAuthGrantFlag ");
                        sb3.append(this.d);
                        RVLogger.d("AriverPermission:RVOpenAuthHelper", sb3.toString());
                        RVFlag.setOpenAuthGrantFlag(this.d, true);
                    }
                }
                sendResult(page, jSONObject);
            }
        } catch (Exception e3) {
            RVLogger.e("AriverPermission:RVOpenAuthHelper", "executeAuth rpc exception ", e3);
            a(page, e3);
        }
    }

    private void a(final Page page, String str, String str2, String str3, byte[] bArr, boolean z) {
        App app = this.g;
        if (app != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
            getErrorConfigVersion = i % 128;
            Object[] objArr = null;
            if (i % 2 == 0) {
                boolean isExited = app.isExited();
                objArr.hashCode();
                if (isExited) {
                    return;
                }
            } else if (app.isExited()) {
                return;
            }
            if (this.g.isDestroyed()) {
                return;
            }
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) 15);
            jSONObject.put("errorMessage", (Object) str2);
            jSONObject.put("errorDesc", (Object) str3);
            if ((TextUtils.equals("TB", str) ? '/' : 'K') != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append("AP showBusinessFailedDialog showErrorTip: ");
                sb.append(z);
                RVLogger.d("AriverPermission:RVOpenAuthHelper", sb.toString());
                if (z) {
                    AuthDialogProxy authDialogProxy = (AuthDialogProxy) RVProxy.get(AuthDialogProxy.class);
                    Context context = this.f;
                    authDialogProxy.showErrorTipDialog(context, LangResourceUtil.getString(context, R.string.tiny_server_busy_error), LangResourceUtil.getString(this.f, R.string.tiny_apologize_for_the_delay), new DialogInterface.OnCancelListener() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.5
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            RVOpenAuthHelper.this.sendResult(page, jSONObject);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            RVOpenAuthHelper.this.sendResult(page, jSONObject);
                        }
                    }, new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            RVOpenAuthHelper.this.sendResult(page, jSONObject);
                        }
                    });
                    return;
                }
                return;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
            getErrorConfigVersion = i2 % 128;
            int i3 = i2 % 2;
            jSONObject.put("errorCode", (Object) str2);
            jSONObject.put("message", (Object) str3);
            jSONObject.put("errorMessage", (Object) str3);
            if (bArr != null && bArr.length > 0) {
                Object[] objArr2 = new Object[1];
                h(Color.alpha(0) + 199134543, (-72) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (short) (67 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (KeyEvent.getMaxKeyCode() >> 16) + 1440599979, (byte) Drawable.resolveOpacity(0, 0), objArr2);
                String str4 = new String(bArr, Charset.forName(((String) objArr2[0]).intern()));
                if (!TextUtils.isEmpty(str4)) {
                    int i4 = getErrorConfigVersion + 93;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                    if (i4 % 2 != 0) {
                        jSONObject.putAll(JSON.parseObject(str4));
                        jSONObject.remove(IgnoreLogUtils.TYPE_API);
                        int length = objArr.length;
                    } else {
                        jSONObject.putAll(JSON.parseObject(str4));
                        jSONObject.remove(IgnoreLogUtils.TYPE_API);
                    }
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
                    getErrorConfigVersion = i5 % 128;
                    int i6 = i5 % 2;
                }
            }
            sendResult(page, jSONObject);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TB showBusinessFailedDialog showErrorTip: ");
            sb2.append(z);
            RVLogger.d("AriverPermission:RVOpenAuthHelper", sb2.toString());
            if (z) {
                int i7 = getErrorConfigVersion + 73;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i7 % 128;
                int i8 = i7 % 2;
                if ("TB".equals(str)) {
                    return;
                }
                AuthDialogProxy authDialogProxy2 = (AuthDialogProxy) RVProxy.get(AuthDialogProxy.class);
                Context context2 = this.f;
                authDialogProxy2.showErrorTipDialog(context2, LangResourceUtil.getString(context2, R.string.tiny_server_busy_error), LangResourceUtil.getString(this.f, R.string.tiny_apologize_for_the_delay));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        if ((r0 == null) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if ((r0 != null ? 11 : 'M') != 'M') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r0.isEmpty() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        r1 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        return com.alibaba.ariver.kernel.common.utils.JSONUtils.getBoolean(r0, "callbackErrorAtDuplicate", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a() {
        /*
            r5 = this;
            int r0 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L6b
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L6b
            int r0 = r0 % 2
            r1 = 50
            if (r0 != 0) goto L11
            r0 = 50
            goto L13
        L11:
            r0 = 8
        L13:
            java.lang.String r2 = ""
            java.lang.String r3 = "h5_newGetAuthCodeConfig"
            r4 = 0
            if (r0 == r1) goto L32
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVConfigService> r0 = com.alibaba.ariver.kernel.common.service.RVConfigService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVConfigService r0 = (com.alibaba.ariver.kernel.common.service.RVConfigService) r0
            java.lang.String r0 = r0.getConfig(r3, r2)
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.parseObject(r0)
            if (r0 == 0) goto L2e
            r1 = 0
            goto L2f
        L2e:
            r1 = 1
        L2f:
            if (r1 == 0) goto L51
            goto L68
        L32:
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVConfigService> r0 = com.alibaba.ariver.kernel.common.service.RVConfigService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVConfigService r0 = (com.alibaba.ariver.kernel.common.service.RVConfigService) r0
            java.lang.String r0 = r0.getConfig(r3, r2)
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.parseObject(r0)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L69
            r1 = 77
            if (r0 == 0) goto L4d
            r2 = 11
            goto L4f
        L4d:
            r2 = 77
        L4f:
            if (r2 == r1) goto L68
        L51:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L68
            int r1 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 35
            int r2 = r1 % 128
            com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion = r2
            int r1 = r1 % 2
            java.lang.String r1 = "callbackErrorAtDuplicate"
            boolean r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getBoolean(r0, r1, r4)
            return r0
        L68:
            return r4
        L69:
            r0 = move-exception
            throw r0
        L6b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.a():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        if (r12 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        if (r12 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
    
        if (r12.isEmpty() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        r2 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (r2 == '?') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
    
        r1.putAll(r12);
        r12 = com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.getErrorConfigVersion + 105;
        com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 = r12 % 128;
        r12 = r12 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.alibaba.ariver.permission.api.proxy.H5OpenAuthProxy r9, com.alibaba.ariver.app.api.Page r10, com.alibaba.ariver.permission.openauth.model.result.H5AuthParamsModel r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.a(com.alibaba.ariver.permission.api.proxy.H5OpenAuthProxy, com.alibaba.ariver.app.api.Page, com.alibaba.ariver.permission.openauth.model.result.H5AuthParamsModel, android.os.Bundle):void");
    }

    /* loaded from: classes6.dex */
    class H5AuthRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private AuthSkipResultModel f6180a;
        private String b;
        private String c;
        private List<String> d;
        private boolean e;
        private String f;
        private Map<String, String> g;
        private Map<String, String> h;
        private Page i;
        private App j;
        private String k;

        public H5AuthRunnable(App app, Page page, AuthSkipResultModel authSkipResultModel, String str, String str2, String str3, List<String> list, boolean z, String str4, Map<String, String> map, Map<String, String> map2) {
            this.f6180a = authSkipResultModel;
            this.j = app;
            this.i = page;
            this.k = str;
            this.b = str2;
            this.c = str3;
            this.d = list;
            this.e = z;
            this.f = str4;
            this.g = map;
            this.h = map2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IOpenAuthDialog openAuthDialog;
            ArrayList arrayList;
            final IOpenAuthDialog iOpenAuthDialog;
            List<String> authText = this.f6180a.getAuthContentResult().getAuthText();
            String appName = this.f6180a.getAuthContentResult().getAppName();
            String appLogoLink = this.f6180a.getAuthContentResult().getAppLogoLink();
            List<AuthAgreementModel> agreements = this.f6180a.getAuthContentResult().getAgreements();
            if (((AuthDialogProxy) RVProxy.get(this.j, AuthDialogProxy.class)) == null) {
                RVLogger.e("AriverPermission:RVOpenAuthHelper", "get authdialogproxy is null");
            }
            if (authText != null && !authText.isEmpty()) {
                RVLogger.e("authText is Empty");
            }
            App app = this.j;
            if (app == null || app.isDestroyed() || this.j.isExited()) {
                return;
            }
            AppContext appContext = this.j.getAppContext();
            Page page = this.i;
            if ((page != null && (page.isDestroyed() || this.i.isExited())) || appContext == null) {
                RVLogger.w("AriverPermission:RVOpenAuthHelper", "auth should show dailog but page is exited!");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) "11");
                jSONObject.put("message", (Object) "页面已退出");
                jSONObject.put("errorMessage", (Object) "页面已退出");
                RVOpenAuthHelper.access$100(RVOpenAuthHelper.this).sendJSONResponse(jSONObject);
                return;
            }
            if (this.k.equals("TB")) {
                if (((AuthSettingProxy) RVProxy.get(AuthSettingProxy.class)).openGetAuthorizeSuccess()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", (Object) "success");
                    RVOpenAuthHelper.access$100(RVOpenAuthHelper.this).sendJSONResponse(jSONObject2);
                    return;
                }
                openAuthDialog = ((TBAuthDialogProxy) RVProxy.get(this.j, TBAuthDialogProxy.class)).getOpenAuthDialog(appContext.getContext());
            } else {
                openAuthDialog = ((AuthDialogProxy) RVProxy.get(this.j, AuthDialogProxy.class)).getOpenAuthDialog(appContext.getContext());
            }
            IOpenAuthDialog iOpenAuthDialog2 = openAuthDialog;
            List<String> localFailScopeList = iOpenAuthDialog2.getLocalFailScopeList(this.j);
            ArrayList arrayList2 = new ArrayList(this.d);
            if (localFailScopeList != null) {
                for (int i = 0; i < localFailScopeList.size(); i++) {
                    this.d.remove(localFailScopeList.get(i));
                }
            }
            boolean isEmpty = this.d.isEmpty();
            if (agreements == null || agreements.isEmpty()) {
                arrayList = arrayList2;
                iOpenAuthDialog = iOpenAuthDialog2;
                iOpenAuthDialog.setContent(appName, appLogoLink, this.j, this.d, authText, null, this.f6180a.getAuthContentResult().getIsvAgent().booleanValue() ? this.f6180a.getAuthContentResult().getIsvAgentDesc() : null, this.f6180a.getAuthContentResult().getExtInfo());
            } else {
                ArrayList arrayList3 = new ArrayList(agreements.size());
                for (AuthAgreementModel authAgreementModel : agreements) {
                    arrayList3.add(new AuthProtocol(authAgreementModel.getName(), authAgreementModel.getLink()));
                }
                arrayList = arrayList2;
                iOpenAuthDialog = iOpenAuthDialog2;
                iOpenAuthDialog2.setContent(appName, appLogoLink, this.j, this.d, authText, arrayList3, this.f6180a.getAuthContentResult().getIsvAgent().booleanValue() ? this.f6180a.getAuthContentResult().getIsvAgentDesc() : null, this.f6180a.getAuthContentResult().getExtInfo());
            }
            iOpenAuthDialog.setOnConfirmClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.H5AuthRunnable.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", "h5OpenAuthDialog click begin invoke auth");
                    iOpenAuthDialog.cancel();
                    if (TextUtils.equals("TB", H5AuthRunnable.this.k)) {
                        IOpenAuthDialog iOpenAuthDialog3 = iOpenAuthDialog;
                        if (iOpenAuthDialog3 instanceof IOpenAuthDialogCheck) {
                            H5AuthRunnable.this.d = ((IOpenAuthDialogCheck) iOpenAuthDialog3).getSelectedScopeList();
                        } else {
                            H5AuthRunnable.this.d = new ArrayList();
                        }
                    }
                    ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.H5AuthRunnable.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RVOpenAuthHelper.access$1300(RVOpenAuthHelper.this, H5AuthRunnable.this.k, H5AuthRunnable.this.j, H5AuthRunnable.this.i, H5AuthRunnable.this.b, H5AuthRunnable.this.c, H5AuthRunnable.this.d, H5AuthRunnable.this.e, H5AuthRunnable.this.f, H5AuthRunnable.this.g, H5AuthRunnable.this.h, H5AuthRunnable.this.f6180a);
                        }
                    });
                }
            });
            iOpenAuthDialog.setOnCloseClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.RVOpenAuthHelper.H5AuthRunnable.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", "h5OpenAuthDialog click close");
                    iOpenAuthDialog.cancel();
                    if (!"TB".equals(H5AuthRunnable.this.k)) {
                        RVOpenAuthHelper.access$1500(RVOpenAuthHelper.this, H5AuthRunnable.this.j, H5AuthRunnable.this.i, H5AuthRunnable.this.f6180a, H5AuthRunnable.this.k, H5AuthRunnable.this.b, H5AuthRunnable.this.c, H5AuthRunnable.this.d, H5AuthRunnable.this.e, H5AuthRunnable.this.f, H5AuthRunnable.this.g, H5AuthRunnable.this.h);
                        return;
                    }
                    RVLogger.d("AriverPermission:RVOpenAuthHelper", "h5OpenAuthNoticeDialog click exit auth");
                    H5AuthRunnable h5AuthRunnable = H5AuthRunnable.this;
                    h5AuthRunnable.a(h5AuthRunnable.d);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("error", (Object) "11");
                    jSONObject3.put("message", (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
                    jSONObject3.put("errorMessage", (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
                    if (TextUtils.equals("TB", H5AuthRunnable.this.k)) {
                        jSONObject3.put("errorCode", (Object) TRVOpenAuthHelper.ERROR_CODE_CANCEL_TRIVER);
                        if (H5AuthRunnable.this.f6180a != null) {
                            JSONArray jSONArray = new JSONArray();
                            if (!CollectionUtils.isEmpty(H5AuthRunnable.this.f6180a.getAlreadyAuthedScopeNicks())) {
                                Iterator<String> it = H5AuthRunnable.this.f6180a.getAlreadyAuthedScopeNicks().iterator();
                                while (it.hasNext()) {
                                    jSONArray.add(it.next());
                                }
                            }
                            jSONObject3.put("authSuccessScopes", (Object) jSONArray);
                            JSONObject jSONObject4 = new JSONObject();
                            if (!CollectionUtils.isEmpty(H5AuthRunnable.this.f6180a.getRequestScopeNicks())) {
                                Iterator<String> it2 = H5AuthRunnable.this.f6180a.getRequestScopeNicks().iterator();
                                while (it2.hasNext()) {
                                    jSONObject4.put(it2.next(), (Object) TRVOpenAuthHelper.ERROR_CODE_CANCEL_TRIVER);
                                }
                            }
                            jSONObject3.put("authErrorScopes", (Object) jSONObject4);
                        }
                    }
                    RVOpenAuthHelper.this.sendResult(H5AuthRunnable.this.i, jSONObject3);
                }
            });
            if ((!isEmpty) != false) {
                try {
                    iOpenAuthDialog.show();
                    return;
                } catch (Throwable th) {
                    RVLogger.e("AriverPermission:RVOpenAuthHelper", th);
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("error", (Object) "12");
            jSONObject3.put("message", (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
            jSONObject3.put("errorMessage", (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
            if (TextUtils.equals("TB", this.k)) {
                jSONObject3.put("errorCode", (Object) TRVOpenAuthHelper.ERROR_CODE_CANCEL_TRIVER);
                JSONObject jSONObject4 = new JSONObject();
                if (!CollectionUtils.isEmpty(arrayList)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONObject4.put((String) it.next(), (Object) TRVOpenAuthHelper.ERROR_CODE_CANCEL_TRIVER);
                    }
                }
                jSONObject3.put("authErrorScopes", (Object) jSONObject4);
            }
            RVOpenAuthHelper.this.sendResult(this.i, jSONObject3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<String> list) {
            AuthSkipResultModel authSkipResultModel = this.f6180a;
            if (authSkipResultModel == null || authSkipResultModel.getScopeTypeMap() == null) {
                return;
            }
            for (String str : list) {
                if ("device".equals(this.f6180a.getScopeTypeMap().get(str))) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(TRVOpenAuthHelper.getAuthAppkey(this.j), TRVOpenAuthHelper.buildPermissionKey(this.j, this.b, str), "0");
                } else {
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                    String authAppkey = TRVOpenAuthHelper.getAuthAppkey(this.j);
                    App app = this.j;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME);
                    kVStorageProxy.putString(authAppkey, TRVOpenAuthHelper.buildPermissionKey(app, sb.toString()), "false");
                }
            }
        }
    }

    private static void h(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int i4;
        boolean z2;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        try {
            int i5 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
            if ((i5 == -1 ? '?' : 'c') != 'c') {
                int i6 = $10 + 19;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                byte[] bArr = PlaceComponentResult;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i8 = 0;
                    while (true) {
                        if (!(i8 < length)) {
                            break;
                        }
                        bArr2[i8] = (byte) (bArr[i8] ^ 3097486228508854431L);
                        i8++;
                    }
                    bArr = bArr2;
                }
                i5 = !(bArr == null) ? (byte) (((byte) (PlaceComponentResult[((int) (getAuthRequestContext ^ 3097486228508854431L)) + i] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))) : (short) (((short) (KClassImpl$Data$declaredNonStaticMembers$2[((int) (getAuthRequestContext ^ 3097486228508854431L)) + i] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            }
            if ((i5 > 0 ? '\r' : (char) 4) != 4) {
                int i9 = ((i + i5) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L));
                if (z) {
                    try {
                        int i10 = $10 + 83;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        i4 = 1;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    int i12 = $11 + 75;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    i4 = 0;
                }
                b2.getAuthRequestContext = i9 + i4;
                b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = PlaceComponentResult;
                if (bArr3 != null) {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    int i14 = 0;
                    while (true) {
                        if ((i14 < length2 ? (char) 4 : (char) 15) == 15) {
                            break;
                        }
                        int i15 = $10 + 47;
                        $11 = i15 % 128;
                        int i16 = i15 % 2;
                        bArr4[i14] = (byte) (bArr3[i14] ^ 3097486228508854431L);
                        i14++;
                    }
                    bArr3 = bArr4;
                }
                if (bArr3 != null) {
                    int i17 = $10 + 13;
                    $11 = i17 % 128;
                    int i18 = i17 % 2;
                    z2 = true;
                } else {
                    z2 = false;
                }
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                    if (z2) {
                        int i19 = $10 + 11;
                        $11 = i19 % 128;
                        int i20 = i19 % 2;
                        byte[] bArr5 = PlaceComponentResult;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        short[] sArr = KClassImpl$Data$declaredNonStaticMembers$2;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
