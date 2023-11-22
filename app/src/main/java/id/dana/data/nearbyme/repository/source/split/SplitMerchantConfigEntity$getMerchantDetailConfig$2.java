package id.dana.data.nearbyme.repository.source.split;

import com.google.gson.reflect.TypeToken;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.extension.CoroutinesExtKt;
import id.dana.domain.extension.MapExtKt;
import id.dana.lib.toggle.RawResultsCallback;
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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2", f = "SplitMerchantConfigEntity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class SplitMerchantConfigEntity$getMerchantDetailConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MerchantConfigEntity>>, Object> {
    final /* synthetic */ String[] $keys;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplitMerchantConfigEntity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitMerchantConfigEntity$getMerchantDetailConfig$2(SplitMerchantConfigEntity splitMerchantConfigEntity, String[] strArr, Continuation<? super SplitMerchantConfigEntity$getMerchantDetailConfig$2> continuation) {
        super(2, continuation);
        this.this$0 = splitMerchantConfigEntity;
        this.$keys = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplitMerchantConfigEntity$getMerchantDetailConfig$2 splitMerchantConfigEntity$getMerchantDetailConfig$2 = new SplitMerchantConfigEntity$getMerchantDetailConfig$2(this.this$0, this.$keys, continuation);
        splitMerchantConfigEntity$getMerchantDetailConfig$2.L$0 = obj;
        return splitMerchantConfigEntity$getMerchantDetailConfig$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MerchantConfigEntity>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MerchantConfigEntity>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<MerchantConfigEntity>> continuation) {
        return ((SplitMerchantConfigEntity$getMerchantDetailConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SplitFacade splitFacade;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            splitFacade = this.this$0.splitFacade;
            Observable<BaseTrafficType> KClassImpl$Data$declaredNonStaticMembers$2 = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2();
            final String[] strArr = this.$keys;
            return CollectionsKt.toList(((Map) KClassImpl$Data$declaredNonStaticMembers$2.flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    ObservableSource m1534invokeSuspend$lambda0;
                    m1534invokeSuspend$lambda0 = SplitMerchantConfigEntity$getMerchantDetailConfig$2.m1534invokeSuspend$lambda0(strArr, (BaseTrafficType) obj2);
                    return m1534invokeSuspend$lambda0;
                }
            }).observeOn(CoroutinesExtKt.asScheduler(coroutineScope)).blockingFirst()).values());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final ObservableSource m1534invokeSuspend$lambda0(String[] strArr, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullExpressionValue(baseTrafficType, "");
        final List asList = ArraysKt.asList(strArr);
        final String str = DefaultJsonPath.DEFAULT_NEARBY_MERCHANT_CONFIG;
        final boolean z = false;
        final boolean z2 = true;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<Map<String, T>> observableEmitter) {
                Map emptyMap;
                final Object obj;
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                try {
                    Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(JsonUtil.PlaceComponentResult(BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2, str), null), new TypeToken<Map<String, ? extends T>>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1.1
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(fromJson, "");
                    emptyMap = (Map) fromJson;
                } catch (Exception unused) {
                    emptyMap = MapsKt.emptyMap();
                }
                final Map map = emptyMap;
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(JsonUtil.PlaceComponentResult(BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2, str), null), (Class<Object>) MerchantConfigEntity.class);
                } catch (Exception unused2) {
                    obj = null;
                }
                List list = asList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(TuplesKt.to((String) it.next(), null));
                }
                final Map mutableMap = MapsKt.toMutableMap(MapsKt.toMap(arrayList));
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                List<String> list2 = asList;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final boolean z3 = z;
                final boolean z4 = z2;
                final List list3 = asList;
                MyBillsEntityDataFactory.PlaceComponentResult(list2, BuiltInFictitiousFunctionClassFactory, new RawResultsCallback() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$$inlined$getConfigsOnceReady$default$1.2
                    @Override // id.dana.lib.toggle.RawResultsCallback
                    public final void onComplete(Map<String, ? extends RawResult> it2) {
                        Object obj2;
                        Unit unit = null;
                        if (it2 != null) {
                            ObservableEmitter observableEmitter2 = ObservableEmitter.this;
                            Map map2 = mutableMap;
                            final BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            boolean z5 = z3;
                            final Map map3 = map;
                            final Object obj3 = obj;
                            boolean z6 = z4;
                            for (Map.Entry<String, ? extends RawResult> entry : it2.entrySet()) {
                                final String key = entry.getKey();
                                RawResult value = entry.getValue();
                                if (Intrinsics.areEqual(value.getAuthRequestContext, "control")) {
                                    if (!z5) {
                                        T invoke = new Function1<String, T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$.inlined.getConfigsOnceReady.default.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final T invoke(String str2) {
                                                Intrinsics.checkNotNullParameter(str2, "");
                                                Map map4 = map3;
                                                if (!((map4.isEmpty() ^ true) && map4.containsKey(str2))) {
                                                    map4 = null;
                                                }
                                                if (map4 != null) {
                                                    String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str2));
                                                    if (json == null) {
                                                        json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                                    }
                                                    T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) MerchantConfigEntity.class);
                                                    if (t != null) {
                                                        return t;
                                                    }
                                                }
                                                return (T) obj3;
                                            }
                                        }.invoke(key);
                                        if (invoke != null) {
                                            map2.put(key, invoke);
                                        }
                                    } else {
                                        ConfigUtil configUtil = ConfigUtil.INSTANCE;
                                        T invoke2 = new Function1<String, T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$.inlined.getConfigsOnceReady.default.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final T invoke(String str2) {
                                                String jSONObject;
                                                Intrinsics.checkNotNullParameter(str2, "");
                                                JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str2);
                                                if (jSONConfig != null && (jSONObject = jSONConfig.toString()) != null) {
                                                    T t = null;
                                                    try {
                                                        t = (T) JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, null), (Class) MerchantConfigEntity.class);
                                                    } catch (Exception unused3) {
                                                    }
                                                    if (t != null) {
                                                        return t;
                                                    }
                                                }
                                                ConfigUtil configUtil2 = ConfigUtil.INSTANCE;
                                                final BaseTrafficType baseTrafficType4 = BaseTrafficType.this;
                                                final Map map4 = map3;
                                                final Object obj4 = obj3;
                                                return new Function1<String, T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$.inlined.getConfigsOnceReady.default.1.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final T invoke(String str3) {
                                                        Intrinsics.checkNotNullParameter(str3, "");
                                                        Map map5 = map4;
                                                        if (!((map5.isEmpty() ^ true) && map5.containsKey(str3))) {
                                                            map5 = null;
                                                        }
                                                        if (map5 != null) {
                                                            String json = JSONExtKt.PlaceComponentResult().toJson(map5.get(str3));
                                                            if (json == null) {
                                                                json = JSONExtKt.PlaceComponentResult().toJson(map5);
                                                            }
                                                            T t2 = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) MerchantConfigEntity.class);
                                                            if (t2 != null) {
                                                                return t2;
                                                            }
                                                        }
                                                        return (T) obj4;
                                                    }
                                                }.invoke(key);
                                            }
                                        }.invoke(key);
                                        if (invoke2 != null) {
                                            map2.put(key, invoke2);
                                        }
                                    }
                                } else if (z6) {
                                    String str2 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (str2 != null) {
                                        try {
                                            obj2 = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str2, null), (Class<Object>) MerchantConfigEntity.class);
                                        } catch (Exception unused3) {
                                            obj2 = null;
                                        }
                                        if (obj2 != null) {
                                            map2.put(key, obj2);
                                            if (obj2 == null) {
                                            }
                                        }
                                    }
                                    T invoke3 = new Function1<String, T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$.inlined.getConfigsOnceReady.default.1.2.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final T invoke(String str3) {
                                            Intrinsics.checkNotNullParameter(str3, "");
                                            Map map4 = map3;
                                            if (!((map4.isEmpty() ^ true) && map4.containsKey(str3))) {
                                                map4 = null;
                                            }
                                            if (map4 != null) {
                                                String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str3));
                                                if (json == null) {
                                                    json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                                }
                                                T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) MerchantConfigEntity.class);
                                                if (t != null) {
                                                    return t;
                                                }
                                            }
                                            return (T) obj3;
                                        }
                                    }.invoke(key);
                                    if (invoke3 != null) {
                                        map2.put(key, invoke3);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                } else {
                                    String str3 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (str3 != null) {
                                        if (str3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type id.dana.data.nearbyme.model.MerchantConfigEntity");
                                        }
                                        map2.put(key, (MerchantConfigEntity) str3);
                                        if (str3 == null) {
                                        }
                                    }
                                    T invoke4 = new Function1<String, T>() { // from class: id.dana.data.nearbyme.repository.source.split.SplitMerchantConfigEntity$getMerchantDetailConfig$2$invokeSuspend$lambda-0$.inlined.getConfigsOnceReady.default.1.2.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final T invoke(String str4) {
                                            Intrinsics.checkNotNullParameter(str4, "");
                                            Map map4 = map3;
                                            if (!((map4.isEmpty() ^ true) && map4.containsKey(str4))) {
                                                map4 = null;
                                            }
                                            if (map4 != null) {
                                                String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str4));
                                                if (json == null) {
                                                    json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                                }
                                                T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) MerchantConfigEntity.class);
                                                if (t != null) {
                                                    return t;
                                                }
                                            }
                                            return (T) obj3;
                                        }
                                    }.invoke(key);
                                    if (invoke4 != null) {
                                        map2.put(key, invoke4);
                                        Unit unit3 = Unit.INSTANCE;
                                    }
                                }
                            }
                            observableEmitter2.onNext(MapExtKt.filterNotNullValues(map2));
                            observableEmitter2.onComplete();
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            ObservableEmitter.this.onError(new SplitNull(list3.toString()));
                        }
                    }

                    @Override // id.dana.lib.toggle.RawResultsCallback
                    public final void onError() {
                        ObservableEmitter.this.onError(new SplitException("Error when get configs once ready"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }
}
