package id.dana.data.expresspurchase.source.config.split;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import id.dana.data.expresspurchase.model.ExpressPurchaseConfigResult;
import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import id.dana.data.expresspurchase.model.ServiceEmasConfigResult;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.E;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005R\u0017\u0010\f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/expresspurchase/source/config/split/SplitExpressPurchaseConfigEntityData;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/model/ExpressPurchaseConfigResult;", "getBottomSheetExpressPurchaseConfig", "()Lio/reactivex/Observable;", "getBottomSheetExpressPurchaseGoldConfig", "Lid/dana/data/expresspurchase/model/ExpressPurchasePaylaterConfigResult;", "getBottomSheetExpressPurchasePaylaterConfig", "Lid/dana/data/expresspurchase/model/ServiceEmasConfigResult;", "getServiceEmasConfig", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "getSplitFacade", "()Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitExpressPurchaseConfigEntityData implements ExpressPurchaseEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 10896;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = -956812108;
    private static int PlaceComponentResult = 1;
    private static long getAuthRequestContext = 4360990799332652212L;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$5QkB5dwsZMTRnRpFQgh4MeS78Eg(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 != 0 ? '#' : 'S';
        ObservableSource m1241getServiceEmasConfig$lambda1 = m1241getServiceEmasConfig$lambda1(baseTrafficType);
        if (c == '#') {
            int i2 = 75 / 0;
        }
        return m1241getServiceEmasConfig$lambda1;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$7PtKOmy0lvmF60VUc_L08pHLnXk(BaseTrafficType baseTrafficType) {
        try {
            int i = PlaceComponentResult + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            ObservableSource m1239getBottomSheetExpressPurchaseGoldConfig$lambda2 = m1239getBottomSheetExpressPurchaseGoldConfig$lambda2(baseTrafficType);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                return m1239getBottomSheetExpressPurchaseGoldConfig$lambda2;
            }
            Object obj = null;
            obj.hashCode();
            return m1239getBottomSheetExpressPurchaseGoldConfig$lambda2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$TFYRsP7lq_f_UGFZz49qxMda62M(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m1238getBottomSheetExpressPurchaseConfig$lambda0 = m1238getBottomSheetExpressPurchaseConfig$lambda0(baseTrafficType);
        int i3 = PlaceComponentResult + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return m1238getBottomSheetExpressPurchaseConfig$lambda0;
    }

    public static /* synthetic */ ExpressPurchasePaylaterConfigResult $r8$lambda$j0GToXRhVgZeOUFUbNiWCPWC5ME(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ExpressPurchasePaylaterConfigResult m1240getBottomSheetExpressPurchasePaylaterConfig$lambda3 = m1240getBottomSheetExpressPurchasePaylaterConfig$lambda3(baseTrafficType);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m1240getBottomSheetExpressPurchasePaylaterConfig$lambda3;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getExpressPurchase(String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$getExpressPurchase = ExpressPurchaseEntityData.CC.$default$getExpressPurchase(this, str, str2);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return $default$getExpressPurchase;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getLastOfferCancelAction(String str, String str2, String str3) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$getLastOfferCancelAction = ExpressPurchaseEntityData.CC.$default$getLastOfferCancelAction(this, str, str2, str3);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return $default$getLastOfferCancelAction;
        }
        Object obj = null;
        obj.hashCode();
        return $default$getLastOfferCancelAction;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getLastOfferSucceedAction(String str, String str2) {
        int i = PlaceComponentResult + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Observable $default$getLastOfferSucceedAction = ExpressPurchaseEntityData.CC.$default$getLastOfferSucceedAction(this, str, str2);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 42 / 0;
            return $default$getLastOfferSucceedAction;
        }
        return $default$getLastOfferSucceedAction;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyDeals(String str, String str2, String str3) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return ExpressPurchaseEntityData.CC.$default$getQuickBuyDeals(this, str, str2, str3);
            } catch (Exception e) {
                throw e;
            }
        }
        Observable $default$getQuickBuyDeals = ExpressPurchaseEntityData.CC.$default$getQuickBuyDeals(this, str, str2, str3);
        Object[] objArr = null;
        int length = objArr.length;
        return $default$getQuickBuyDeals;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyGold(String str, String str2, String str3, Map map, String str4, String str5, String str6, String str7) {
        int i = PlaceComponentResult + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            try {
                Observable $default$getQuickBuyGold = ExpressPurchaseEntityData.CC.$default$getQuickBuyGold(this, str, str2, str3, map, str4, str5, str6, str7);
                Object obj = null;
                obj.hashCode();
                return $default$getQuickBuyGold;
            } catch (Exception e) {
                throw e;
            }
        }
        return ExpressPurchaseEntityData.CC.$default$getQuickBuyGold(this, str, str2, str3, map, str4, str5, str6, str7);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyInsurance(String str, String str2, String str3, Map map) {
        int i = PlaceComponentResult + 43;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Observable $default$getQuickBuyInsurance = ExpressPurchaseEntityData.CC.$default$getQuickBuyInsurance(this, str, str2, str3, map);
        int i3 = PlaceComponentResult + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return $default$getQuickBuyInsurance;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable orderQueryByCondition(String str, List list) {
        int i = PlaceComponentResult + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Observable $default$orderQueryByCondition = ExpressPurchaseEntityData.CC.$default$orderQueryByCondition(this, str, list);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return $default$orderQueryByCondition;
        }
        Object obj = null;
        obj.hashCode();
        return $default$orderQueryByCondition;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable saveLastOfferCancelAction(String str, String str2, String str3) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                Observable $default$saveLastOfferCancelAction = ExpressPurchaseEntityData.CC.$default$saveLastOfferCancelAction(this, str, str2, str3);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 == 0 ? 'R' : '-') != 'R') {
                    return $default$saveLastOfferCancelAction;
                }
                Object obj = null;
                obj.hashCode();
                return $default$saveLastOfferCancelAction;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable saveLastOfferSucceedAction(String str, String str2) {
        Observable $default$saveLastOfferSucceedAction;
        int i = PlaceComponentResult + 65;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object obj = null;
        if (!(i % 2 == 0)) {
            $default$saveLastOfferSucceedAction = ExpressPurchaseEntityData.CC.$default$saveLastOfferSucceedAction(this, str, str2);
            obj.hashCode();
        } else {
            try {
                $default$saveLastOfferSucceedAction = ExpressPurchaseEntityData.CC.$default$saveLastOfferSucceedAction(this, str, str2);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 == 0 ? '1' : Typography.amp) != '1') {
            return $default$saveLastOfferSucceedAction;
        }
        obj.hashCode();
        return $default$saveLastOfferSucceedAction;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateBundleProduct(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            Observable $default$validateBundleProduct = ExpressPurchaseEntityData.CC.$default$validateBundleProduct(this, str, str2, str3, str4, str5, str6);
            int i3 = PlaceComponentResult + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 19 / 0;
                return $default$validateBundleProduct;
            }
            return $default$validateBundleProduct;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateGoldProduct(String str, List list, Map map) {
        int i = PlaceComponentResult + 21;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$validateGoldProduct = ExpressPurchaseEntityData.CC.$default$validateGoldProduct(this, str, list, map);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                return $default$validateGoldProduct;
            }
            int i4 = 13 / 0;
            return $default$validateGoldProduct;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateStandaloneProduct(String str, String str2) {
        int i = PlaceComponentResult + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '_' : 'C') != '_') {
            return ExpressPurchaseEntityData.CC.$default$validateStandaloneProduct(this, str, str2);
        }
        try {
            Observable $default$validateStandaloneProduct = ExpressPurchaseEntityData.CC.$default$validateStandaloneProduct(this, str, str2);
            int i2 = 9 / 0;
            return $default$validateStandaloneProduct;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitExpressPurchaseConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @JvmName(name = "getSplitFacade")
    public final SplitFacade getSplitFacade() {
        SplitFacade splitFacade;
        try {
            int i = PlaceComponentResult + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            Object obj = null;
            if ((i % 2 != 0 ? '\t' : '9') != '\t') {
                splitFacade = this.splitFacade;
            } else {
                splitFacade = this.splitFacade;
                obj.hashCode();
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 4 : 'E') != 'E') {
                obj.hashCode();
                return splitFacade;
            }
            return splitFacade;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseConfig() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExpressPurchaseConfigEntityData.$r8$lambda$TFYRsP7lq_f_UGFZz49qxMda62M((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'H' : (char) 29) != 'H') {
            return flatMap;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return flatMap;
    }

    /* renamed from: getBottomSheetExpressPurchaseConfig$lambda-0  reason: not valid java name */
    private static final ObservableSource m1238getBottomSheetExpressPurchaseConfig$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final ExpressPurchaseConfigResult expressPurchaseConfigResult = new ExpressPurchaseConfigResult("0", "0");
        Object[] objArr = new Object[1];
        a(new char[]{24224, 46541, 15224, 21073, 13822, 61815, 413, 300, 64353, 62597, 64903, 8756, 13902, 64267, 23275, 11915, 56041, 52296, 24862, 1741, 26933, 23615, 13745}, new char[]{6088, 45530, 44221, 7851}, (char) Drawable.resolveOpacity(0, 0), new char[]{0, 0, 0, 0}, (-1112417769) - View.MeasureSpec.makeMeasureSpec(0, 0), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getBottomSheetExpressPurchaseConfig$lambda-0$$inlined$getConfigCachedOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = expressPurchaseConfigResult;
                final boolean z = r4;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, ExpressPurchaseConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getBottomSheetExpressPurchaseConfig$lambda-0$$inlined$getConfigCachedOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(treatment, "control")) {
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
        int i = PlaceComponentResult + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return observable;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        return observable;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ServiceEmasConfigResult> getServiceEmasConfig() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExpressPurchaseConfigEntityData.$r8$lambda$5QkB5dwsZMTRnRpFQgh4MeS78Eg((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = PlaceComponentResult + 35;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getServiceEmasConfig$lambda-1  reason: not valid java name */
    private static final ObservableSource m1241getServiceEmasConfig$lambda1(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final ServiceEmasConfigResult serviceEmasConfigResult = new ServiceEmasConfigResult("https://h5-staging-emas.innov8.id", "2020060201899528117838", "QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA,PUBLIC_ID,KYC_INFO,TRANSFER_MONEY,CASHIER");
        Object[] objArr = new Object[1];
        a(new char[]{33900, 36010, 46953, 7646, 37611, 3446, 34695, 15408, 54662, 37913, 63048, 31732}, new char[]{7146, 44135, 60098, 53824}, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{0, 0, 0, 0}, ViewConfiguration.getMinimumFlingVelocity() >> 16, objArr);
        final boolean z = false;
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getServiceEmasConfig$lambda-1$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = serviceEmasConfigResult;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, ServiceEmasConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getServiceEmasConfig$lambda-1$$inlined$getConfigOnceReady$default$1.1
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
        int i = PlaceComponentResult + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            int i2 = 92 / 0;
            return observable;
        }
        return observable;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseGoldConfig() {
        try {
            Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitExpressPurchaseConfigEntityData.$r8$lambda$7PtKOmy0lvmF60VUc_L08pHLnXk((BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0)) {
                int i2 = 75 / 0;
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getBottomSheetExpressPurchaseGoldConfig$lambda-2  reason: not valid java name */
    private static final ObservableSource m1239getBottomSheetExpressPurchaseGoldConfig$lambda2(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final ExpressPurchaseConfigResult expressPurchaseConfigResult = new ExpressPurchaseConfigResult("0", "0");
        final boolean z = false;
        Object[] objArr = new Object[1];
        a(new char[]{38448, 7989, 17461, 24198, 6604, 23234, 25776, 10234, 32522, 56114, 26153, 30040, 61221, 32165, 13144, 37434, 64584, 8299, 5313, 49354, 41734, 31137, 2495, 62172, 19123, 42130, 61227, 33097}, new char[]{6202, 18399, 41723, 52900}, (char) (TextUtils.indexOf((CharSequence) "", '0') + 42147), new char[]{0, 0, 0, 0}, Color.alpha(0), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getBottomSheetExpressPurchaseGoldConfig$lambda-2$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = expressPurchaseConfigResult;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, ExpressPurchaseConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$getBottomSheetExpressPurchaseGoldConfig$lambda-2$$inlined$getConfigOnceReady$default$1.1
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
        int i = PlaceComponentResult + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return observable;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ExpressPurchasePaylaterConfigResult> getBottomSheetExpressPurchasePaylaterConfig() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExpressPurchaseConfigEntityData.$r8$lambda$j0GToXRhVgZeOUFUbNiWCPWC5ME((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return map;
        }
        Object obj = null;
        obj.hashCode();
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (r2 != 17) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        if ((r13 == null ? 'L' : ',') != 'L') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        r0 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        r1 = (id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult) new org.json.JSONArray(r0);
     */
    /* renamed from: getBottomSheetExpressPurchasePaylaterConfig$lambda-3  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult m1240getBottomSheetExpressPurchasePaylaterConfig$lambda3(id.dana.data.toggle.traffictype.BaseTrafficType r13) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData.m1240getBottomSheetExpressPurchasePaylaterConfig$lambda3(id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult");
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $11 + 123;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? '+' : 'G') == '+') {
                int i4 = $10 + 31;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
