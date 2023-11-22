package id.dana.data.investment.repository.source.split;

import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.investment.repository.source.InvestmentEntityData;
import id.dana.data.investment.repository.source.split.response.DanaPlusMethodConfigResult;
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
import o.E;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/investment/repository/source/split/SplitInvestmentEntityData;", "Lid/dana/data/investment/repository/source/InvestmentEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/investment/repository/source/split/response/DanaPlusMethodConfigResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "MyBillsEntityDataFactory", "Lid/dana/data/toggle/SplitFacade;", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitInvestmentEntityData implements InvestmentEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = -956812108;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 13492;
    private static long PlaceComponentResult = -555104963701670932L;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SplitFacade KClassImpl$Data$declaredNonStaticMembers$2;

    public static /* synthetic */ ObservableSource getAuthRequestContext(BaseTrafficType baseTrafficType) {
        int i = getAuthRequestContext + 9;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        ObservableSource MyBillsEntityDataFactory = MyBillsEntityDataFactory(baseTrafficType);
        try {
            int i3 = getAuthRequestContext + 119;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? 'W' : (char) 28) != 28) {
                Object[] objArr = null;
                int length = objArr.length;
                return MyBillsEntityDataFactory;
            }
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.investment.repository.source.InvestmentEntityData
    public final /* synthetic */ Observable MyBillsEntityDataFactory(String str, String str2) {
        int i = getAuthRequestContext + 77;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Observable PlaceComponentResult2 = InvestmentEntityData.CC.PlaceComponentResult(str, str2);
        int i3 = lookAheadTest + 113;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return PlaceComponentResult2;
    }

    @Inject
    public SplitInvestmentEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitFacade;
    }

    @Override // id.dana.data.investment.repository.source.InvestmentEntityData
    public final Observable<DanaPlusMethodConfigResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            try {
                Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.investment.repository.source.split.SplitInvestmentEntityData$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitInvestmentEntityData.getAuthRequestContext((BaseTrafficType) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = getAuthRequestContext + 87;
                lookAheadTest = i % 128;
                if ((i % 2 == 0 ? '7' : (char) 17) != '7') {
                    return flatMap;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource MyBillsEntityDataFactory(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final DanaPlusMethodConfigResult danaPlusMethodConfigResult = new DanaPlusMethodConfigResult("Dana Plus Balance", "216620000096550100935", "");
        Object[] objArr = new Object[1];
        a(new char[]{64895, 17589, 51170, 7928, 41288, 44238, 63958, 57591, 22656, 21796, 16331, 2180, 34093, 32174, 57743, 58924, 5424, 54040, 10171, 10928, 60602, 47826, 58185}, new char[]{34072, 37865, 21481, 19081}, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), new char[]{20312, 51065, 34044, 50382}, (-376182394) + TextUtils.indexOf((CharSequence) "", '0'), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.investment.repository.source.split.SplitInvestmentEntityData$getDanaPlusMethodConfig$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $KClassImpl$Data$declaredNonStaticMembers$2 = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = danaPlusMethodConfigResult;
                final boolean z = this.$KClassImpl$Data$declaredNonStaticMembers$2;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, DanaPlusMethodConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.investment.repository.source.split.SplitInvestmentEntityData$getDanaPlusMethodConfig$lambda-0$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
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
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
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
        int i = getAuthRequestContext + 105;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? (char) 25 : JSONLexer.EOI) != 25) {
            return observable;
        }
        Object obj = null;
        obj.hashCode();
        return observable;
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
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3)) {
                int i2 = $11 + 11;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                String str = new String(cArr6);
                int i6 = $11 + 109;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
