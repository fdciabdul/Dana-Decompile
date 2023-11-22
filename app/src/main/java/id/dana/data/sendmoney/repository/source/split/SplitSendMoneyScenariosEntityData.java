package id.dana.data.sendmoney.repository.source.split;

import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import id.dana.data.sendmoney.repository.source.SendMoneyScenariosEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.util.SendMoneyDefaultConfigGenerator;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.A;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\t\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/sendmoney/repository/source/split/SplitSendMoneyScenariosEntityData;", "Lid/dana/data/sendmoney/repository/source/SendMoneyScenariosEntityData;", "Lio/reactivex/Observable;", "", "", "getSendMoneyCategories", "()Lio/reactivex/Observable;", "Lkotlin/Function1;", "Lid/dana/data/sendmoney/model/SendMoneyScenarioEntity;", "getSendMoneyScenario", "()Lkotlin/jvm/functions/Function1;", "getSendMoneyScenarios", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitSendMoneyScenariosEntityData implements SendMoneyScenariosEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 269894778;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$WyCe0c9I34BdrweKEE7kTn5wGD0(BaseTrafficType baseTrafficType) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                ObservableSource m1936getSendMoneyCategories$lambda1 = m1936getSendMoneyCategories$lambda1(baseTrafficType);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return m1936getSendMoneyCategories$lambda1;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$xDahpgBSzujMm2t6OheEhWMfh0c(Function1 function1, List list) {
        int i = PlaceComponentResult + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? '/' : (char) 16) != 16) {
            try {
                ObservableSource m1937getSendMoneyScenarios$lambda0 = m1937getSendMoneyScenarios$lambda0(function1, list);
                Object obj = null;
                obj.hashCode();
                return m1937getSendMoneyScenarios$lambda0;
            } catch (Exception e) {
                throw e;
            }
        }
        return m1937getSendMoneyScenarios$lambda0(function1, list);
    }

    @Inject
    public SplitSendMoneyScenariosEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    public static final /* synthetic */ SplitFacade access$getSplitFacade$p(SplitSendMoneyScenariosEntityData splitSendMoneyScenariosEntityData) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        SplitFacade splitFacade = splitSendMoneyScenariosEntityData.splitFacade;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return splitFacade;
        }
        Object obj = null;
        obj.hashCode();
        return splitFacade;
    }

    @Override // id.dana.data.sendmoney.repository.source.SendMoneyScenariosEntityData
    public final Observable<List<SendMoneyScenarioEntity>> getSendMoneyScenarios() {
        Observable<List<String>> sendMoneyCategories = getSendMoneyCategories();
        final Function1<List<String>, Observable<List<SendMoneyScenarioEntity>>> sendMoneyScenario = getSendMoneyScenario();
        try {
            Observable flatMap = sendMoneyCategories.flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitSendMoneyScenariosEntityData.$r8$lambda$xDahpgBSzujMm2t6OheEhWMfh0c(Function1.this, (List) obj);
                }
            });
            try {
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = PlaceComponentResult + 85;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getSendMoneyScenarios$lambda-0  reason: not valid java name */
    private static final ObservableSource m1937getSendMoneyScenarios$lambda0(Function1 function1, List list) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            try {
                Intrinsics.checkNotNullParameter(function1, "");
                return (ObservableSource) function1.invoke(list);
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(function1, "");
        ObservableSource observableSource = (ObservableSource) function1.invoke(list);
        int i2 = 49 / 0;
        return observableSource;
    }

    private final Observable<List<String>> getSendMoneyCategories() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSendMoneyScenariosEntityData.$r8$lambda$WyCe0c9I34BdrweKEE7kTn5wGD0((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 83;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 22 : '.') != 22) {
            return flatMap;
        }
        int i2 = 65 / 0;
        return flatMap;
    }

    /* renamed from: getSendMoneyCategories$lambda-1  reason: not valid java name */
    private static final ObservableSource m1936getSendMoneyCategories$lambda1(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final List<String> createSendMoneyHomeCategory = SendMoneyDefaultConfigGenerator.INSTANCE.createSendMoneyHomeCategory();
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(new char[]{4, 65530, 65525, 3, 5, 4, 65531, 15, 65525, '\t', 65529, 65531, 4, 65527, '\b', 65535, 5, '\t', '\t', 65531}, 201 - ExpandableListView.getPackedPositionType(0L), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20, false, 18 - (ViewConfiguration.getScrollBarSize() >> 8), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData$getSendMoneyCategories$lambda-1$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = createSendMoneyHomeCategory;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData$getSendMoneyCategories$lambda-1$$inlined$getConfigOnceReady$1.1
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
        int i = PlaceComponentResult + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? 'H' : 'V') != 'H') {
            return observable;
        }
        Object obj = null;
        obj.hashCode();
        return observable;
    }

    private final Function1<List<String>, Observable<List<SendMoneyScenarioEntity>>> getSendMoneyScenario() {
        SplitSendMoneyScenariosEntityData$getSendMoneyScenario$1 splitSendMoneyScenariosEntityData$getSendMoneyScenario$1 = new SplitSendMoneyScenariosEntityData$getSendMoneyScenario$1(this);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return splitSendMoneyScenariosEntityData$getSendMoneyScenario$1;
        }
        return splitSendMoneyScenariosEntityData$getSendMoneyScenario$1;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? 'I' : '5') == '5') {
                break;
            }
            int i4 = $11 + 85;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr2[i6] = (char) (cArr2[i6] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if ((i3 > 0 ? '8' : 'A') != 'A') {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i7 = $11 + 57;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                try {
                    if (a2.MyBillsEntityDataFactory >= i2) {
                        break;
                    }
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
