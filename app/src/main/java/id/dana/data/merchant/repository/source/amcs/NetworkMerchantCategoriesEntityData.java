package id.dana.data.merchant.repository.source.amcs;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.base.DanaContentApi;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.MerchantCategoryContentResult;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityData;
import id.dana.data.storage.Serializer;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;

@Singleton
/* loaded from: classes2.dex */
public class NetworkMerchantCategoriesEntityData implements MerchantCategoriesEntityData {
    private static final String MC_ID = "mc_id";
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final DanaContentApi danaContentApi;
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getFromCdn$11(Map map, List list) throws Exception {
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getMerchantSubCategoryFromCdn$17(Map map, List list) throws Exception {
        return map;
    }

    @Inject
    public NetworkMerchantCategoriesEntityData(Serializer serializer, ConfigEntityDataFactory configEntityDataFactory, DanaContentApi danaContentApi) {
        this.serializer = serializer;
        this.configEntityDataFactory = configEntityDataFactory;
        this.danaContentApi = danaContentApi;
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<List<String>> getMerchantOrder(String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1481xf2df2f55();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.lambda$getMerchantOrder$1((JSONArray) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantOrder$0$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ JSONArray m1481xf2df2f55() throws Exception {
        JSONArray merchantOrderFromConfig = getMerchantOrderFromConfig();
        if (merchantOrderFromConfig != null) {
            return merchantOrderFromConfig;
        }
        throw new CallableReturnNullError("NetworkMerchantCategoriesEntityData#getMerchantOrder");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getMerchantOrder$1(JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return Observable.error(new Throwable("Merchant Order is Empty"));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        return Observable.just(arrayList);
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantCategoryEntity>> getMerchantCategories() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1479x5fb948a3();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1480x8e6ab2c2((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$2$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ JSONObject m1479x5fb948a3() throws Exception {
        JSONObject merchantCategoriesFromConfig = getMerchantCategoriesFromConfig();
        if (merchantCategoriesFromConfig != null) {
            return merchantCategoriesFromConfig;
        }
        throw new CallableReturnNullError("NetworkMerchantCategoriesEntityData#getMerchantCategories");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantCategories$3$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1480x8e6ab2c2(JSONObject jSONObject) throws Exception {
        if (jSONObject.isEmpty()) {
            return Observable.error(new Throwable("Merchant Categories is Empty"));
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                MerchantCategoryEntity merchantCategoryEntity = (MerchantCategoryEntity) this.serializer.deserialize(((JSONObject) value).toJSONString(), MerchantCategoryEntity.class);
                merchantCategoryEntity.f8069id = key;
                hashMap.put(key, merchantCategoryEntity);
            }
        }
        return Observable.just(hashMap);
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantSubcategoryEntity>> getMerchantSubcategories() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda20
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1486x8c35a303();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1487xbae70d22((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategories$4$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ JSONObject m1486x8c35a303() throws Exception {
        JSONObject subMerchantCategoriesFromConfig = getSubMerchantCategoriesFromConfig();
        if (subMerchantCategoriesFromConfig != null) {
            return subMerchantCategoriesFromConfig;
        }
        throw new CallableReturnNullError("NetworkMerchantCategoriesEntityData#getMerchantSubcategories");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategories$5$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1487xbae70d22(JSONObject jSONObject) throws Exception {
        if (jSONObject.isEmpty()) {
            return Observable.error(new Throwable("Merchant Sub Categories is Empty"));
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                hashMap.put(key, (MerchantSubcategoryEntity) this.serializer.deserialize(((JSONObject) value).toJSONString(), MerchantSubcategoryEntity.class));
            }
        }
        return Observable.just(hashMap);
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, String>> getMerchantTopups() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1489x2269c798();
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.lambda$getMerchantTopups$7((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantTopups$6$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ JSONObject m1489x2269c798() throws Exception {
        JSONObject merchantTopupsFromConfig = getMerchantTopupsFromConfig();
        if (merchantTopupsFromConfig != null) {
            return merchantTopupsFromConfig;
        }
        throw new CallableReturnNullError("NetworkMerchantCategoriesEntityData#getMerchantTopups");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getMerchantTopups$7(JSONObject jSONObject) throws Exception {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return Observable.just(hashMap);
    }

    private JSONObject getMerchantTopupsFromConfig() {
        return createSplitConfigEntityData().getMerchantTopups().blockingFirst();
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<List<String>> getNewMerchantCategoryOrder(MerchantCategoryType merchantCategoryType) {
        return createSplitConfigEntityData().getNewMerchantCategoryOrder(merchantCategoryType);
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantCategoryEntity>> getNewMerchantCategories() {
        return createSplitConfigEntityData().getNewMerchantCategories().flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1490xdb9ef92f((MerchantCategoryContentResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantCategories$8$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1490xdb9ef92f(MerchantCategoryContentResult merchantCategoryContentResult) throws Exception {
        if (TextUtils.isEmpty(merchantCategoryContentResult.getUrl())) {
            return Observable.error(new Throwable("Empty url"));
        }
        return getFromCdn(merchantCategoryContentResult.getUrl());
    }

    private Observable<Map<String, MerchantCategoryEntity>> getFromCdn(String str) {
        return this.danaContentApi.getMerchantCategoriesContent(str).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1477x55021cd2((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getFromCdn$13$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1477x55021cd2(final JSONObject jSONObject) throws Exception {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1478x212504f(jSONObject);
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1476x2650b2b3((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getFromCdn$9$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ Set m1478x212504f(JSONObject jSONObject) throws Exception {
        Map<String, String> deserializeMap = this.serializer.deserializeMap(jSONObject.toString());
        if (deserializeMap.isEmpty()) {
            throw new Exception("Empty categories");
        }
        return deserializeMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getFromCdn$12$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1476x2650b2b3(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1475xc8edde75(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.lambda$getFromCdn$11(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getFromCdn$10$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ MerchantCategoryEntity m1475xc8edde75(Map map, Map.Entry entry) throws Exception {
        String str = (String) entry.getKey();
        MerchantCategoryEntity merchantCategoryEntity = (MerchantCategoryEntity) this.serializer.deserialize((String) entry.getValue(), MerchantCategoryEntity.class);
        merchantCategoryEntity.f8069id = str;
        map.put(str, merchantCategoryEntity);
        return merchantCategoryEntity;
    }

    @Override // id.dana.data.merchant.repository.source.MerchantCategoriesEntityData
    public Observable<Map<String, MerchantSubcategoryEntity>> getNewMerchantSubCategories() {
        return createSplitConfigEntityData().getNewMerchantSubCategories().flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1491xa2da5274((MerchantCategoryContentResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getNewMerchantSubCategories$14$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1491xa2da5274(MerchantCategoryContentResult merchantCategoryContentResult) throws Exception {
        if (TextUtils.isEmpty(merchantCategoryContentResult.getUrl())) {
            return Observable.error(new Throwable("Empty url"));
        }
        return getMerchantSubCategoryFromCdn(merchantCategoryContentResult.getUrl());
    }

    private Observable<Map<String, MerchantSubcategoryEntity>> getMerchantSubCategoryFromCdn(String str) {
        return this.danaContentApi.getMerchantCategoriesContent(str).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1485x1694ed48((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubCategoryFromCdn$19$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1485x1694ed48(final JSONObject jSONObject) throws Exception {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1482x5bcf44cc(jSONObject);
            }
        }).flatMap(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1484xe7e38329((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubCategoryFromCdn$15$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ Set m1482x5bcf44cc(JSONObject jSONObject) throws Exception {
        Map<String, String> deserializeMap = this.serializer.deserializeMap(jSONObject.toString());
        if (deserializeMap.isEmpty()) {
            throw new Exception("Empty categories");
        }
        return deserializeMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubCategoryFromCdn$18$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1484xe7e38329(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.this.m1483x8a80aeeb(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMerchantCategoriesEntityData.lambda$getMerchantSubCategoryFromCdn$17(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubCategoryFromCdn$16$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ MerchantSubcategoryEntity m1483x8a80aeeb(Map map, Map.Entry entry) throws Exception {
        String str = (String) entry.getKey();
        MerchantSubcategoryEntity merchantSubcategoryEntity = (MerchantSubcategoryEntity) this.serializer.deserialize((String) entry.getValue(), MerchantSubcategoryEntity.class);
        merchantSubcategoryEntity.mcc = str;
        map.put(str, merchantSubcategoryEntity);
        return merchantSubcategoryEntity;
    }

    private JSONObject getMerchantCategoriesFromConfig() {
        return createSplitConfigEntityData().getMerchantCategories().blockingFirst();
    }

    private JSONArray getMerchantOrderFromConfig() {
        return createSplitConfigEntityData().getMerchantOrder().blockingFirst();
    }

    private ConfigEntityData createSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private JSONObject getSubMerchantCategoriesFromConfig() {
        return getMerchantSubcategoriesFromSplit().blockingFirst();
    }

    private Observable<JSONObject> getMerchantSubcategoriesFromSplit() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NetworkMerchantCategoriesEntityData.this.m1488xf2d4d3a1();
            }
        }).map(new Function() { // from class: id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                JSONObject onGotMerchantOrder;
                onGotMerchantOrder = NetworkMerchantCategoriesEntityData.this.onGotMerchantOrder((JSONArray) obj);
                return onGotMerchantOrder;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMerchantSubcategoriesFromSplit$20$id-dana-data-merchant-repository-source-amcs-NetworkMerchantCategoriesEntityData  reason: not valid java name */
    public /* synthetic */ JSONArray m1488xf2d4d3a1() throws Exception {
        JSONArray merchantOrderFromConfig = getMerchantOrderFromConfig();
        if (merchantOrderFromConfig != null) {
            return merchantOrderFromConfig;
        }
        throw new CallableReturnNullError("NetworkMerchantCategoriesEntityData#getMerchantSubcategoriesFromSplit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject onGotMerchantOrder(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = jsonArrayToStringList(jSONArray).iterator();
        while (it.hasNext()) {
            onGotMcId(jSONObject, it.next());
        }
        return jSONObject;
    }

    private void onGotMcId(JSONObject jSONObject, String str) {
        for (String str2 : getStringListFromSplit(str)) {
            JSONObject jSONObjectFromSplit = getJSONObjectFromSplit(str2);
            if (!jSONObjectFromSplit.isEmpty()) {
                jSONObjectFromSplit.put(MC_ID, (Object) str);
                jSONObject.put(str2, (Object) jSONObjectFromSplit);
            }
        }
    }

    private List<String> getStringListFromSplit(String str) {
        return getSplitConfigEntityData().getStringList(str).onErrorReturnItem(new ArrayList()).blockingFirst();
    }

    private JSONObject getJSONObjectFromSplit(String str) {
        return getSplitConfigEntityData().getJSONObject(str).onErrorReturnItem(new JSONObject()).blockingFirst();
    }

    private List<String> jsonArrayToStringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getString(i));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private SplitConfigEntityData getSplitConfigEntityData() {
        return (SplitConfigEntityData) createSplitConfigEntityData();
    }
}
