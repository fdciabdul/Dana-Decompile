package id.dana.danah5.tracker;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.mixpanel.MixpanelBridge;
import id.dana.danah5.mixpanel.StrictBaseBridge;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/danah5/tracker/GeneralTrackEventBridge;", "Lid/dana/danah5/mixpanel/StrictBaseBridge;", "Lcom/alibaba/fastjson/JSONObject;", "properties", "", "addProperties", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "key", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", BridgeName.GENERAL_TRACK_EVENT, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onInitialized", "()V", "startTrack", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;", "errorStatus", "failed", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;)V", "Lid/dana/tracker/EventTrackerModel$Builder;", "eventTrackerModel", "Lid/dana/tracker/EventTrackerModel$Builder;", "getEventTrackerModel", "()Lid/dana/tracker/EventTrackerModel$Builder;", "setEventTrackerModel", "(Lid/dana/tracker/EventTrackerModel$Builder;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeneralTrackEventBridge extends StrictBaseBridge {
    public EventTrackerModel.Builder eventTrackerModel;

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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public final void generalTrackEvent(@BindingParam(name = {"key"}) String str, @BindingParam(name = {"properties"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        boolean z;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bridgeCallback, "");
            String str2 = str;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                z = false;
                if (!z || jSONObject == null) {
                    failed(bridgeCallback, MixpanelBridge.ErrorStatus.MISSING_REQUIRED_JSAPI_PARAM);
                } else if (jSONObject.isEmpty()) {
                    failed(bridgeCallback, MixpanelBridge.ErrorStatus.MISSING_REQUIRED_PROPERTIES);
                    return;
                } else {
                    EventTrackerModel.Builder builder = new EventTrackerModel.Builder(GriverEnv.getApplicationContext());
                    builder.MyBillsEntityDataFactory = str;
                    Intrinsics.checkNotNullExpressionValue(builder, "");
                    setEventTrackerModel(builder);
                    startTrack(jSONObject, bridgeCallback);
                    return;
                }
            }
            z = true;
            if (!z) {
            }
            failed(bridgeCallback, MixpanelBridge.ErrorStatus.MISSING_REQUIRED_JSAPI_PARAM);
        }
    }

    private final void startTrack(JSONObject properties, BridgeCallback callback) {
        addProperties(properties);
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = getEventTrackerModel().BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        callback.sendJSONResponse(jSONObject);
    }

    private final void addProperties(JSONObject properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                getEventTrackerModel().MyBillsEntityDataFactory(key, (String) value);
            } else if (value instanceof Integer) {
                EventTrackerModel.Builder eventTrackerModel = getEventTrackerModel();
                Intrinsics.checkNotNullExpressionValue(value, "");
                eventTrackerModel.PlaceComponentResult(key, ((Number) value).intValue());
            } else if (value instanceof Long ? true : value instanceof BigInteger) {
                Long longOrNull = StringsKt.toLongOrNull(value.toString());
                if (longOrNull != null) {
                    getEventTrackerModel().BuiltInFictitiousFunctionClassFactory(key, longOrNull.longValue());
                }
            } else if (value instanceof Float ? true : value instanceof Double) {
                Double doubleOrNull = StringsKt.toDoubleOrNull(value.toString());
                if (doubleOrNull != null) {
                    getEventTrackerModel().MyBillsEntityDataFactory(key, doubleOrNull.doubleValue());
                }
            } else if (value instanceof Boolean) {
                EventTrackerModel.Builder eventTrackerModel2 = getEventTrackerModel();
                Intrinsics.checkNotNullExpressionValue(value, "");
                eventTrackerModel2.BuiltInFictitiousFunctionClassFactory(key, ((Boolean) value).booleanValue());
            } else {
                getEventTrackerModel().MyBillsEntityDataFactory(key, value.toString());
            }
        }
    }

    private final void failed(BridgeCallback bridgeCallback, MixpanelBridge.ErrorStatus errorStatus) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", (String) Integer.valueOf(errorStatus.getCode()));
        jSONObject2.put((JSONObject) "errorMessage", errorStatus.getMessage());
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
