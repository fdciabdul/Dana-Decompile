package id.dana.danah5.suggestlocations;

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
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.here.AddressNotFoundException;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.nearbyplaces.interactor.GetListSuggestedLocations;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import id.dana.extension.lang.StringExtKt;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danah5/suggestlocations/SuggestLocationsBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "onInitialized", "()V", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", BridgeName.SUGGEST_LOCATIONS, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations;", "getListSuggestedLocations", "Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations;", "getGetListSuggestedLocations", "()Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations;", "setGetListSuggestedLocations", "(Lid/dana/domain/nearbyplaces/interactor/GetListSuggestedLocations;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SuggestLocationsBridge extends BaseBridge {
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LIMIT = "limit";
    private static final String KEY_LONG = "long";
    private static final String KEY_SOURCE = "source";
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public GetListSuggestedLocations getListSuggestedLocations;
    private static final List<String> BLACKLISTED_KEYWORDS = CollectionsKt.listOf("Jalan");

    @JvmName(name = "getGetListSuggestedLocations")
    public final GetListSuggestedLocations getGetListSuggestedLocations() {
        GetListSuggestedLocations getListSuggestedLocations = this.getListSuggestedLocations;
        if (getListSuggestedLocations != null) {
            return getListSuggestedLocations;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetListSuggestedLocations")
    public final void setGetListSuggestedLocations(GetListSuggestedLocations getListSuggestedLocations) {
        Intrinsics.checkNotNullParameter(getListSuggestedLocations, "");
        this.getListSuggestedLocations = getListSuggestedLocations;
    }

    @JvmName(name = "getDeviceInformationProvider")
    public final DeviceInformationProvider getDeviceInformationProvider() {
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            return deviceInformationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this);
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter(canOverride = false)
    public final void suggestLocations(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback final BridgeCallback bridgeCallback) {
        String obj;
        String obj2;
        Object obj3;
        String obj4;
        Object obj5;
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        String obj6 = (info == null || (obj5 = info.get("keyword")) == null) ? null : obj5.toString();
        Integer valueOf = (info == null || (obj3 = info.get("limit")) == null || (obj4 = obj3.toString()) == null) ? null : Integer.valueOf(Integer.parseInt(obj4));
        String str = obj6;
        if ((str == null || str.length() == 0) || valueOf == null) {
            bridgeCallback.sendJSONResponse(SuggestLocationsResponse.INSTANCE.error("PARAM_ILLEGAL"));
        } else if (StringExtKt.KClassImpl$Data$declaredNonStaticMembers$2(BLACKLISTED_KEYWORDS, obj6)) {
            bridgeCallback.sendJSONResponse(SuggestLocationsResponse.INSTANCE.error("KEYWORD_BLACKLISTED"));
        } else {
            Object obj7 = info.get("lat");
            Double valueOf2 = (obj7 == null || (obj2 = obj7.toString()) == null) ? null : Double.valueOf(Double.parseDouble(obj2));
            Object obj8 = info.get("long");
            Double valueOf3 = (obj8 == null || (obj = obj8.toString()) == null) ? null : Double.valueOf(Double.parseDouble(obj));
            Object obj9 = info.get("source");
            String obj10 = obj9 != null ? obj9.toString() : null;
            String deviceUUID = getDeviceInformationProvider().getDeviceUUID();
            Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
            getGetListSuggestedLocations().execute(new GetListSuggestedLocations.Params(deviceUUID, obj6, valueOf.intValue(), valueOf2, valueOf3, obj10), new Function1<List<? extends SuggestedLocation>, Unit>() { // from class: id.dana.danah5.suggestlocations.SuggestLocationsBridge$suggestLocations$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends SuggestedLocation> list) {
                    invoke2((List<SuggestedLocation>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<SuggestedLocation> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    BridgeCallback.this.sendJSONResponse(SuggestLocationsResponse.INSTANCE.success(list));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.suggestlocations.SuggestLocationsBridge$suggestLocations$2
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
                    JSONObject error;
                    Intrinsics.checkNotNullParameter(th, "");
                    if (th instanceof AddressNotFoundException) {
                        error = SuggestLocationsResponse.INSTANCE.error("LOCATIONS_NOT_FOUND");
                    } else {
                        error = SuggestLocationsResponse.INSTANCE.error("UNKNOWN_ERROR");
                    }
                    BridgeCallback.this.sendJSONResponse(error);
                }
            });
        }
    }
}
