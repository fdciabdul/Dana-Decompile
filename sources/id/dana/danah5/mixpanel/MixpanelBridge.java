package id.dana.danah5.mixpanel;

import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.DanaH5;
import id.dana.danah5.H5ExtKt;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.mixpanel.MixpanelBridge;
import id.dana.danah5.mixpanel.model.JSApiStatus;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.interactor.GetService;
import id.dana.passkey.Passkey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.functions.Function;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b:\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f0\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u001a\u001a\u00020\u00122\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010 J3\u0010'\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b'\u0010(R\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00028\u0002X\u0083D¢\u0006\u0006\n\u0004\b5\u00106R8\u00109\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f0\f0\f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108"}, d2 = {"Lid/dana/danah5/mixpanel/MixpanelBridge;", "Lid/dana/danah5/mixpanel/StrictBaseBridge;", "", "dataType", "", "propertyValue", "propertyKey", "", "checkDataType", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Z", "Lcom/alibaba/fastjson/JSONObject;", "properties", "", "splitEvent", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", "checkPropertyRequirements", "(Lcom/alibaba/fastjson/JSONObject;Ljava/util/Map;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Z", "", "onInitialized", "()V", "Lcom/alibaba/ariver/app/api/Page;", "page", "startTrack", "(Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "key", BridgeName.TRACK_EVENT, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "appId", "Lid/dana/tracker/EventTrackerModel$Builder;", "eventTrackerModel", "trackEventByAppId", "(Ljava/lang/String;Lid/dana/tracker/EventTrackerModel$Builder;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", DanaH5.SERVICE_KEY, "trackEventByServiceKey", "Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;", "errorStatus", "property", "type", "failed", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/tracker/EventTrackerModel$Builder;", "getEventTrackerModel", "()Lid/dana/tracker/EventTrackerModel$Builder;", "setEventTrackerModel", "(Lid/dana/tracker/EventTrackerModel$Builder;)V", "Lid/dana/domain/services/interactor/GetService;", "getService", "Lid/dana/domain/services/interactor/GetService;", "getGetService", "()Lid/dana/domain/services/interactor/GetService;", "setGetService", "(Lid/dana/domain/services/interactor/GetService;)V", RecordError.KEY_JSAPI_NAME, "Ljava/lang/String;", "getSplitEventRules", "()Ljava/util/Map;", "splitEventRules", "<init>", "ErrorStatus"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MixpanelBridge extends StrictBaseBridge {
    public EventTrackerModel.Builder eventTrackerModel;
    @Inject
    public GetService getService;
    private final String jsapiName = BridgeName.TRACK_EVENT;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JSApiStatus.values().length];
            iArr[JSApiStatus.ENABLED.ordinal()] = 1;
            iArr[JSApiStatus.DISABLED.ordinal()] = 2;
            iArr[JSApiStatus.NOT_WHITELIST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
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

    @JvmName(name = "getEventTrackerModel")
    public final EventTrackerModel.Builder getEventTrackerModel() {
        EventTrackerModel.Builder builder = this.eventTrackerModel;
        if (builder != null) {
            return builder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setEventTrackerModel")
    public final void setEventTrackerModel(EventTrackerModel.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        this.eventTrackerModel = builder;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }

    @JvmName(name = "getSplitEventRules")
    private final Map<String, Map<String, Map<String, Object>>> getSplitEventRules() {
        Object blockingFirst = getSplitFacade().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.mixpanel.MixpanelBridge$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map m703_get_splitEventRules_$lambda0;
                m703_get_splitEventRules_$lambda0 = MixpanelBridge.m703_get_splitEventRules_$lambda0((BaseTrafficType) obj);
                return m703_get_splitEventRules_$lambda0;
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (Map) blockingFirst;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public final void trackEvent(@BindingParam(name = {"key"}) String key, @BindingParam(name = {"properties"}) JSONObject properties, @BindingCallback BridgeCallback callback, @BindingNode(Page.class) Page page) {
        boolean z;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(callback, "");
            Intrinsics.checkNotNullParameter(page, "");
            String str = key;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
                if (!z || properties == null) {
                    failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_JSAPI_PARAM, null, null, 6, null);
                }
                Map<String, Map<String, Object>> map = getSplitEventRules().get(key);
                if (map == null) {
                    failed$default(this, callback, ErrorStatus.INVALID_KEY_EVENT, null, null, 6, null);
                    return;
                } else if (properties.isEmpty()) {
                    failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_PROPERTIES, null, null, 6, null);
                    return;
                } else {
                    EventTrackerModel.Builder builder = new EventTrackerModel.Builder(GriverEnv.getApplicationContext());
                    builder.MyBillsEntityDataFactory = key;
                    Intrinsics.checkNotNullExpressionValue(builder, "");
                    setEventTrackerModel(builder);
                    if (checkPropertyRequirements(properties, map, callback)) {
                        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
                            String key2 = entry.getKey();
                            Map<String, Object> value = entry.getValue();
                            if (value.get(Passkey.REQUIRED) == null) {
                                failed$default(this, callback, ErrorStatus.GENERAL_ERROR, key2, null, 4, null);
                                return;
                            } else if (Intrinsics.areEqual(value.get(Passkey.REQUIRED), Boolean.TRUE) && !properties.keySet().contains(key2)) {
                                failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_PROPERTIES, key2, null, 4, null);
                                return;
                            }
                        }
                        startTrack(page, callback);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (!z) {
            }
            failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_JSAPI_PARAM, null, null, 6, null);
        }
    }

    private final boolean checkPropertyRequirements(JSONObject properties, Map<String, ? extends Map<String, ? extends Object>> splitEvent, BridgeCallback callback) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Map<String, ? extends Object> map = splitEvent.get(key);
            boolean areEqual = map != null ? Intrinsics.areEqual(map.get(Passkey.REQUIRED), Boolean.TRUE) : false;
            Map<String, ? extends Object> map2 = splitEvent.get(key);
            String valueOf = String.valueOf(map2 != null ? map2.get("type") : null);
            if (!splitEvent.keySet().contains(key)) {
                failed$default(this, callback, ErrorStatus.INVALID_PROPERTIES, key, null, 4, null);
                return false;
            } else if (areEqual && (value == null || ((value instanceof String) && StringsKt.isBlank((CharSequence) value)))) {
                failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_PROPERTIES, key, null, 4, null);
                return false;
            } else {
                try {
                    Intrinsics.checkNotNullExpressionValue(key, "");
                    if (!checkDataType(valueOf, value, key)) {
                        failed(callback, ErrorStatus.WRONG_DATA_TYPE, key, valueOf);
                        return false;
                    }
                } catch (Exception unused) {
                    failed$default(this, callback, ErrorStatus.GENERAL_ERROR, null, null, 6, null);
                    return false;
                }
            }
        }
        return true;
    }

    private final void startTrack(Page page, BridgeCallback callback) {
        int i = WhenMappings.$EnumSwitchMapping$0[canUse(this.jsapiName, page).ordinal()];
        if (i == 1) {
            if (H5ExtKt.getAppId(page) != null) {
                trackEventByAppId(H5ExtKt.getAppId(page), getEventTrackerModel(), callback);
            } else {
                trackEventByServiceKey(H5ExtKt.getServiceKey(page), getEventTrackerModel(), callback);
            }
        } else if (i == 2) {
            failed$default(this, callback, ErrorStatus.JSAPI_DISABLED, null, null, 6, null);
        } else if (i == 3) {
            failed$default(this, callback, ErrorStatus.JSAPI_NOT_WHITELISTED, null, null, 6, null);
        }
    }

    private final void trackEventByServiceKey(final String serviceKey, final EventTrackerModel.Builder eventTrackerModel, final BridgeCallback callback) {
        if (serviceKey != null) {
            getGetService().execute(serviceKey, new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.danah5.mixpanel.MixpanelBridge$trackEventByServiceKey$1
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
                    Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                    EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = EventTrackerModel.Builder.this.MyBillsEntityDataFactory("Service Key", serviceKey).MyBillsEntityDataFactory(TrackerKey.MixpanelProperties.CLIENT_ID, thirdPartyServiceResponse.getClientId()).MyBillsEntityDataFactory("App ID", thirdPartyServiceResponse.getAppId()).BuiltInFictitiousFunctionClassFactory();
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                    EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
                    BridgeCallback bridgeCallback = callback;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.mixpanel.MixpanelBridge$trackEventByServiceKey$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Intrinsics.checkNotNullParameter(th, "");
                    MixpanelBridge.failed$default(MixpanelBridge.this, callback, MixpanelBridge.ErrorStatus.GENERAL_ERROR, null, null, 6, null);
                }
            });
        } else {
            failed$default(this, callback, ErrorStatus.MISSING_REQUIRED_JSAPI_PARAM, null, null, 6, null);
        }
    }

    private final void trackEventByAppId(String appId, EventTrackerModel.Builder eventTrackerModel, BridgeCallback callback) {
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = eventTrackerModel.MyBillsEntityDataFactory("App ID", appId).BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        callback.sendJSONResponse(jSONObject);
    }

    private final boolean checkDataType(String dataType, Object propertyValue, String propertyKey) {
        Double doubleOrNull;
        Long longOrNull;
        switch (dataType.hashCode()) {
            case -1653751294:
                if (dataType.equals("fraction")) {
                    if (((propertyValue instanceof Float) || (propertyValue instanceof Double) || (((propertyValue instanceof BigDecimal) && ((BigDecimal) propertyValue).scale() > 0) || (propertyValue instanceof Integer) || (propertyValue instanceof Long) || (propertyValue instanceof BigInteger))) && (doubleOrNull = StringsKt.toDoubleOrNull(propertyValue.toString())) != null) {
                        getEventTrackerModel().MyBillsEntityDataFactory(propertyKey, doubleOrNull.doubleValue());
                        return true;
                    }
                    return false;
                }
                break;
            case 3556653:
                if (dataType.equals("text")) {
                    if (propertyValue instanceof String) {
                        getEventTrackerModel().MyBillsEntityDataFactory(propertyKey, (String) propertyValue);
                        return true;
                    }
                    return false;
                }
                break;
            case 64711720:
                if (dataType.equals("boolean")) {
                    return propertyValue instanceof Boolean;
                }
                break;
            case 1958052158:
                if (dataType.equals("integer")) {
                    if (propertyValue instanceof Integer) {
                        getEventTrackerModel().PlaceComponentResult(propertyKey, ((Number) propertyValue).intValue());
                        return true;
                    } else if (((propertyValue instanceof Long) || (propertyValue instanceof BigInteger)) && (longOrNull = StringsKt.toLongOrNull(propertyValue.toString())) != null) {
                        getEventTrackerModel().BuiltInFictitiousFunctionClassFactory(propertyKey, longOrNull.longValue());
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
        }
        throw new Exception("Data Type Not Found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void failed$default(MixpanelBridge mixpanelBridge, BridgeCallback bridgeCallback, ErrorStatus errorStatus, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        mixpanelBridge.failed(bridgeCallback, errorStatus, str, str2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016"}, d2 = {"Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "GENERAL_ERROR", "UNABLE_ACCESS_JSAPI", "JSAPI_DISABLED", "JSAPI_NOT_WHITELISTED", "MISSING_REQUIRED_PROPERTIES", "INVALID_PROPERTIES", "WRONG_DATA_TYPE", "MISSING_REQUIRED_JSAPI_PARAM", "INVALID_KEY_EVENT"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public enum ErrorStatus {
        GENERAL_ERROR(1, "General Error"),
        UNABLE_ACCESS_JSAPI(2, "Unable Access JSAPI"),
        JSAPI_DISABLED(2, "JSAPI is disabled"),
        JSAPI_NOT_WHITELISTED(2, "JSAPI is not whitelisted to this mini program"),
        MISSING_REQUIRED_PROPERTIES(3, "Missing Required Properties"),
        INVALID_PROPERTIES(4, "Invalid Properties"),
        WRONG_DATA_TYPE(5, "Wrong Data Type"),
        MISSING_REQUIRED_JSAPI_PARAM(6, "Missing Required Data"),
        INVALID_KEY_EVENT(7, "Invalid Key Event");

        private final int code;
        private final String message;

        ErrorStatus(int i, String str) {
            this.code = i;
            this.message = str;
        }

        @JvmName(name = "getCode")
        public final int getCode() {
            return this.code;
        }

        @JvmName(name = "getMessage")
        public final String getMessage() {
            return this.message;
        }
    }

    private final void failed(BridgeCallback bridgeCallback, ErrorStatus errorStatus, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", (String) Integer.valueOf(errorStatus.getCode()));
        String message = errorStatus.getMessage();
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(message);
            sb.append(" (");
            sb.append(str);
            sb.append(").");
            message = sb.toString();
        }
        if (str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(message);
            sb2.append(" Expected ");
            sb2.append(str2);
            message = sb2.toString();
        }
        jSONObject2.put((JSONObject) "errorMessage", message);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_splitEventRules_$lambda-0  reason: not valid java name */
    public static final Map m703_get_splitEventRules_$lambda0(BaseTrafficType baseTrafficType) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext("mixpanel_jsapi_event_rules", false);
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
