package id.dana.data.merchant.repository.source;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ExpandableListView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.merchant.CacheMerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.MerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.mapper.MerchantCategoriesMapper;
import id.dana.data.merchant.mapper.MerchantSubcategoryMapper;
import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.merchant.model.MerchantCategory;
import id.dana.domain.merchant.model.MerchantSubcategory;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.text.Typography;
import o.A;

@Singleton
/* loaded from: classes2.dex */
public class MerchantCategoriesEntityRepository implements MerchantCategoriesRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 269894783;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult;
    private final CacheMerchantCategoriesEntityDataFactory cacheMerchantCategoriesEntityDataFactory;
    private final MerchantCategoriesEntityDataFactory merchantCategoriesEntityDataFactory;
    private final MerchantCategoriesMapper merchantCategoriesMapper;
    private final MerchantSubcategoryMapper merchantSubcategoryMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Iterable lambda$getMerchantCategories$1(List list) throws Exception {
        int i = MyBillsEntityDataFactory + 53;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int i3 = MyBillsEntityDataFactory + 83;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return list;
    }

    @Inject
    public MerchantCategoriesEntityRepository(MerchantCategoriesEntityDataFactory merchantCategoriesEntityDataFactory, MerchantCategoriesMapper merchantCategoriesMapper, MerchantSubcategoryMapper merchantSubcategoryMapper, CacheMerchantCategoriesEntityDataFactory cacheMerchantCategoriesEntityDataFactory) {
        this.merchantCategoriesEntityDataFactory = merchantCategoriesEntityDataFactory;
        this.merchantCategoriesMapper = merchantCategoriesMapper;
        this.merchantSubcategoryMapper = merchantSubcategoryMapper;
        this.cacheMerchantCategoriesEntityDataFactory = cacheMerchantCategoriesEntityDataFactory;
    }

    @Override // id.dana.domain.merchant.MerchantCategoriesRepository
    public Observable<Boolean> initMerchantCategoriesV2() {
        Observable zipWith = getNewMerchantCategoryFromConfig().zipWith(getNewMerchantSubCategoryFromConfig(), new BiFunction() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return MerchantCategoriesEntityRepository.lambda$initMerchantCategoriesV2$0((Map) obj, (Map) obj2);
            }
        });
        try {
            int i = PlaceComponentResult + 83;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return zipWith;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if ((!r2 ? '`' : 'O') != '`') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if (r3.isEmpty() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r2 = id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.MyBillsEntityDataFactory + 119;
        id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        return java.lang.Boolean.valueOf(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r2 == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Boolean lambda$initMerchantCategoriesV2$0(java.util.Map r2, java.util.Map r3) throws java.lang.Exception {
        /*
            int r0 = id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.PlaceComponentResult
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 14
            if (r0 != 0) goto L11
            r0 = 14
            goto L13
        L11:
            r0 = 62
        L13:
            boolean r2 = r2.isEmpty()
            if (r0 == r1) goto L1c
            if (r2 != 0) goto L3e
            goto L2c
        L1c:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L44
            r0 = 96
            if (r2 != 0) goto L27
            r2 = 96
            goto L29
        L27:
            r2 = 79
        L29:
            if (r2 == r0) goto L2c
            goto L3e
        L2c:
            boolean r2 = r3.isEmpty()
            if (r2 != 0) goto L3e
            int r2 = id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.MyBillsEntityDataFactory
            int r2 = r2 + 119
            int r3 = r2 % 128
            id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.PlaceComponentResult = r3
            int r2 = r2 % 2
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L44:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository.lambda$initMerchantCategoriesV2$0(java.util.Map, java.util.Map):java.lang.Boolean");
    }

    @Override // id.dana.domain.merchant.MerchantCategoriesRepository
    public Observable<List<MerchantCategory>> getMerchantCategories() {
        Observable<R> flatMap = createMerchantCategories().getMerchantCategories().onErrorResumeNext(defaultMerchantCategoriesIfEmpty()).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1468x2e027ac5((Map) obj);
            }
        });
        MerchantCategoriesMapper merchantCategoriesMapper = this.merchantCategoriesMapper;
        Objects.requireNonNull(merchantCategoriesMapper);
        Observable<List<MerchantCategory>> map = flatMap.map(new MerchantCategoriesEntityRepository$$ExternalSyntheticLambda7(merchantCategoriesMapper));
        int i = PlaceComponentResult + 123;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$3$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1468x2e027ac5(final Map map) throws Exception {
        MerchantCategoriesEntityData createMerchantCategories = createMerchantCategories();
        Object[] objArr = new Object[1];
        a(new char[]{65527, 4, '\n', 65525, 65529, 65527, '\n', 65531, 65533, 5, '\b', 15, 65525, 5, '\b', 65530, 65531, '\b', 3, 65531, '\b', 65529, 65534}, 195 - TextUtils.lastIndexOf("", '0', 0), 24 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), false, ExpandableListView.getPackedPositionChild(0L) + 19, objArr);
        Observable<List<String>> merchantOrder = createMerchantCategories.getMerchantOrder(((String) objArr[0]).intern());
        Object[] objArr2 = new Object[1];
        a(new char[]{65527, 4, '\n', 65525, 65529, 65527, '\n', 65531, 65533, 5, '\b', 15, 65525, 5, '\b', 65530, 65531, '\b', 3, 65531, '\b', 65529, 65534}, TextUtils.indexOf("", "", 0) + 196, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 22, false, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, objArr2);
        Observable filter = merchantOrder.onErrorResumeNext(defaultCategoryIfEmpty(((String) objArr2[0]).intern())).flatMapIterable(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.lambda$getMerchantCategories$1((List) obj);
            }
        }).filter(new Predicate() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return MerchantCategoriesEntityRepository.lambda$getMerchantCategories$2(map, (String) obj);
            }
        });
        Objects.requireNonNull(map);
        Single list = filter.map(new MerchantCategoriesEntityRepository$$ExternalSyntheticLambda21(map)).toList();
        if (list instanceof FuseToObservable) {
            int i = PlaceComponentResult + 111;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return ((FuseToObservable) list).getAuthRequestContext();
        }
        Observable BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        int i3 = PlaceComponentResult + 89;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return BuiltInFictitiousFunctionClassFactory2;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getMerchantCategories$2(Map map, String str) throws Exception {
        try {
            int i = PlaceComponentResult + 19;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            boolean z = !(map.get(str) == null);
            int i3 = PlaceComponentResult + 119;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.merchant.MerchantCategoriesRepository
    public Observable<List<MerchantSubcategory>> getMerchantSubcategories() {
        try {
            Observable<R> flatMap = createMerchantCategories().getMerchantSubcategories().onErrorResumeNext(defaultMerchantSubcategoriesIfEmpty()).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return MerchantCategoriesEntityRepository.lambda$getMerchantSubcategories$5((Map) obj);
                }
            });
            final MerchantSubcategoryMapper merchantSubcategoryMapper = this.merchantSubcategoryMapper;
            Objects.requireNonNull(merchantSubcategoryMapper);
            Observable<List<MerchantSubcategory>> map = flatMap.map(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return MerchantSubcategoryMapper.this.apply((ArrayList) obj);
                }
            });
            try {
                int i = MyBillsEntityDataFactory + 5;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getMerchantSubcategories$5(final Map map) throws Exception {
        try {
            Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return MerchantCategoriesEntityRepository.lambda$getMerchantSubcategories$4(map);
                }
            });
            int i = PlaceComponentResult + 33;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return fromCallable;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArrayList lambda$getMerchantSubcategories$4(Map map) throws Exception {
        ArrayList arrayList = new ArrayList(map.values());
        int i = PlaceComponentResult + 41;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? '\n' : (char) 27) != '\n') {
            return arrayList;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return arrayList;
    }

    private Function<Throwable, ObservableSource<Map<String, MerchantSubcategoryEntity>>> defaultMerchantSubcategoriesIfEmpty() {
        Function<Throwable, ObservableSource<Map<String, MerchantSubcategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1462xce75dff((Throwable) obj);
            }
        };
        int i = PlaceComponentResult + 59;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultMerchantSubcategoriesIfEmpty$6$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1462xce75dff(Throwable th) throws Exception {
        try {
            int i = MyBillsEntityDataFactory + 29;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? '\r' : 'R') != '\r') {
                return createDefaultMerchantCategories().getMerchantSubcategories();
            }
            Observable<Map<String, MerchantSubcategoryEntity>> merchantSubcategories = createDefaultMerchantCategories().getMerchantSubcategories();
            Object obj = null;
            obj.hashCode();
            return merchantSubcategories;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.merchant.MerchantCategoriesRepository
    public Observable<List<MerchantCategory>> getNewMerchantCategories(MerchantCategoryType merchantCategoryType) {
        try {
            try {
                Observable flatMap = createCacheMerchantCategories().getCachedNewMerchantCategories().flatMap(getConfigNewMerchantCategoryIfEmpty()).flatMap(getOrderedNewMerchantCategories(merchantCategoryType));
                MerchantCategoriesMapper merchantCategoriesMapper = this.merchantCategoriesMapper;
                Objects.requireNonNull(merchantCategoriesMapper);
                Observable<List<MerchantCategory>> map = flatMap.map(new MerchantCategoriesEntityRepository$$ExternalSyntheticLambda7(merchantCategoriesMapper));
                int i = MyBillsEntityDataFactory + 95;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Function<Map<String, MerchantCategoryEntity>, Observable<Map<String, MerchantCategoryEntity>>> getConfigNewMerchantCategoryIfEmpty() {
        Function<Map<String, MerchantCategoryEntity>, Observable<Map<String, MerchantCategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1463xe4cd9379((Map) obj);
            }
        };
        int i = MyBillsEntityDataFactory + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getConfigNewMerchantCategoryIfEmpty$7$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1463xe4cd9379(Map map) throws Exception {
        Observable<Map<String, MerchantCategoryEntity>> newMerchantCategoryFromConfig;
        try {
            if (!map.isEmpty()) {
                newMerchantCategoryFromConfig = Observable.just(map);
            } else {
                int i = MyBillsEntityDataFactory + 29;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                newMerchantCategoryFromConfig = getNewMerchantCategoryFromConfig();
            }
            try {
                int i3 = MyBillsEntityDataFactory + 25;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return newMerchantCategoryFromConfig;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Function<Map<String, MerchantCategoryEntity>, Observable<List<MerchantCategoryEntity>>> getOrderedNewMerchantCategories(final MerchantCategoryType merchantCategoryType) {
        Function<Map<String, MerchantCategoryEntity>, Observable<List<MerchantCategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1474x572c1c3e(merchantCategoryType, (Map) obj);
            }
        };
        int i = MyBillsEntityDataFactory + 119;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '=' : Typography.greater) != '>') {
            Object[] objArr = null;
            int length = objArr.length;
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOrderedNewMerchantCategories$10$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1474x572c1c3e(MerchantCategoryType merchantCategoryType, final Map map) throws Exception {
        Observable<R> flatMap = getMerchantCategoriesOrder(merchantCategoryType).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.lambda$getOrderedNewMerchantCategories$9(map, (List) obj);
            }
        });
        int i = PlaceComponentResult + 125;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 47 / 0;
            return flatMap;
        }
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getOrderedNewMerchantCategories$9(final Map map, List list) throws Exception {
        Observable filter = Observable.fromIterable(list).filter(new Predicate() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return MerchantCategoriesEntityRepository.lambda$getOrderedNewMerchantCategories$8(map, (String) obj);
            }
        });
        Objects.requireNonNull(map);
        Single list2 = filter.map(new MerchantCategoriesEntityRepository$$ExternalSyntheticLambda21(map)).toList();
        if (list2 instanceof FuseToObservable) {
            int i = MyBillsEntityDataFactory + 11;
            PlaceComponentResult = i % 128;
            try {
                if (i % 2 == 0) {
                    return ((FuseToObservable) list2).getAuthRequestContext();
                }
                int i2 = 44 / 0;
                return ((FuseToObservable) list2).getAuthRequestContext();
            } catch (Exception e) {
                throw e;
            }
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getOrderedNewMerchantCategories$8(Map map, String str) throws Exception {
        if ((map.get(str) != null ? '3' : '\b') != '3') {
            int i = MyBillsEntityDataFactory + 123;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return false;
        }
        int i3 = MyBillsEntityDataFactory + 123;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        try {
            int i5 = PlaceComponentResult + 41;
            try {
                MyBillsEntityDataFactory = i5 % 128;
                int i6 = i5 % 2;
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Observable<List<String>> getMerchantCategoriesOrder(MerchantCategoryType merchantCategoryType) {
        int i = PlaceComponentResult + 1;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            try {
                Observable<List<String>> onErrorResumeNext = createMerchantCategories().getNewMerchantCategoryOrder(merchantCategoryType).onErrorResumeNext(getDefaultNewMerchantOrders(merchantCategoryType));
                int i3 = PlaceComponentResult + 53;
                MyBillsEntityDataFactory = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return onErrorResumeNext;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return onErrorResumeNext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.domain.merchant.MerchantCategoriesRepository
    public Observable<List<MerchantSubcategory>> getNewMerchantSubCategories() {
        Observable<Map<String, MerchantSubcategoryEntity>> newMerchantSubCategoriesMap = getNewMerchantSubCategoriesMap();
        final MerchantSubcategoryMapper merchantSubcategoryMapper = this.merchantSubcategoryMapper;
        Objects.requireNonNull(merchantSubcategoryMapper);
        Observable map = newMerchantSubCategoriesMap.map(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantSubcategoryMapper.this.transform((Map) obj);
            }
        });
        int i = PlaceComponentResult + 111;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    public Observable<Map<String, MerchantSubcategoryEntity>> getNewMerchantSubCategoriesMap() {
        try {
            int i = MyBillsEntityDataFactory + 17;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? (char) 24 : 'Y') != 'Y') {
                int i2 = 28 / 0;
                return createCacheMerchantCategories().getCachedNewMerchantSubCategories().flatMap(getConfigNewMerchantSubCategoryIfEmpty()).flatMap(getNewMerchantSubCategoriesMappedToCategory());
            }
            return createCacheMerchantCategories().getCachedNewMerchantSubCategories().flatMap(getConfigNewMerchantSubCategoryIfEmpty()).flatMap(getNewMerchantSubCategoriesMappedToCategory());
        } catch (Exception e) {
            throw e;
        }
    }

    private Function<Map<String, MerchantSubcategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> getConfigNewMerchantSubCategoryIfEmpty() {
        Function<Map<String, MerchantSubcategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1464xddc38f2c((Map) obj);
            }
        };
        int i = PlaceComponentResult + 49;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            int i2 = 35 / 0;
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getConfigNewMerchantSubCategoryIfEmpty$11$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1464xddc38f2c(Map map) throws Exception {
        Observable<Map<String, MerchantSubcategoryEntity>> just;
        int i;
        int i2 = MyBillsEntityDataFactory + 69;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        if (map.isEmpty()) {
            int i4 = MyBillsEntityDataFactory + 3;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            just = getNewMerchantSubCategoryFromConfig();
            i = MyBillsEntityDataFactory + 35;
        } else {
            just = Observable.just(map);
            i = MyBillsEntityDataFactory + 89;
        }
        PlaceComponentResult = i % 128;
        int i6 = i % 2;
        return just;
    }

    private Function<Map<String, MerchantSubcategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> getNewMerchantSubCategoriesMappedToCategory() {
        Function<Map<String, MerchantSubcategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1471xca915d85((Map) obj);
            }
        };
        int i = PlaceComponentResult + 81;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantSubCategoriesMappedToCategory$12$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1471xca915d85(Map map) throws Exception {
        int i = MyBillsEntityDataFactory + 29;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 7 : '1') != 7) {
            try {
                try {
                    return createCacheMerchantCategories().getCachedNewMerchantCategories().flatMap(getConfigNewMerchantCategoryIfEmpty()).flatMap(mapNewSubCategories(map));
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        Observable flatMap = createCacheMerchantCategories().getCachedNewMerchantCategories().flatMap(getConfigNewMerchantCategoryIfEmpty()).flatMap(mapNewSubCategories(map));
        Object[] objArr = null;
        int length = objArr.length;
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Observable lambda$mapNewSubCategories$14(final Map map, final Map map2) throws Exception {
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MerchantCategoriesEntityRepository.lambda$mapNewSubCategories$13(map2, map);
            }
        });
        int i = PlaceComponentResult + 33;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return fromCallable;
    }

    private Function<Map<String, MerchantCategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> mapNewSubCategories(final Map<String, MerchantSubcategoryEntity> map) {
        Function<Map<String, MerchantCategoryEntity>, Observable<Map<String, MerchantSubcategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.lambda$mapNewSubCategories$14(map, (Map) obj);
            }
        };
        int i = MyBillsEntityDataFactory + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$mapNewSubCategories$13(Map map, Map map2) throws Exception {
        Iterator it = map.entrySet().iterator();
        while (true) {
            if ((it.hasNext() ? InputCardNumberView.DIVIDER : (char) 20) != ' ') {
                int i = MyBillsEntityDataFactory + 1;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return map2;
            }
            try {
                try {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getValue() != null && ((MerchantCategoryEntity) entry.getValue()).mccCodes != null) {
                        int i3 = MyBillsEntityDataFactory + 9;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        Iterator<String> it2 = ((MerchantCategoryEntity) entry.getValue()).mccCodes.iterator();
                        while (true) {
                            if ((it2.hasNext() ? '?' : '\'') != '?') {
                                break;
                            }
                            String next = it2.next();
                            MerchantSubcategoryEntity merchantSubcategoryEntity = (MerchantSubcategoryEntity) map2.get(next);
                            if (merchantSubcategoryEntity != null) {
                                if ((!merchantSubcategoryEntity.categoryIds.contains(next) ? '*' : (char) 15) == '*') {
                                    int i5 = MyBillsEntityDataFactory + 71;
                                    PlaceComponentResult = i5 % 128;
                                    int i6 = i5 % 2;
                                    merchantSubcategoryEntity.categoryIds.add((String) entry.getKey());
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private Observable<Map<String, MerchantCategoryEntity>> getNewMerchantCategoryFromConfig() {
        Observable flatMap = createMerchantCategories().getNewMerchantCategories().onErrorResumeNext(getDefaultNewMerchantCategories()).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1470x5b109021((Map) obj);
            }
        });
        int i = MyBillsEntityDataFactory + 5;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return flatMap;
        }
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantCategoryFromConfig$16$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1470x5b109021(final Map map) throws Exception {
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MerchantCategoriesEntityRepository.this.m1469x18f962c2(map);
            }
        });
        try {
            int i = PlaceComponentResult + 7;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? '_' : '8') != '_') {
                return fromCallable;
            }
            int i2 = 30 / 0;
            return fromCallable;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantCategoryFromConfig$15$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Map m1469x18f962c2(Map map) throws Exception {
        int i = MyBillsEntityDataFactory + 33;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            createCacheMerchantCategories().saveMerchantNewCategories(map);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            createCacheMerchantCategories().saveMerchantNewCategories(map);
        }
        return map;
    }

    private Observable<Map<String, MerchantSubcategoryEntity>> getNewMerchantSubCategoryFromConfig() {
        Observable flatMap = createMerchantCategories().getNewMerchantSubCategories().onErrorResumeNext(getDefaultNewMerchantSubCategories()).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1473xa03c4901((Map) obj);
            }
        });
        int i = MyBillsEntityDataFactory + 101;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return flatMap;
        }
        Object obj = null;
        obj.hashCode();
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantSubCategoryFromConfig$18$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1473xa03c4901(final Map map) throws Exception {
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MerchantCategoriesEntityRepository.this.m1472x5e251ba2(map);
            }
        });
        int i = PlaceComponentResult + 39;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantSubCategoryFromConfig$17$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ Map m1472x5e251ba2(Map map) throws Exception {
        try {
            int i = MyBillsEntityDataFactory + 113;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                createCacheMerchantCategories().saveMerchantNewSubCategories(map);
            } else {
                createCacheMerchantCategories().saveMerchantNewSubCategories(map);
                Object obj = null;
                obj.hashCode();
            }
            int i2 = MyBillsEntityDataFactory + 1;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    private Function<Throwable, ObservableSource<Map<String, MerchantCategoryEntity>>> defaultMerchantCategoriesIfEmpty() {
        Function<Throwable, ObservableSource<Map<String, MerchantCategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1461x3390152d((Throwable) obj);
            }
        };
        int i = PlaceComponentResult + 35;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultMerchantCategoriesIfEmpty$19$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1461x3390152d(Throwable th) throws Exception {
        Observable<Map<String, MerchantCategoryEntity>> merchantCategories;
        int i = MyBillsEntityDataFactory + 15;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            merchantCategories = createDefaultMerchantCategories().getMerchantCategories();
            int i2 = 45 / 0;
        } else {
            merchantCategories = createDefaultMerchantCategories().getMerchantCategories();
        }
        int i3 = PlaceComponentResult + 85;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return merchantCategories;
    }

    private Function<Throwable, ObservableSource<List<String>>> defaultCategoryIfEmpty(final String str) {
        Function<Throwable, ObservableSource<List<String>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1460xc4cab9d(str, (Throwable) obj);
            }
        };
        int i = PlaceComponentResult + 91;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 89 / 0;
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultCategoryIfEmpty$20$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1460xc4cab9d(String str, Throwable th) throws Exception {
        Observable<List<String>> merchantOrder;
        try {
            int i = PlaceComponentResult + 11;
            try {
                MyBillsEntityDataFactory = i % 128;
                Object[] objArr = null;
                if (i % 2 != 0) {
                    merchantOrder = createDefaultMerchantCategories().getMerchantOrder(str);
                } else {
                    merchantOrder = createDefaultMerchantCategories().getMerchantOrder(str);
                    int length = objArr.length;
                }
                int i2 = PlaceComponentResult + 33;
                MyBillsEntityDataFactory = i2 % 128;
                if (i2 % 2 != 0) {
                    return merchantOrder;
                }
                objArr.hashCode();
                return merchantOrder;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private MerchantCategoriesEntityData createMerchantCategories() {
        int i = PlaceComponentResult + 67;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'T' : (char) 18) != 18) {
            try {
                MerchantCategoriesEntityData createData2 = this.merchantCategoriesEntityDataFactory.createData2("network");
                Object[] objArr = null;
                int length = objArr.length;
                return createData2;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.merchantCategoriesEntityDataFactory.createData2("network");
    }

    private MerchantCategoriesEntityData createDefaultMerchantCategories() {
        int i = MyBillsEntityDataFactory + 91;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '%' : (char) 3) != '%') {
            return this.merchantCategoriesEntityDataFactory.createData2("local");
        }
        MerchantCategoriesEntityData createData2 = this.merchantCategoriesEntityDataFactory.createData2("local");
        Object[] objArr = null;
        int length = objArr.length;
        return createData2;
    }

    private CacheMerchantCategoriesEntityData createCacheMerchantCategories() {
        int i = PlaceComponentResult + 81;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        DefaultMerchantCategoriesEntityData createData2 = this.cacheMerchantCategoriesEntityDataFactory.createData2("local");
        try {
            int i3 = MyBillsEntityDataFactory + 105;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return createData2;
        } catch (Exception e) {
            throw e;
        }
    }

    private Function<Throwable, ObservableSource<Map<String, MerchantCategoryEntity>>> getDefaultNewMerchantCategories() {
        Function<Throwable, ObservableSource<Map<String, MerchantCategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1465x4eed19ca((Throwable) obj);
            }
        };
        int i = MyBillsEntityDataFactory + 117;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDefaultNewMerchantCategories$21$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1465x4eed19ca(Throwable th) throws Exception {
        try {
            int i = PlaceComponentResult + 45;
            try {
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 != 0)) {
                    int i2 = 14 / 0;
                    return createDefaultMerchantCategories().getNewMerchantCategories();
                }
                return createDefaultMerchantCategories().getNewMerchantCategories();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Function<Throwable, ObservableSource<Map<String, MerchantSubcategoryEntity>>> getDefaultNewMerchantSubCategories() {
        Function<Throwable, ObservableSource<Map<String, MerchantSubcategoryEntity>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1467x3431fa89((Throwable) obj);
            }
        };
        int i = MyBillsEntityDataFactory + 61;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return function;
        }
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDefaultNewMerchantSubCategories$22$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1467x3431fa89(Throwable th) throws Exception {
        Observable<Map<String, MerchantSubcategoryEntity>> newMerchantSubCategories;
        int i = MyBillsEntityDataFactory + 87;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            try {
                newMerchantSubCategories = createDefaultMerchantCategories().getNewMerchantSubCategories();
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            newMerchantSubCategories = createDefaultMerchantCategories().getNewMerchantSubCategories();
        }
        int i2 = PlaceComponentResult + 97;
        MyBillsEntityDataFactory = i2 % 128;
        if (i2 % 2 != 0) {
            return newMerchantSubCategories;
        }
        int length2 = objArr.length;
        return newMerchantSubCategories;
    }

    private Function<Throwable, ObservableSource<List<String>>> getDefaultNewMerchantOrders(final MerchantCategoryType merchantCategoryType) {
        Function<Throwable, ObservableSource<List<String>>> function = new Function() { // from class: id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MerchantCategoriesEntityRepository.this.m1466x5a07f591(merchantCategoryType, (Throwable) obj);
            }
        };
        try {
            int i = MyBillsEntityDataFactory + 79;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return function;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getDefaultNewMerchantOrders$23$id-dana-data-merchant-repository-source-MerchantCategoriesEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1466x5a07f591(MerchantCategoryType merchantCategoryType, Throwable th) throws Exception {
        Observable<List<String>> newMerchantCategoryOrder;
        int i = MyBillsEntityDataFactory + 71;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '?' : '(') != '?') {
            newMerchantCategoryOrder = createDefaultMerchantCategories().getNewMerchantCategoryOrder(merchantCategoryType);
        } else {
            try {
                newMerchantCategoryOrder = createDefaultMerchantCategories().getNewMerchantCategoryOrder(merchantCategoryType);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 29;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return newMerchantCategoryOrder;
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
            cArr2[i6] = (char) (cArr2[i6] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            try {
                int i7 = $10 + 27;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(!z)) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? (char) 28 : '7') != 28) {
                    break;
                }
                try {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                    int i9 = $10 + 65;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
