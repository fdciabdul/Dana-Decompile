package id.dana.data.saving.repository.source.split;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSON;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.saving.model.SavingEmptyStateEntity;
import id.dana.data.saving.model.SavingLimitEntity;
import id.dana.data.saving.repository.SavingConfigEntityData;
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
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o.C;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/saving/repository/source/split/SplitSavingConfigEntityData;", "Lid/dana/data/saving/repository/SavingConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/saving/model/SavingEmptyStateEntity;", "getSavingEmptyState", "()Lio/reactivex/Observable;", "Lid/dana/data/saving/model/SavingLimitEntity;", "getSavingLimit", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitSavingConfigEntityData implements SavingConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final String MAX_SAVING_AMOUNT_KYC = "16.000.000";
    private static final String MAX_SAVING_AMOUNT_NON_KYC = "1.500.000";
    private static final String MAX_SAVING_COUNT_NON_KYC = "10";
    private static char MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char PlaceComponentResult;
    private static char getAuthRequestContext;
    private final SplitFacade splitFacade;

    /* renamed from: $r8$lambda$DC7vEZUu-2nVUZvcvy2bCTv3lN0  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1895$r8$lambda$DC7vEZUu2nVUZvcvy2bCTv3lN0(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource m1897getSavingEmptyState$lambda0 = m1897getSavingEmptyState$lambda0(baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? ')' : (char) 21) != 21) {
            Object[] objArr = null;
            int length = objArr.length;
            return m1897getSavingEmptyState$lambda0;
        }
        return m1897getSavingEmptyState$lambda0;
    }

    /* renamed from: $r8$lambda$sOJU-SzjbEYMCM7tgPez_c_Bl_Q  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1896$r8$lambda$sOJUSzjbEYMCM7tgPez_c_Bl_Q(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource m1898getSavingLimit$lambda1 = m1898getSavingLimit$lambda1(baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 21 : '\t') != '\t') {
            Object[] objArr = null;
            int length = objArr.length;
            return m1898getSavingLimit$lambda1;
        }
        return m1898getSavingLimit$lambda1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        MyBillsEntityDataFactory();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            return;
        }
        int length = r1.length;
    }

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 5239;
        getAuthRequestContext = (char) 49714;
        MyBillsEntityDataFactory = (char) 54756;
        PlaceComponentResult = (char) 47468;
    }

    @Inject
    public SplitSavingConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.saving.repository.SavingConfigEntityData
    public final Observable<SavingEmptyStateEntity> getSavingEmptyState() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSavingConfigEntityData.m1895$r8$lambda$DC7vEZUu2nVUZvcvy2bCTv3lN0((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? '\'' : (char) 14) != '\'') {
            return flatMap;
        }
        int i2 = 42 / 0;
        return flatMap;
    }

    @Override // id.dana.data.saving.repository.SavingConfigEntityData
    public final Observable<SavingLimitEntity> getSavingLimit() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSavingConfigEntityData.m1896$r8$lambda$sOJUSzjbEYMCM7tgPez_c_Bl_Q((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getSavingLimit$lambda-1  reason: not valid java name */
    private static final ObservableSource m1898getSavingLimit$lambda1(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final SavingLimitEntity savingLimitEntity = new SavingLimitEntity("10", MAX_SAVING_AMOUNT_NON_KYC, MAX_SAVING_AMOUNT_KYC);
        final boolean z = false;
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 9, new char[]{43349, 48834, 49944, 43241, 45705, 43505, 46964, 32759, 3037, 44733}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$getSavingLimit$lambda-1$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = savingLimitEntity;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, SavingLimitEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$getSavingLimit$lambda-1$$inlined$getConfigOnceReady$default$1.1
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
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return observable;
    }

    /* renamed from: getSavingEmptyState$lambda-0  reason: not valid java name */
    private static final ObservableSource m1897getSavingEmptyState$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Object parseObject = JSON.parseObject(JsonUtil.PlaceComponentResult(baseTrafficType.KClassImpl$Data$declaredNonStaticMembers$2, DefaultJsonPath.DEFAULT_SAVING_EMPTY_STATE_CONFIG), SavingEmptyStateEntity.class);
        final boolean z = false;
        Object[] objArr = new Object[1];
        a(TextUtils.lastIndexOf("", '0', 0, 0) + 27, new char[]{44464, 56634, 23500, 18020, 17311, 44082, 47001, 21072, 39706, 33869, 7909, 38231, 36699, 62918, 49513, 53384, 876, 7763, 32778, 54157, 3751, 49623, 16565, 16899, 20906, 46262}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$getSavingEmptyState$lambda-0$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = parseObject;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(str, BuiltInFictitiousFunctionClassFactory2, SavingEmptyStateEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.saving.repository.source.split.SplitSavingConfigEntityData$getSavingEmptyState$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? ')' : 'I') != 'I') {
            Object obj = null;
            obj.hashCode();
            return observable;
        }
        return observable;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $11 + 13;
        $10 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if (c.BuiltInFictitiousFunctionClassFactory >= cArr.length) {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i4 = $11 + 39;
            $10 = i4 % 128;
            int i5 = 58224;
            if ((i4 % 2 != 0 ? 'R' : 'V') != 'R') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            } else {
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory % 0];
            }
            for (int i6 = 0; i6 < 16; i6++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i5) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i5) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                i5 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
            i2 = $10 + 81;
            $11 = i2 % 128;
        }
    }
}
