package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.AddPayMethodConfigEntityData;
import id.dana.data.storage.Serializer;
import id.dana.domain.sendmoney.model.AddPayMethod;
import io.reactivex.Observable;
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
public class DefaultAddPayMethodConfig implements AddPayMethodConfigEntityData {
    private static final String DEFAULT_ADD_PAY_METHOD_JSON = "json/amcs-add-paymethod-default.json";
    private final Context context;
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$createMapIterable$2(Map map, List list) throws Exception {
        return map;
    }

    @Inject
    public DefaultAddPayMethodConfig(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.sendmoney.AddPayMethodConfigEntityData
    public Observable<Map<String, AddPayMethod>> getAddPayMethodConfig() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultAddPayMethodConfig.this.m1917xf17fcac2();
            }
        }).flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable createMapIterable;
                createMapIterable = DefaultAddPayMethodConfig.this.createMapIterable((Set) obj);
                return createMapIterable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getAddPayMethodConfig$0$id-dana-data-sendmoney-repository-source-local-DefaultAddPayMethodConfig  reason: not valid java name */
    public /* synthetic */ Set m1917xf17fcac2() throws Exception {
        return this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, DEFAULT_ADD_PAY_METHOD_JSON)).entrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Map<String, AddPayMethod>> createMapIterable(Set<Map.Entry<String, String>> set) {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultAddPayMethodConfig.this.m1916xdee2332f(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultAddPayMethodConfig.lambda$createMapIterable$2(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createMapIterable$1$id-dana-data-sendmoney-repository-source-local-DefaultAddPayMethodConfig  reason: not valid java name */
    public /* synthetic */ AddPayMethod m1916xdee2332f(Map map, Map.Entry entry) throws Exception {
        AddPayMethod createAddPaymethodFromMap = createAddPaymethodFromMap(entry);
        map.put(createAddPaymethodFromMap.getKey(), createAddPaymethodFromMap);
        return createAddPaymethodFromMap;
    }

    private AddPayMethod createAddPaymethodFromMap(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        AddPayMethod addPayMethod = (AddPayMethod) this.serializer.deserialize(entry.getValue(), AddPayMethod.class);
        addPayMethod.setKey(key);
        return addPayMethod;
    }
}
