package id.dana.data.merchant.repository.source.local;

import android.content.Context;
import id.dana.data.config.source.split.DefaultNearbyGenerator;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityData;
import id.dana.data.storage.Serializer;
import id.dana.domain.merchant.MerchantCategoryType;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class DefaultMerchantCategoriesEntityData implements MerchantCategoriesEntityData, CacheMerchantCategoriesEntityData {
    private static final String MERCHANT_CATEGORIES_ORDER_JSON = "json/amcs-merchant-categories-order-default.json";
    private final Context context;
    private final Map<String, MerchantCategoryEntity> merchantCategoryEntities = new HashMap();
    private final Map<String, MerchantSubcategoryEntity> merchantSubcategoryEntityMap = new HashMap();
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getMerchantCategories$3(Map map, List list) throws Exception {
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getMerchantSubcategories$7(Map map, List list) throws Exception {
        return map;
    }

    @Inject
    public DefaultMerchantCategoriesEntityData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<List<String>> getMerchantOrder(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMerchantCategoriesEntityData.this.m1495x687d8309(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantOrder$0$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ List m1495x687d8309(String str) throws Exception {
        return this.serializer.deserializeList(this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, MERCHANT_CATEGORIES_ORDER_JSON)).get(str));
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantCategoryEntity>> getMerchantCategories() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMerchantCategoriesEntityData.this.m1492xef6ab9ba();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.this.m1494xe5de46fd((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$1$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ Set m1492xef6ab9ba() throws Exception {
        return this.serializer.deserializeMap(DefaultNearbyGenerator.INSTANCE.generateMerchantCategories().toJSONString()).entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$4$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1494xe5de46fd(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.this.m1493x96e6937b(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.lambda$getMerchantCategories$3(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$2$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ MerchantCategoryEntity m1493x96e6937b(Map map, Map.Entry entry) throws Exception {
        String str = (String) entry.getKey();
        MerchantCategoryEntity merchantCategoryEntity = (MerchantCategoryEntity) this.serializer.deserialize((String) entry.getValue(), MerchantCategoryEntity.class);
        merchantCategoryEntity.f8069id = str;
        map.put(str, merchantCategoryEntity);
        return merchantCategoryEntity;
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantSubcategoryEntity>> getMerchantSubcategories() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMerchantCategoriesEntityData.this.m1496xa1715edc();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.this.m1498x97e4ec1f((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategories$5$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ Set m1496xa1715edc() throws Exception {
        return this.serializer.deserializeMap(DefaultNearbyGenerator.INSTANCE.generateMerchantSubCategories().toJSONString()).entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategories$8$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1498x97e4ec1f(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.this.m1497x48ed389d(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultMerchantCategoriesEntityData.lambda$getMerchantSubcategories$7(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategories$6$id-dana-data-merchant-repository-source-local-DefaultMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ MerchantSubcategoryEntity m1497x48ed389d(Map map, Map.Entry entry) throws Exception {
        String str = (String) entry.getKey();
        MerchantSubcategoryEntity merchantSubcategoryEntity = (MerchantSubcategoryEntity) this.serializer.deserialize((String) entry.getValue(), MerchantSubcategoryEntity.class);
        map.put(str, merchantSubcategoryEntity);
        return merchantSubcategoryEntity;
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, String>> getMerchantTopups() {
        return Observable.just(DefaultNearbyGenerator.INSTANCE.generateDefaultMerchantTopUpAgent());
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<List<String>> getNewMerchantCategoryOrder(MerchantCategoryType merchantCategoryType) {
        return Observable.just(DefaultNearbyGenerator.INSTANCE.generateNewMerchantOrder(merchantCategoryType));
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantCategoryEntity>> getNewMerchantCategories() {
        return Observable.just(DefaultNearbyGenerator.INSTANCE.generateNewMerchantCategories());
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantSubcategoryEntity>> getNewMerchantSubCategories() {
        return Observable.just(DefaultNearbyGenerator.INSTANCE.generateNewMerchantSubCategories());
    }

    @Override // id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData
    public void saveMerchantNewCategories(Map<String, ? extends MerchantCategoryEntity> map) {
        this.merchantCategoryEntities.putAll(map);
    }

    @Override // id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData
    public void saveMerchantNewSubCategories(Map<String, ? extends MerchantSubcategoryEntity> map) {
        this.merchantSubcategoryEntityMap.putAll(map);
    }

    @Override // id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData
    public Observable<Map<String, MerchantCategoryEntity>> getCachedNewMerchantCategories() {
        return Observable.just(this.merchantCategoryEntities);
    }

    @Override // id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData
    public Observable<Map<String, MerchantSubcategoryEntity>> getCachedNewMerchantSubCategories() {
        return Observable.just(this.merchantSubcategoryEntityMap);
    }
}
