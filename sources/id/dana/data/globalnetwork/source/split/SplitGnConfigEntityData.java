package id.dana.data.globalnetwork.source.split;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.globalnetwork.model.GnHereLocationConfig;
import id.dana.data.globalnetwork.source.GnConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/globalnetwork/source/split/SplitGnConfigEntityData;", "Lid/dana/data/globalnetwork/source/GnConfigEntityData;", "Lio/reactivex/Observable;", "", "", "getGnCScanBBlacklistedCountry", "()Lio/reactivex/Observable;", "getMerchantBlockRegistration", "", "isGoogleBlockRegistration", "Lid/dana/data/globalnetwork/model/GnHereLocationConfig;", "isHereLocationEnabled", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitGnConfigEntityData implements GnConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final int DEFAULT_TIME_REFRESH_LOCATION = 10;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 1;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$84sS0ry9eNWnMmJNccRtpOqVc8k(BaseTrafficType baseTrafficType) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 85;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                return m1341getGnCScanBBlacklistedCountry$lambda0(baseTrafficType);
            }
            try {
                int i2 = 37 / 0;
                return m1341getGnCScanBBlacklistedCountry$lambda0(baseTrafficType);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$HVzI-F8eae_6XML0-CR-9bPIzx0  reason: not valid java name */
    public static /* synthetic */ List m1338$r8$lambda$HVzIF8eae_6XML0CR9bPIzx0(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 77;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        List m1342getMerchantBlockRegistration$lambda1 = m1342getMerchantBlockRegistration$lambda1(baseTrafficType);
        int i3 = BuiltInFictitiousFunctionClassFactory + 5;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return m1342getMerchantBlockRegistration$lambda1;
        }
        return m1342getMerchantBlockRegistration$lambda1;
    }

    /* renamed from: $r8$lambda$Jz5-iVlXji7Ad3SmT_fpeixPP6c  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1339$r8$lambda$Jz5iVlXji7Ad3SmT_fpeixPP6c(BaseTrafficType baseTrafficType) {
        ObservableSource m1344isHereLocationEnabled$lambda4;
        try {
            int i = PlaceComponentResult + 103;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if ((i % 2 != 0 ? '!' : 'B') != 'B') {
                try {
                    m1344isHereLocationEnabled$lambda4 = m1344isHereLocationEnabled$lambda4(baseTrafficType);
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                m1344isHereLocationEnabled$lambda4 = m1344isHereLocationEnabled$lambda4(baseTrafficType);
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 25;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return m1344isHereLocationEnabled$lambda4;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$VfygfuSUi-xyFxNrvIEyEZE_CnM  reason: not valid java name */
    public static /* synthetic */ Boolean m1340$r8$lambda$VfygfuSUixyFxNrvIEyEZE_CnM(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 85;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Boolean m1343isGoogleBlockRegistration$lambda2 = m1343isGoogleBlockRegistration$lambda2(baseTrafficType);
        int i3 = BuiltInFictitiousFunctionClassFactory + 13;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m1343isGoogleBlockRegistration$lambda2;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$g0GJ7U181o6WyU29FPfu_a9owrY(Map map) {
        int i = BuiltInFictitiousFunctionClassFactory + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1345isHereLocationEnabled$lambda4$lambda3 = m1345isHereLocationEnabled$lambda4$lambda3(map);
            int i3 = BuiltInFictitiousFunctionClassFactory + 15;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m1345isHereLocationEnabled$lambda4$lambda3;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2 = 269894756;
            try {
                INSTANCE = new Companion(null);
                int i = PlaceComponentResult + 43;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Inject
    public SplitGnConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<List<String>> getGnCScanBBlacklistedCountry() {
        Observable switchMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().switchMap(new Function() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGnConfigEntityData.$r8$lambda$84sS0ry9eNWnMmJNccRtpOqVc8k((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : ':') != ':') {
            Object[] objArr = null;
            int length = objArr.length;
            return switchMap;
        }
        return switchMap;
    }

    /* renamed from: getGnCScanBBlacklistedCountry$lambda-0  reason: not valid java name */
    private static final ObservableSource m1341getGnCScanBBlacklistedCountry$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final List emptyList = CollectionsKt.emptyList();
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(new char[]{'\f', 6, 65530, 65526, 65531, 65532, 11, '\n', 0, 3, 2, 65530, 65528, 3, 65529, 65526, 65529, 5, 65528, 65530, '\n', 65530, 65526, 5, 65534, 16, '\t', 11, 5}, 170 - (Process.myPid() >> 22), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 28, true, 26 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$getGnCScanBBlacklistedCountry$lambda-0$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = emptyList;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$getGnCScanBBlacklistedCountry$lambda-0$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(value);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str4 = str2;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str4));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = PlaceComponentResult + 87;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            return observable;
        }
        return observable;
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<List<String>> getMerchantBlockRegistration() {
        Observable map = this.splitFacade.PlaceComponentResult().map(new Function() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGnConfigEntityData.m1338$r8$lambda$HVzIF8eae_6XML0CR9bPIzx0((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = BuiltInFictitiousFunctionClassFactory + 3;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* renamed from: getMerchantBlockRegistration$lambda-1  reason: not valid java name */
    private static final List m1342getMerchantBlockRegistration$lambda1(BaseTrafficType baseTrafficType) {
        String str = "";
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = new Object[1];
        a(new char[]{'\b', '\n', '\t', 65535, 65533, 65531, '\b', 65525, 1, 65529, 5, 2, 65528, 65525, '\n', 4, 65527, 65534, 65529, '\b', 65531, 3, 4, 5, 65535, '\n', 65527}, KeyEvent.keyCodeFromString("") + 171, 26 - TextUtils.indexOf((CharSequence) "", '0'), true, 22 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr);
        String authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), true);
        if (JSONArray.class.isAssignableFrom(JSONArray.class)) {
            int i = PlaceComponentResult + 81;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            if (authRequestContext == null) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 87;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } else {
                str = authRequestContext;
            }
            jSONArray = new JSONArray(str);
        } else {
            if ((authRequestContext != null ? '7' : (char) 2) == '7') {
                int i5 = PlaceComponentResult + 21;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                Object obj = null;
                try {
                    if (i5 % 2 != 0) {
                        Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) JSONArray.class);
                        obj.hashCode();
                        obj = fromJson;
                    } else {
                        obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) JSONArray.class);
                    }
                } catch (Exception unused) {
                }
                if ((obj == null ? Typography.dollar : '/') != '$') {
                    jSONArray = obj;
                } else {
                    int i6 = BuiltInFictitiousFunctionClassFactory + 83;
                    PlaceComponentResult = i6 % 128;
                    if ((i6 % 2 == 0 ? '[' : '.') == '[') {
                        int i7 = 0 / 0;
                    }
                }
            }
        }
        return JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONArray);
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<Boolean> isGoogleBlockRegistration() {
        Observable map = this.splitFacade.PlaceComponentResult().map(new Function() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGnConfigEntityData.m1340$r8$lambda$VfygfuSUixyFxNrvIEyEZE_CnM((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 93;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            return map;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return map;
    }

    /* renamed from: isGoogleBlockRegistration$lambda-2  reason: not valid java name */
    private static final Boolean m1343isGoogleBlockRegistration$lambda2(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 33;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object[] objArr = new Object[1];
        a(new char[]{65526, 2, 65530, 6, 3, 65529, 65526, 5, 65534, 65532, 3, 65534, 6, 6, 65534, 65526, 5, 6, 0, 11, 65528, '\t', 11, '\n', 0, 65534, 65532, '\t'}, 170 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 27 - MotionEvent.axisFromString(""), true, 9 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr);
        Boolean valueOf = Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), true, true));
        int i3 = BuiltInFictitiousFunctionClassFactory + 117;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return valueOf;
    }

    @Override // id.dana.data.globalnetwork.source.GnConfigEntityData
    public final Observable<GnHereLocationConfig> isHereLocationEnabled() {
        Observable switchMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().switchMap(new Function() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGnConfigEntityData.m1339$r8$lambda$Jz5iVlXji7Ad3SmT_fpeixPP6c((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        int i = PlaceComponentResult + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '9' : 'D') != '9') {
            return switchMap;
        }
        Object obj = null;
        obj.hashCode();
        return switchMap;
    }

    /* renamed from: isHereLocationEnabled$lambda-4  reason: not valid java name */
    private static final ObservableSource m1344isHereLocationEnabled$lambda4(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Map emptyMap = MapsKt.emptyMap();
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(new char[]{65528, 7, 0, 65528, 65534, 11, 65534, 1, 0, 2, 65535, 7, '\b', 65532}, 169 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 14 - View.MeasureSpec.getMode(0), true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 8, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$isHereLocationEnabled$lambda-4$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = emptyMap;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, Map.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$isHereLocationEnabled$lambda-4$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(value);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str4 = str2;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str4));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable switchMap = create.switchMap(new Function() { // from class: id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGnConfigEntityData.$r8$lambda$g0GJ7U181o6WyU29FPfu_a9owrY((Map) obj);
            }
        });
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return switchMap;
    }

    /* renamed from: isHereLocationEnabled$lambda-4$lambda-3  reason: not valid java name */
    private static final ObservableSource m1345isHereLocationEnabled$lambda4$lambda3(Map map) {
        boolean parseBoolean;
        int i;
        Intrinsics.checkNotNullParameter(map, "");
        String str = (String) map.get("enable");
        if (!(str != null)) {
            parseBoolean = true;
        } else {
            int i2 = BuiltInFictitiousFunctionClassFactory + 49;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            parseBoolean = Boolean.parseBoolean(str);
        }
        try {
            String str2 = (String) map.get("timeRefreshLocation");
            if (!(str2 == null)) {
                int i4 = BuiltInFictitiousFunctionClassFactory + 47;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
                i = Integer.parseInt(str2);
                if (i5 == 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } else {
                i = 10;
            }
            Observable just = Observable.just(new GnHereLocationConfig(parseBoolean, i));
            int i6 = PlaceComponentResult + 83;
            BuiltInFictitiousFunctionClassFactory = i6 % 128;
            if (i6 % 2 == 0) {
                return just;
            }
            int i7 = 60 / 0;
            return just;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if (!(a2.MyBillsEntityDataFactory < i2)) {
                break;
            }
            int i4 = $10 + 15;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr2[i6] = (char) (cArr2[i6] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                try {
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if ((z ? 'W' : '2') != '2') {
            int i7 = $11 + 43;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                int i9 = $11 + 43;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            int i11 = $11 + 97;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
