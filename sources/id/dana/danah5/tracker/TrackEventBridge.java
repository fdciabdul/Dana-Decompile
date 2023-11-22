package id.dana.danah5.tracker;

import android.view.ViewConfiguration;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.common.env.GriverEnv;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.mixpanel.MixpanelBridge;
import id.dana.danah5.mixpanel.StrictBaseBridge;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\u00020\u00042\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/tracker/TrackEventBridge;", "Lid/dana/danah5/mixpanel/StrictBaseBridge;", "Lcom/alibaba/fastjson/JSONObject;", "properties", "", "addProperties", "(Lcom/alibaba/fastjson/JSONObject;)V", "onInitialized", "()V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", "startTrack", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "key", BridgeName.TRACK_EVENT_H5, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;", "errorStatus", "failed", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;)V", "Lid/dana/tracker/EventTrackerModel$Builder;", "eventTrackerModel", "Lid/dana/tracker/EventTrackerModel$Builder;", "getEventTrackerModel", "()Lid/dana/tracker/EventTrackerModel$Builder;", "setEventTrackerModel", "(Lid/dana/tracker/EventTrackerModel$Builder;)V", "", "getFeatureTrackEvent", "()Z", "featureTrackEvent", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TrackEventBridge extends StrictBaseBridge {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static boolean MyBillsEntityDataFactory = false;
    private static int PlaceComponentResult = 0;
    public static final String SOURCE_H5 = "H5";
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;
    public EventTrackerModel.Builder eventTrackerModel;

    /* renamed from: $r8$lambda$PFljY89EWitOE8EQHU4tmAT-7X8 */
    public static /* synthetic */ Boolean m723$r8$lambda$PFljY89EWitOE8EQHU4tmAT7X8(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 125;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        Boolean m724_get_featureTrackEvent_$lambda0 = m724_get_featureTrackEvent_$lambda0(baseTrafficType);
        if (!z) {
            int i2 = 97 / 0;
        }
        return m724_get_featureTrackEvent_$lambda0;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = PlaceComponentResult + 119;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'G' : (char) 5) != 5) {
            defaultConstructorMarker.hashCode();
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{39472, 39475, 39479, 39458, 39459, 39460, 39481, 39477, 39469, 39456, 39464, 39886, 39907};
        MyBillsEntityDataFactory = true;
        BuiltInFictitiousFunctionClassFactory = true;
        getAuthRequestContext = 909155222;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0020, code lost:
    
        if ((r1 == null) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x002d, code lost:
    
        if ((r1 == null) != true) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x002f, code lost:
    
        r0 = id.dana.danah5.tracker.TrackEventBridge.lookAheadTest + 37;
        id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x003b, code lost:
    
        if ((r0 % 2) == 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x003d, code lost:
    
        r0 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0040, code lost:
    
        r0 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0042, code lost:
    
        if (r0 == 16) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0044, code lost:
    
        r0 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0048, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0049, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x004a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x004b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0050, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getEventTrackerModel")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.tracker.EventTrackerModel.Builder getEventTrackerModel() {
        /*
            r5 = this;
            int r0 = id.dana.danah5.tracker.TrackEventBridge.lookAheadTest
            r1 = 11
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult = r2
            int r0 = r0 % 2
            r2 = 74
            if (r0 == 0) goto L10
            goto L12
        L10:
            r1 = 74
        L12:
            r0 = 0
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L27
            id.dana.tracker.EventTrackerModel$Builder r1 = r5.eventTrackerModel     // Catch: java.lang.Exception -> L25
            r4.hashCode()     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L1f
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 == 0) goto L2f
            goto L4b
        L23:
            r0 = move-exception
            throw r0
        L25:
            r0 = move-exception
            goto L51
        L27:
            id.dana.tracker.EventTrackerModel$Builder r1 = r5.eventTrackerModel     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L2c
            goto L2d
        L2c:
            r0 = 1
        L2d:
            if (r0 == r3) goto L4b
        L2f:
            int r0 = id.dana.danah5.tracker.TrackEventBridge.lookAheadTest     // Catch: java.lang.Exception -> L49
            int r0 = r0 + 37
            int r2 = r0 % 128
            id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L49
            int r0 = r0 % 2
            r2 = 16
            if (r0 == 0) goto L40
            r0 = 58
            goto L42
        L40:
            r0 = 16
        L42:
            if (r0 == r2) goto L48
            int r0 = r4.length     // Catch: java.lang.Throwable -> L46
            goto L48
        L46:
            r0 = move-exception
            throw r0
        L48:
            return r1
        L49:
            r0 = move-exception
            throw r0
        L4b:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r4
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.tracker.TrackEventBridge.getEventTrackerModel():id.dana.tracker.EventTrackerModel$Builder");
    }

    @JvmName(name = "setEventTrackerModel")
    public final void setEventTrackerModel(EventTrackerModel.Builder builder) {
        int i = lookAheadTest + 49;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(builder, "");
        this.eventTrackerModel = builder;
        int i3 = lookAheadTest + 125;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '2' : 'S') != 'S') {
            Object obj = null;
            obj.hashCode();
        }
    }

    @JvmName(name = "getFeatureTrackEvent")
    private final boolean getFeatureTrackEvent() {
        Object blockingFirst = getSplitFacade().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.tracker.TrackEventBridge$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TrackEventBridge.m723$r8$lambda$PFljY89EWitOE8EQHU4tmAT7X8((BaseTrafficType) obj);
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        boolean booleanValue = ((Boolean) blockingFirst).booleanValue();
        int i = PlaceComponentResult + 97;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? (char) 31 : 'S') != 31) {
            return booleanValue;
        }
        Object obj = null;
        obj.hashCode();
        return booleanValue;
    }

    /* renamed from: _get_featureTrackEvent_$lambda-0 */
    private static final Boolean m724_get_featureTrackEvent_$lambda0(BaseTrafficType baseTrafficType) {
        Object obj;
        int i = lookAheadTest + 5;
        PlaceComponentResult = i % 128;
        Object obj2 = null;
        if ((i % 2 != 0 ? '2' : JSONLexer.EOI) != 26) {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr = new Object[1];
            a(121 / (ViewConfiguration.getTouchSlop() << 69), new byte[]{-115, -116, -124, -117, -126, -118, -126, -121, -119, -120, -125, -122, -124, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
            obj = objArr[0];
        } else {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getTouchSlop() >> 8) + 127, new byte[]{-115, -116, -124, -117, -126, -118, -126, -121, -119, -120, -125, -122, -124, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr2);
            obj = objArr2[0];
        }
        Boolean valueOf = Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) obj).intern(), false, false));
        int i2 = PlaceComponentResult + 39;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 == 0 ? '@' : InputCardNumberView.DIVIDER) != '@') {
            return valueOf;
        }
        obj2.hashCode();
        return valueOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0073, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x001e, code lost:
    
        if (r3 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x002f, code lost:
    
        if (r3 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0031, code lost:
    
        r0.PlaceComponentResult = (id.dana.di.component.ApplicationComponent) dagger.internal.Preconditions.getAuthRequestContext(((id.dana.DanaApplication) r3).getApplicationComponent());
        r0.getAuthRequestContext = (id.dana.di.modules.GContainerModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.GContainerModule());
        r0.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(r5);
        r0 = id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult + 1;
        id.dana.danah5.tracker.TrackEventBridge.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005e, code lost:
    
        if ((r0 % 2) != 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0060, code lost:
    
        r0 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0063, code lost:
    
        r0 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0065, code lost:
    
        if (r0 == 'Y') goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0067, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0068, code lost:
    
        return;
     */
    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onInitialized() {
        /*
            r5 = this;
            int r0 = id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.danah5.tracker.TrackEventBridge.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r2 = 0
            if (r0 == 0) goto L23
            super.onInitialized()
            id.dana.di.component.DaggerGContainerComponent$Builder r0 = id.dana.di.component.DaggerGContainerComponent.PlaceComponentResult()     // Catch: java.lang.Exception -> L21
            android.app.Application r3 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()     // Catch: java.lang.Exception -> L21
            if (r3 == 0) goto L6c
            goto L31
        L21:
            r0 = move-exception
            throw r0
        L23:
            super.onInitialized()
            id.dana.di.component.DaggerGContainerComponent$Builder r0 = id.dana.di.component.DaggerGContainerComponent.PlaceComponentResult()
            android.app.Application r3 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()
            int r4 = r2.length     // Catch: java.lang.Throwable -> L74
            if (r3 == 0) goto L6c
        L31:
            id.dana.DanaApplication r3 = (id.dana.DanaApplication) r3
            id.dana.di.component.ApplicationComponent r3 = r3.getApplicationComponent()
            java.lang.Object r3 = dagger.internal.Preconditions.getAuthRequestContext(r3)
            id.dana.di.component.ApplicationComponent r3 = (id.dana.di.component.ApplicationComponent) r3
            r0.PlaceComponentResult = r3
            id.dana.di.modules.GContainerModule r3 = new id.dana.di.modules.GContainerModule
            r3.<init>()
            java.lang.Object r3 = dagger.internal.Preconditions.getAuthRequestContext(r3)
            id.dana.di.modules.GContainerModule r3 = (id.dana.di.modules.GContainerModule) r3
            r0.getAuthRequestContext = r3
            id.dana.di.component.GContainerComponent r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2()
            r0.BuiltInFictitiousFunctionClassFactory(r5)
            int r0 = id.dana.danah5.tracker.TrackEventBridge.PlaceComponentResult
            int r0 = r0 + r1
            int r1 = r0 % 128
            id.dana.danah5.tracker.TrackEventBridge.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 89
            if (r0 != 0) goto L63
            r0 = 67
            goto L65
        L63:
            r0 = 89
        L65:
            if (r0 == r1) goto L6b
            int r0 = r2.length     // Catch: java.lang.Throwable -> L69
            return
        L69:
            r0 = move-exception
            throw r0
        L6b:
            return
        L6c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type id.dana.DanaApplication"
            r0.<init>(r1)
            throw r0
        L74:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.tracker.TrackEventBridge.onInitialized():void");
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public final void trackEventH5(@BindingParam(name = {"key"}) String str, @BindingParam(name = {"properties"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        boolean z;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bridgeCallback, "");
            if (!getFeatureTrackEvent()) {
                failed(bridgeCallback, MixpanelBridge.ErrorStatus.JSAPI_DISABLED);
                return;
            }
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
        try {
            EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory2 = getEventTrackerModel().BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory2, (byte) 0));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            callback.sendJSONResponse(jSONObject);
            int i = PlaceComponentResult + 11;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:246:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addProperties(com.alibaba.fastjson.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.tracker.TrackEventBridge.addProperties(com.alibaba.fastjson.JSONObject):void");
    }

    private final void failed(BridgeCallback bridgeCallback, MixpanelBridge.ErrorStatus errorStatus) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", (String) Integer.valueOf(errorStatus.getCode()));
        jSONObject2.put((JSONObject) "errorMessage", errorStatus.getMessage());
        bridgeCallback.sendJSONResponse(jSONObject);
        try {
            int i = PlaceComponentResult + 73;
            lookAheadTest = i % 128;
            if (i % 2 == 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int i3 = $10 + 89;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i5 = $10 + 59;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = 0;
            while (true) {
                if (!(i7 < length)) {
                    break;
                }
                cArr3[i7] = (char) (cArr2[i7] ^ 4571606982258105150L);
                i7++;
            }
            cArr2 = cArr3;
        }
        try {
            int i8 = (int) (4571606982258105150L ^ getAuthRequestContext);
            if (BuiltInFictitiousFunctionClassFactory) {
                try {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        int i9 = $11 + 33;
                        $10 = i9 % 128;
                        if (i9 % 2 != 0) {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) << bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] / i8);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory - 1;
                        } else {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i8);
                            i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                        }
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                    }
                    objArr[0] = new String(cArr4);
                } catch (Exception e) {
                    throw e;
                }
            } else if (MyBillsEntityDataFactory) {
                int i10 = $11 + 23;
                $10 = i10 % 128;
                int i11 = i10 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i12 = $11 + 121;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        objArr[0] = new String(cArr6);
                        return;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i8);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
