package com.iap.ac.android.acs.plugin.downgrade.router;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.ActionExecutor;
import com.iap.ac.android.acs.plugin.downgrade.amcs.NavigateSceneConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.utils.AclAPIContextUtils;
import com.iap.ac.android.biz.common.callback.OpenBizSceneCallback;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getCallingPid;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BizSceneNavigateManager {
    public static final String KEY_ALL = "all";
    public static final String KEY_DEFAULT = "default";
    public static final String LOGGER_KEY_FAILED = "failed";
    public static final String LOGGER_KEY_FROM_ALL = "fromAll";
    public static final String LOGGER_KEY_FROM_APPID = "fromAppId";
    public static final String LOGGER_KEY_FROM_COMMON = "fromCommon";
    public static final String LOGGER_KEY_FROM_DEFAULT = "fromDefault";
    public static final String LOGGER_KEY_FROM_REMOTE = "fromRemote";
    public static final String LOGGER_KEY_FROM_SPI = "fromSPI";
    public static final String LOGGER_KEY_FROM_WALLET = "fromWallet";
    public static final String SCENE_SCHEME_PRESET_PATH_IN_COMMON;
    public static final String SCENE_SCHEME_PRESET_PATH_IN_WALLET;
    public static final String TAG = ApiDowngradeUtils.logTag("BizSceneNavigateManager");
    public static BizSceneNavigateManager sInstance;
    public String JSON_KEY_PARAM = "param";
    public String JSON_KEY_DOWNGRADED = "downgraded";

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiDowngradeUtils.dirInAssets());
        sb.append("scene_scheme_map.json");
        SCENE_SCHEME_PRESET_PATH_IN_WALLET = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ApiDowngradeUtils.dirInAssets());
        sb2.append("scene_scheme_map_in_common.json");
        SCENE_SCHEME_PRESET_PATH_IN_COMMON = sb2.toString();
    }

    private void callbackWithError(IActionHandlerCallback iActionHandlerCallback, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", ApiDowngradeConstant.Error.ERR_DEF_CODE);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("callbackWithError() error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
        }
        iActionHandlerCallback.onHandleFailure(jSONObject);
    }

    public static BizSceneNavigateManager getInstance() {
        if (sInstance == null) {
            synchronized (BizSceneNavigateManager.class) {
                if (sInstance == null) {
                    sInstance = new BizSceneNavigateManager();
                }
            }
        }
        return sInstance;
    }

    private boolean handleBeforeAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, String str, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleBeforeNavigate() start beforeActionConfig: ");
        sb.append(jSONObject);
        ACLog.d(str2, sb.toString());
        if (jSONObject == null) {
            ACLog.d(str2, "handleBeforeNavigate() canceled for the beforeActionConfig is null");
            return false;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(iAPConnectPluginContext.miniProgramAppID);
        String str3 = null;
        if (optJSONObject2 != null) {
            str3 = "fromAppId";
            jSONObject2 = optJSONObject2.optJSONObject(str);
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 == null && (optJSONObject = jSONObject.optJSONObject("default")) != null) {
            jSONObject2 = optJSONObject.optJSONObject(str);
            str3 = "fromDefault";
        }
        if (jSONObject2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handleBeforeNavigate() canceled for the beforeActionConfig in sceneCode: ");
            sb2.append(str);
            sb2.append(" is null");
            ACLog.d(str2, sb2.toString());
            return false;
        }
        onHandleActionSuccess(iAPConnectPluginContext, jSONObject2, iActionHandlerCallback);
        ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_DOWNGRADE_BEFORE, iAPConnectPluginContext.miniProgramAppID, str).addParams(ApiDowngradeLogger.EXT_KEY_DOWNGRADE_TYPE, str3).addParams(ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, iAPConnectPluginContext.jsParameters).event();
        ACLog.d(str2, "handleBeforeNavigate() success, returns true to consume the action.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailureAction(IAPConnectPluginContext iAPConnectPluginContext, String str, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject failureAction = NavigateSceneConfigManager.getInstance().getFailureAction();
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleFailureNavigate() start, failure config: ");
        sb.append(failureAction);
        ACLog.d(str2, sb.toString());
        String str3 = "failed";
        if (failureAction != null) {
            JSONObject optJSONObject2 = failureAction.optJSONObject(iAPConnectPluginContext.miniProgramAppID);
            String str4 = null;
            if (optJSONObject2 != null) {
                str4 = "fromAppId";
                jSONObject = optJSONObject2.optJSONObject(str);
            } else {
                jSONObject = null;
            }
            if (jSONObject == null && (optJSONObject = failureAction.optJSONObject("default")) != null) {
                jSONObject = optJSONObject.optJSONObject(str);
                str4 = "fromDefault";
            }
            if (jSONObject == null) {
                jSONObject = failureAction.optJSONObject("all");
                if (jSONObject != null) {
                    str3 = LOGGER_KEY_FROM_ALL;
                }
            } else {
                str3 = str4;
            }
            if (jSONObject != null) {
                onHandleActionSuccess(iAPConnectPluginContext, jSONObject, iActionHandlerCallback);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("failure action is null in sceneCode:");
                sb2.append(str);
                onHandleActionFailed(iActionHandlerCallback, sb2.toString());
            }
        } else {
            callbackWithError(iActionHandlerCallback, "handleFailureNavigate() the failureActionConfig is null");
            ACLog.e(str2, "handleFailureNavigate() the failureActionConfig is null");
        }
        ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_DOWNGRADE_AFTER, iAPConnectPluginContext.miniProgramAppID, str).addParams(ApiDowngradeLogger.EXT_KEY_DOWNGRADE_TYPE, str3).addParams(ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, iAPConnectPluginContext.jsParameters).event();
    }

    private void handleSceneNavigateAndFailure(final IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, final String str, final IActionHandlerCallback iActionHandlerCallback) {
        String str2;
        JSONObject readJSONFromAssets;
        JSONObject readJSONFromAssets2;
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleSceneNavigateAndFailure() start sceneAction: ");
        sb.append(jSONObject);
        ACLog.d(str3, sb.toString());
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject(str);
            str2 = LOGGER_KEY_FROM_REMOTE;
        } else {
            str2 = null;
        }
        if (jSONObject2 == null && (readJSONFromAssets2 = ApiDowngradeUtils.readJSONFromAssets(iAPConnectPluginContext.getContext(), SCENE_SCHEME_PRESET_PATH_IN_WALLET)) != null) {
            jSONObject2 = readJSONFromAssets2.optJSONObject(str);
            str2 = LOGGER_KEY_FROM_WALLET;
        }
        if (jSONObject2 == null && (readJSONFromAssets = ApiDowngradeUtils.readJSONFromAssets(iAPConnectPluginContext.getContext(), SCENE_SCHEME_PRESET_PATH_IN_COMMON)) != null) {
            jSONObject2 = readJSONFromAssets.optJSONObject(str);
            str2 = LOGGER_KEY_FROM_COMMON;
        }
        final String str4 = str2;
        if (jSONObject2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handleSceneNavigateAndFailure() start handleAction by ActionExecutor#handleAction(), sceneCode: ");
            sb2.append(str);
            sb2.append(", sceneAction: ");
            sb2.append(jSONObject2);
            ACLog.d(str3, sb2.toString());
            ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject2, new IActionHandlerCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.router.BizSceneNavigateManager.2
                private static int $10 = 0;
                private static int $11 = 1;
                private static char BuiltInFictitiousFunctionClassFactory = 42070;
                private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                private static char[] MyBillsEntityDataFactory = {37359, 37286, 37280, 37365, 37281, 37289, 37358, 37353, 37352};
                private static int PlaceComponentResult;

                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleFailure(JSONObject jSONObject3) {
                    String str5 = BizSceneNavigateManager.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("handleSceneNavigateAndFailure() handleAction by ActionExecutor#handleAction(), onHandleFailure() response: ");
                    sb3.append(jSONObject3);
                    ACLog.d(str5, sb3.toString());
                    ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_MAP_FAILURE, iAPConnectPluginContext.miniProgramAppID, str).addParams(ApiDowngradeLogger.EXT_KEY_NAVIGATE_TYPE, str4).event();
                    iActionHandlerCallback.onHandleFailure(jSONObject3);
                    try {
                        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                        try {
                            PlaceComponentResult = i % 128;
                            if (i % 2 != 0) {
                                Object obj = null;
                                obj.hashCode();
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }

                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
                public void onHandleSuccess(JSONObject jSONObject3) {
                    String str5 = BizSceneNavigateManager.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("handleSceneNavigateAndFailure() handleAction by ActionExecutor#handleAction(), onHandleSuccess() response: ");
                    sb3.append(jSONObject3);
                    ACLog.d(str5, sb3.toString());
                    ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_MAP_SUCCESS, iAPConnectPluginContext.miniProgramAppID, str).addParams(ApiDowngradeLogger.EXT_KEY_NAVIGATE_TYPE, str4).event();
                    iActionHandlerCallback.onHandleSuccess(jSONObject3);
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                }

                public static void $$a(long j, long j2) {
                    long j3 = j ^ (j2 << 32);
                    Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                    StringBuilder sb3 = new StringBuilder();
                    Object[] objArr = new Object[1];
                    a(new char[]{4, 7, '\b', 5, 6, 3}, (byte) (Color.blue(0) + 45), 6 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr);
                    sb3.append((String) objArr[0]);
                    sb3.append(j3);
                    String obj = sb3.toString();
                    Intrinsics.checkNotNullParameter(obj, "");
                    BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
                    RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
                    Intrinsics.checkNotNullParameter(dexguardException, "");
                    BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
                    RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.HOOKED);
                    UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.HOOKED);
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                    PlaceComponentResult = i % 128;
                    if (!(i % 2 == 0)) {
                        int i2 = 83 / 0;
                    }
                }

                private static void a(char[] cArr, byte b, int i, Object[] objArr) {
                    int i2;
                    getCallingPid getcallingpid = new getCallingPid();
                    char[] cArr2 = MyBillsEntityDataFactory;
                    if (cArr2 != null) {
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        int i3 = 0;
                        while (true) {
                            if (!(i3 < length)) {
                                break;
                            }
                            int i4 = $10 + 69;
                            $11 = i4 % 128;
                            int i5 = i4 % 2;
                            cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                            i3++;
                        }
                        cArr2 = cArr3;
                    }
                    char c = (char) ((-1549216646985767851L) ^ BuiltInFictitiousFunctionClassFactory);
                    char[] cArr4 = new char[i];
                    if (i % 2 != 0) {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    } else {
                        i2 = i;
                    }
                    if (i2 > 1) {
                        getcallingpid.getAuthRequestContext = 0;
                        while (getcallingpid.getAuthRequestContext < i2) {
                            int i6 = $11 + 7;
                            $10 = i6 % 128;
                            int i7 = i6 % 2;
                            getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                            getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                            if (getcallingpid.MyBillsEntityDataFactory != getcallingpid.PlaceComponentResult) {
                                getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                                getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                                getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                                getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                                if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                                    getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                                    int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                    int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                    cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                                } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                                    getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                    getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                    int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                    int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                    cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                                } else {
                                    int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                    int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                    cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                                }
                            } else {
                                int i14 = $10 + 19;
                                $11 = i14 % 128;
                                if ((i14 % 2 == 0 ? (char) 18 : Typography.dollar) != '$') {
                                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory * b);
                                    cArr4[getcallingpid.getAuthRequestContext - 0] = (char) (getcallingpid.PlaceComponentResult - b);
                                } else {
                                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                                }
                            }
                            getcallingpid.getAuthRequestContext += 2;
                            try {
                                int i15 = $11 + 99;
                                try {
                                    $10 = i15 % 128;
                                    int i16 = i15 % 2;
                                } catch (Exception e) {
                                    throw e;
                                }
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                    }
                    int i17 = 0;
                    while (true) {
                        if ((i17 < i ? 'J' : (char) 17) != 17) {
                            int i18 = $11 + 95;
                            $10 = i18 % 128;
                            int i19 = i18 % 2;
                            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
                            i17++;
                        } else {
                            objArr[0] = new String(cArr4);
                            return;
                        }
                    }
                }
            });
            return;
        }
        Map<String, String> parseJSONParamsToMap = ApiDowngradeUtils.parseJSONParamsToMap(iAPConnectPluginContext.jsParameters.optJSONObject(this.JSON_KEY_PARAM));
        AclAPIContext createAclAPIContext = AclAPIContextUtils.createAclAPIContext(iAPConnectPluginContext);
        try {
            ACLog.d(str3, String.format("before SPIManager#openBizScene, sceneCode: %s, jsParameters: %s", str, iAPConnectPluginContext.jsParameters));
            SPIManager.getInstance().openBizScene(str, parseJSONParamsToMap, createAclAPIContext, new OpenBizSceneCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.router.BizSceneNavigateManager.3
                @Override // com.iap.ac.android.biz.common.callback.OpenBizSceneCallback
                public void sendJSONResponse(JSONObject jSONObject3) {
                    ACLog.d(BizSceneNavigateManager.TAG, String.format("after SPIManager#openBizScene, sceneCode: %s, result: %s", str, jSONObject3));
                    if (!jSONObject3.optBoolean("success", false)) {
                        ACLog.e(BizSceneNavigateManager.TAG, "handle scene navigate failed, start handle by failure action.");
                        ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_MAP_FAILURE, iAPConnectPluginContext.miniProgramAppID, str).addParams("error", Integer.valueOf((int) ApiDowngradeConstant.Error.ERR_DEF_CODE)).addParams("errorMessage", "handle scene navigate failed, start handle by failure action.").event();
                        BizSceneNavigateManager.this.handleFailureAction(iAPConnectPluginContext, str, iActionHandlerCallback);
                        return;
                    }
                    ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_MAP_SUCCESS, iAPConnectPluginContext.miniProgramAppID, str).addParams(ApiDowngradeLogger.EXT_KEY_NAVIGATE_TYPE, BizSceneNavigateManager.LOGGER_KEY_FROM_SPI).event();
                    iActionHandlerCallback.onHandleSuccess(jSONObject3);
                }
            });
        } catch (Exception e) {
            handleFailureAction(iAPConnectPluginContext, str, iActionHandlerCallback);
            String str5 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("handleSceneNavigateAndFailure() failed with exception :");
            sb3.append(e);
            ACLog.e(str5, sb3.toString());
        }
    }

    public void navigate(IAPConnectPluginContext iAPConnectPluginContext, String str, IActionHandlerCallback iActionHandlerCallback) {
        String str2 = iAPConnectPluginContext.miniProgramAppID;
        JSONObject jSONObject = iAPConnectPluginContext.jsParameters;
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("navigate() appId: ");
        sb.append(str2);
        sb.append(", sceneCode: ");
        sb.append(str);
        sb.append(", params: ");
        sb.append(jSONObject);
        ACLog.d(str3, sb.toString());
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("the appId is empty when navigate to sceneCode: ");
            sb2.append(str);
            String obj = sb2.toString();
            onHandleActionFailed(iActionHandlerCallback, obj);
            ACLog.e(str3, obj);
            ApiDowngradeLogger.logException(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_APPID_IS_NULL, obj);
        } else if (handleBeforeAction(iAPConnectPluginContext, NavigateSceneConfigManager.getInstance().getBeforeAction(), str, iActionHandlerCallback)) {
        } else {
            ApiDowngradeLogger.newLoggerInScene(ApiDowngradeLogger.BL_ACS_NAVIGATE_SCENE_MAP_START, str2, str).addParams(ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, jSONObject).event();
            handleSceneNavigateAndFailure(iAPConnectPluginContext, NavigateSceneConfigManager.getInstance().getSceneSchemeMap(), str, iActionHandlerCallback);
        }
    }

    public void onHandleActionFailed(IActionHandlerCallback iActionHandlerCallback, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.JSON_KEY_DOWNGRADED, false);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handleBeforeNavigate() onHandleFailure() put value error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
        }
        iActionHandlerCallback.onHandleFailure(jSONObject);
    }

    public void onHandleActionSuccess(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, final IActionHandlerCallback iActionHandlerCallback) {
        ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject, new IActionHandlerCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.router.BizSceneNavigateManager.1
            @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
            public void onHandleFailure(JSONObject jSONObject2) {
                String str = BizSceneNavigateManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onHandleActionSuccess() on ActionExecutor#handleAction onHandleFailure() response: ");
                sb.append(jSONObject2);
                ACLog.d(str, sb.toString());
                try {
                    jSONObject2.put(BizSceneNavigateManager.this.JSON_KEY_DOWNGRADED, true);
                } catch (JSONException e) {
                    String str2 = BizSceneNavigateManager.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onHandleActionSuccess() on ActionExecutor#handleAction onHandleFailure() put value error: ");
                    sb2.append(e);
                    ACLog.w(str2, sb2.toString());
                }
                iActionHandlerCallback.onHandleSuccess(jSONObject2);
            }

            @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback
            public void onHandleSuccess(JSONObject jSONObject2) {
                String str = BizSceneNavigateManager.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onHandleActionSuccess() on ActionExecutor#handleAction onHandleSuccess() response: ");
                sb.append(jSONObject2);
                ACLog.d(str, sb.toString());
                try {
                    jSONObject2.put(BizSceneNavigateManager.this.JSON_KEY_DOWNGRADED, true);
                } catch (JSONException e) {
                    String str2 = BizSceneNavigateManager.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onHandleActionSuccess() on ActionExecutor#handleAction onHandleSuccess() put value error: ");
                    sb2.append(e);
                    ACLog.w(str2, sb2.toString());
                }
                iActionHandlerCallback.onHandleSuccess(jSONObject2);
            }
        });
    }
}
