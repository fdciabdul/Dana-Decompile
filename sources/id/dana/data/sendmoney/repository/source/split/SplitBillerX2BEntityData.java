package id.dana.data.sendmoney.repository.source.split;

import android.graphics.Color;
import com.google.gson.reflect.TypeToken;
import id.dana.data.sendmoney.BillerX2BEntityData;
import id.dana.data.sendmoney.model.BillerX2BEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.util.BillerX2BConfigGenerator;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.lib.toggle.result.RawResult;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/sendmoney/repository/source/split/SplitBillerX2BEntityData;", "Lid/dana/data/sendmoney/BillerX2BEntityData;", "Lio/reactivex/Observable;", "", "Lid/dana/data/sendmoney/model/BillerX2BEntity;", "getListBillerX2B", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitBillerX2BEntityData implements BillerX2BEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int getAuthRequestContext;
    private final SplitFacade splitFacade;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {39908, 39850, 39930, 39935, 39914, 39929, 39928, 39925, 39931, 39912, 39933, 39920, 39919, 39918, 39926, 39927};
    private static boolean PlaceComponentResult = true;
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static int MyBillsEntityDataFactory = 909155164;

    public static /* synthetic */ ObservableSource $r8$lambda$0jUpSEroAckMuG22fosz02FGdIU(BaseTrafficType baseTrafficType, List list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
        getAuthRequestContext = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 4 : Typography.less) != 4) {
                return m1929getListBillerX2B$lambda4$lambda3(baseTrafficType, list);
            }
            ObservableSource m1929getListBillerX2B$lambda4$lambda3 = m1929getListBillerX2B$lambda4$lambda3(baseTrafficType, list);
            Object[] objArr = null;
            int length = objArr.length;
            return m1929getListBillerX2B$lambda4$lambda3;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$HVRhY1_fxsl2n5BFY1Qd8dHZ3no(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? '0' : '@';
        ObservableSource m1928getListBillerX2B$lambda4 = m1928getListBillerX2B$lambda4(baseTrafficType);
        if (c != '@') {
            int i2 = 79 / 0;
        }
        int i3 = getAuthRequestContext + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return m1928getListBillerX2B$lambda4;
    }

    @Inject
    public SplitBillerX2BEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.sendmoney.BillerX2BEntityData
    public final Observable<List<BillerX2BEntity>> getListBillerX2B() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillerX2BEntityData.$r8$lambda$HVRhY1_fxsl2n5BFY1Qd8dHZ3no((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getListBillerX2B$lambda-4  reason: not valid java name */
    private static final ObservableSource m1928getListBillerX2B$lambda4(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final List<String> x2bRedirectAllBillerConfig = BillerX2BConfigGenerator.INSTANCE.x2bRedirectAllBillerConfig();
        final boolean z = false;
        Object[] objArr = new Object[1];
        a(Color.green(0) + 127, new byte[]{-112, -120, -113, -114, -115, -119, -124, -123, -122, -116, -116, -120, -125, -124, -116, -116, -117, -124, -118, -119, -122, -123, -120, -121, -122, -123, -124, -125, -126, -127}, null, null, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData$getListBillerX2B$lambda-4$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = x2bRedirectAllBillerConfig;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData$getListBillerX2B$lambda-4$$inlined$getConfigOnceReady$1.1
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
        Observable flatMap = create.flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitBillerX2BEntityData.$r8$lambda$0jUpSEroAckMuG22fosz02FGdIU(BaseTrafficType.this, (List) obj);
            }
        });
        int i = getAuthRequestContext + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: getListBillerX2B$lambda-4$lambda-3  reason: not valid java name */
    private static final ObservableSource m1929getListBillerX2B$lambda4$lambda3(BaseTrafficType baseTrafficType, List list) {
        try {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Intrinsics.checkNotNullParameter(list, "");
            Map<String, RawResult> PlaceComponentResult2 = ToggleManager.MyBillsEntityDataFactory().PlaceComponentResult(list, baseTrafficType.BuiltInFictitiousFunctionClassFactory(), baseTrafficType.getAuthRequestContext);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            Iterator<Map.Entry<String, RawResult>> it = PlaceComponentResult2.entrySet().iterator();
            while (true) {
                Object[] objArr = null;
                if (!it.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
                    Iterator it2 = linkedHashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        List list2 = (List) JSONExtKt.PlaceComponentResult().fromJson((String) ((Map.Entry) it2.next()).getValue(), new TypeToken<List<? extends BillerX2BEntity>>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData$getListBillerX2B$1$1$1$1$itemType$1
                        }.getType());
                        Intrinsics.checkNotNullExpressionValue(list2, "");
                        Iterator it3 = list2.iterator();
                        while (true) {
                            if ((it3.hasNext() ? (char) 11 : (char) 5) != 5) {
                                arrayList.add((BillerX2BEntity) it3.next());
                            }
                        }
                        arrayList2.add(Unit.INSTANCE);
                    }
                    Observable just = Observable.just(arrayList);
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
                    getAuthRequestContext = i % 128;
                    if ((i % 2 != 0 ? '5' : '\f') != '\f') {
                        int length = objArr.length;
                        return just;
                    }
                    return just;
                }
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                Map.Entry<String, RawResult> next = it.next();
                String key = next.getKey();
                String str = next.getValue().KClassImpl$Data$declaredNonStaticMembers$2;
                if (str != null) {
                    int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
                    getAuthRequestContext = i4 % 128;
                    if (i4 % 2 == 0) {
                        Intrinsics.checkNotNullExpressionValue(key, "");
                        if ((str != null ? Typography.less : '[') == '[') {
                            break;
                        }
                        linkedHashMap.put(key, str);
                        int i5 = getAuthRequestContext + 99;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                        int i6 = i5 % 2;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(key, "");
                        objArr.hashCode();
                        if (!(str != null)) {
                            break;
                        }
                        linkedHashMap.put(key, str);
                        int i52 = getAuthRequestContext + 99;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i52 % 128;
                        int i62 = i52 % 2;
                    }
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ MyBillsEntityDataFactory);
        if (BuiltInFictitiousFunctionClassFactory) {
            int i4 = $11 + 45;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            String str = new String(cArr4);
            try {
                int i6 = $10 + 39;
                $11 = i6 % 128;
                if (i6 % 2 != 0) {
                    objArr[0] = str;
                    return;
                }
                Object[] objArr2 = null;
                int length2 = objArr2.length;
                objArr[0] = str;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((PlaceComponentResult ? (char) 16 : 'R') == 'R') {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            try {
                int i7 = $10 + 33;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i9 = $10 + 3;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
                return;
            } catch (Exception e2) {
                throw e2;
            }
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'C' : '\f') == '\f') {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }
}
