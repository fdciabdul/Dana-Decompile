package id.dana.network.rpc;

import android.content.Context;
import android.os.Build;
import com.akamai.botman.CYFMonitor;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.iap.android.common.timesync.TimeSyncManager;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.QuakeConfig;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import com.alipay.imobile.network.quake.rpc.IQuakeRpc;
import com.alipay.imobile.network.quake.rpc.QuakeRpc;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.apiguard3.APIGuard;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.gson.Gson;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.AkamaiUserAgentFactory;
import id.dana.network.util.BotProtectionUtil;
import id.dana.rum.Rum;
import id.dana.rum.exception.RumInterceptorNullException;
import id.dana.utils.BuildConfigUtils;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.config.entity.NetworkLoggingConfiguration;
import id.dana.utils.config.model.NetworkLoggingConfig;
import id.dana.utils.foundation.SignatureUtils;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import id.dana.utils.rpc.errorcode.VerificationErrorCode;
import id.dana.utils.rpc.response.BaseNetworkRpcResponse;
import id.dana.utils.rpc.response.DefaultResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* loaded from: classes2.dex */
public class RpcConnector {
    private static final String APP_ID = "6CC59C4231550";
    private static final String APP_KEY = "6CC59C4231550_ANDROID";
    private static final String DEFAULT_RPC_GATEWAY_URL = "https://mgs-gw.m.dana.id/mgw.htm";
    public static final String LANGUAGE_TAG_ID = "ID";
    private static final String MGW_TRACE_ID = "Mgw-TraceId";
    private static final String SIGN_AUTHCODE = "0ce8";
    private static final String SIGN_AUTHCODE_FOR_NOT_GOOGLE_PLAY = "0ce8_1";
    private static final String TENANT_ID = "FKPZXBCN";
    private static final String WORKSPACED_ID = "prod";
    private static NetworkLoggingConfig networkLoggingConfig;
    private final ApSecurity apSecurityFacade;
    private final Context context;
    private final DeviceInformation deviceInformation;
    private final Gson gson;
    private final HoldLoginConfig holdLoginConfig;
    private final HoldLoginV2Interceptor holdLoginV2Interceptor;
    private final Map<String, Map<String, Object>> mapOperationTypeCustomTracked = ImmutableMap.of("alipayplus.mobilewallet.user.checkRegisteredUserAndSendOTP", ImmutableMap.of("Source", TrackerDataKey.Source.VERIFY_PHONE_NUMBER), TrackerDataKey.NetworkErrorOperationTypeProperty.TRUST_RISK_LOGIN_V2, ImmutableMap.of("Source", "Login"), TrackerDataKey.NetworkErrorOperationTypeProperty.PASSWORD_VERIFY, ImmutableMap.of("Source", "Login"), "alipayplus.mobilewallet.user.login", ImmutableMap.of("Source", "Login"), TrackerDataKey.NetworkErrorOperationTypeProperty.REGISTER, ImmutableMap.of("Source", "Registration"), TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP_RISK, ImmutableMap.of(), "alipayplus.mobilewallet.user.security.sendOtp", ImmutableMap.of(), TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP, ImmutableMap.of(), TrackerDataKey.NetworkErrorOperationTypeProperty.GET_AUTH_CODE, ImmutableMap.of());
    private HttpMetric metric;
    @Inject
    NetworkLoggingConfiguration networkLoggingConfiguration;

    @Inject
    public RpcConnector(Context context, ApSecurity apSecurity, DeviceInformation deviceInformation, Gson gson, HoldLoginV2Interceptor holdLoginV2Interceptor, HoldLoginConfig holdLoginConfig) {
        this.apSecurityFacade = apSecurity;
        this.deviceInformation = deviceInformation;
        this.holdLoginV2Interceptor = holdLoginV2Interceptor;
        this.holdLoginConfig = holdLoginConfig;
        init(context);
        this.context = context;
        this.gson = gson;
    }

    public Context getContext() {
        return this.context;
    }

    private void init(Context context) {
        final IQuakeRpc createInstance = QuakeRpc.createInstance(context);
        createInstance.getQuake().config(new QuakeConfig("6CC59C4231550", "6CC59C4231550_ANDROID", SignatureUtils.getAuthRequestContext(context) ? "0ce8" : SIGN_AUTHCODE_FOR_NOT_GOOGLE_PLAY, "https://mgs-gw.m.dana.id/mgw.htm", 4));
        Objects.requireNonNull(createInstance);
        RPCProxyHost.setRPCImplement(new RPCProxyHost.IRPCProxy() { // from class: id.dana.network.rpc.RpcConnector$$ExternalSyntheticLambda0
            @Override // com.alipay.iap.android.common.rpcintegration.RPCProxyHost.IRPCProxy
            public final Object getInterfaceProxy(Class cls) {
                return IQuakeRpc.this.getRpcProxy(cls);
            }
        });
        Quake.instance().addRequestInterceptor(new AnonymousClass1());
        Rum.CC.getAuthRequestContext(new Function3() { // from class: id.dana.network.rpc.RpcConnector$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RpcConnector.lambda$init$0((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
            }
        });
        RequestInterceptor MyBillsEntityDataFactory = Rum.CC.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != null) {
            Quake.instance().addRequestInterceptor(MyBillsEntityDataFactory);
        } else {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            RumInterceptorNullException rumInterceptorNullException = new RumInterceptorNullException();
            Intrinsics.checkNotNullParameter(rumInterceptorNullException, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(rumInterceptorNullException);
            Rum.CC.getAuthRequestContext().MyBillsEntityDataFactory(new RumInterceptorNullException(), new Pair[0]);
        }
        TimeSyncManager.getInstance(context).syncTime(null);
        BuildConfigUtils.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.network.rpc.RpcConnector$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements RequestInterceptor {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Object PlaceComponentResult() {
            return null;
        }

        AnonymousClass1() {
        }

        @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
        public void beforeSendRequest(Request request) {
            String[] split = request.toString().split("#");
            HashMap hashMap = new HashMap();
            hashMap.put("version", "1.0");
            hashMap.put("appId", Quake.instance().getConfig().getAppId());
            hashMap.put("X-Apdid-Token", RpcConnector.this.apSecurityFacade.BuiltInFictitiousFunctionClassFactory());
            hashMap.put("workspaceId", "prod");
            hashMap.put(HeaderConstant.HEADER_KEY_TENANT_ID, "FKPZXBCN");
            hashMap.put("OPERATION-TYPE", split[1]);
            if (RpcConnector.this.getLanguage().endsWith("ID")) {
                hashMap.put("Accept-Language", RpcConnector.this.getLanguage());
            }
            hashMap.put(HeaderConstant.HEADER_KEY_DID, RpcConnector.this.deviceInformation.getDeviceUtdId());
            Quake.instance().setDefaultUserAgent(AkamaiUserAgentFactory.create());
            hashMap.put("X-acf-sensor-data", CYFMonitor.KClassImpl$Data$declaredNonStaticMembers$2());
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap.putAll(APIGuard.getSharedInstance().getRequestHeaders(request.getUrl(), null));
            }
            request.addExternalInfo(hashMap);
            if (RpcConnector.this.isHoldLoginV2Enable() && RpcConnector.this.hasSession()) {
                RpcConnector.this.holdLoginV2Interceptor.BuiltInFictitiousFunctionClassFactory(request);
            }
            RpcConnector.this.startLogging(request, split[1]);
        }

        @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
        public void afterReceiveResponse(Request request, NetworkResponse networkResponse) {
            String str = request.toString().split("#")[1];
            if (RpcConnector.this.isHoldLoginV2Enable() && RpcConnector.this.hasSession()) {
                RpcConnector.this.holdLoginV2Interceptor.PlaceComponentResult(request, networkResponse, new Function0() { // from class: id.dana.network.rpc.RpcConnector$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RpcConnector.AnonymousClass1.PlaceComponentResult();
                    }
                });
            }
            RpcConnector.this.getAkamaiResponseHeader(networkResponse, str);
            if (Build.VERSION.SDK_INT >= 21) {
                APIGuard.getSharedInstance().parseResponseHeaders(networkResponse.extData);
            }
            RpcConnector.this.stopLogging(request, networkResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$init$0(Boolean bool, Boolean bool2, Boolean bool3) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        String obj = bool.toString();
        Intrinsics.checkNotNullParameter("Is Above API 21", "");
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Above API 21", obj);
        String obj2 = bool2.toString();
        Intrinsics.checkNotNullParameter("Is Network Instrumentation", "");
        Intrinsics.checkNotNullParameter(obj2, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Network Instrumentation", obj2);
        String obj3 = bool3.toString();
        Intrinsics.checkNotNullParameter("Is Rum No Op", "");
        Intrinsics.checkNotNullParameter(obj3, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("Is Rum No Op", obj3);
        return null;
    }

    public boolean isHoldLoginV2Enable() {
        return this.holdLoginConfig.BuiltInFictitiousFunctionClassFactory();
    }

    public FeatureHoldLoginConfig getHoldLoginConfig() {
        return this.holdLoginConfig.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public boolean hasSession() {
        return this.holdLoginConfig.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLogging(Request request, String str) {
        NetworkLoggingConfiguration networkLoggingConfiguration;
        trackRegisterToLoginApi(str);
        if (networkLoggingConfig == null && (networkLoggingConfiguration = this.networkLoggingConfiguration) != null) {
            networkLoggingConfig = networkLoggingConfiguration.getNetworkLogging();
        }
        startTrackNetworkRequest(request, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLogging(Request request, NetworkResponse networkResponse) {
        if (networkLoggingConfig != null) {
            try {
                BaseNetworkRpcResponse baseNetworkRpcResponse = (BaseNetworkRpcResponse) this.gson.fromJson(new String(networkResponse.data, StandardCharsets.UTF_8), BaseNetworkRpcResponse.class);
                boolean isTrackable = isTrackable(getErrorCode(baseNetworkRpcResponse), networkLoggingConfig.getAuthRequestContext);
                if (isTrackable) {
                    processResponseForErrorLogging(request, networkResponse, baseNetworkRpcResponse);
                }
                if (networkLoggingConfig.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    stopTrackNetworkRequest(request, networkResponse, baseNetworkRpcResponse, isTrackable);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void processResponseForErrorLogging(Request request, NetworkResponse networkResponse, BaseNetworkRpcResponse baseNetworkRpcResponse) {
        String str = request.toString().split("#")[1];
        if ((isOperationTypeCustomlyTracked(str) && baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2.toString().isEmpty()) || networkResponse.data == null) {
            return;
        }
        if (baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2.intValue() == 1000 && baseNetworkRpcResponse.PlaceComponentResult()) {
            return;
        }
        String str2 = networkResponse.extData.containsKey("Mgw-TraceId") ? networkResponse.extData.get("Mgw-TraceId") : null;
        DefaultResponse defaultResponse = baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory;
        String networkErrorMessage = defaultResponse != null ? defaultResponse.getNetworkErrorMessage() : "";
        String obj = baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2.toString();
        if (defaultResponse != null) {
            obj = defaultResponse.getErrorCode();
        }
        trackNetworkError(str, obj, networkErrorMessage, str2);
    }

    private boolean isOperationTypeCustomlyTracked(String str) {
        return this.mapOperationTypeCustomTracked.containsKey(str);
    }

    private void trackNetworkError(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Operation Type", str);
            jSONObject.put("Error Code", str2);
            jSONObject.put("Error Message", str3);
            jSONObject.put("Trace ID", str4);
            Map<String, Object> map = this.mapOperationTypeCustomTracked.get(str);
            if (map != null && !map.keySet().isEmpty()) {
                for (String str5 : map.keySet()) {
                    jSONObject.put(str5, map.get(str5));
                }
            }
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Mixpanel", DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
        if (getContext() == null || str2.equals(VerificationErrorCode.RETRY_VERIFY) || str2.equals("AE15001858018002")) {
            return;
        }
        MixPanelDataTracker.PlaceComponentResult(getContext(), "Network Error", jSONObject);
    }

    private void startTrackNetworkRequest(Request request, String str) {
        if (RpcLogging.INSTANCE.getEnableNetworkTrace()) {
            HttpMetric newHttpMetric = FirebasePerformance.getInstance().newHttpMetric(request.getUrl(), "POST");
            this.metric = newHttpMetric;
            newHttpMetric.putAttribute(Condition.TYPE_OPERATION_TYPE, str);
            this.metric.start();
        }
    }

    private void stopTrackNetworkRequest(Request request, NetworkResponse networkResponse, BaseNetworkRpcResponse baseNetworkRpcResponse, boolean z) {
        if (this.metric != null) {
            if ((baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2.intValue() != 1000 || !baseNetworkRpcResponse.PlaceComponentResult()) && z) {
                this.metric.setHttpResponseCode(SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
                this.metric.putAttribute(BehaviorLogger.Key.ERROR_CODE, getErrorCode(baseNetworkRpcResponse));
            } else {
                this.metric.setHttpResponseCode(networkResponse.statusCode);
            }
            String str = networkResponse.extData.get(HttpHeaders.CONTENT_LENGTH);
            if (str != null) {
                this.metric.setRequestPayloadSize(request.toString().getBytes().length);
                this.metric.setResponsePayloadSize(Long.parseLong(str));
            }
            this.metric.stop();
        }
    }

    private boolean isTrackable(String str, List<String> list) {
        return !list.contains(str);
    }

    private void trackRegisterToLoginApi(String str) {
        if (str == null || !RpcLogging.INSTANCE.getEnabled()) {
            return;
        }
        addBasedOnRequest(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAkamaiResponseHeader(NetworkResponse networkResponse, String str) {
        String str2 = networkResponse.extData.get(BotProtectionUtil.AKAMAI_BOT_HEADER);
        if (str2 != null) {
            Matcher matcher = Pattern.compile(BotProtectionUtil.AKAMAI_DEFAULT_BOT_REGEX).matcher(str2);
            if (matcher.find()) {
                String group = matcher.group(5);
                String group2 = matcher.group(3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TrackerDataKey.Property.ACTION_TAKEN, group2);
                    jSONObject.put(TrackerDataKey.Property.BOT_SCORE, group);
                    jSONObject.put("Operation Type", str);
                } catch (JSONException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
                }
                if (getContext() != null) {
                    MixPanelDataTracker.PlaceComponentResult(getContext(), TrackerDataKey.Event.BOT_DETECTION, jSONObject);
                }
            }
        }
    }

    private void addBasedOnRequest(String str) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        sb.append("operation: ");
        sb.append(str);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLanguage() {
        String obj = Locale.getDefault().toString();
        return obj.endsWith("ID") ? "id-ID" : obj;
    }

    public <T> T getFacade(Class<T> cls) {
        return (T) RPCProxyHost.getInterfaceProxy(cls);
    }

    private String getErrorCode(BaseNetworkRpcResponse baseNetworkRpcResponse) {
        if (baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory != null) {
            return baseNetworkRpcResponse.BuiltInFictitiousFunctionClassFactory.getErrorCode();
        }
        return String.valueOf(baseNetworkRpcResponse.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
