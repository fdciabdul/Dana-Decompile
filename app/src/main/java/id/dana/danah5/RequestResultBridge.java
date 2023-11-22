package id.dana.danah5;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.functions.Function;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bD\u0010\u0016J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JG\u0010\u001b\u001a\u00020\u00072\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\u0007*\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b6\u00107R,\u0010<\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020908088CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C"}, d2 = {"Lid/dana/danah5/RequestResultBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lid/dana/domain/useragreement/interactor/ConsultAgreement$Params;", "consultAgreementParams", "", "url", "requestId", "", "checkConsultAgreement", "(Lid/dana/domain/useragreement/interactor/ConsultAgreement$Params;Ljava/lang/String;Ljava/lang/String;)V", DanaH5.SERVICE_KEY, "checkH5AgreementStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "merchantId", "clientId", "checkUserAgreementStatus", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrlWithoutParameters", "(Ljava/lang/String;)Ljava/lang/String;", "onInitialized", "()V", "openNewUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", "requestResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lcom/alibaba/fastjson/JSONObject;", "result", "sendResult", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "errorCode", "failedResponse", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;I)V", "", "callbackMap", "Ljava/util/Map;", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "consultAgreement", "Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "getConsultAgreement", "()Lid/dana/domain/useragreement/interactor/ConsultAgreement;", "setConsultAgreement", "(Lid/dana/domain/useragreement/interactor/ConsultAgreement;)V", "Lid/dana/domain/services/interactor/GetService;", "getService", "Lid/dana/domain/services/interactor/GetService;", "getGetService", "()Lid/dana/domain/services/interactor/GetService;", "setGetService", "(Lid/dana/domain/services/interactor/GetService;)V", "requestResultCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "", "", "getRequestResultRules", "()Ljava/util/Map;", "requestResultRules", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "getSplitFacade", "()Lid/dana/data/toggle/SplitFacade;", "setSplitFacade", "(Lid/dana/data/toggle/SplitFacade;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestResultBridge extends BaseBridge {
    private static final int AUTH_REQUIRED = 4;
    private static final int CANCELED_BY_USER = 3;
    private static final int INVALID_URL = 2;
    private static final String MERCHANT_PAGE_AGREEMENT_TYPE = "MERCHANT_PAGE";
    private static final String MINI_PROGRAM_PREFIX = "MINIPROGRAM_";
    private static final int MISSING_INFO_REQUIRED = 5;
    private static final String REQUEST_ID = "requestId";
    private static final int UNKOWN_ERROR = 1;
    private final Map<String, BridgeCallback> callbackMap = new LinkedHashMap();
    @Inject
    public ConsultAgreement consultAgreement;
    @Inject
    public GetService getService;
    private BridgeCallback requestResultCallback;
    @Inject
    public SplitFacade splitFacade;

    @JvmName(name = "getSplitFacade")
    public final SplitFacade getSplitFacade() {
        SplitFacade splitFacade = this.splitFacade;
        if (splitFacade != null) {
            return splitFacade;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSplitFacade")
    public final void setSplitFacade(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @JvmName(name = "getGetService")
    public final GetService getGetService() {
        GetService getService = this.getService;
        if (getService != null) {
            return getService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetService")
    public final void setGetService(GetService getService) {
        Intrinsics.checkNotNullParameter(getService, "");
        this.getService = getService;
    }

    @JvmName(name = "getConsultAgreement")
    public final ConsultAgreement getConsultAgreement() {
        ConsultAgreement consultAgreement = this.consultAgreement;
        if (consultAgreement != null) {
            return consultAgreement;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setConsultAgreement")
    public final void setConsultAgreement(ConsultAgreement consultAgreement) {
        Intrinsics.checkNotNullParameter(consultAgreement, "");
        this.consultAgreement = consultAgreement;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    @JvmName(name = "getRequestResultRules")
    private final Map<String, Map<String, Boolean>> getRequestResultRules() {
        Object blockingFirst = getSplitFacade().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.RequestResultBridge$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map m630_get_requestResultRules_$lambda0;
                m630_get_requestResultRules_$lambda0 = RequestResultBridge.m630_get_requestResultRules_$lambda0((BaseTrafficType) obj);
                return m630_get_requestResultRules_$lambda0;
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (Map) blockingFirst;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void requestResult(@BindingParam(name = {"url"}) String url, @BindingParam(name = {"merchantId"}) String merchantId, @BindingParam(name = {"clientId"}) String clientId, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback callback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(callback, "");
        this.requestResultCallback = callback;
        if (!Patterns.WEB_URL.matcher(url == null ? "" : url).matches()) {
            BridgeCallback bridgeCallback = this.requestResultCallback;
            if (bridgeCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            }
            failedResponse(bridgeCallback, 2);
            return;
        }
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        String urlWithoutParameters = getUrlWithoutParameters(url == null ? "" : url);
        Map<String, Map<String, Boolean>> requestResultRules = getRequestResultRules();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Map<String, Boolean>> entry : requestResultRules.entrySet()) {
            String key = entry.getKey();
            if (!Patterns.WEB_URL.matcher(key).matches()) {
                key = UrlUtil.getAuthRequestContext(key);
            }
            Intrinsics.checkNotNullExpressionValue(key, "");
            if (StringsKt.contains((CharSequence) urlWithoutParameters, (CharSequence) key, true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map map = (Map) CollectionsKt.firstOrNull(linkedHashMap.values());
        if (map != null ? Intrinsics.areEqual(map.get("requiresAuth"), Boolean.TRUE) : false) {
            checkUserAgreementStatus(page, merchantId, clientId, url, obj);
            return;
        }
        if (url == null) {
            url = "";
        }
        openNewUrl(url, obj);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void sendResult(@BindingNode(Page.class) Page page, @BindingParam(name = {"requestId"}) String requestId, @BindingParam(name = {"result"}) JSONObject result, @BindingCallback BridgeCallback callback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Intrinsics.checkNotNullParameter(callback, "");
        BridgeCallback remove = this.callbackMap.remove(requestId);
        if (remove != null) {
            remove.sendJSONResponse(result);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            callback.sendJSONResponse(jSONObject);
            Activity activity = BridgeExtensionExtKt.getActivity(page);
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        callback.sendJSONResponse(jSONObject2);
    }

    private final void checkUserAgreementStatus(Page page, String merchantId, String clientId, String url, String requestId) {
        String str = url;
        String appId = H5ExtKt.getAppId(page);
        if (appId == null || StringsKt.isBlank(appId)) {
            String serviceKey = H5ExtKt.getServiceKey(page);
            if (serviceKey == null) {
                return;
            }
            checkH5AgreementStatus(serviceKey, str, requestId);
            return;
        }
        String str2 = merchantId;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            String str3 = clientId;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                String valueOf = String.valueOf(H5ExtKt.getAppId(page));
                StringBuilder sb = new StringBuilder();
                sb.append("MINIPROGRAM_");
                sb.append(valueOf);
                sb.append('_');
                sb.append(merchantId);
                ConsultAgreement.Params params = new ConsultAgreement.Params(valueOf, CollectionsKt.listOf(sb.toString()), "MERCHANT_PAGE", null, clientId, true);
                if (str == null) {
                    str = "";
                }
                checkConsultAgreement(params, str, requestId);
                return;
            }
        }
        BridgeCallback bridgeCallback = this.requestResultCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        failedResponse(bridgeCallback, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkConsultAgreement(ConsultAgreement.Params consultAgreementParams, final String url, final String requestId) {
        getConsultAgreement().execute(consultAgreementParams, new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.danah5.RequestResultBridge$checkConsultAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                if (!consultAgreementResponse.getNeedUserAgreement()) {
                    RequestResultBridge.this.openNewUrl(url, requestId);
                    return;
                }
                RequestResultBridge requestResultBridge = RequestResultBridge.this;
                bridgeCallback = requestResultBridge.requestResultCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                requestResultBridge.failedResponse(bridgeCallback, 4);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.RequestResultBridge$checkConsultAgreement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                RequestResultBridge requestResultBridge = RequestResultBridge.this;
                bridgeCallback = requestResultBridge.requestResultCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                requestResultBridge.failedResponse(bridgeCallback, 1);
            }
        });
    }

    private final void checkH5AgreementStatus(final String serviceKey, final String url, final String requestId) {
        getGetService().execute(serviceKey, new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.danah5.RequestResultBridge$checkH5AgreementStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                invoke2(thirdPartyServiceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                List<String> listOf;
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                BridgeCallback bridgeCallback2 = null;
                if (Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "GET")) {
                    listOf = thirdPartyServiceResponse.getSpaceCodes();
                    if (listOf == null) {
                        listOf = CollectionsKt.emptyList();
                    }
                } else {
                    String clientId = thirdPartyServiceResponse.getClientId();
                    if (clientId == null || StringsKt.isBlank(clientId)) {
                        RequestResultBridge requestResultBridge = RequestResultBridge.this;
                        bridgeCallback = requestResultBridge.requestResultCallback;
                        if (bridgeCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback2 = bridgeCallback;
                        }
                        requestResultBridge.failedResponse(bridgeCallback2, 5);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(ShowAgreementBridge.MINI_PROGRAM_PREFIX);
                    sb.append(thirdPartyServiceResponse.getClientId());
                    listOf = CollectionsKt.listOf(sb.toString());
                }
                List<String> list = listOf;
                String str = Intrinsics.areEqual(thirdPartyServiceResponse.getAction(), "POST") ? ShowAgreementBridge.MERCHANT_PAGE_AGREEMENT_TYPE : null;
                String str2 = serviceKey;
                String scopes = thirdPartyServiceResponse.getScopes();
                ConsultAgreement.Params params = new ConsultAgreement.Params(str2, list, str, scopes == null ? "" : scopes, null, false);
                RequestResultBridge requestResultBridge2 = RequestResultBridge.this;
                String str3 = url;
                requestResultBridge2.checkConsultAgreement(params, str3 != null ? str3 : "", requestId);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.RequestResultBridge$checkH5AgreementStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                RequestResultBridge requestResultBridge = RequestResultBridge.this;
                bridgeCallback = requestResultBridge.requestResultCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                requestResultBridge.failedResponse(bridgeCallback, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openNewUrl(String url, final String requestId) {
        BridgeCallback bridgeCallback = null;
        try {
            String obj = Uri.parse(url).buildUpon().appendQueryParameter("requestId", requestId).build().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            Map<String, BridgeCallback> map = this.callbackMap;
            BridgeCallback bridgeCallback2 = this.requestResultCallback;
            if (bridgeCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback2 = null;
            }
            map.put(requestId, bridgeCallback2);
            DanaH5.startContainerFullUrlWithSendCredentials$default(obj, new DanaH5Listener() { // from class: id.dana.danah5.RequestResultBridge$openNewUrl$1
                @Override // id.dana.utils.danah5.DanaH5Listener
                public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                    DanaH5Listener.CC.getAuthRequestContext();
                }

                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerDestroyed(Bundle bundle) {
                    Map map2;
                    map2 = RequestResultBridge.this.callbackMap;
                    BridgeCallback bridgeCallback3 = (BridgeCallback) map2.remove(requestId);
                    if (bridgeCallback3 != null) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = jSONObject;
                        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                        jSONObject2.put((JSONObject) "errorCode", (String) 3);
                        bridgeCallback3.sendJSONResponse(jSONObject);
                    }
                }
            }, null, null, 12, null);
        } catch (Exception unused) {
            BridgeCallback bridgeCallback3 = this.requestResultCallback;
            if (bridgeCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback3;
            }
            failedResponse(bridgeCallback, 2);
        }
    }

    private final String getUrlWithoutParameters(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String obj = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, null).toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failedResponse(BridgeCallback bridgeCallback, int i) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorCode", (String) Integer.valueOf(i));
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_requestResultRules_$lambda-0  reason: not valid java name */
    public static final Map m630_get_requestResultRules_$lambda0(BaseTrafficType baseTrafficType) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext("request_result_jsapi_rules", false);
        Object obj2 = null;
        if (Map.class.isAssignableFrom(JSONArray.class)) {
            obj2 = (Map) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else {
            if (authRequestContext != null) {
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) Map.class);
                } catch (Exception unused) {
                    obj = null;
                }
                if (obj != null) {
                    obj2 = obj;
                }
            }
            Intrinsics.checkNotNull(null);
        }
        return (Map) obj2;
    }
}
