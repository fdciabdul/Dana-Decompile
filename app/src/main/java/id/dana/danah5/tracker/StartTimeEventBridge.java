package id.dana.danah5.tracker;

import android.app.Application;
import android.graphics.PointF;
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
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danah5/tracker/StartTimeEventBridge;", "Lid/dana/danah5/mixpanel/StrictBaseBridge;", "", "onInitialized", "()V", "", "key", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", BridgeName.TRACK_EVENT_H5, "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;", "errorStatus", "failed", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/mixpanel/MixpanelBridge$ErrorStatus;)V", "Lid/dana/tracker/EventTrackerModel$Builder;", "eventTrackerModel", "Lid/dana/tracker/EventTrackerModel$Builder;", "getEventTrackerModel", "()Lid/dana/tracker/EventTrackerModel$Builder;", "setEventTrackerModel", "(Lid/dana/tracker/EventTrackerModel$Builder;)V", "", "getFeatureTrackEvent", "()Z", "featureTrackEvent", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StartTimeEventBridge extends StrictBaseBridge {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int moveToNextValue = 1;
    public EventTrackerModel.Builder eventTrackerModel;
    private static char[] getAuthRequestContext = {39545, 39544, 39548, 39531, 39528, 39533, 39550, 39546, 39538, 39529, 39537, 39447, 39464};
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static boolean MyBillsEntityDataFactory = true;
    private static int PlaceComponentResult = 909155295;

    public static /* synthetic */ Boolean $r8$lambda$yBr7VxgtZ2arSEUtEJNTfqg4bCE(BaseTrafficType baseTrafficType) {
        Boolean m722_get_featureTrackEvent_$lambda0;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        moveToNextValue = i % 128;
        if (i % 2 != 0) {
            try {
                m722_get_featureTrackEvent_$lambda0 = m722_get_featureTrackEvent_$lambda0(baseTrafficType);
            } catch (Exception e) {
                throw e;
            }
        } else {
            m722_get_featureTrackEvent_$lambda0 = m722_get_featureTrackEvent_$lambda0(baseTrafficType);
            int i2 = 46 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return m722_get_featureTrackEvent_$lambda0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0016, code lost:
    
        if (r0 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0023, code lost:
    
        if ((r0 != null ? '\'' : 2) != 2) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0025, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0026, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.danah5.tracker.StartTimeEventBridge.moveToNextValue + 123;
        id.dana.danah5.tracker.StartTimeEventBridge.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0034, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getEventTrackerModel")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.tracker.EventTrackerModel.Builder getEventTrackerModel() {
        /*
            r4 = this;
            int r0 = id.dana.danah5.tracker.StartTimeEventBridge.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.danah5.tracker.StartTimeEventBridge.moveToNextValue = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r3 = 0
            if (r0 == r2) goto L1b
            id.dana.tracker.EventTrackerModel$Builder r0 = r4.eventTrackerModel
            int r2 = r3.length     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L26
            goto L25
        L19:
            r0 = move-exception
            throw r0
        L1b:
            id.dana.tracker.EventTrackerModel$Builder r0 = r4.eventTrackerModel     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto L22
            r2 = 39
            goto L23
        L22:
            r2 = 2
        L23:
            if (r2 == r1) goto L26
        L25:
            return r0
        L26:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.danah5.tracker.StartTimeEventBridge.moveToNextValue
            int r0 = r0 + 123
            int r2 = r0 % 128
            id.dana.danah5.tracker.StartTimeEventBridge.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % r1
            return r3
        L35:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.tracker.StartTimeEventBridge.getEventTrackerModel():id.dana.tracker.EventTrackerModel$Builder");
    }

    @JvmName(name = "setEventTrackerModel")
    public final void setEventTrackerModel(EventTrackerModel.Builder builder) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        moveToNextValue = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(builder, "");
            this.eventTrackerModel = builder;
        } else {
            Intrinsics.checkNotNullParameter(builder, "");
            this.eventTrackerModel = builder;
            int i2 = 92 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        moveToNextValue = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 85 / 0;
        }
    }

    @JvmName(name = "getFeatureTrackEvent")
    private final boolean getFeatureTrackEvent() {
        try {
            Object blockingFirst = getSplitFacade().KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.tracker.StartTimeEventBridge$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return StartTimeEventBridge.$r8$lambda$yBr7VxgtZ2arSEUtEJNTfqg4bCE((BaseTrafficType) obj);
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            boolean booleanValue = ((Boolean) blockingFirst).booleanValue();
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            moveToNextValue = i % 128;
            if ((i % 2 == 0 ? 'b' : (char) 21) != 'b') {
                return booleanValue;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return booleanValue;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: _get_featureTrackEvent_$lambda-0 */
    private static final Boolean m722_get_featureTrackEvent_$lambda0(BaseTrafficType baseTrafficType) {
        boolean authRequestContext;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        moveToNextValue = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr = new Object[1];
            a(46 % (PointF.length(2.0f, 0.0f) > 2.0f ? 1 : (PointF.length(2.0f, 0.0f) == 2.0f ? 0 : -1)), new byte[]{-115, -116, -124, -117, -126, -118, -126, -121, -119, -120, -125, -122, -124, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr);
            authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), true, true);
        } else {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr2 = new Object[1];
            a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-115, -116, -124, -117, -126, -118, -126, -121, -119, -120, -125, -122, -124, -121, -126, -122, -123, -124, -125, -126, -127}, null, null, objArr2);
            authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr2[0]).intern(), false, false);
        }
        return Boolean.valueOf(authRequestContext);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        int i = moveToNextValue + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult2 = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            try {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
            } catch (Exception e) {
                throw e;
            }
        }
        PlaceComponentResult2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult2.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public final void trackEventH5(@BindingParam(name = {"key"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(bridgeCallback, "");
            if (!getFeatureTrackEvent()) {
                failed(bridgeCallback, MixpanelBridge.ErrorStatus.JSAPI_DISABLED);
                return;
            }
            MixPanelTracker.getAuthRequestContext(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    private final void failed(BridgeCallback bridgeCallback, MixpanelBridge.ErrorStatus errorStatus) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", (String) Integer.valueOf(errorStatus.getCode()));
        jSONObject2.put((JSONObject) "errorMessage", errorStatus.getMessage());
        bridgeCallback.sendJSONResponse(jSONObject);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        moveToNextValue = i % 128;
        int i2 = i % 2;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = getAuthRequestContext;
        if (!(cArr3 == null)) {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr4[i3] = (char) (cArr3[i3] ^ 4571606982258105150L);
            }
            cArr3 = cArr4;
        }
        int i4 = (int) (4571606982258105150L ^ PlaceComponentResult);
        try {
            if (!(MyBillsEntityDataFactory)) {
                if ((BuiltInFictitiousFunctionClassFactory ? 'S' : (char) 30) == 30) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        try {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                int i5 = $11 + 49;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i7 = $10 + 27;
                    $11 = i7 % 128;
                    if (!(i7 % 2 != 0)) {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 1) % bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] % i] % i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 0;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr6);
                return;
            }
            int i8 = $10 + 125;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            }
            while (true) {
                if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? '=' : (char) 14) == 14) {
                    objArr[0] = new String(cArr2);
                    return;
                } else {
                    cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
