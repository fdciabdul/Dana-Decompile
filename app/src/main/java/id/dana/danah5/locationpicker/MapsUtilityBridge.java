package id.dana.danah5.locationpicker;

import android.app.Application;
import android.content.Intent;
import android.os.Parcelable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.core.ui.util.OSUtil;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity;
import id.dana.danah5.locationpicker.enums.MapUtilityEvent;
import id.dana.danah5.locationpicker.model.MapPageResponseGenerator;
import id.dana.danah5.locationpicker.model.MapPageResult;
import id.dana.danah5.locationpicker.model.PickLocationResponse;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b4\u0010\u001dJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u00020\u00102\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b \u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0012J'\u0010%\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010\u0012J\u0015\u0010'\u001a\u0004\u0018\u00010&*\u00020\nH\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0014\u0010+\u001a\u00020*8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103"}, d2 = {"Lid/dana/danah5/locationpicker/MapsUtilityBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "lat", "long", "name", "details", "Lid/dana/danah5/locationpicker/model/PickLocationResponse;", "assamblePickLocationInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/locationpicker/model/PickLocationResponse;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/app/api/Page;", "page", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "handleMapsUtility", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", BridgeName.MAP_UTILITY, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onInitialized", "()V", "processMapPageResult", "(ILandroid/content/Intent;)V", "processPickLocationResult", "errorCode", "setErrorCodeResult", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;)V", "startMapPageEvent", "startPickLocationEvent", "Lid/dana/domain/globalsearch/model/LatLng;", "getLatLng", "(Lcom/alibaba/fastjson/JSONObject;)Lid/dana/domain/globalsearch/model/LatLng;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "", "isFeatureEnabled", "()Z", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "getSplitFacade", "()Lid/dana/data/toggle/SplitFacade;", "setSplitFacade", "(Lid/dana/data/toggle/SplitFacade;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MapsUtilityBridge extends BaseBridge {
    private static final String ERROR_CODE_FEATURE_DISABLED = "500";
    private static final String ERROR_CODE_MISSING_EVENT = "420";
    private static final String ERROR_CODE_MISSING_INFO = "410";
    private static final String ERROR_CODE_MISSING_TITLE = "430";
    private static final String ERROR_CODE_NOT_SUPPORTED = "421";
    private static final String ERROR_CODE_PICK_LOCATION_CANCELLED_BY_USER = "400";
    private BridgeCallback bridgeCallback;
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
    public final void mapUtility(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        if (info != null) {
            handleMapsUtility(info, page, bridgeCallback);
        } else {
            setErrorCodeResult(bridgeCallback, ERROR_CODE_MISSING_INFO);
        }
    }

    private final void handleMapsUtility(JSONObject info, Page page, BridgeCallback bridgeCallback) {
        if (!isFeatureEnabled()) {
            setErrorCodeResult(bridgeCallback, ERROR_CODE_FEATURE_DISABLED);
            return;
        }
        Object obj = info.get("event");
        if (Intrinsics.areEqual(obj, MapUtilityEvent.PICK_LOCATION.invoke())) {
            startPickLocationEvent(info, page, bridgeCallback);
            return;
        }
        if (!Intrinsics.areEqual(obj, MapUtilityEvent.CURRENT_LOCATION.invoke())) {
            if (Intrinsics.areEqual(obj, MapUtilityEvent.MAP_PAGE.invoke())) {
                startMapPageEvent(info, page, bridgeCallback);
                return;
            } else if (obj == null) {
                setErrorCodeResult(bridgeCallback, ERROR_CODE_MISSING_EVENT);
                return;
            }
        }
        setErrorCodeResult(bridgeCallback, ERROR_CODE_NOT_SUPPORTED);
    }

    private final void startPickLocationEvent(JSONObject info, Page page, BridgeCallback bridgeCallback) {
        LatLng monas;
        if (info.get("title") != null) {
            if (info.containsKey("lat") && info.containsKey("long")) {
                monas = new LatLng(Double.parseDouble(String.valueOf(info.get("lat"))), Double.parseDouble(String.valueOf(info.get("long"))));
            } else {
                monas = LatLng.INSTANCE.monas();
            }
            BuildersKt__Builders_commonKt.launch$default(getUiScope(), null, null, new MapsUtilityBridge$startPickLocationEvent$1(page, info, monas, this, null), 3, null);
            return;
        }
        setErrorCodeResult(bridgeCallback, ERROR_CODE_MISSING_TITLE);
    }

    private final void startMapPageEvent(JSONObject info, Page page, BridgeCallback bridgeCallback) {
        BuildersKt__Builders_commonKt.launch$default(getUiScope(), null, null, new MapsUtilityBridge$startMapPageEvent$1(page, getLatLng(info), this, null), 3, null);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            processPickLocationResult(resultCode, data);
        } else if (requestCode == 200) {
            processMapPageResult(resultCode, data);
        }
    }

    private final void processMapPageResult(int resultCode, Intent data) {
        JSONObject generate;
        MapPageResult mapPageResult;
        Parcelable parcelable;
        BridgeCallback bridgeCallback = null;
        if (resultCode == -1) {
            String stringExtra = data != null ? data.getStringExtra(MapPageActivity.KEY_CHOICE) : null;
            if (data != null) {
                OSUtil oSUtil = OSUtil.INSTANCE;
                if (OSUtil.PlaceComponentResult()) {
                    parcelable = (Parcelable) data.getParcelableExtra(MapPageActivity.KEY_RESULT, MapPageResult.class);
                } else {
                    Parcelable parcelableExtra = data.getParcelableExtra(MapPageActivity.KEY_RESULT);
                    if (!(parcelableExtra instanceof MapPageResult)) {
                        parcelableExtra = null;
                    }
                    parcelable = (MapPageResult) parcelableExtra;
                }
                mapPageResult = (MapPageResult) parcelable;
            } else {
                mapPageResult = null;
            }
            generate = MapPageResponseGenerator.INSTANCE.generate(stringExtra, mapPageResult);
        } else {
            generate = MapPageResponseGenerator.INSTANCE.generate(null, null);
        }
        BridgeCallback bridgeCallback2 = this.bridgeCallback;
        if (bridgeCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback2;
        }
        bridgeCallback.sendJSONResponse(generate);
    }

    private final LatLng getLatLng(JSONObject jSONObject) {
        if (jSONObject.containsKey("lat") && jSONObject.containsKey("long")) {
            return new LatLng(Double.parseDouble(String.valueOf(jSONObject.get("lat"))), Double.parseDouble(String.valueOf(jSONObject.get("long"))));
        }
        return null;
    }

    private final void setErrorCodeResult(BridgeCallback bridgeCallback, String errorCode) {
        Object json = JSON.toJSON(new PickLocationResponse(false, null, errorCode));
        if (json == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        }
        bridgeCallback.sendJSONResponse((JSONObject) json);
    }

    private final PickLocationResponse assamblePickLocationInfo(String lat, String r3, String name, String details) {
        return new PickLocationResponse(true, new PickLocationResponse.LocationResult(lat, r3, name, details), "");
    }

    @JvmName(name = "isFeatureEnabled")
    private final boolean isFeatureEnabled() {
        Object blockingFirst = getSplitFacade().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.locationpicker.MapsUtilityBridge$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m684_get_isFeatureEnabled_$lambda1;
                m684_get_isFeatureEnabled_$lambda1 = MapsUtilityBridge.m684_get_isFeatureEnabled_$lambda1((BaseTrafficType) obj);
                return m684_get_isFeatureEnabled_$lambda1;
            }
        }).onErrorReturnItem(Boolean.FALSE).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return ((Boolean) blockingFirst).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_isFeatureEnabled_$lambda-1  reason: not valid java name */
    public static final Boolean m684_get_isFeatureEnabled_$lambda1(BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        return Boolean.valueOf(BaseTrafficType.getAuthRequestContext(baseTrafficType, "feature_miniprogram_map_utility", false, 6));
    }

    private final void processPickLocationResult(int resultCode, Intent data) {
        MiniProgramLocationPickerActivity.Place place;
        Parcelable parcelable;
        BridgeCallback bridgeCallback = null;
        if (resultCode != -1) {
            BridgeCallback bridgeCallback2 = this.bridgeCallback;
            if (bridgeCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback2;
            }
            setErrorCodeResult(bridgeCallback, ERROR_CODE_PICK_LOCATION_CANCELLED_BY_USER);
            return;
        }
        if (data != null) {
            OSUtil oSUtil = OSUtil.INSTANCE;
            if (OSUtil.PlaceComponentResult()) {
                parcelable = (Parcelable) data.getParcelableExtra("result", MiniProgramLocationPickerActivity.Place.class);
            } else {
                Parcelable parcelableExtra = data.getParcelableExtra("result");
                if (!(parcelableExtra instanceof MiniProgramLocationPickerActivity.Place)) {
                    parcelableExtra = null;
                }
                parcelable = (MiniProgramLocationPickerActivity.Place) parcelableExtra;
            }
            place = (MiniProgramLocationPickerActivity.Place) parcelable;
        } else {
            place = null;
        }
        if (place != null) {
            Object json = JSON.toJSON(assamblePickLocationInfo(String.valueOf(place.getLocation().getLatitude()), String.valueOf(place.getLocation().getLongitude()), place.getName(), place.getAddress()));
            if (json == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            }
            JSONObject jSONObject = (JSONObject) json;
            BridgeCallback bridgeCallback3 = this.bridgeCallback;
            if (bridgeCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback3;
            }
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }
}
