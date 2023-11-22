package id.dana.danah5.location;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.DefaultObserver;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\n2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/location/GetLocationNameBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "createObserver", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Lid/dana/domain/DefaultObserver;", "Lcom/alibaba/fastjson/JSONObject;", "info", "", BridgeName.LOCATION_NAME, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onFinalized", "()V", "onInitialized", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "getIndoSubdivisionsByLocation", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "getGetIndoSubdivisionsByLocation", "()Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "setGetIndoSubdivisionsByLocation", "(Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetLocationNameBridge extends BaseBridge {
    public static final String PARAM_KEY_LATITUDE = "lat";
    public static final String PARAM_KEY_LONGITUTE = "long";
    public static final String PARAM_KEY_SOURCE = "source";
    public static final String RESPONSE_KEY_DATA = "data";
    @Inject
    public GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation;

    @JvmName(name = "getGetIndoSubdivisionsByLocation")
    public final GetIndoSubdivisionsByLocation getGetIndoSubdivisionsByLocation() {
        GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation = this.getIndoSubdivisionsByLocation;
        if (getIndoSubdivisionsByLocation != null) {
            return getIndoSubdivisionsByLocation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetIndoSubdivisionsByLocation")
    public final void setGetIndoSubdivisionsByLocation(GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation) {
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        this.getIndoSubdivisionsByLocation = getIndoSubdivisionsByLocation;
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

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        getGetIndoSubdivisionsByLocation().dispose();
        super.onFinalized();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if ((r6 == null || r6.length() == 0) == false) goto L21;
     */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.NETWORK)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter(canOverride = false)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void locationName(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"info"}) com.alibaba.fastjson.JSONObject r18, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r4 = 0
            if (r1 == 0) goto L88
            java.lang.String r5 = "lat"
            java.lang.String r6 = r1.getString(r5)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L22
            int r6 = r6.length()
            if (r6 == 0) goto L22
            r6 = 0
            goto L23
        L22:
            r6 = 1
        L23:
            java.lang.String r9 = "long"
            if (r6 != 0) goto L3b
            java.lang.String r6 = r1.getString(r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L37
            int r6 = r6.length()
            if (r6 == 0) goto L37
            r6 = 0
            goto L38
        L37:
            r6 = 1
        L38:
            if (r6 != 0) goto L3b
            goto L3c
        L3b:
            r7 = 0
        L3c:
            if (r7 != 0) goto L3f
            r1 = r4
        L3f:
            if (r1 == 0) goto L88
            java.lang.String r4 = r1.getString(r5)
            java.lang.String r1 = r1.getString(r9)
            id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation r5 = r17.getGetIndoSubdivisionsByLocation()
            id.dana.domain.DefaultObserver r6 = r0.createObserver(r2)
            io.reactivex.observers.DisposableObserver r6 = (io.reactivex.observers.DisposableObserver) r6
            id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation$Params$Companion r7 = id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation.Params.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            double r8 = java.lang.Double.parseDouble(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            double r10 = java.lang.Double.parseDouble(r1)
            android.location.Location r8 = id.dana.utils.LocationUtil.PlaceComponentResult(r8, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            id.dana.domain.tracker.HereMixPanelTrackerData r1 = new id.dana.domain.tracker.HereMixPanelTrackerData
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 30
            r16 = 0
            java.lang.String r10 = "JSAPI (LocationName)"
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r9 = 0
            r10 = 0
            r13 = 22
            r11 = r1
            id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation$Params r1 = id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation.Params.Companion.forLocation$default(r7, r8, r9, r10, r11, r12, r13, r14)
            r5.execute(r6, r1)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L88:
            if (r4 != 0) goto L92
            r1 = r0
            id.dana.danah5.location.GetLocationNameBridge r1 = (id.dana.danah5.location.GetLocationNameBridge) r1
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r1 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.INVALID_PARAM
            r2.sendBridgeResponse(r1)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.location.GetLocationNameBridge.locationName(com.alibaba.fastjson.JSONObject, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    private final DefaultObserver<IndoSubdivisions> createObserver(final BridgeCallback bridgeCallback) {
        return new DefaultObserver<IndoSubdivisions>() { // from class: id.dana.danah5.location.GetLocationNameBridge$createObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(IndoSubdivisions indoSubdivisions) {
                Intrinsics.checkNotNullParameter(indoSubdivisions, "");
                JSONObject jSONObject = BridgeResponse.SUCCESS.get();
                jSONObject.put("data", (Object) indoSubdivisions);
                BridgeCallback.this.sendJSONResponse(jSONObject);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "");
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(e.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.JS_BRIDGE_TAG, sb.toString(), e);
            }
        };
    }
}
