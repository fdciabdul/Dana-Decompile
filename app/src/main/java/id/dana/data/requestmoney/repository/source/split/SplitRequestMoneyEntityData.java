package id.dana.data.requestmoney.repository.source.split;

import android.graphics.Color;
import android.text.TextUtils;
import id.dana.data.requestmoney.repository.RequestMoneyEntityData;
import id.dana.data.requestmoney.repository.model.NameCheckConfigEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.payasset.model.Institution;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.C;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/requestmoney/repository/source/split/SplitRequestMoneyEntityData;", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/requestmoney/repository/model/NameCheckConfigEntity;", "getNameCheckConfig", "()Lio/reactivex/Observable;", "", "", "getTopFeatureBanks", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitRequestMoneyEntityData implements RequestMoneyEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 43719;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 52338;
    private static char PlaceComponentResult = 52721;
    private static char getAuthRequestContext = 21585;
    private static int scheduleImpl = 1;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$47wXWXh5mvdlqst_JHITXe9SOZU(BaseTrafficType baseTrafficType) {
        int i = scheduleImpl + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1839getNameCheckConfig$lambda1 = m1839getNameCheckConfig$lambda1(baseTrafficType);
            int i3 = scheduleImpl + 115;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return m1839getNameCheckConfig$lambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$frrp_CD0BdPvMAeJGMEJAPqZxN4(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m1840getTopFeatureBanks$lambda0 = m1840getTopFeatureBanks$lambda0(baseTrafficType);
            int i3 = scheduleImpl + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return m1840getTopFeatureBanks$lambda0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitRequestMoneyEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyEntityData
    public final Observable<List<String>> getTopFeatureBanks() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitRequestMoneyEntityData.$r8$lambda$frrp_CD0BdPvMAeJGMEJAPqZxN4((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getTopFeatureBanks$lambda-0  reason: not valid java name */
    private static final ObservableSource m1840getTopFeatureBanks$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final List listOf = CollectionsKt.listOf((Object[]) new String[]{Institution.BCA, Institution.BRI, Institution.MANDIRI, Institution.BNI, "BTPNC1ID", Institution.CIMB});
        Object[] objArr = new Object[1];
        a(Color.red(0) + 9, new char[]{19414, 11977, 54176, 43172, 63499, 61575, 33894, 32356, 40618, 4605}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$getTopFeatureBanks$lambda-0$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = listOf;
                final boolean z = r4;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$getTopFeatureBanks$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i = scheduleImpl + 27;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return observable;
        }
        Object obj = null;
        obj.hashCode();
        return observable;
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyEntityData
    public final Observable<NameCheckConfigEntity> getNameCheckConfig() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitRequestMoneyEntityData.$r8$lambda$47wXWXh5mvdlqst_JHITXe9SOZU((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? '.' : 'V') != 'V') {
            int i2 = 24 / 0;
            return flatMap;
        }
        return flatMap;
    }

    /* renamed from: getNameCheckConfig$lambda-1  reason: not valid java name */
    private static final ObservableSource m1839getNameCheckConfig$lambda1(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final boolean z = false;
        final NameCheckConfigEntity nameCheckConfigEntity = new NameCheckConfigEntity(0, 10, 300);
        Object[] objArr = new Object[1];
        a(15 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{50271, 33863, 18816, 54139, 38865, 36296, 19606, 54357, 61445, 29468, 2892, 25999, 64080, 41767, 16981, 4650}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$getNameCheckConfig$lambda-1$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = nameCheckConfigEntity;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, NameCheckConfigEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData$getNameCheckConfig$lambda-1$$inlined$getConfigOnceReady$default$1.1
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
        int i = scheduleImpl + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return observable;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 27 : 'Y') == 'Y') {
                break;
            }
            int i2 = $11 + 95;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i4 = 58224;
            int i5 = 0;
            while (true) {
                if (!(i5 >= 16)) {
                    int i6 = $10 + 9;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i5++;
                }
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        String str = new String(cArr2, 0, i);
        int i8 = $11 + 111;
        $10 = i8 % 128;
        if (i8 % 2 == 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
