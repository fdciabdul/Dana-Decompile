package id.dana.data.sendmoney.repository.source.split;

import android.graphics.drawable.Drawable;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.DigitalMoneyEntityData;
import id.dana.data.sendmoney.model.DigitalMoneyEntity;
import id.dana.data.sendmoney.model.DigitalMoneyResult;
import id.dana.data.sendmoney.model.EWalletInnovConfigResult;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.D;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\b\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\nH\u0002¢\u0006\u0004\b\u000f\u0010\rJ3\u0010\u0010\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\n0\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/sendmoney/repository/source/split/SplitDigitalMoneyEntityData;", "Lid/dana/data/sendmoney/DigitalMoneyEntityData;", "Lkotlin/Function1;", "", "", "Lid/dana/data/sendmoney/model/DigitalMoneyResult;", "", "Lid/dana/data/sendmoney/model/DigitalMoneyEntity;", "getDigitalMoneyEntities", "()Lkotlin/jvm/functions/Function1;", "Lio/reactivex/Observable;", "Lid/dana/data/sendmoney/model/EWalletInnovConfigResult;", "getEWalletInnovConfig", "()Lio/reactivex/Observable;", "getEWalletPrefix", "getEwalletAffixList", "getEwalletList", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitDigitalMoneyEntityData implements DigitalMoneyEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult = 0;
    private static long getAuthRequestContext = -7532925322904572271L;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$1HT1arewqrnjeFDyY0K7ZnEOT5U(Function1 function1, List list) {
        int i = MyBillsEntityDataFactory + 97;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        ObservableSource m1932getEWalletPrefix$lambda2 = m1932getEWalletPrefix$lambda2(function1, list);
        if (z) {
            int i2 = 78 / 0;
        }
        int i3 = PlaceComponentResult + 109;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return m1932getEWalletPrefix$lambda2;
    }

    public static /* synthetic */ List $r8$lambda$FAclht7W2LPgZzACFJuMPpyN5aY(List list) {
        int i = MyBillsEntityDataFactory + 31;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        List m1931getEWalletPrefix$lambda1 = m1931getEWalletPrefix$lambda1(list);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1931getEWalletPrefix$lambda1;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$_3ptdTM6T8GzRimZM4m3V4KpKl8(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 13;
        MyBillsEntityDataFactory = i % 128;
        try {
            if ((i % 2 == 0 ? 'L' : '.') == '.') {
                return m1930getEWalletInnovConfig$lambda5(baseTrafficType);
            }
            int i2 = 72 / 0;
            return m1930getEWalletInnovConfig$lambda5(baseTrafficType);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ List $r8$lambda$_aL24zU_dlMqcxyhvkFICN2pRiE(Function1 function1, Map map) {
        int i = MyBillsEntityDataFactory + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        List m1933getEWalletPrefix$lambda3 = m1933getEWalletPrefix$lambda3(function1, map);
        int i3 = PlaceComponentResult + 21;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return m1933getEWalletPrefix$lambda3;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$cxR3_JgZtDmn2rq8fUPLebkJloo(BaseTrafficType baseTrafficType) {
        try {
            int i = MyBillsEntityDataFactory + 5;
            PlaceComponentResult = i % 128;
            char c = i % 2 != 0 ? 'W' : '*';
            ObservableSource m1934getEwalletAffixList$lambda4 = m1934getEwalletAffixList$lambda4(baseTrafficType);
            if (c == 'W') {
                int i2 = 92 / 0;
            }
            int i3 = MyBillsEntityDataFactory + 35;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m1934getEwalletAffixList$lambda4;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitDigitalMoneyEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    public static final /* synthetic */ SplitFacade access$getSplitFacade$p(SplitDigitalMoneyEntityData splitDigitalMoneyEntityData) {
        int i = PlaceComponentResult + 15;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            SplitFacade splitFacade = splitDigitalMoneyEntityData.splitFacade;
            try {
                int i3 = PlaceComponentResult + 49;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return splitFacade;
                }
                return splitFacade;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.sendmoney.DigitalMoneyEntityData
    public final Observable<List<DigitalMoneyEntity>> getEWalletPrefix() {
        Observable<R> map = getEwalletAffixList().map(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitDigitalMoneyEntityData.$r8$lambda$FAclht7W2LPgZzACFJuMPpyN5aY((List) obj);
            }
        });
        final Function1<List<String>, Observable<Map<String, DigitalMoneyResult>>> ewalletList = getEwalletList();
        Observable flatMap = map.flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitDigitalMoneyEntityData.$r8$lambda$1HT1arewqrnjeFDyY0K7ZnEOT5U(Function1.this, (List) obj);
            }
        });
        final Function1<Map<String, DigitalMoneyResult>, List<DigitalMoneyEntity>> digitalMoneyEntities = getDigitalMoneyEntities();
        Observable<List<DigitalMoneyEntity>> map2 = flatMap.map(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitDigitalMoneyEntityData.$r8$lambda$_aL24zU_dlMqcxyhvkFICN2pRiE(Function1.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        try {
            int i = MyBillsEntityDataFactory + 23;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return map2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getEWalletPrefix$lambda-2  reason: not valid java name */
    private static final ObservableSource m1932getEWalletPrefix$lambda2(Function1 function1, List list) {
        ObservableSource observableSource;
        int i = MyBillsEntityDataFactory + 17;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'M' : (char) 17) != 17) {
            try {
                Intrinsics.checkNotNullParameter(function1, "");
                observableSource = (ObservableSource) function1.invoke(list);
                int i2 = 42 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(function1, "");
            observableSource = (ObservableSource) function1.invoke(list);
        }
        int i3 = PlaceComponentResult + 63;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return observableSource;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return observableSource;
    }

    /* renamed from: getEWalletPrefix$lambda-3  reason: not valid java name */
    private static final List m1933getEWalletPrefix$lambda3(Function1 function1, Map map) {
        int i = MyBillsEntityDataFactory + 101;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '3' : '#') != '3') {
            Intrinsics.checkNotNullParameter(function1, "");
            return (List) function1.invoke(map);
        }
        Intrinsics.checkNotNullParameter(function1, "");
        List list = (List) function1.invoke(map);
        int i2 = 39 / 0;
        return list;
    }

    private final Function1<List<String>, Observable<Map<String, DigitalMoneyResult>>> getEwalletList() {
        SplitDigitalMoneyEntityData$getEwalletList$1 splitDigitalMoneyEntityData$getEwalletList$1 = new SplitDigitalMoneyEntityData$getEwalletList$1(this);
        int i = MyBillsEntityDataFactory + 1;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return splitDigitalMoneyEntityData$getEwalletList$1;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return splitDigitalMoneyEntityData$getEwalletList$1;
    }

    private final Function1<Map<String, DigitalMoneyResult>, List<DigitalMoneyEntity>> getDigitalMoneyEntities() {
        SplitDigitalMoneyEntityData$getDigitalMoneyEntities$1 splitDigitalMoneyEntityData$getDigitalMoneyEntities$1;
        int i = PlaceComponentResult + 85;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : 'F') != 'F') {
            splitDigitalMoneyEntityData$getDigitalMoneyEntities$1 = new Function1<Map<String, ? extends DigitalMoneyResult>, List<DigitalMoneyEntity>>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getDigitalMoneyEntities$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ List<DigitalMoneyEntity> invoke(Map<String, ? extends DigitalMoneyResult> map) {
                    return invoke2((Map<String, DigitalMoneyResult>) map);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final List<DigitalMoneyEntity> invoke2(Map<String, DigitalMoneyResult> map) {
                    Intrinsics.checkNotNullParameter(map, "");
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Map.Entry<String, DigitalMoneyResult> entry : map.entrySet()) {
                        arrayList.add(new DigitalMoneyEntity(entry.getValue().getInstId(), entry.getKey(), entry.getValue().getBankName(), entry.getValue().getEWalletName(), entry.getValue().getIdentifier()));
                    }
                    return CollectionsKt.toMutableList((Collection) arrayList);
                }
            };
            int i2 = 25 / 0;
        } else {
            splitDigitalMoneyEntityData$getDigitalMoneyEntities$1 = new Function1<Map<String, ? extends DigitalMoneyResult>, List<DigitalMoneyEntity>>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getDigitalMoneyEntities$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ List<DigitalMoneyEntity> invoke(Map<String, ? extends DigitalMoneyResult> map) {
                    return invoke2((Map<String, DigitalMoneyResult>) map);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final List<DigitalMoneyEntity> invoke2(Map<String, DigitalMoneyResult> map) {
                    Intrinsics.checkNotNullParameter(map, "");
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Map.Entry<String, DigitalMoneyResult> entry : map.entrySet()) {
                        arrayList.add(new DigitalMoneyEntity(entry.getValue().getInstId(), entry.getKey(), entry.getValue().getBankName(), entry.getValue().getEWalletName(), entry.getValue().getIdentifier()));
                    }
                    return CollectionsKt.toMutableList((Collection) arrayList);
                }
            };
        }
        int i3 = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return splitDigitalMoneyEntityData$getDigitalMoneyEntities$1;
        }
        int i4 = 65 / 0;
        return splitDigitalMoneyEntityData$getDigitalMoneyEntities$1;
    }

    private final Observable<List<String>> getEwalletAffixList() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitDigitalMoneyEntityData.$r8$lambda$cxR3_JgZtDmn2rq8fUPLebkJloo((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 119;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    @Override // id.dana.data.sendmoney.DigitalMoneyEntityData
    public final Observable<EWalletInnovConfigResult> getEWalletInnovConfig() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitDigitalMoneyEntityData.$r8$lambda$_3ptdTM6T8GzRimZM4m3V4KpKl8((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 103;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'X' : (char) 15) != 15) {
            Object obj = null;
            obj.hashCode();
            return flatMap;
        }
        return flatMap;
    }

    /* renamed from: getEWalletPrefix$lambda-1  reason: not valid java name */
    private static final List m1931getEWalletPrefix$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<String> mutableList = CollectionsKt.toMutableList((Collection) list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutableList, 10));
        try {
            int i = MyBillsEntityDataFactory + 9;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            for (String str : mutableList) {
                StringBuilder sb = new StringBuilder();
                sb.append("ewallet_");
                sb.append(str);
                arrayList.add(sb.toString());
            }
            return arrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getEWalletInnovConfig$lambda-5  reason: not valid java name */
    private static final ObservableSource m1930getEWalletInnovConfig$lambda5(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Object parseObject = JSON.parseObject(JsonUtil.PlaceComponentResult(baseTrafficType.KClassImpl$Data$declaredNonStaticMembers$2, DefaultJsonPath.DEFAULT_EWALLET_INNOV_CONFIG), EWalletInnovConfigResult.class);
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{'5', 'P', 36451, 44397, 33881, 49180, 49866, 43547, 36285, 7253, 20731, 14348, 7060, 37442, 59021, 17984, 43503, 24599, 29860, 54372, 14283, 62978, 64178, 24960}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEWalletInnovConfig$lambda-5$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = parseObject;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(str, BuiltInFictitiousFunctionClassFactory, EWalletInnovConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEWalletInnovConfig$lambda-5$$inlined$getConfigOnceReady$default$1.1
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
        int i = MyBillsEntityDataFactory + 65;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return observable;
    }

    /* renamed from: getEwalletAffixList$lambda-4  reason: not valid java name */
    private static final ObservableSource m1934getEwalletAffixList$lambda4(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Object parseObject = JSON.parseObject(JsonUtil.PlaceComponentResult(baseTrafficType.KClassImpl$Data$declaredNonStaticMembers$2, DefaultJsonPath.DEFAULT_EWALLET_AFFIXES), List.class);
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(Drawable.resolveOpacity(0, 0) + 1, new char[]{33629, 33592, 6339, 15309, 58320, 26593, 42307, 3558, 3797, 35573, 14194, 40945, 39141, 1278, 33039, 57780, 10904, 63120, 4881, 29594, 46244, 24759, 40230}, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletAffixList$lambda-4$$inlined$getConfigOnceReady$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = parseObject;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(str, BuiltInFictitiousFunctionClassFactory, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletAffixList$lambda-4$$inlined$getConfigOnceReady$default$1.1
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
        int i = PlaceComponentResult + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return observable;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            int i2 = $10 + 61;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                    int i4 = $11 + 113;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getAuthRequestContext ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } else {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
